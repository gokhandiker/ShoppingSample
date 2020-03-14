package com.melisa.vitrinova.ui.newshops;

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
import com.melisa.vitrinova.data.domain.Shop;
import com.melisa.vitrinova.ui.newproducts.PicassoClient;

import java.util.List;

public class NewShopAdapter extends RecyclerView.Adapter<NewShopAdapter.ShopHolder> {

    private List<Shop> newShopList;
    private Activity activity;
    private int lastPosition = -1;


    public NewShopAdapter(List<Shop> list, Activity activity) {
        this.newShopList = list;
        this.activity = activity;

    }

    public static class ShopHolder
            extends RecyclerView.ViewHolder {

        ImageView newShopTopImage;
        ImageView newShopLogo;


        TextView txtNewShopName, txtNewShopDefinition, txtNewShopProductCount;

        public ShopHolder(View view) {
            super(view);

            newShopTopImage = view.findViewById(R.id.img_new_shop_top_image);
            newShopLogo = view.findViewById(R.id.img_new_shop_logo);


            txtNewShopName = view.findViewById(R.id.txt_new_shop_name);
            txtNewShopDefinition = view.findViewById(R.id.txt_new_shop_definition);
            txtNewShopProductCount = view.findViewById(R.id.txt_new_shop_product_count);

        }
    }


    @NonNull
    @Override
    public ShopHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.rv_new_shop_item,
                        parent,
                        false);
        ShopHolder holder = new ShopHolder(itemView);
        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull ShopHolder holder, int position) {
        String topImageUrl = null;
        String logoUrl = null;

        if (newShopList.get(position).getCover() != null)
            topImageUrl = newShopList.get(position).getCover().getMedium().getUrl();

        if (newShopList.get(position).getLogo() != null)
             logoUrl = newShopList.get(position).getLogo().getThumbnail().getUrl();




        PicassoClient.downloadImage(activity.getApplicationContext(), topImageUrl, holder.newShopTopImage);
        PicassoClient.downloadImage(activity.getApplicationContext(), logoUrl, holder.newShopLogo);



        holder.txtNewShopName.setText(newShopList.get(position).getName());
        holder.txtNewShopDefinition.setText(newShopList.get(position).getDefinition());
        if (newShopList.get(position).getProductCount()!=null)
        holder.txtNewShopProductCount.setText(newShopList.get(position).getProductCount()+" ürün");


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
        return newShopList.size();
    }


}
