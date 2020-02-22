package com.melisa.vitrinova.carousel;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.melisa.vitrinova.R;

public class DepthPageTransformer  implements ViewPager.PageTransformer{
    @Override
    public void transformPage(View page, float position) {
        if(position >= -1 && position <= 1){
            page.findViewById(R.id.imageView).setTranslationX(-position * page.getWidth() / 2);
            page.findViewById(R.id.big_text).setTranslationX(-position * page.getWidth() / 2);
            page.findViewById(R.id.small_text).setTranslationX(-position * page.getWidth() / 2);
        } else {
            page.setAlpha(1);
        }
    }
}