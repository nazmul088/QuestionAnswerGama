package com.example.questionanswer;

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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultActivity extends AppCompatActivity {
    private Animation animation;
    private Button button;
    private Context context;
    private Resources resources;
    private TextView textView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_result);
        final String game = getIntent().getStringExtra("game");
        String earnValue = getIntent().getStringExtra("earn");
        String lostValue = getIntent().getStringExtra("lost");
        final String language = getIntent().getStringExtra("language");
        if (game.equalsIgnoreCase("practice")) {
            TextView textView2 = (TextView) findViewById(R.id.textView);
            this.textView = textView2;
            textView2.setAnimation(this.animation);
            String str = "The correct answer to this question is 136.Based on your allocation, you earned " + Double.parseDouble(earnValue) + " taka";
            String banglaStr = "এই প্রশ্নের সঠিক উত্তর হল ১৩৬। আপনার বরাদ্দের উপর ভিত্তি করে, আপনি " + MyStaff.numBangla(Double.parseDouble(earnValue)) + "টাকা অর্জন করেছেন।\n";
            if (language.equalsIgnoreCase("Bangla")) {
                Context locale = LocaleHelper.setLocale(this, "bn");
                this.context = locale;
                this.resources = locale.getResources();
                TextView textView3 = (TextView) findViewById(R.id.textView1);
                this.textView = textView3;
                textView3.setText(banglaStr);
                Animation loadAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                this.animation = loadAnimation;
                this.textView.setAnimation(loadAnimation);
                TextView textView4 = (TextView) findViewById(R.id.textView);
                this.textView = textView4;
                textView4.setText(this.resources.getString(R.string.thank_you_for_your_answer));
                Animation loadAnimation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                this.animation = loadAnimation2;
                this.textView.setAnimation(loadAnimation2);
            } else {
                Context locale2 = LocaleHelper.setLocale(this, "en");
                this.context = locale2;
                this.resources = locale2.getResources();
                TextView textView5 = (TextView) findViewById(R.id.textView1);
                this.textView = textView5;
                textView5.setText(str);
                Animation loadAnimation3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                this.animation = loadAnimation3;
                this.textView.setAnimation(loadAnimation3);
                TextView textView6 = (TextView) findViewById(R.id.textView);
                this.textView = textView6;
                textView6.setText(this.resources.getString(R.string.thank_you_for_your_answer));
                Animation loadAnimation4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                this.animation = loadAnimation4;
                this.textView.setAnimation(loadAnimation4);
            }
        } else if (game.equalsIgnoreCase("practiceSecond")) {
            TextView textView7 = (TextView) findViewById(R.id.textView);
            this.textView = textView7;
            textView7.setAnimation(this.animation);
            this.animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
            String str2 = "The correct answer to this question is 92.2%.Based on your allocation, you earned " + Double.parseDouble(earnValue) + " taka";
            String banglaStr2 = "এই প্রশ্নের সঠিক উত্তর হল ৯২.২%। আপনার বরাদ্দের উপর ভিত্তি করে, আপনি " + MyStaff.numBangla(Double.parseDouble(earnValue)) + "টাকা অর্জন করেছেন।\n";
            if (language.equalsIgnoreCase("Bangla")) {
                Context locale3 = LocaleHelper.setLocale(this, "bn");
                this.context = locale3;
                this.resources = locale3.getResources();
                TextView textView8 = (TextView) findViewById(R.id.textView1);
                this.textView = textView8;
                textView8.setText(banglaStr2);
                Animation loadAnimation5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                this.animation = loadAnimation5;
                this.textView.setAnimation(loadAnimation5);
                TextView textView9 = (TextView) findViewById(R.id.textView);
                this.textView = textView9;
                textView9.setText(this.resources.getString(R.string.thank_you_for_your_answer));
                Animation loadAnimation6 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                this.animation = loadAnimation6;
                this.textView.setAnimation(loadAnimation6);
            } else {
                Context locale4 = LocaleHelper.setLocale(this, "en");
                this.context = locale4;
                this.resources = locale4.getResources();
                TextView textView10 = (TextView) findViewById(R.id.textView1);
                this.textView = textView10;
                textView10.setText(str2);
                Animation loadAnimation7 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                this.animation = loadAnimation7;
                this.textView.setAnimation(loadAnimation7);
                TextView textView11 = (TextView) findViewById(R.id.textView);
                this.textView = textView11;
                textView11.setText(this.resources.getString(R.string.thank_you_for_your_answer));
                Animation loadAnimation8 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                this.animation = loadAnimation8;
                this.textView.setAnimation(loadAnimation8);
            }
        } else if (game.equalsIgnoreCase("practiceThird")) {
            TextView textView12 = (TextView) findViewById(R.id.textView);
            this.textView = textView12;
            textView12.setAnimation(this.animation);
            this.animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
            String str3 = "The correct answer to this question is $70191 million.Based on your allocation, you earned " + Double.parseDouble(earnValue) + " taka.";
            String banglaStr3 = "এই প্রশ্নের সঠিক উত্তর হল ৭১৯১ হাজার কোটি টাকা। আপনার বরাদ্দের উপর ভিত্তি করে, আপনি " + MyStaff.numBangla(Double.parseDouble(earnValue)) + "টাকা অর্জন করেছেন।\n";
            if (language.equalsIgnoreCase("Bangla")) {
                Context locale5 = LocaleHelper.setLocale(this, "bn");
                this.context = locale5;
                this.resources = locale5.getResources();
                TextView textView13 = (TextView) findViewById(R.id.textView1);
                this.textView = textView13;
                textView13.setText(banglaStr3);
                Animation loadAnimation9 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                this.animation = loadAnimation9;
                this.textView.setAnimation(loadAnimation9);
                TextView textView14 = (TextView) findViewById(R.id.textView);
                this.textView = textView14;
                textView14.setText(this.resources.getString(R.string.thank_you_for_your_answer));
                Animation loadAnimation10 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                this.animation = loadAnimation10;
                this.textView.setAnimation(loadAnimation10);
            } else {
                Context locale6 = LocaleHelper.setLocale(this, "en");
                this.context = locale6;
                this.resources = locale6.getResources();
                TextView textView15 = (TextView) findViewById(R.id.textView1);
                this.textView = textView15;
                textView15.setText(str3);
                TextView textView16 = (TextView) findViewById(R.id.textView);
                this.textView = textView16;
                textView16.setText(this.resources.getString(R.string.thank_you_for_your_answer));
                Animation loadAnimation11 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                this.animation = loadAnimation11;
                this.textView.setAnimation(loadAnimation11);
            }
        } else if (game.equalsIgnoreCase("secondQuestion")) {
            TextView textView17 = (TextView) findViewById(R.id.textView);
            this.textView = textView17;
            textView17.setAnimation(this.animation);
            this.animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
            TextView textView18 = (TextView) findViewById(R.id.textView1);
            this.textView = textView18;
            textView18.setText("The correct answer to this question is 35.69%.Based on your allocation, you earned " + earnValue + " points and lost " + lostValue + " points");
            this.textView.setAnimation(this.animation);
        } else if (game.equalsIgnoreCase("firstMainQuestion") || game.equalsIgnoreCase("SecondMainQuestion") || game.equalsIgnoreCase("thirdMainQuestion")) {
            TextView textView19 = (TextView) findViewById(R.id.textView);
            this.textView = textView19;
            textView19.setAnimation(this.animation);
            this.animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
            if (language.equalsIgnoreCase("Bangla")) {
                Context locale7 = LocaleHelper.setLocale(this, "bn");
                this.context = locale7;
                this.resources = locale7.getResources();
                TextView textView20 = (TextView) findViewById(R.id.textView1);
                this.textView = textView20;
                textView20.setText("আমরা আপনার অর্জিত বোনাস হিসাব করবো এবং এন্ড লাইন সার্ভের পরে আপনার ফেক্টরি/কারখানার মোবাইল মানি অ্যাকাউন্টে টাকাটি পাঠিয়ে দিবো।\n");
                Animation loadAnimation12 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                this.animation = loadAnimation12;
                this.textView.setAnimation(loadAnimation12);
                TextView textView21 = (TextView) findViewById(R.id.textView);
                this.textView = textView21;
                textView21.setText(this.resources.getString(R.string.thank_you_for_your_answer));
                Animation loadAnimation13 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                this.animation = loadAnimation13;
                this.textView.setAnimation(loadAnimation13);
            } else {
                Context locale8 = LocaleHelper.setLocale(this, "en");
                this.context = locale8;
                this.resources = locale8.getResources();
                TextView textView22 = (TextView) findViewById(R.id.textView1);
                this.textView = textView22;
                textView22.setText("We will calculate your earned bonus and send the amount in your firm’s mobile money account after the Endline Survey.");
                TextView textView23 = (TextView) findViewById(R.id.textView);
                this.textView = textView23;
                textView23.setText(this.resources.getString(R.string.thank_you_for_your_answer));
                Animation loadAnimation14 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                this.animation = loadAnimation14;
                this.textView.setAnimation(loadAnimation14);
            }
        }
        Button button2 = (Button) findViewById(R.id.button1);
        this.button = button2;
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (game.equalsIgnoreCase("practice")) {
                    Intent intent = new Intent(ResultActivity.this.getApplicationContext(), PracticeSecondActivity.class);
                    intent.putExtra("language", language);
                    ResultActivity.this.startActivity(intent);
                }
                if (game.equalsIgnoreCase("practiceSecond")) {
                    Intent intent2 = new Intent(ResultActivity.this.getApplicationContext(), PracticeThirdActivity.class);
                    intent2.putExtra("language", language);
                    ResultActivity.this.startActivity(intent2);
                } else if (game.equalsIgnoreCase("practiceThird")) {
                    Intent intent3 = new Intent(ResultActivity.this.getApplicationContext(), PracticeSessionEndActivity.class);
                    intent3.putExtra("language", language);
                    ResultActivity.this.startActivity(intent3);
                } else if (game.equalsIgnoreCase("secondQuestion")) {
                    Intent intent4 = new Intent(ResultActivity.this.getApplicationContext(), PracticeSessionEndActivity.class);
                    intent4.putExtra("language", language);
                    ResultActivity.this.startActivity(intent4);
                } else if (game.equalsIgnoreCase("firstMainQuestion")) {
                    Intent intent5 = new Intent(ResultActivity.this.getApplicationContext(), SecondMainQuestionActivity.class);
                    intent5.putExtra("language", language);
                    ResultActivity.this.startActivity(intent5);
                } else if (game.equalsIgnoreCase("secondMainQuestion")) {
                    Intent intent6 = new Intent(ResultActivity.this.getApplicationContext(), ThirdMainQuestionActivity.class);
                    intent6.putExtra("language", language);
                    ResultActivity.this.startActivity(intent6);
                } else if (game.equalsIgnoreCase("thirdMainQuestion")) {
                    ResultActivity.this.uploadToServer();
                    Intent intent7 = new Intent(ResultActivity.this.getApplicationContext(), GameEndActivity.class);
                    intent7.putExtra("language", language);
                    ResultActivity.this.startActivity(intent7);
                }
            }
        });
    }



    /* access modifiers changed from: private */
    public void uploadToServer() {
        FirebaseDatabase.getInstance().getReference("counter").addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {
                int size = 0;
                try {
                    size = Integer.parseInt(snapshot.getValue().toString());
                } catch (Exception e) {
                }
                HashMap<String, String> main = new HashMap<>();
                main.put("Date",ThirdMainQuestionActivity.Game_Play_Date);
                main.put("Start Time",MaintwoActivity.startTime);
                main.put("End Time",ThirdMainQuestionActivity.endTime);
                SimpleDateFormat simpleDateFormat
                        = new SimpleDateFormat("HH:mm:ss");

                // Parsing the Time Period
                try {
                    Date time1 = simpleDateFormat.parse(MaintwoActivity.startTime);
                    Date time2 = simpleDateFormat.parse(ThirdMainQuestionActivity.endTime);

                    long differenceInMilliSeconds
                            = Math.abs(time2.getTime() - time1.getTime());
                    long differenceInSeconds
                            = (differenceInMilliSeconds / 1000) % 60;

                    long differenceInMinutes
                            = (differenceInMilliSeconds / (60 * 1000)) % 60;
                    main.put("Duration",differenceInMinutes+ " m " + differenceInSeconds+ " s ");
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                main.put("id", NameActivity.id);
                main.put("enumerator_name", NameActivity.enumerator_name);
                main.put("respondent_name", NameActivity.respondent_name);
                List<HashMap<String, String>> lists = new ArrayList<>();
                lists.add(MaintwoActivity.resp);
                lists.add(PracticeSecondActivity.resp);
                lists.add(PracticeThirdActivity.resp);
                lists.add(FirstMainQuestionActivity.resp);
                lists.add(SecondMainQuestionActivity.resp);
                lists.add(ThirdMainQuestionActivity.resp);

                for (int i = 0; i < lists.size(); i++) {
                    int ii = 1;
                    for (Map.Entry<String, String> entry : lists.get(i).entrySet()) {
                        main.put("game" + (i + 1) + "_box" + ii, entry.getValue());
                        ii++;
                    }
                }
                main.put("game1Score", MaintwoActivity.resultString);
                main.put("game2Score", PracticeSecondActivity.resultString);
                main.put("game3Score", PracticeThirdActivity.resultString);
                main.put("game4Score", FirstMainQuestionActivity.resultString);
                main.put("game5Score", SecondMainQuestionActivity.resultString);
                main.put("game6Score", ThirdMainQuestionActivity.resultString);

                int size2 = size + 1;
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
                databaseReference.child("game/" + size2).setValue(main).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ResultActivity.this,"Result Uploaded Successfully",Toast.LENGTH_LONG).show();
                    }
                });
                databaseReference.child("counter").setValue(Integer.valueOf(size2));
            }

            public void onCancelled(DatabaseError error) {
            }
        });
    }
}
