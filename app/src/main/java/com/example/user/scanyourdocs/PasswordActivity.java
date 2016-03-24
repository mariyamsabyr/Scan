package com.example.user.scanyourdocs;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by user on 07.02.2016.
 */
public class PasswordActivity extends AppCompatActivity{
    public Button button1,button2,button3,button4,button5,button6,
            button7,button8,button9,button0,buttonClear,
            buttonReady,buttonBack;

    EditText passwordText;
    boolean check=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        passwordText=(EditText)findViewById(R.id.passwordText);

        button1=(Button) findViewById(R.id.button1);
        button2=(Button) findViewById(R.id.button2);
        button3=(Button) findViewById(R.id.button3);
        button4=(Button) findViewById(R.id.button4);
        button5=(Button) findViewById(R.id.button5);
        button6=(Button) findViewById(R.id.button6);
        button7=(Button) findViewById(R.id.button7);
        button8=(Button) findViewById(R.id.button8);
        button9=(Button) findViewById(R.id.button9);
        button0=(Button) findViewById(R.id.button0);

        buttonBack=(Button)findViewById(R.id.buttonBack);
        buttonClear=(Button)findViewById(R.id.buttonClear);
        buttonReady=(Button)findViewById(R.id.buttonReady);

        final ArrayList<Button> numbers= new ArrayList<Button>();
        numbers.add(button1);
        numbers.add(button2);
        numbers.add(button3);
        numbers.add(button4);
        numbers.add(button5);
        numbers.add(button6);
        numbers.add(button7);
        numbers.add(button8);
        numbers.add(button9);
        numbers.add(button0);
        numbers.add(buttonBack);
        numbers.add(buttonClear);
        numbers.add(buttonReady);





        for (final Button b : numbers) {
            b.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        b.setTextColor(Color.BLACK);
                        //return true;
                    } else if (event.getAction() == MotionEvent.ACTION_UP) {
                        b.setTextColor(Color.WHITE);
                        //return true;
                    }
                    if(b==button1)
                        passwordText.setText(passwordText.getText()+"1");
                    if(b==button2)
                        passwordText.setText(passwordText.getText()+"2");
                    if(b==button3)
                        passwordText.setText(passwordText.getText()+"3");
                    if(b==button4)
                        passwordText.setText(passwordText.getText()+"4");
                    if(b==button5)
                        passwordText.setText(passwordText.getText()+"5");
                    if(b==button6)
                        passwordText.setText(passwordText.getText()+"6");
                    if(b==button7)
                        passwordText.setText(passwordText.getText()+"7");
                    if(b==button8)
                        passwordText.setText(passwordText.getText()+"8");
                    if(b==button9)
                        passwordText.setText(passwordText.getText()+"9");
                    if(b==button0)
                        passwordText.setText(passwordText.getText()+"0");

                    if (b == buttonClear) {
                        passwordText.setText("");
                        //Intent myIntent = new Intent(Biology.this, Geometry.class);
                        //startActivity(myIntent);
                        //Toast.makeText(PasswordActivity.this, passwordText.getText(),
                        //      Toast.LENGTH_SHORT).show();
                    }
                    if (b == buttonReady) {
                        Intent myIntent = new Intent(PasswordActivity.this, MainActivity.class);
                        startActivity(myIntent);
                        //Toast.makeText(PasswordActivity.this, passwordText.getText(),
                        //      Toast.LENGTH_SHORT).show();
                    }

                    if(b==buttonBack){
                        Intent myIntent = new Intent(PasswordActivity.this,
                                FirstActivity.class);
                        startActivity(myIntent);

                        //return false;
                    }
                    return true;
                }

            });
        }



    }
}
