package com.example.questionanswer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SecondMainQuestionActivity extends CustomActivity {
    public static Activity activity;
    public static boolean ended = false;
    public static HashMap<String, String> resp = new HashMap<>();
    public static String resultString = "";
    public static int[] value = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: a */
    double f33a = 3000.0d;

    /* renamed from: b */
    double f34b = 1500.0d;
    private Button button;
    private Context context;
    /* access modifiers changed from: private */
    public String language;
    private Resources resources;
    /* access modifiers changed from: private */
    public TextView textView;
    int totVal = 0;

    public void onBackPressed() {
    }

    private void setupTableBangla() {
        TableLayout tableLayout = (TableLayout) findViewById(R.id.table_layout);
        for (int i = 0; i < 10; i++) {
            double calculateResult = calculateResult(i);
            TextView textView2 = (TextView) ((TableRow) tableLayout.getChildAt(i + 1)).getChildAt(0);
            this.textView = textView2;
            if (i == 0) {
                textView2.setText("যদি ০-০.৫ সঠিক হয়");
            } else if (i == 1) {
                textView2.setText("যদি ০.৫-১ সঠিক হয়");
            }
            if (i == 2) {
                this.textView.setText("যদি ১-১.৫ সঠিক হয়");
            } else if (i == 3) {
                this.textView.setText("যদি ১.৫-২ সঠিক হয়");
            } else if (i == 4) {
                this.textView.setText("যদি ২-২.৫ সঠিক হয়");
            } else if (i == 5) {
                this.textView.setText("যদি ২.৫-৩ সঠিক হয়");
            } else if (i == 6) {
                this.textView.setText("যদি ৩-৩.৫ সঠিক হয়");
            } else if (i == 7) {
                this.textView.setText("যদি ৩.৫-৪ সঠিক হয়");
            } else if (i == 8) {
                this.textView.setText("যদি ৪-৪.৫ সঠিক হয়");
            } else if (i == 9) {
                this.textView.setText("যদি ৪.৫-৫ সঠিক হয়");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        il = new ItemList[11];
        activity = this;
        setContentView((int) R.layout.activity_second_main_question);
        String stringExtra = getIntent().getStringExtra("language");
        this.language = stringExtra;
        if (stringExtra.equalsIgnoreCase("Bangla")) {
            setupTableBangla();
        }
        if (this.language.equalsIgnoreCase("Bangla")) {
            Context locale = LocaleHelper.setLocale(this, "bn");
            this.context = locale;
            this.resources = locale.getResources();
            TextView textView2 = (TextView) findViewById(R.id.textView);
            this.textView = textView2;
            textView2.setText(this.resources.getString(R.string.mainQuestion2));
            TextView textView3 = (TextView) findViewById(R.id.h1);
            this.textView = textView3;
            textView3.setText(this.resources.getString(R.string.q_4_o_1));
            TextView textView4 = (TextView) findViewById(R.id.h2);
            this.textView = textView4;
            textView4.setText(this.resources.getString(R.string.q_4_o_2));
            TextView textView5 = (TextView) findViewById(R.id.h3);
            this.textView = textView5;
            textView5.setText(this.resources.getString(R.string.q_4_o_3));
            TextView textView6 = (TextView) findViewById(R.id.h4);
            this.textView = textView6;
            textView6.setText(this.resources.getString(R.string.q_4_o_4));
            TextView textView7 = (TextView) findViewById(R.id.h5);
            this.textView = textView7;
            textView7.setText(this.resources.getString(R.string.q_4_o_5));
            TextView textView8 = (TextView) findViewById(R.id.h6);
            this.textView = textView8;
            textView8.setText(this.resources.getString(R.string.q_4_o_6));
            TextView textView9 = (TextView) findViewById(R.id.h7);
            this.textView = textView9;
            textView9.setText(this.resources.getString(R.string.q_4_o_7));
            TextView textView10 = (TextView) findViewById(R.id.h8);
            this.textView = textView10;
            textView10.setText(this.resources.getString(R.string.q_4_o_8));
            TextView textView11 = (TextView) findViewById(R.id.h9);
            this.textView = textView11;
            textView11.setText(this.resources.getString(R.string.q_4_o_9));
            TextView textView12 = (TextView) findViewById(R.id.h10);
            this.textView = textView12;
            textView12.setText(this.resources.getString(R.string.q_4_o_10));
        } else {
            Context locale2 = LocaleHelper.setLocale(this, "en");
            this.context = locale2;
            this.resources = locale2.getResources();
            TextView textView13 = (TextView) findViewById(R.id.textView);
            this.textView = textView13;
            textView13.setText(this.resources.getString(R.string.mainQuestion2));
            TextView textView14 = (TextView) findViewById(R.id.h1);
            this.textView = textView14;
            textView14.setText(this.resources.getString(R.string.q_4_o_1));
            TextView textView15 = (TextView) findViewById(R.id.h2);
            this.textView = textView15;
            textView15.setText(this.resources.getString(R.string.q_4_o_2));
            TextView textView16 = (TextView) findViewById(R.id.h3);
            this.textView = textView16;
            textView16.setText(this.resources.getString(R.string.q_4_o_3));
            TextView textView17 = (TextView) findViewById(R.id.h4);
            this.textView = textView17;
            textView17.setText(this.resources.getString(R.string.q_4_o_4));
            TextView textView18 = (TextView) findViewById(R.id.h5);
            this.textView = textView18;
            textView18.setText(this.resources.getString(R.string.q_4_o_5));
            TextView textView19 = (TextView) findViewById(R.id.h6);
            this.textView = textView19;
            textView19.setText(this.resources.getString(R.string.q_4_o_6));
            TextView textView20 = (TextView) findViewById(R.id.h7);
            this.textView = textView20;
            textView20.setText(this.resources.getString(R.string.q_4_o_7));
            TextView textView21 = (TextView) findViewById(R.id.h8);
            this.textView = textView21;
            textView21.setText(this.resources.getString(R.string.q_4_o_8));
            TextView textView22 = (TextView) findViewById(R.id.h9);
            this.textView = textView22;
            textView22.setText(this.resources.getString(R.string.q_4_o_9));
            TextView textView23 = (TextView) findViewById(R.id.h10);
            this.textView = textView23;
            textView23.setText(this.resources.getString(R.string.q_4_o_10));
        }
        lsrc = (RecyclerView) findViewById(R.id.lsrc);
        src = (CardView) findViewById(R.id.src);
        ldes[0] = (RecyclerView) findViewById(R.id.ldes1);
        ldes[1] = (RecyclerView) findViewById(R.id.ldes2);
        ldes[2] = (RecyclerView) findViewById(R.id.ldes3);
        ldes[3] = (RecyclerView) findViewById(R.id.ldes4);
        ldes[4] = (RecyclerView) findViewById(R.id.ldes5);
        ldes[5] = (RecyclerView) findViewById(R.id.ldes6);
        ldes[6] = (RecyclerView) findViewById(R.id.ldes7);
        ldes[7] = (RecyclerView) findViewById(R.id.ldes8);
        ldes[8] = (RecyclerView) findViewById(R.id.ldes9);
        ldes[9] = (RecyclerView) findViewById(R.id.ldes10);
        des[0] = (CardView) findViewById(R.id.des1);
        des[1] = (CardView) findViewById(R.id.des2);
        des[2] = (CardView) findViewById(R.id.des3);
        des[3] = (CardView) findViewById(R.id.des4);
        des[4] = (CardView) findViewById(R.id.des5);
        des[5] = (CardView) findViewById(R.id.des6);
        des[6] = (CardView) findViewById(R.id.des7);
        des[7] = (CardView) findViewById(R.id.des8);
        des[8] = (CardView) findViewById(R.id.des9);
        des[9] = (CardView) findViewById(R.id.des10);
        tdes[0] = (TextView) findViewById(R.id.tdes1);
        tdes[1] = (TextView) findViewById(R.id.tdes2);
        tdes[2] = (TextView) findViewById(R.id.tdes3);
        tdes[3] = (TextView) findViewById(R.id.tdes4);
        tdes[4] = (TextView) findViewById(R.id.tdes5);
        tdes[5] = (TextView) findViewById(R.id.tdes6);
        tdes[6] = (TextView) findViewById(R.id.tdes7);
        tdes[7] = (TextView) findViewById(R.id.tdes8);
        tdes[8] = (TextView) findViewById(R.id.tdes9);
        tdes[9] = (TextView) findViewById(R.id.tdes10);
        tdes[10] = (TextView) findViewById(R.id.tsrc);
        hdes[0] = (TextView) findViewById(R.id.textView20);
        hdes[1] = (TextView) findViewById(R.id.h1);
        hdes[2] = (TextView) findViewById(R.id.h2);
        hdes[3] = (TextView) findViewById(R.id.h3);
        hdes[4] = (TextView) findViewById(R.id.h4);
        hdes[5] = (TextView) findViewById(R.id.h5);
        hdes[6] = (TextView) findViewById(R.id.h6);
        hdes[7] = (TextView) findViewById(R.id.h7);
        hdes[8] = (TextView) findViewById(R.id.h8);
        hdes[9] = (TextView) findViewById(R.id.h9);
        hdes[10] = (TextView) findViewById(R.id.h10);
        root = (ConstraintLayout) findViewById(R.id.root);
        List<DataItem> list = new ArrayList<>();
        list.add(new DataItem(1, "#aa9955"));
        list.add(new DataItem(2, "#99aa55"));
        list.add(new DataItem(3, "#5599aa"));
        list.add(new DataItem(4, "#ff7733"));
        list.add(new DataItem(5, "#77ff33"));
        list.add(new DataItem(6, "#3377ff"));
        list.add(new DataItem(7, "#cc1133"));
        list.add(new DataItem(8, "#11cc33"));
        list.add(new DataItem(9, "#3311cc"));
        list.add(new DataItem(10, "#cc00aa"));
        Button button2 = (Button) findViewById(R.id.button1);
        this.button = button2;
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                double result;
                double lostValue;
                SecondMainQuestionActivity secondMainQuestionActivity = SecondMainQuestionActivity.this;
                TextView unused = secondMainQuestionActivity.textView = (TextView) secondMainQuestionActivity.findViewById(R.id.tsrc);
                if (SecondMainQuestionActivity.this.textView.getText().toString().equals("0")) {
                    if (!SecondMainQuestionActivity.ended) {
                        for (int i = 0; i < 10; i++) {
                            SecondMainQuestionActivity.value[i] = Integer.parseInt(CustomActivity.tdes[i].getText().toString());
                        }
                        result = SecondMainQuestionActivity.this.calculateResult(3);
                        lostValue = 100.0d - result;
                        SecondMainQuestionActivity.ended = true;
                    } else {
                        result = Double.parseDouble(SecondMainQuestionActivity.resultString);
                        lostValue = 100.0d - result;
                    }
                    Intent intent = new Intent(SecondMainQuestionActivity.this.getApplicationContext(), ResultActivity.class);
                    intent.putExtra("game", "secondMainQuestion");
                    SecondMainQuestionActivity.resultString = String.valueOf(result);
                    intent.putExtra("earn", String.valueOf(result));
                    intent.putExtra("lost", String.valueOf(lostValue));
                    intent.putExtra("language", SecondMainQuestionActivity.this.language);
                    SecondMainQuestionActivity.this.startActivity(intent);
                    return;
                }
                Toast.makeText(SecondMainQuestionActivity.this, "Please Drag all Icon from Source Box", Toast.LENGTH_SHORT).show();
            }
        });
        if (ended) {
            new ArrayList();
            List<List<DataItem>> desLists = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                List<DataItem> dlists = new ArrayList<>();
                for (int j = 0; j < value[i]; j++) {
                    dlists.add(new DataItem(j, ""));
                }
                desLists.add(dlists);
            }
            for (int i2 = 0; i2 < 10; i2++) {
                ldes[i2].setHasFixedSize(true);
                ldes[i2].setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                List<DataItem> list1 = desLists.get(i2);
                il[i2 + 1] = new ItemList(activity, list1, des[i2], ldes[i2], tdes[i2]);
                ldes[i2].setAdapter(il[i2 + 1]);
                TextView textView24 = tdes[i2];
                textView24.setText("" + list1.size());
            }
            TableLayout tableLayout = (TableLayout) findViewById(R.id.table_layout);
            tableLayout.setVisibility(View.VISIBLE);
            for (int i3 = 0; i3 < 10; i3++) {
                double temp = calculateResult(i3);
                this.textView = (TextView) ((TableRow) tableLayout.getChildAt(i3 + 1)).getChildAt(1);
                if (this.language.equalsIgnoreCase("Bangla")) {
                    this.textView.setText(MyStaff.numBangla(temp));
                } else {
                    this.textView.setText(String.valueOf(temp));
                }
            }
            return;
        }
        for (int i4 = 0; i4 < 10; i4++) {
            TextView textView25 = tdes[i4];
            this.textView = textView25;
            textView25.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                public void afterTextChanged(Editable editable) {
                    SecondMainQuestionActivity.this.setResultVisible();
                    TableLayout tableLayout = (TableLayout) SecondMainQuestionActivity.this.findViewById(R.id.table_layout);
                    for (int i = 0; i < 10; i++) {
                        double temp = SecondMainQuestionActivity.this.calculateResult(i);
                        TextView unused = SecondMainQuestionActivity.this.textView = (TextView) ((TableRow) tableLayout.getChildAt(i + 1)).getChildAt(1);
                        if (SecondMainQuestionActivity.this.language.equalsIgnoreCase("Bangla")) {
                            SecondMainQuestionActivity.this.textView.setText(MyStaff.numBangla(temp));
                        } else {
                            SecondMainQuestionActivity.this.textView.setText(String.valueOf(temp));
                        }
                    }
                }
            });
        }
        for (int i5 = 0; i5 < 10; i5++) {
            ldes[i5].setHasFixedSize(true);
            ldes[i5].setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            il[i5 + 1] = new ItemList(activity, new ArrayList<>(), des[i5], ldes[i5], tdes[i5]);
            ldes[i5].setAdapter(il[i5 + 1]);
        }
        lsrc.setHasFixedSize(true);
        lsrc.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        lsrc.addOnScrollListener(new RecyclerView.OnScrollListener() {

            /* renamed from: x */
            int f35x = 0;

            /* renamed from: y */
            int f36y = 0;

            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                this.f35x += dx;
            }
        });
        il[0] = new ItemList(activity, list, 0, src, lsrc, tdes[10]);
        lsrc.setAdapter(il[0]);
    }

    /* access modifiers changed from: private */
    public double calculateResult(int rightValuePosition) {
        double totalValue = this.f33a - this.f34b;
        int startRange = 1;
        int endRange = 10;
        for (int i = 0; i < 10; i++) {
            if (i != 0) {
                startRange += 10;
                endRange += 10;
            }
            double value2 = Double.parseDouble(tdes[i].getText().toString());
            if (value2 != 0.0d) {
                if (i == rightValuePosition) {
                    double temp = value2 / 10.0d;
                    totalValue += this.f34b * temp * (2.0d - temp);
                } else {
                    double temp2 = value2 / 10.0d;
                    totalValue -= (this.f34b * temp2) * temp2;
                }
            }
        }
        System.out.println(totalValue);
        return totalValue;
    }

    public void setResultVisible() {
        int totalValue = 0;
        for (int i = 0; i < 10; i++) {
            TextView textView2 = tdes[i];
            this.textView = textView2;
            totalValue += Integer.parseInt(textView2.getText().toString());
        }
        if (totalValue != 10 || this.totVal == 10) {
            this.totVal = 0;
            ((TableLayout) findViewById(R.id.table_layout)).setVisibility(View.INVISIBLE);
            return;
        }
        this.totVal = 10;
        ((TableLayout) findViewById(R.id.table_layout)).setVisibility(View.VISIBLE);
        resp = getRes();
    }
}
