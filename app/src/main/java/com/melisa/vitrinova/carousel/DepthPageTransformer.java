package com.melisa.vitrinova.carousel;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.melisa.vitrinova.R;

public class DepthPageTransformer  implements ViewPager.PageTransformer{
    @Override
    public void transformPage(View page, float position) {
        if(position >= 0 && position <= 1){
            page.findViewById(R.id.img_featured_image).setTranslationX(-position * page.getWidth() / 2);
            page.findViewById(R.id.txt_title).setTranslationX(-position * page.getWidth() / 2);
            page.findViewById(R.id.txt_sub_title).setTranslationX(-position * page.getWidth() / 2);
        } else {
            page.setAlpha(1);
        }
    }
}