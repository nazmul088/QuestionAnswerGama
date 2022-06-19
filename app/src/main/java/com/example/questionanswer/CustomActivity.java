package com.example.questionanswer;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;

public class CustomActivity extends AppCompatActivity {
    public static CardView[] des = new CardView[10];
    public static TextView[] hdes = new TextView[11];

    /* renamed from: il */
    public static ItemList[] il;
    public static RecyclerView[] ldes = new RecyclerView[10];
    public static RecyclerView lsrc;
    public static ConstraintLayout root;
    public static CardView src;
    public static TextView[] tdes = new TextView[11];
    public HashMap<String, String> res = new HashMap<>();

    public HashMap<String, String> getRes() {
        HashMap<String, String> has = new HashMap<>();
        for (int i = 1; i < 11; i++) {
            has.put(hdes[i].getText().toString(), tdes[i - 1].getText().toString());
        }
        return has;
    }

    public String getResOld() {
        String s = "";
        for (int i = 1; i < 11; i++) {
            if (!tdes[i - 1].getText().toString().equals("0")) {
                if (!s.equals("")) {
                    s = s + "_";
                }
                s = s + hdes[i].getText().toString() + "(" + tdes[i - 1].getText().toString() + ")";
            }
        }
        return s;
    }
}
