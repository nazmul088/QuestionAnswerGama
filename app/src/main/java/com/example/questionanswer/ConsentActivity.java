package com.example.questionanswer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class ConsentActivity extends AppCompatActivity {

    private Button button;
    private CheckBox checkBox,checkBox1;
    private TextView textView;
    private Context context;
    private Resources resources;

    private String language;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_consent);
            String name = getIntent().getStringExtra("name");
            textView = (TextView) findViewById(R.id.textView4);
            textView.setText(name);

            language = getIntent().getStringExtra("language");
            if (language.equalsIgnoreCase("Bangla")) {
                System.out.println("In Bangla");
                context = LocaleHelper.setLocale(ConsentActivity.this, "bn");
                resources = context.getResources();
                textView = (TextView) findViewById(R.id.textView3);
                textView.setText(resources.getString(R.string.consent_label));

                textView = (TextView) findViewById(R.id.textView1);
                textView.setText(resources.getString(R.string.hello_my_name_is));

                textView = (TextView) findViewById(R.id.textView2);
                textView.setLineSpacing((float) 0.01, 1);
                textView.setText(resources.getString(R.string.consent_text));

            } else {

                context = LocaleHelper.setLocale(ConsentActivity.this, "en");
                resources = context.getResources();
                textView = (TextView) findViewById(R.id.textView3);
                textView.setText(resources.getString(R.string.consent_label));

                textView = (TextView) findViewById(R.id.textView1);
                textView.setText(resources.getString(R.string.hello_my_name_is));

                textView = (TextView) findViewById(R.id.textView2);
                textView.setText(resources.getString(R.string.consent_text));

            }
            //Change Language


//        languageSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(b){//In bangla
//
//
//                }else{ //In English
//                    languageSwitch.setText("Bangla");
//
//                }
//            }
//        });


            button = (Button) findViewById(R.id.button1);
            checkBox = (CheckBox) findViewById(R.id.checkbox1);
            checkBox1 = (CheckBox) findViewById(R.id.checkbox2);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (checkBox.isChecked()) {
                        checkBox1.setEnabled(false);
                    } else {
                        checkBox1.setEnabled(true);
                    }
                }
            });

            checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (checkBox1.isChecked()) {
                        checkBox.setEnabled(false);
                    } else {
                        checkBox.setEnabled(true);
                    }
                }
            });
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if (checkBox.isChecked()) {
                        Intent intent = new Intent(ConsentActivity.this, InstructionActivity.class);
                        intent.putExtra("language", language);
                        startActivity(intent);
                    } else if (checkBox1.isChecked()) {
                        Intent intent = new Intent(ConsentActivity.this, GameEndActivity.class);
                        intent.putExtra("language", language);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ConsentActivity.this, "Please check any one agreement", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }catch (Exception e ){
            Toast.makeText(ConsentActivity.this, "e2"+e, Toast.LENGTH_SHORT).show();
            Toast.makeText(ConsentActivity.this, "e2"+e, Toast.LENGTH_SHORT).show();
            Toast.makeText(ConsentActivity.this, "e2"+e, Toast.LENGTH_SHORT).show();

        }

    }


}