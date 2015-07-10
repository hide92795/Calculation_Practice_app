package com.example.chiharu_miyosi.calculation_practice_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;


public class StartActivity extends ActionBarActivity {
    int last_year;
    int last_month;
    int last_day;
    int last_date;
    int year;
    int month;
    int day;
    int date;
    int times_in_day;
    int continuous_day;
    TextView times_in_day_t,continuous_day_times_t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        times_in_day_t = (TextView)findViewById(R.id.textView9);
        continuous_day_times_t = (TextView)findViewById(R.id.textView10);
        SharedPreferences prefs = getSharedPreferences("last_year", Context.MODE_PRIVATE);
        SharedPreferences prefs2 = getSharedPreferences("last_month",Context.MODE_PRIVATE);
        SharedPreferences prefs3 = getSharedPreferences("last_day",Context.MODE_PRIVATE);
        SharedPreferences prefs4 = getSharedPreferences("times_day",Context.MODE_PRIVATE);
        SharedPreferences prefs5 = getSharedPreferences("continuous_day",Context.MODE_PRIVATE);
        SharedPreferences prefs6 = getSharedPreferences("last_date",Context.MODE_PRIVATE);
        times_in_day = prefs4.getInt("times_day",0);
        continuous_day = prefs5.getInt("continuous_day",0);
        last_year = prefs.getInt("last_year", 0);
        last_month = prefs2.getInt("last_month", 0);
        last_day = prefs3.getInt("last_day", 0);
        last_date = prefs6.getInt("last_date",0);
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        date = day + month * 100 + year * 10000;
        if(last_date == date){
            times_in_day = times_in_day + 1;
        }else{
            times_in_day = 1;
        }
        if(date == last_date + 1){
            continuous_day = continuous_day +1;
        }else{
            continuous_day = 0;
        }
        times_in_day_t.setText("今日(" + year + "年" + month + "月" + day + "日)、" + times_in_day + "回目のプレイです。");
        if(continuous_day > 0){
            continuous_day_times_t.setText(continuous_day + "日連続プレイです。");
        }else{
            continuous_day_times_t.setText("前回のプレイは" + last_year + "年" + last_month + "月" + last_day + "日です。");
        }
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("last_year",year);
        editor.commit();
        SharedPreferences.Editor editor2 = prefs2.edit();
        editor2.putInt("last_month",month);
        editor2.commit();
        SharedPreferences.Editor editor3 = prefs3.edit();
        editor3.putInt("last_day",day);
        editor3.commit();
        SharedPreferences.Editor editor4 = prefs4.edit();
        editor4.putInt("times_day",times_in_day);
        editor4.commit();
        SharedPreferences.Editor editor5 = prefs5.edit();
        editor5.putInt("continuous_day",continuous_day);
        editor5.commit();
        SharedPreferences.Editor editor6 = prefs6.edit();
        editor6.putInt("last_date",date);
        editor6.commit();
    }

    public void addition(View v){
        Intent intent = new Intent(StartActivity.this,AdditionActivity.class);
        startActivity(intent);
    }

    public void subtraction(View v){
        Intent intent = new Intent(StartActivity.this,SubtractionActivity.class);
        startActivity(intent);
    }

    public void settings(View v){
        Intent intent = new Intent(StartActivity.this,SettingActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
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
