package nazar.optigra_vk_test.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.squareup.picasso.Picasso;


import nazar.optigra_vk_test.R;
import nazar.optigra_vk_test.model.AndroidPost;

/**
 * Created by NAZAR on 25/06/2014.
 */
public class PostVkLinearLayout extends LinearLayout  {
    public TextView tv_avtor=null;
    public TextView tv_text=null;



        public PostVkLinearLayout(Context context,AndroidPost post) {
            super(context);
            LinearLayout.LayoutParams lpView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams lpView_image = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            Activity activity = (Activity) context;


            tv_avtor = new TextView(context);
            tv_avtor.setText(activity.getIntent().getStringExtra(post.getAvtor()));
            tv_avtor.setLayoutParams(lpView);
            this.addView(tv_avtor);

        if (!post.getText().equals("")) {
             tv_text = new TextView(context);
             tv_text.setText(post.getText());
             tv_text.setLayoutParams(lpView);
             this.addView(tv_text);
        }
            LinearLayout linLayout = new LinearLayout(context);
            linLayout.setOrientation(LinearLayout.VERTICAL);
        if (post.getPhotolistpost().size()!=0) {
            for (String temp:post.getPhotolistpost()) {
                ImageView image= new ImageView(context);
                image.setLayoutParams(lpView_image);
                Picasso.with(context).load(temp).into(image);
                linLayout.addView(image);

            }
            this.addView(linLayout);

        }

        if(post.getOther_avtor()!=null) {
            TextView tv_Other_avtor = new TextView(context);
            tv_Other_avtor.setText("-----> "+activity.getIntent().getStringExtra(post.getOther_avtor()));
            //tv_Other_avtor.setText("-----> "+post.getOther_avtor());
            tv_Other_avtor.setLayoutParams(lpView);
            this.addView(tv_Other_avtor);
        }


            if (post.getOther_text()!=null) {
                TextView tv_Other_text = new TextView(context);
                tv_Other_text.setText(post.getOther_text());
                tv_Other_text.setLayoutParams(lpView);
                this.addView(tv_Other_text);

            }

            linLayout = new LinearLayout(context);
            linLayout.setOrientation(LinearLayout.VERTICAL);
            if (post.getOther_photolistpost().size()!=0) {
                for (String temp:post.getOther_photolistpost()) {
                    ImageView image= new ImageView(context);
                    image.setLayoutParams(lpView_image);
                    Picasso.with(context).load(temp).into(image);
                    linLayout.addView(image);

                }
                this.addView(linLayout);

            }

            TextView seperator = new TextView(context);


            seperator.setTextColor(context.getResources().getColor(R.color.colorSeparator));
            seperator.setText("");
            seperator.setBackgroundColor(context.getResources().getColor(R.color.colorSeparator));
            seperator.setLayoutParams(lpView);
            this.addView(seperator);





       /* if(post.getOther_text()!=null || !post.getOther_text().equals("")) {

        }else{
            TextView tv_Other_text = new TextView(context);
            tv_Other_text.setText(post.getOther_text());
            tv_Other_text.setLayoutParams(lpView);
            this.addView(tv_Other_text);
        }*/

















        }


}
