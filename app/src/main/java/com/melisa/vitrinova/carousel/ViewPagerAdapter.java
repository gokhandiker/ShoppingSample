package com.melisa.vitrinova.carousel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.melisa.vitrinova.R;
import com.melisa.vitrinova.model.Featured;
import com.melisa.vitrinova.newproducts.PicassoClient;

import java.util.List;

public class ViewPagerAdapter  extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<Featured> featuredList;

    public ViewPagerAdapter(Context context,List<Featured> list) {
        this.context = context;
        this.featuredList=list;
    }

    @Override
    public int getCount() {
        return featuredList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_item, null);
        ImageView featuredImage =  view.findViewById(R.id.img_featured_image);
        TextView txtTitle =  view.findViewById(R.id.txt_title);
        TextView txtSubTitle =  view.findViewById(R.id.txt_sub_title);

        txtTitle.setText(featuredList.get(position).getTitle());
        txtSubTitle.setText(featuredList.get(position).getSubTitle());

        PicassoClient.downloadImage(context,featuredList.get(position).getCover().getUrl(),featuredImage);


        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}