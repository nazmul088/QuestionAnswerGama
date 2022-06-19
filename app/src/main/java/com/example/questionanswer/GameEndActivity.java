package com.example.questionanswer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameEndActivity extends AppCompatActivity {
    private TextView textView;
    private Animation animation;

    private String language;

    private Context context;
    private Resources resources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end);
        language = getIntent().getStringExtra("language");

        Button button  = (Button) findViewById(R.id.button1);

        animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);

        textView = (TextView) findViewById(R.id.textView1);
        textView.setAnimation(animation);

        if(language.equalsIgnoreCase("Bangla"))
        {
            context = LocaleHelper.setLocale(GameEndActivity.this, "bn");
            resources = context.getResources();
            textView.setText(resources.getString(R.string.thank_you_for_your_time_have_a_good_day));
        }
        else{
            context = LocaleHelper.setLocale(GameEndActivity.this, "en");
            resources = context.getResources();
            textView.setText(resources.getString(R.string.thank_you_for_your_time_have_a_good_day));

        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaintwoActivity.ended = false;
                PracticeSecondActivity.ended = false;
                PracticeThirdActivity.ended = false;
                FirstMainQuestionActivity.ended = false;
                SecondMainQuestionActivity.ended = false;
                ThirdMainQuestionActivity.ended = false;
                startActivity(new Intent(getApplicationContext(),NameActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(GameEndActivity.this,"Cannot Go back on this stage",Toast.LENGTH_LONG).show();
    }
}