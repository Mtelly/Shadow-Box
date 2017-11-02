package com.example.extropy.shadowbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.content.Intent;

public class ShadowBoxActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity :";
    private TextView mBoxTextView;
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
        mHard = (Button) findViewById(R.id.showHardButton);
        mMediumButton = (Button) findViewById(R.id.showMediumButton);
        mEasy = (Button) findViewById(R.id.easyButton);
        mSouthpaw = (Switch) findViewById(R.id.southpaw);

//Goes to a completely different activity.
        mEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startEasy(0);
            }
        });

        mMediumButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startEasy(1);
            }
        });

        mHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startEasy(2);
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