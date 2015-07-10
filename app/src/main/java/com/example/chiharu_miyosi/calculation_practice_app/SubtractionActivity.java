package com.example.chiharu_miyosi.calculation_practice_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class SubtractionActivity extends ActionBarActivity {

    TextView number1;
    TextView number2;
    TextView answer;
    TextView correct_t;
    ImageView eraser_image,correct_img,incorrect_img;
    int n1;
    int n2;
    int a;
    int ca;
    int correct;
    int times;
    int question_numbers;
    int eraser_color;
    int minus;
    boolean answer_minus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction);

        correct_img = (ImageView)findViewById(R.id.correct_img);
        correct_img.setVisibility(View.GONE);
        incorrect_img = (ImageView)findViewById(R.id.incorrect_img);
        incorrect_img.setVisibility(View.GONE);
        eraser_image = (ImageView)findViewById(R.id.imageView);
        SharedPreferences prefs2 = getSharedPreferences("eraser_color", Context.MODE_PRIVATE);
        eraser_color = prefs2.getInt("eraser_color",1);
        int image = getResources().getIdentifier("delete_button_" + eraser_color, "drawable", getPackageName());
        eraser_image.setImageResource(image);
        SharedPreferences prefs = getSharedPreferences("question_numbers", Context.MODE_PRIVATE);
        question_numbers = prefs.getInt("question_numbers",10);
        SharedPreferences prefs3 =getSharedPreferences("minus",Context.MODE_PRIVATE);
        minus = prefs3.getInt("minus",1);
        number1 = (TextView)findViewById(R.id.number1);
        number2 = (TextView)findViewById(R.id.number2);
        answer = (TextView)findViewById(R.id.answer);
        correct_t = (TextView)findViewById(R.id.correct);
        correct_t.setText("0/0問");
        if(minus == 1) {
            while (n1 < n2) {
                n1 = (int)(Math.random() * 98) + 1;
                n2 = (int)(Math.random() * 98) + 1;
            }
        }else{
            n1 = (int)(Math.random()*98) + 1;
            n2 = (int)(Math.random()*98) + 1;
        }
        number1.setText(String.valueOf(n1));
        number2.setText(String.valueOf(n2));
        answer.setText("");
        ca = n1 - n2;
        a = 0;
        correct = 0;
        times = 0;
        answer_minus = false;
    }

    public void click1(View v){
        if(answer_minus == true){
            if(a == 0){
                a = -1;
            }else{
                a = -1 + a * 10;
            }
        }else{
            if(a == 0){
                a = 1;
            }else{
                a = 1 + a * 10;
            }
        }
        answer.setText(String.valueOf(a));
    }

    public void click2(View v) {
        if(answer_minus == true){
            if(a == 0){
                a = -2;
            }else{
                a = -2 + a * 10;
            }
        }else{
            if(a == 0){
                a = 2;
            }else{
                a = 2 + a * 10;
            }
        }
        answer.setText(String.valueOf(a));
    }

    public void click3(View v) {
        if(answer_minus == true){
            if(a == 0){
                a = -3;
            }else{
                a = -3 + a * 10;
            }
        }else{
            if(a == 0){
                a = 3;
            }else{
                a = 3 + a * 10;
            }
        }
        answer.setText(String.valueOf(a));
    }

    public void click4(View v) {
        if(answer_minus == true){
            if(a == 0){
                a = -4;
            }else{
                a = -4 + a * 10;
            }
        }else{
            if(a == 0){
                a = 4;
            }else{
                a = 4 + a * 10;
            }
        }
        answer.setText(String.valueOf(a));
    }

    public void click5(View v) {
        if(answer_minus == true){
            if(a == 0){
                a = -5;
            }else{
                a = -5 + a * 10;
            }
        }else{
            if(a == 0){
                a = 5;
            }else{
                a = 5 + a * 10;
            }
        }
        answer.setText(String.valueOf(a));
    }

    public void click6(View v) {
        if(answer_minus == true){
            if(a == 0){
                a = -6;
            }else{
                a = -6 + a * 10;
            }
        }else{
            if(a == 0){
                a = 6;
            }else{
                a = 6 + a * 10;
            }
        }
        answer.setText(String.valueOf(a));
    }

    public void click7(View v) {
        if(answer_minus == true){
            if(a == 0){
                a = -7;
            }else{
                a = -7 + a * 10;
            }
        }else{
            if(a == 0){
                a = 7;
            }else{
                a = 7 + a * 10;
            }
        }
        answer.setText(String.valueOf(a));
    }

    public void click8(View v) {
        if(answer_minus == true){
            if(a == 0){
                a = -8;
            }else{
                a = -8 + a * 10;
            }
        }else{
            if(a == 0){
                a = 8;
            }else{
                a = 8 + a * 10;
            }
        }
        answer.setText(String.valueOf(a));
    }

    public void click9(View v) {
        if(answer_minus == true){
            if(a == 0){
                a = -9;
            }else{
                a = -9 + a * 10;
            }
        }else{
            if(a == 0){
                a = 9;
            }else{
                a = 9 + a * 10;
            }
        }
        answer.setText(String.valueOf(a));
    }

    public void click0(View v) {
        if (a == 0) {
            a = 0;
        } else {
            a = a * 10;
        }
        answer.setText(String.valueOf(a));
    }

    public void erase (View v){
        if(a < 10){
            a = 0;
        }else{
            a = a / 10;
        }
        answer.setText(String.valueOf(a));
    }

    public void click_minus (View v){
        if(a == 0){
            answer.setText("-");
            answer_minus = true;
        }else{
            a = a * -1;
            answer.setText(String.valueOf(a));
        }
    }

    public void next(View v){
        times = times + 1;
        if(a == ca){
            correct = correct + 1;
            correct_img.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    correct_img.setVisibility(View.GONE);
                    if(minus == 1) {
                        while (n1 < n2) {
                            n1 = (int) (Math.random() * 98) + 1;
                            n2 = (int) (Math.random() * 98) + 1;
                        }
                    }else{
                        n1 = (int) (Math.random() * 98) + 1;
                        n2 = (int) (Math.random() * 98) + 1;
                    }
                }
            },1000);
        }else{
            incorrect_img.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    incorrect_img.setVisibility(View.GONE);
                    if (minus == 1) {
                        while (n1 < n2) {
                            n1 = (int) (Math.random() * 98) + 1;
                            n2 = (int) (Math.random() * 98) + 1;
                        }
                    } else {
                        n1 = (int) (Math.random() * 98) + 1;
                        n2 = (int) (Math.random() * 98) + 1;
                    }
                }
            }, 1000);
        }
        number1.setText(String.valueOf(n1));
        number2.setText(String.valueOf(n2));
        answer.setText("");
        ca = n1 - n2;
        a = 0;
        correct_t.setText(correct + "/" + times + "問");
        answer_minus = false;

        if(times == question_numbers){
            Intent intent = new Intent();
            intent.putExtra("correct",correct);
            intent.setAction(Intent.ACTION_MAIN);
            intent.setClass(SubtractionActivity.this, FinishActivity.class);
            startActivity(intent);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_subtraction, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
