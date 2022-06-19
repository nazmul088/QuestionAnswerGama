package com.example.questionanswer;

import static com.example.questionanswer.CustomActivity.des;
import static com.example.questionanswer.CustomActivity.hdes;
import static com.example.questionanswer.CustomActivity.il;
import static com.example.questionanswer.CustomActivity.ldes;
import static com.example.questionanswer.CustomActivity.lsrc;
import static com.example.questionanswer.CustomActivity.root;
import static com.example.questionanswer.CustomActivity.src;
import static java.lang.Math.abs;
import static java.lang.Math.max;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemList extends RecyclerView.Adapter<ItemHolder> {
    public final List<DataItem> mlist;
    public CardView cview;
    public RecyclerView recyclerView;
    int type=1;
    public ImageView ontop=null,tii=null;
    public TextView counter;
    public Activity activity;

    ItemList(Activity activity,List<DataItem> list, CardView cview, RecyclerView recyclerView, TextView textView) {
        mlist=list;
        this.cview=cview;
        this.counter=textView;
        this.recyclerView=recyclerView;
        counter.setText(String.valueOf(list.size()));
        this.activity=activity;
    }

    ItemList(Activity activity,List<DataItem> list, int type, CardView cview, RecyclerView recyclerView, TextView textView) {
        mlist=list;
        this.activity=activity;
        this.counter=textView;
        this.type=type;
        this.cview=cview;
        this.recyclerView=recyclerView;
        counter.setText(""+list.size());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public int getItemViewType(int position)
    {
        return position;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if(this==il[0])
        {
            View listItem= layoutInflater.inflate(R.layout.item, parent, false);
            ItemHolder viewHolder = new ItemHolder(listItem,null);
            return viewHolder;
        }
        View listItem= layoutInflater.inflate(R.layout.itemsrc, parent, false);
        ItemHolder viewHolder = new ItemHolder(listItem,null);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemHolder holder, final int position)
    {
        holder.iv.setVisibility(View.VISIBLE);


        if(this== il[0]) {
            holder.cv.setScaleX(1.3f);
            holder.cv.setScaleY(1.3f);
        }
        /////////////holder.iv.setBackgroundColor(Color.parseColor(mlist.get(position).code));
        final int poss=holder.getAdapterPosition();
        final DataItem ditem=mlist.get(position);
        //if(type==0)
        {
            holder.iv.post(new Runnable() {
                final ImageView iv=holder.iv;
                final ItemHolder item=holder;
                int pos=poss;
                DataItem dataItem=ditem;
                @Override
                public void run() {
                    item.iv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            try {
                                if(activity==MaintwoActivity.activity&&MaintwoActivity.ended)
                                {
return;
                                }
                                else if(activity==PracticeSecondActivity.activity&&PracticeSecondActivity.ended)
                                {
return;
                                }
                                else if(activity==PracticeThirdActivity.activity&&PracticeThirdActivity.ended)
                                {
return;
                                }
                                else if(activity==FirstMainQuestionActivity.activity&&FirstMainQuestionActivity.ended)
                                {
return;
                                }
                                else if(activity==SecondMainQuestionActivity.activity&&SecondMainQuestionActivity.ended)
                                {
return;
                                }
                                else if(activity==ThirdMainQuestionActivity.activity&&ThirdMainQuestionActivity.ended)
                                {
                                    return;
                                }
                                int posi[] = new int[2];
                                iv.getLocationOnScreen(posi);
                                //Toast.makeText(activity, posi[0]+" "+posi[1], Toast.LENGTH_SHORT).show();
                                setDragListener(iv, mlist.get(pos).code, posi[0]-10, cview.getY() + item.cv.getY() + iv.getY(), pos);
                                //setDragListener(iv,mlist.get(pos).code,cview.getX()+item.cv.getX()+iv.getX()+(10-mlist.size())*abs(5-mlist.size())*5,cview.getY()+item.cv.getY()+iv.getY(),pos);
                            }
                            catch (Exception e)
                            {
                                Toast.makeText(activity, "e3"+e, Toast.LENGTH_SHORT).show();
                            }
                                //Toast.makeText(activity, src.getX()+item.cv.getX()+iv.getX()+" "+src.getY()+item.v.getY()+iv.getY(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
        }
    }

    public void addItem(String data,RecyclerView rec)
    {
        int max=0;
        for(int i=0;i<mlist.size();i++)
        {
            max=max(max,mlist.get(i).id);
        }
        mlist.add(new DataItem(max+1,data));
        notifyItemInserted(mlist.size()-1);
        rec.smoothScrollToPosition(mlist.size()-1);
        counter.setText(""+mlist.size());

        LinearLayoutManager v=(LinearLayoutManager) rec.getLayoutManager();
        v.scrollToPositionWithOffset(0, 10);
    }

    private void setDragListener(final ImageView ii,final String cval,final float fx,final float fy,final int pos) {
        try{
            if(ontop!=null)
                root.removeView(ontop);
            ontop=null;
        }catch (Exception e)
        {

        }
        if(tii!=null)
        {
            tii.setVisibility(View.VISIBLE);
            tii=null;
        }

        ImageView ivnew = new ImageView(activity);
        //ivnew.setBackgroundColor(Color.BLACK);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ivnew.setBackground(activity.getDrawable(R.drawable.needle_6));
        }
        else
        {
            ivnew.setBackground(activity.getResources().getDrawable(R.drawable.needle_6));
        }
        ///////ivnew.setBackgroundColor(Color.parseColor(cval));
        final float height=ii.getHeight()+15;
        ivnew.setLayoutParams(new ViewGroup.LayoutParams(ii.getWidth()+15,15+ii.getHeight()*1));
        //ivnew.getLayoutParams().height = iv1.getHeight();
        //ivnew.getLayoutParams().width = iv1.getWidth();
        ivnew.setX(fx);
        ivnew.setY(fy);
        root.addView(ivnew);
        ivnew.setX(fx);
        ivnew.setY(fy);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //Toast.makeText(activity, "juhhh", Toast.LENGTH_SHORT).show();
            ivnew.setZ(30);
            ivnew.setTranslationZ(30);
            cview.setZ(-90);
        }
        //ivnew.bringToFront();
        ontop=ivnew;
        tii=ii;
        ii.setVisibility(View.INVISIBLE);
        ImageView ivv=ivnew;
        ivnew.setOnTouchListener(new View.OnTouchListener() {
            float x=fx,y=fy;
            float fheight=height;
            ImageView iv1=ii;
            ImageView ivnew=ivv;
            String code=cval;
            float ix,iy;
            final int posi=pos;
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN)
                {
                    //Toast.makeText(activity, x+" "+y, Toast.LENGTH_SHORT).show();
                    ix = x - motionEvent.getRawX();
                    iy = y - motionEvent.getRawY();
                }
                else if(motionEvent.getAction()==MotionEvent.ACTION_MOVE)
                {
                    ivnew.animate()
                            .x(motionEvent.getRawX() + ix)
                            .y(motionEvent.getRawY() + iy)
                            .setDuration(0)
                            .start();
                    //iv1.setX(motionEvent.getX());
                    //iv1.setY(motionEvent.getY());
                }
                else if(motionEvent.getAction()==MotionEvent.ACTION_UP)
                {
                    int duke_nai=1;
                    //Toast.makeText(MainActivity.this, iv1.getX()+" "+iv1.getY(), Toast.LENGTH_SHORT).show();
                    if(cview!=src&&((ivnew.getX()>src.getX()&&ivnew.getX()+ivnew.getWidth()+10<src.getX()+src.getWidth())&&(ivnew.getY()>hdes[0].getY()&&ivnew.getY()+fheight<src.getY()+src.getHeight())))
                    {
                        duke_nai=0;
                        root.removeView(ivnew);
                        il[0].addItem(code,lsrc);
                        removeItem(posi);
                    }
                    for(int i=0;i<10;i++)
                    {
                        if(cview==des[i])
                        {
                            if((ivnew.getX()>des[i].getX()&&ivnew.getX()+ivnew.getWidth()+10<des[i].getX()+des[i].getWidth())&&(ivnew.getY()>hdes[i+1].getY()&&ivnew.getY()+fheight<des[i].getY()+des[i].getHeight()))
                            {
                                duke_nai=2;
                            }
                            continue;
                        }
                        if((ivnew.getX()>des[i].getX()&&ivnew.getX()+ivnew.getWidth()+10<des[i].getX()+des[i].getWidth())&&(ivnew.getY()>hdes[i+1].getY()&&ivnew.getY()+fheight<des[i].getY()+des[i].getHeight()))
                        {
                            duke_nai=0;
                            root.removeView(ivnew);
                            il[i+1].addItem(code,ldes[i]);
                            removeItem(posi);
                            break;
                        }
                    }
                    if(duke_nai==1&&cview==src)
                    {
                        root.removeView(ivnew);
                        iv1.setVisibility(View.VISIBLE);
                    }
                    else if (duke_nai==2)
                    {
                        root.removeView(ivnew);
                        iv1.setVisibility(View.VISIBLE);
                    }
                    else if (duke_nai==1)
                    {
                        root.removeView(ivnew);
                        removeItem(posi);
                        il[0].addItem(code,lsrc);
                    }
                    tii=null;
                    ontop=null;
                }
                else
                    return false;
                return true;
            }
        });
    }

    public void removeItem(int posi) {
        try {
            mlist.remove(posi);
            notifyItemRemoved(posi);
            LinearLayoutManager v=(LinearLayoutManager) recyclerView.getLayoutManager();
            v.scrollToPositionWithOffset(0, 10);
            notifyItemRangeChanged(posi,mlist.size());
        }catch (Exception e)
        {

        }
        counter.setText(""+mlist.size());
    }


}