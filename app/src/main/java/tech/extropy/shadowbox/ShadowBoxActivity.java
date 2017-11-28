package tech.extropy.shadowbox;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import tech.extropy.shadowbox.R;

public class ShadowBoxActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity :";
    private TextView mBoxTextView;
    private Button mTraining;
    private Button mEasy;
    private Button mMediumButton;
    private Button mHard;
    private Switch mSouthpaw;

    //private Preference settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadow_box);
        mBoxTextView = (TextView) findViewById(R.id.boxTextView);
        mTraining = (Button) findViewById(R.id.showTrainingButton);
        mHard = (Button) findViewById(R.id.showHardButton);
        mMediumButton = (Button) findViewById(R.id.showMediumButton);
        mEasy = (Button) findViewById(R.id.showEasyButton);
        mSouthpaw = (Switch) findViewById(R.id.southpaw);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        ActionBar actionBar = getActionBar();
        //actionBar.hide();

        mTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startEasy(0);
            }
        });

        mEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startEasy(1);
            }
        });

        mMediumButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startEasy(2);
            }
        });

        mHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startEasy(3);
            }
        });

        //Keep device awake
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }//onCreate()

    private void startEasy(int difficulty) {
        Intent intent = new Intent(this, BeginActivity.class);
        intent.putExtra("settings", new Preference((mSouthpaw.isChecked() ? true : false), difficulty));
        startActivity(intent);
    }
}