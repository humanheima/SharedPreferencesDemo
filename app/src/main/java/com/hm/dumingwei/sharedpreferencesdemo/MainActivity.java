package com.hm.dumingwei.sharedpreferencesdemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String TAG = "MainActivity";
    private Button btnPut;

    private Button btnGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getPreferences(MODE_PRIVATE);
        //sharedPreferences = getBaseContext().getSharedPreferences("dmw_shared_pref", MODE_PRIVATE);
        sharedPreferences = getBaseContext().getSharedPreferences("dmw_second_shared_pref", MODE_PRIVATE);
        //PreferenceManager.getDefaultSharedPreferences(this);
        btnPut = findViewById(R.id.btnPut);
        btnGet = findViewById(R.id.btnGet);
        editor = sharedPreferences.edit();


        btnPut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                put();
            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get();
            }

        });

    }

    private void put() {
        editor.putString("hello", "world");
        editor.commit();

    }

    private void get() {
        String temp = sharedPreferences.getString("hello", "hi");
        Log.e(TAG, "get: " + temp);
    }
}
