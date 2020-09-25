package com.example.splashtrial;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecyclerViewadapter extends RecyclerView.Adapter <RecyclerViewadapter.MyViewHolder> {

    private Context mContext;
    private List<Brands> mData;


    public RecyclerViewadapter(Context mContext, List<Brands> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater=LayoutInflater.from(mContext);
        view=mInflater.inflate(R.layout.cardview_item_brandlogo,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv_brand_name.setText(mData.get(position).getBrandName());
        holder.img_brand_logo.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext,BrandInfo.class);

                intent.putExtra("BrandName",mData.get(position).getBrandName());
                intent.putExtra("Category",mData.get(position).getCategory());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                intent.putExtra("Description",mData.get(position).getDescription());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_brand_name;
        ImageView img_brand_logo;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_brand_name=(TextView) itemView.findViewById(R.id.brand_name);
            img_brand_logo=(ImageView) itemView.findViewById(R.id.brand_image);
            cardView=(CardView)  itemView.findViewById(R.id.cardview);
        }
    }

}