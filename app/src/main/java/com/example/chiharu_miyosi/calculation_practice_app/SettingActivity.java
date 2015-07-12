package com.example.chiharu_miyosi.calculation_practice_app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.DialogPreference;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


public class SettingActivity extends ActionBarActivity {

    int question_numbers,eraser_color,minus;
    Spinner spinner,spinner2,spinner3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        final ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.setting, android.R.layout.simple_list_item_1);
        final ListView listview = (ListView)findViewById(R.id.listView);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position = (int)listview.getSelectedItemPosition();
                if(position == 0){
                    String[] items = getResources().getStringArray(R.array.question_numbers);
                    AlertDialog.Builder adb1 = new AlertDialog.Builder(SettingActivity.this);
                    int checkedItem;
                    checkedItem = 0;
                    adb1.setItems(new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which){

                        }
                    });
                    adb1.show();
                }
                //positionに応じてアラートダイアログを表示する。
            }
            public void onNothingSelected(AdapterView<?> parent,View view,int position,long id) {

            }
        });
    }

    public void to_start(View v){
        Intent intent = new Intent(SettingActivity.this,StartActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_setting, menu);
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
