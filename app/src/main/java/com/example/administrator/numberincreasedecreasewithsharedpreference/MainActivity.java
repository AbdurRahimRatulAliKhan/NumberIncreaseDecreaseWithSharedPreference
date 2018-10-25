package com.example.administrator.numberincreasedecreasewithsharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        loadData();
    }

    private void loadData() {
        SharedPreferences preferences = getSharedPreferences("database",MODE_PRIVATE);
        int lastScore = preferences.getInt("score",0);
        textView.setText(String.valueOf(lastScore));
    }

    public void buttonClick(View view) {
        if(view.getId()==R.id.button){
            int score = Integer.parseInt(textView.getText().toString());
            score++;
            textView.setText(String.valueOf(score));

            saveScore(score);
        }
        else if(view.getId()==R.id.button2){
            int score = Integer.parseInt(textView.getText().toString());
            score--;
            textView.setText(String.valueOf(score));
            saveScore(score);
        }
    }

    private void saveScore(int score) {
        SharedPreferences preferences = getSharedPreferences("database",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt("score",score).commit();
    }
}
