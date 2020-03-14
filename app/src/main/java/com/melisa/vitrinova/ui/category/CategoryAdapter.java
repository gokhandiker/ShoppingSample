package com.melisa.vitrinova.ui.category;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.melisa.vitrinova.R;
import com.melisa.vitrinova.data.domain.CategoryBig;
import com.melisa.vitrinova.ui.newproducts.PicassoClient;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    private List<CategoryBig> categoryList;
    private Activity activity;
    private int lastPosition = -1;

    public CategoryAdapter(List<CategoryBig> list, Activity activity) {
        this.categoryList=list;
        this.activity=activity;
    }



    public static class CategoryHolder
            extends RecyclerView.ViewHolder {

        ImageView categoryImage;
        TextView txtCategoryName;

        public CategoryHolder(View view)
        {
            super(view);


            categoryImage = view.findViewById(R.id.img_category_image);
            txtCategoryName = view.findViewById(R.id.txt_category_name);

        }
    }



    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.rv_category_item,
                        parent,
                        false);
        CategoryHolder holder = new CategoryHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {

        String imageUrl = categoryList.get(position).getLogo().getMedium().getUrl();


        PicassoClient.downloadImage(activity.getApplicationContext(),imageUrl,holder.categoryImage);

        holder.txtCategoryName.setText(categoryList.get(position).getName());


        setAnimation(holder.itemView, position);
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(activity.getApplicationContext(), R.anim.slide_in_right);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount()
    {
        return categoryList.size();
    }



}
