package nazar.optigra_vk_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;


import java.util.ArrayList;

import nazar.optigra_vk_test.Adapter.PostVkLinearLayout;
import nazar.optigra_vk_test.model.AndroidPost;
import nazar.optigra_vk_test.model.WallVk;

public class Vk_wall_activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        ArrayList<AndroidPost> myParcelableObject=new ArrayList<AndroidPost>();
        myParcelableObject = i.getParcelableArrayListExtra("response");


        LinearLayout linLayout = new LinearLayout(this);
        linLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams linLayoutParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ScrollView scrollView=new ScrollView(this);
        scrollView.addView(linLayout);
        setContentView(scrollView, linLayoutParam);

        LinearLayout.LayoutParams lpView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);



        for (AndroidPost temp:myParcelableObject){
            PostVkLinearLayout  Vkl=new PostVkLinearLayout(this,temp);
            Vkl.setLayoutParams(lpView);
            Vkl.setOrientation(LinearLayout.VERTICAL);
            linLayout.addView(Vkl);

        }






       /*
        PostVkLinearLayout  Vkl=new PostVkLinearLayout(this,2);
        Vkl.setLayoutParams(lpView);
        Vkl.setOrientation(LinearLayout.VERTICAL);
        linLayout.addView(Vkl);

        PostVkLinearLayout  Vkl2=new PostVkLinearLayout(this,1);
        Vkl2.setLayoutParams(lpView);
        Vkl2.setOrientation(LinearLayout.VERTICAL);
        linLayout.addView(Vkl2);
*/



        /*TextView tv = new TextView(this);
        tv.setText("TextView");
        tv.setLayoutParams(lpView);
        linLayout.addView(tv);
*/
       /* Button btn = new Button(this);
        btn.setText("Button");
        linLayout.addView(btn, lpView);


        LinearLayout.LayoutParams leftMarginParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        leftMarginParams.leftMargin = 50;

        Button btn1 = new Button(this);
        btn1.setText("Button1");
        linLayout.addView(btn1, leftMarginParams);


        LinearLayout.LayoutParams rightGravityParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        rightGravityParams.gravity = Gravity.RIGHT;

        Button btn2 = new Button(this);
        btn2.setText("Button2");
        linLayout.addView(btn2, rightGravityParams);*/
    }
}