package com.example.questionanswer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticeSessionEndActivity extends AppCompatActivity {

    private String language;

    private Context context;
    private Resources resources;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_session_end);
        TextView textView = (TextView) findViewById(R.id.textView1);
        String html = "You have completed the practice exercise. We will now move to the main exercise, " +
                "which will help us learn what you expect will change for a Leather Goods or " +
                "Footwear Firm similar to yours, if it replaces the clutch motor on one sewing machine " +
                "with a servo motor. We will ask you 3 questions. While answering please keep in mind that " +
                "we are asking these questions for a Leather Goods or Footwear firm similar to yours.";

        String banglahtml = "আপনি প্র্যাক্টিস অনুশীলনটি সম্পন্ন করেছেন। আমরা এখন মূল অনুশীলনে চলে যাব, যা " +
                "আমাদেরকে বুঝতে সাহায্য করবে যে, আপনি আপনার ফার্মের মতো চামড়জাত পণ্য বা ফুটওয়্যার ফার্মের জন্য " +
                "কী ধরনের পরিবর্তন আশা করেন, যদি একটি ক্লাচ মোটর চালিত সেলাই মেশিনে সার্ভো মোটর লাগানো/প্রতিস্থাপিত হয়। " +
                "আমরা আপনাকে ৩টি প্রশ্ন করবো। উত্তর দেওয়ার সময় অনুগ্রহ করে মনে রাখবেন যে আমরা প্রশ্নগুলি করছি  আপনার ফার্মের " +
                "মতো চামড়াজাত পণ্য উৎপাদন করে এরকম অথবা ফুটওয়্যার ফার্মের জন্য।";
        language = getIntent().getStringExtra("language");
        if(language.equalsIgnoreCase("Bangla"))
        {
                textView.setText(banglahtml);
        }
        else{
            textView.setText(Html.fromHtml(html));
        }

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PracticeSessionEndActivity.this,FirstMainQuestionActivity.class);
                intent.putExtra("language",language);
                startActivity(intent);
            }
        });
    }
}