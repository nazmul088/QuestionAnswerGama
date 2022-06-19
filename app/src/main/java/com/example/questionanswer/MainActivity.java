package com.example.questionanswer;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView iv0,iv2,iv3,iv4;
    RecyclerView recyclerView;
    ConstraintLayout root;
    ItemList lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv4=findViewById(R.id.iv4);
        iv0 = findViewById(R.id.id1);
        iv2 = findViewById(R.id.id2);
        iv3 = findViewById(R.id.id3);
        root = findViewById(R.id.root);
        recyclerView = findViewById(R.id.finlist);
        List<String> itemlist = new ArrayList<>();
        lv = null;//ew ItemList(itemlist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(lv);
        iv0.post(new Runnable() {
            @Override
            public void run() {
                setDragListener(iv0,"#aa3333",iv0.getX(),iv0.getY());
            }
        });

        iv2.post(new Runnable() {
            @Override
            public void run() {
                setDragListener(iv2,"#33aa33",iv2.getX(),iv2.getY());
            }
        });
        iv3.post(new Runnable() {
            @Override
            public void run() {
                setDragListener(iv3,"#3333aa",iv3.getX(),iv3.getY());
            }
        });

        iv4.post(new Runnable() {
            @Override
            public void run() {
                setDragListener(iv4,"#3333aa",iv4.getX(),iv4.getY());
            }
        });

    }

    private void setDragListener(final ImageView ii,final String cval,final float fx,final float fy) {
        ii.setOnTouchListener(new View.OnTouchListener() {
            float x=fx,y=fy;
            ImageView iv1=ii;
            String code=cval;
            float ix,iy;
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_MOVE)
                {
                    iv1.animate()
                            .x(motionEvent.getRawX() + ix)
                            .y(motionEvent.getRawY() + iy)
                            .setDuration(0)
                            .start();
                    //iv1.setX(motionEvent.getX());
                    //iv1.setY(motionEvent.getY());
                }
                else if(motionEvent.getAction()==MotionEvent.ACTION_UP)
                {
                    Toast.makeText(MainActivity.this, iv1.getX()+" "+iv1.getY(), Toast.LENGTH_SHORT).show();
                    if(iv1.getY()>recyclerView.getY()&&iv1.getY()<recyclerView.getY()+recyclerView.getHeight())
                    {
                        float xx=root.getX();
                        float yy=root.getY();
                        root.removeView(iv1);
                        lv.addItem(code,recyclerView);
                        root.setX(xx);
                        root.setY(yy);
                    }
                    else
                    {
                        iv1.setX(x);
                        iv1.setY(y);
                    }
                }
                else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN)
                {
                    ix=iv1.getX()-motionEvent.getX();
                    iy=iv1.getY()-motionEvent.getY();
                }
                else
                    return false;
                /*else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN)
                {
                    x=iv1.getX();
                    y=iv1.getY();
                }*/
                return true;
            }
        });
    }

}