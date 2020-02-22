package com.melisa.vitrinova.collections;

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
import com.melisa.vitrinova.model.Collection;
import com.melisa.vitrinova.newproducts.PicassoClient;

import java.util.List;

public class CollectionsAdapter extends RecyclerView.Adapter<CollectionsAdapter.CollectionHolder> {

    private List<Collection> collectionList;
    private Activity activity;
    private int lastPosition = -1;

    public CollectionsAdapter(List<Collection> list, Activity activity) {
        this.collectionList=list;
        this.activity=activity;
    }

    public static class CollectionHolder
            extends RecyclerView.ViewHolder {

        ImageView collectionImage;
        TextView txtCollectionTitle,txtCollectionDefinition;

        public CollectionHolder(View view)
        {
            super(view);

            collectionImage = view.findViewById(R.id.img_collection_image);
            txtCollectionTitle = view.findViewById(R.id.txt_collection_title);
            txtCollectionDefinition = view.findViewById(R.id.txt_collection_definition);

        }
    }



    @NonNull
    @Override
    public CollectionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.rv_collection_item,
                        parent,
                        false);
        CollectionHolder holder = new CollectionHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionHolder holder, int position) {

        String imageUrl = collectionList.get(position).getCover().getThumbnail().getUrl();


        PicassoClient.downloadImage(activity.getApplicationContext(),imageUrl,holder.collectionImage);

        holder.txtCollectionTitle.setText(collectionList.get(position).getTitle());
        holder.txtCollectionDefinition.setText(collectionList.get(position).getDefinition());

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
        return collectionList.size();
    }



}
