package com.example.project;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private TextView textViewname;
    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;
    EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        myPreferenceRef = getPreferences(MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();
        textViewname = findViewById(R.id.text_name);
        SharedPreferences myPreferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        String name = myPreferences.getString("name", "hittade inget namn");
        textViewname.setText(name);

    }

    @Override

    protected void onResume() {
        super.onResume();


        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button button = findViewById(R.id.start_second_activity);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);


            }
        });


        TextView prefTextRef=new TextView(this);
        prefTextRef=(TextView)findViewById(R.id.name);
        prefTextRef.setText(myPreferenceRef.getString("MyAppPreferenceString", "No preference found."));





    }
}
