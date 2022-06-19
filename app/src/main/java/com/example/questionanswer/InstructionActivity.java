package com.example.questionanswer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InstructionActivity extends AppCompatActivity {

    private Button button;
    private String language;

    private TextView textView;
    private Context context;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        language = getIntent().getStringExtra("language");
        if(language.equalsIgnoreCase("Bangla"))
        {
            context = LocaleHelper.setLocale(InstructionActivity.this, "bn");
            resources = context.getResources();
            textView = (TextView) findViewById(R.id.textView3);
            textView.setText(resources.getString(R.string.instructionsLabel));

            textView = (TextView) findViewById(R.id.textView2);
            textView.setText(resources.getString(R.string.instructionsText));

        }
        else{
            context = LocaleHelper.setLocale(InstructionActivity.this, "en");
            resources = context.getResources();
            textView = (TextView) findViewById(R.id.textView3);
            textView.setText(resources.getString(R.string.instructionsLabel));

            textView = (TextView) findViewById(R.id.textView2);
            textView.setText(resources.getString(R.string.instructionsText));
        }
        button = (Button) findViewById(R.id.button1);
        button.setText("Next");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InstructionActivity.this,DemoGameActivity.class);
                intent.putExtra("language",language);
                startActivity(intent);
            }
        });


    }
}