package tech.extropy.shadowbox;

import android.app.ActionBar;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;

public class BeginActivity extends AppCompatActivity implements OnCompletionListener {
    public final String TAG = ShadowBoxActivity.class.getSimpleName();

    private BoxingCombinations mCombinationsList;
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
    private boolean pauseButton = false;
    private TextView timerValue;
    private long startTime = 0L;
    private Handler customHandler = new Handler();
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_easy);
        mBoxTextView = (TextView) findViewById(R.id.boxTextView);
        mPlay = (Button) findViewById(R.id.showBoxButton);
        mPauseButton = (Button) findViewById(R.id.showPauseButton);
        mEasy = (Button) findViewById(R.id.showEasyButton);
        mReset = (Button) findViewById(R.id.showResetButton);
        timerValue = (TextView) findViewById(R.id.timerValue);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        Bundle data = getIntent().getExtras();
        final Preference settings = (Preference) data.getParcelable("settings");

        mCombinationsList = new BoxingCombinations(settings.getDifficulty(), settings.getSouthpaw());
        multipleCombination = mCombinationsList.getManyCombinations();
        arrayOfAllAudio = mCombinationsList.splitPunchString(multipleCombination);


        mp = mAudioCombinations.getSound(getApplicationContext(), arrayOfAllAudio[audioIndex]);

        arrayOfAllAudioInt = mAudioCombinations.getIntegerSound(getApplicationContext(), arrayOfAllAudio);

        uris = new Uri[arrayOfAllAudioInt.length];
        for(int x = 0; x < arrayOfAllAudioInt.length; x++) {
            uris[x] = Uri.parse("android.resource://tech.extropy.shadowbox/" + arrayOfAllAudioInt[x]);
        }

        mp = new MediaPlayer();

        mp.setOnCompletionListener(this);

        mReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(!mp.isPlaying() && (pauseButton==true)) {
                    pauseButton = true;
                    audioIndex = 0;
                    mp.reset();
                    resetTimer();
                    Context context = getApplicationContext();

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

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    public void onBackPressed() {
        mp.release();
        finish();
    }

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
    };

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
        } else {
            customHandler.removeCallbacks(updateTimerThread);
            mp.release();
        }
    }

    public void startTimer() {
        startTime = SystemClock.uptimeMillis();
        mPlay.postDelayed(updateTimerThread, 0);
    }

    public void pauseTimer() {
        timeSwapBuff += timeInMilliseconds;
        customHandler.removeCallbacks(updateTimerThread);
    }

    public void resetTimer() {
        customHandler.removeCallbacks(updateTimerThread);
        startTime = 0L;
        timeInMilliseconds = 0L;
        timeSwapBuff = 0L;
        updatedTime = 0L;
        pauseButton = false;
        int mins = 0;
        int secs = 0;
        int milliseconds = 0;

        timerValue.setText("" + mins + ":"
                + String.format("%02d", secs) + ":"
                + String.format("%03d", milliseconds));
    }
}