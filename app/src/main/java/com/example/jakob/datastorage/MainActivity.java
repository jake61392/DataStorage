package com.example.jakob.datastorage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int count;
    private TextView textBox;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences file = getPreferences(0);
        count = file.getInt("count",0);
        textBox = (TextView)(findViewById(R.id.count));
        textBox.setText(String.valueOf(count));
    }

    public void increment(View v) {
        count++;
        textBox.setText(String.valueOf(count));
    }

    public void save(View v) {
        SharedPreferences file = getPreferences(0);
        SharedPreferences.Editor editor = file.edit();
        editor.putInt("count", count);
        editor.commit();
    }

    public void reset(View v) {
        count = 0;
        textBox.setText(String.valueOf(count));
    }
}
