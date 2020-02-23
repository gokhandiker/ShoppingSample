package com.melisa.vitrinova.editorshops;

import android.app.Activity;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.util.Log;
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
import com.melisa.vitrinova.model.EditorShop;
import com.melisa.vitrinova.newproducts.PicassoClient;

import java.util.List;

public class EditorShopAdapter extends RecyclerView.Adapter<EditorShopAdapter.ShopHolder> {

    private List<EditorShop> editorShopList;
    private Activity activity;
    private int lastPosition = -1;


    public EditorShopAdapter(List<EditorShop> list, Activity activity) {
        this.editorShopList = list;
        this.activity = activity;

    }

    public static class ShopHolder
            extends RecyclerView.ViewHolder {

        ImageView shopTopImage;
        ImageView firstPopularProductImage;
        ImageView middlePopularProductImage;
        ImageView lastPopularProductImage;


        TextView txtShopName, txtShopDefinition;

        public ShopHolder(View view) {
            super(view);

            shopTopImage = view.findViewById(R.id.img_editor_shop_top);
            firstPopularProductImage = view.findViewById(R.id.img_editor_shop_first);
            middlePopularProductImage = view.findViewById(R.id.img_editor_shop_middle);
            lastPopularProductImage = view.findViewById(R.id.img_editor_shop_last);

            firstPopularProductImage.setClipToOutline(true);
            middlePopularProductImage.setClipToOutline(true);
            lastPopularProductImage.setClipToOutline(true);

            txtShopName = view.findViewById(R.id.txt_editor_shop_name);
            txtShopDefinition = view.findViewById(R.id.txt_editor_shop_definition);

        }
    }


    @NonNull
    @Override
    public ShopHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.rv_editor_shop_item,
                        parent,
                        false);
        ShopHolder holder = new ShopHolder(itemView);
        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull ShopHolder holder, int position) {

        String topImageUrl = editorShopList.get(position).getLogo().getMedium().getUrl();
        String firstImageUrl = editorShopList.get(position).getPopularProducts().get(0).getImages().get(0).getMedium().getUrl();
        String middleImageUrl = editorShopList.get(position).getPopularProducts().get(1).getImages().get(0).getMedium().getUrl();
        String lastImageUrl = editorShopList.get(position).getPopularProducts().get(2).getImages().get(0).getMedium().getUrl();




        PicassoClient.downloadImage(activity.getApplicationContext(), topImageUrl, holder.shopTopImage);
        PicassoClient.downloadImage(activity.getApplicationContext(), firstImageUrl, holder.firstPopularProductImage);
        PicassoClient.downloadImage(activity.getApplicationContext(), middleImageUrl, holder.middlePopularProductImage);
        PicassoClient.downloadImage(activity.getApplicationContext(), lastImageUrl, holder.lastPopularProductImage);


        holder.txtShopName.setText(editorShopList.get(position).getName());
        holder.txtShopDefinition.setText(editorShopList.get(position).getDefinition());


        setAnimation(holder.itemView, position);
    }


    private void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(activity.getApplicationContext(), R.anim.slide_in_right);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }


    @Override
    public int getItemCount() {
        return editorShopList.size();
    }


}
