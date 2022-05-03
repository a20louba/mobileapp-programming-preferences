package com.example.project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    TextView textViewname;
    SharedPreferences preferences;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textViewname = findViewById(R.id.name);
        preferences = getSharedPreferences("preferences", MODE_PRIVATE);

                // denna kod skulle fungera i en setOnClickListener
        //SharedPreferences.Editor  editor= preferences.edit();
        //editor.putString("name","Louise");
        //editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String name = preferences.getString("name", "inget namn hittat");
        textViewname.setText(name);





    }
}
