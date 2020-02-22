package com.melisa.vitrinova.newproducts;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.melisa.vitrinova.R;
import com.melisa.vitrinova.model.NewProducts;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewProductsAdapter extends RecyclerView.Adapter<NewProductsAdapter.ProductHolder> {

    private List<NewProducts> productList;
    private Activity activity;

    public NewProductsAdapter(List<NewProducts> list, Activity activity) {
        this.productList=list;
        this.activity=activity;
    }

    public static class ProductHolder
            extends RecyclerView.ViewHolder {

        ImageView productImage;
        TextView txtTitle;
        TextView txtShop;
        TextView txtPrice;
        TextView txtOldPrice;

        public ProductHolder(View view)
        {
            super(view);


            productImage = view.findViewById(R.id.img_product_image);
            txtTitle = view.findViewById(R.id.txt_product_title);
            txtShop = view.findViewById(R.id.txt_shop_name);
            txtPrice = view.findViewById(R.id.txt_price);
            txtOldPrice = view.findViewById(R.id.txt_old_price);
        }
    }



    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.rv_featureds_item,
                        parent,
                        false);
        ProductHolder holder = new ProductHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {

        String imageUrl = productList.get(position).getImages().get(0).getThumbnail().getUrl();


        PicassoClient.downloadImage(activity.getApplicationContext(),imageUrl,holder.productImage);

        holder.txtTitle.setText(productList.get(position).getTitle());
        holder.txtShop.setText(productList.get(position).getShop().getName());
        holder.txtPrice.setText(""+productList.get(position).getPrice());
        holder.txtOldPrice.setText(""+productList.get(position).getOldPrice());
    }

    // Override getItemCount which Returns
    // the length of the RecyclerView.
    @Override
    public int getItemCount()
    {
        return productList.size();
    }



}
