package com.example.user.scanyourdocs;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;



/**
 * Created by user on 07.02.2016.
 */
public class FirstActivity extends AppCompatActivity {

    Button readyButton;
    MediaPlayer mp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        readyButton=(Button) findViewById(R.id.readyButton);
        //mp = MediaPlayer.create(this, R.raw.soho);
        readyButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    readyButton.setTextColor(Color.RED);
                    //return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    readyButton.setTextColor(Color.WHITE);
                    //return true;
                }
                Intent myIntent = new Intent(FirstActivity.this,
                        PasswordActivity.class);
                startActivity(myIntent);

                return true;
            }

        });
    }
}
