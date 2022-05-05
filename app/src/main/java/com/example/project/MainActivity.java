package com.example.project;

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

    TextView textViewname;
    SharedPreferences preferences;
    EditText editText;

    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button button = findViewById(R.id.start_second_activity);
        button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("name", "Louise");
                    startActivity(intent);
                }
        });

        myPreferenceRef = getPreferences(MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

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

        TextView prefTextRef=new TextView(this);
        prefTextRef=(TextView)findViewById(R.id.text_view);
        prefTextRef.setText(myPreferenceRef.getString("MyAppPreferenceString", "No preference found."));





    }
}
