package com.example.questionanswer;

public class MyStaff {
    public static String numBangla(double val)
    {
        String ans="";
        if(val==0.0||val==0)
            return "0";
        double num=val;
        while(num>1)
        {
            int g=(int)num;
            ans=digitToChar(g%10)+ans;
            num/=10;
        }

        int n=2;
        double dec=val-(int)val;
        if(dec==0)
            return ans;
        //else
          //  ans+=".";
        int v=1;
        double temp=dec;

        for(int i=1;i<n;i++)
        {
            temp=temp*10;
            int y=(int)temp;
            ans+=digitToChar(y);
            temp=temp-(int)temp;
            v*=10;
        }
        return ans;
    }

    private static String digitToChar(int i) {
        if(i==0)
            return "০";
        else if(i==1)
            return "১";
        else if(i==2)
            return "২";
        else if(i==3)
            return "৩";
        else if(i==4)
            return "৪";
        else if(i==5)
            return "৫";
        else if(i==6)
            return "৬";
        else if(i==7)
            return "৭";
        else if(i==8)
            return "৮";
        else if(i==9)
            return "৯";
        return null;
    }
}
