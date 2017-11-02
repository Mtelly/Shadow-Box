package com.example.extropy.shadowbox;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.Toast;
import java.io.IOException;

public class BeginActivity extends AppCompatActivity implements OnCompletionListener {
    public final String TAG = ShadowBoxActivity.class.getSimpleName();

    //Classes needed for combinations
    private BoxingCombinations mCombinationsList = new BoxingCombinations();
    private AudioCombinations mAudioCombinations = new AudioCombinations();

    private TextView mBoxTextView;
    private Button mPlay;
    private Button mPauseButton;
    private Button mEasy;
    private Button mReset;
    public MediaPlayer mp;
    private int audioIndex = 0;
    private String[] arrayOfAllAudio = null;
    private int[] arrayOfAllAudioInt = null;
    private String[] multipleCombination = null;
    private Uri[] uris;
    private int difficulty = 0;
    private boolean pauseButton = false;

    //Timer attributes
    private TextView timerValue;
    private long startTime = 0L;
    private Handler customHandler = new Handler();
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_easy);
        setContentView(R.layout.content_easy);
        mBoxTextView = (TextView) findViewById(R.id.boxTextView);
        mPlay = (Button) findViewById(R.id.showBoxButton);
        mPauseButton = (Button) findViewById(R.id.showPauseButton);
        mEasy = (Button) findViewById(R.id.easyButton);
        mReset = (Button) findViewById(R.id.showResetButton);

        Bundle data = getIntent().getExtras();
        Preference settings = (Preference) data.getParcelable("settings");

        //Setting our combinations
        multipleCombination = mCombinationsList.getManyCombinations();
        arrayOfAllAudio = mCombinationsList.splitPunchString(multipleCombination);

        //Should be used while setOnCompletion is playing.
        mp = mAudioCombinations.getSound(getApplicationContext(), arrayOfAllAudio[audioIndex]);

        //Contains the array of resources as Strings
        arrayOfAllAudioInt = mAudioCombinations.getIntegerSound(getApplicationContext(), arrayOfAllAudio);

        /*We need to convert the arrayOfAllAudioInt to a URI array.*/
        uris = new Uri[arrayOfAllAudioInt.length];
        for(int x = 0; x < arrayOfAllAudioInt.length; x++) {
            uris[x] = Uri.parse("android.resource://com.example.extropy.shadowbox/" + arrayOfAllAudioInt[x]);
        }

        //Media Player
        mp = new MediaPlayer();

        //Listener
        mp.setOnCompletionListener(this); // Important

        timerValue = (TextView) findViewById(R.id.timerValue);

        mReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(!mp.isPlaying() && (pauseButton==true)) {
                    //Pause MediaPlayer and Timer display
                    pauseButton = true;//Pauses within playCombo
                    audioIndex = 0;
                    mp.pause();
                    resetTimer();
                    Context context = getApplicationContext();

                    //Display Toast
                    CharSequence text = "Reset";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

        mPauseButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(mp.isPlaying()) {
                    pauseButton = true;
                    mp.pause();
                    pauseTimer();
                }
            }
        });

        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(!mp.isPlaying()) {
                    pauseButton = false;
                    startTimer();
                    playCombo(audioIndex);
                }
            }
        });


        //Keep device awake
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    public void onBackPressed() {
        mp.release();
        finish();
    }

    //TIMER
    private Runnable updateTimerThread = new Runnable() {
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            updatedTime = timeSwapBuff + timeInMilliseconds;

            int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            secs = secs % 60;
            int milliseconds = (int) (updatedTime % 1000);
            timerValue.setText("" + mins + ":"
                    + String.format("%02d", secs) + ":"
                    + String.format("%03d", milliseconds));

            customHandler.postDelayed(this, 0);
        }
    };//Runnable()

    public void playCombo(int audioIndex){
        try {

            mp.reset();
            mp.setDataSource(getApplicationContext(), uris[audioIndex]);
            mp.prepare();

            mp.start();

             if(pauseButton == true) {
                 pauseTimer();
                 mp.pause();
             }

            if(audioIndex == (arrayOfAllAudio.length - 1)) {
                customHandler.removeCallbacks(updateTimerThread);
                mp.release();//Releases resources associated with MediaPlayer object.
            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCompletion(MediaPlayer arg0) {
        if (audioIndex < (arrayOfAllAudio.length - 1)) {
            audioIndex++;

            playCombo(audioIndex);
        }
    }

    //startTimer
    public void startTimer() {
        startTime = SystemClock.uptimeMillis();
        mPlay.postDelayed(updateTimerThread, 0);
    }

    //pauseTimer
    public void pauseTimer() {
        timeSwapBuff += timeInMilliseconds;
        customHandler.removeCallbacks(updateTimerThread);
    }

    //resetTimer
    public void resetTimer() {
        customHandler.removeCallbacks(updateTimerThread);
        //Reset Timer
        startTime = 0L;
        timeInMilliseconds = 0L;
        timeSwapBuff = 0L;
        updatedTime = 0L;

        //Change timer display
        pauseButton = false;
        int mins = 0;
        int secs = 0;
        int milliseconds = 0;
        timerValue.setText("" + mins + ":"
                + String.format("%02d", secs) + ":"
                + String.format("%03d", milliseconds));
    }
}