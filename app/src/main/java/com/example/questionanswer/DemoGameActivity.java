package com.example.questionanswer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DemoGameActivity extends AppCompatActivity {


    private TextView textView;
    private Context context;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_game);

        String language = getIntent().getStringExtra("language");

        if(language.equalsIgnoreCase("Bangla"))
        {
            context = LocaleHelper.setLocale(DemoGameActivity.this, "bn");
            resources = context.getResources();
            textView = (TextView) findViewById(R.id.textView);
            textView.setText(resources.getString(R.string.instructionsText2));
        }
        else{
            context = LocaleHelper.setLocale(DemoGameActivity.this, "en");
            resources = context.getResources();
            textView = (TextView) findViewById(R.id.textView);
            textView.setText(resources.getString(R.string.instructionsText2));
        }

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DemoGameActivity.this,MaintwoActivity.class);
                intent.putExtra("language",language);
                startActivity(intent);
            }
        });
    }
}