package com.example.splashtrial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class BrandInfo extends AppCompatActivity {

    TextView tvBrandname,tvDescription,tvCategory;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_info);
        Intent intent=getIntent();
        String Category=intent.getExtras().getString("Category");
        String BrandName=intent.getExtras().getString("BrandName");
        String Description=intent.getExtras().getString("Description");
        int Thumbnail =intent.getExtras().getInt("Thumbnail");

        tvCategory=(TextView)findViewById(R.id.brandcategory);
        tvBrandname=(TextView)findViewById(R.id.brandname);
        tvDescription=(TextView)findViewById(R.id.branddescription);
        img=(ImageView)findViewById(R.id.brandthumbnail);

        tvBrandname.setText(BrandName);
        tvCategory.setText(Category);
        tvDescription.setText(Description);
        img.setImageResource(Thumbnail);
    }

}
