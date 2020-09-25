package com.example.splashtrial;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class BrandDisplay extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout DrawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    EditText editText;
    ActionBarDrawerToggle Toggle;
    FirebaseAuth firebaseAuth;
    RecyclerView myrv;
    RecyclerViewadapter myadapter;
    List<Brands> listBrand;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_display);

        DrawerLayout = (DrawerLayout)findViewById(R.id.brand_menu);
        toolbar=findViewById(R.id.toolbar);
        navigationView = (NavigationView)findViewById(R.id.nv);
        firebaseAuth=FirebaseAuth.getInstance();
        listBrand = new ArrayList<>();
        Toggle = new ActionBarDrawerToggle(this,DrawerLayout,R.string.open,R.string.close);
        DrawerLayout.addDrawerListener(Toggle);
        Toggle.syncState();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
       //navigationView.setCheckedItem(R.id.myHome);
        myrv = (RecyclerView)findViewById(R.id.recyclerview);
        myadapter = new RecyclerViewadapter(this,listBrand);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myadapter);

        listBrand.add(new Brands("Gucci","Accessories","Gucci is an Italian fashion label founded in 1921 by Guccio Gucci, making it one of the oldest Italian fashion brands in operation today. Like many historic fashion houses, the brand started out as a luggage manufacturer, producing luxury travel goods for Italy's wealthy upper-classes, as well as equestrian equipment.",R.drawable.gucci));
        listBrand.add(new Brands("H&M","Clothing","Hennes & Mauritz AB is a Swedish multinational clothing-retail company known for its fast-fashion clothing for men, women, teenagers and children.It is the second-largest global clothing retailer, just behind Spain-based Inditex (parent company of Zara). The company has a significant online presence, with online shopping available in 33 countries",R.drawable.hnm));
        listBrand.add(new Brands("Allen Solly","Clothing","Allen Solly is an initiative of Madura Fashion & Lifestyle, a division of Aditya Birla Fashion and Lifestyle is India’s largest and fastest growing branded apparel companies and a premium lifestyle player in the retail sector. After consolidating its market leadership with its own brands, it introduced premier international labels, enabling Indian consumers to buy the most prestigious global fashionwear and accessories within the country.",R.drawable.as));
        listBrand.add(new Brands("Zara","Accessories","Zara is a Spanish clothing retailer based in Galicia, Spain. Founded by Amancio Ortega in 1975, it is the flagship chain store of the Inditex group, the world's largest apparel retailer. The fashion group also owns brands such as Pull&Bear, Massimo Dutti, Bershka, Stradivarius, Oysho, Zara Home and Uterqüe.",R.drawable.zara));
        listBrand.add(new Brands("Versace","Clothing","Gianni Versace S.r.l., usually referred to simply as Versace, is an Italian luxury fashion company and trade name founded by Gianni Versace in 1978. The main collection of the brand is Versace, which produces upmarket Italian-made ready-to-wear and leather accessories.",R.drawable.versace));
        listBrand.add(new Brands("Victoria's Secret","Lingerie","Victoria's Secret is an American designer, manufacturer, and marketer of women's lingerie, womenswear, and beauty products. The company is widely known for their high visibility marketing including a catalog and annual televised fashion show featuring \"angels\" that ran through 2018.",R.drawable.victoriasecret));
        listBrand.add(new Brands("Rayban","Accessories","Ray-Ban is an American-founded Italian brand of luxury sunglasses and eyeglasses created in 1936 by the American company Bausch & Lomb. The brand is known for its Wayfarer and Aviator lines of sunglasses.",R.drawable.rayban));
        listBrand.add(new Brands("M.A.C","Makeup","MAC Cosmetics, stylized as M·A·C, is a cosmetics manufacturer founded in Toronto, Canada in 1984 by Frank Toskan and Frank Angelo. The company is headquartered in New York City and became part of the Estée Lauder Companies in 1996. MAC is an acronym for Make-up Art Cosmetics.",R.drawable.mac));
        listBrand.add(new Brands("Nike","Sports","Nike is an American multinational corporation that is engaged in the design, development, manufacturing, and worldwide marketing and sales of footwear, apparel, equipment, accessories, and services. The company was founded on January 25, 1964, as Blue Ribbon Sports, by Bill Bowerman and Phil Knight, and officially became Nike, Inc. on May 30, 1971. The company takes its name from Nike, the Greek goddess of victory.",R.drawable.nike));
        listBrand.add(new Brands("Louis Vuitton","Accessories","Louis Vuitton Malletier, commonly referred to as Louis Vuitton or shortened to LV, is a French fashion house and luxury retail company founded in 1854 by Louis Vuitton. The label's LV monogram appears on most of its products, ranging from luxury trunks and leather goods to ready-to-wear, shoes, watches, jewelry, accessories, sunglasses and books. Louis Vuitton is one of the world's leading international fashion houses; it sells its products through standalone boutiques, lease departments in high-end department stores, and through the e-commerce section of its website.[5][6] For six consecutive years (2006–2012), Louis Vuitton was named the world's most valuable luxury brand.",R.drawable.lv));
        listBrand.add(new Brands("Swarovski","Accessories","Swarovski is an Austrian producer of glass headquartered in Wattens, Austria. Swarovski has been a family-owned business since it was founded in 1895 by Daniel Swarovski.All Swarovski crystal produced since 2012 have been lead-free. Swarovski is now run by the fifth generation of family members.",R.drawable.swarovski));
        listBrand.add(new Brands("Rolex","Accessories","Rolex is a Swiss luxury watch manufacturer based in Geneva, Switzerland. Originally founded as Wilsdorf and Davis by Hans Wilsdorf and Alfred Davis in London, England in 1905. To date, Rolex still holds the record for the most certified chronometer movements in the category of wristwatches.",R.drawable.rolex));
        listBrand.add(new Brands("Ralph Lauren","Clothing","Ralph Lauren Corporation is an American fashion company producing products ranging from the mid-range to the luxury segments. They are known for the clothing, marketing and distribution of products in four categories: apparel, home, accessories, and fragrances.",R.drawable.rl));
        listBrand.add(new Brands("Adidas","Sports","Adidas is a multinational corporation, founded and headquartered in Herzogenaurach, Germany, that designs and manufactures shoes, clothing and accessories. It is the largest sportswear manufacturer in Europe, and the second largest in the world, after Nike.",R.drawable.adidas));
        listBrand.add(new Brands("Manyavar","Clothing","Manyavar is a men's ethnic wear brand founded in India by entrepreneur Ravi Modi in 1999 under his company Vedant Fashions. Manyavar offers Sherwanis, Kurtas and indo-western clothing for men. The brand started with a 150 sq feet shop in Kolkata and has now expanded to over 570 stores across 180 cities in India and Abroad.",R.drawable.manyavar));
        listBrand.add(new Brands("Giorgio Armani","Accessories","Giorgio Armani is an Italian luxury fashion house founded by Giorgio Armani which designs, manufactures, distributes and retails haute couture, ready-to-wear, leather goods, shoes, watches, jewellery, accessories, eyewear, cosmetics and home interiors. The brand markets these products under several labels. The company also operates a range of cafés worldwide, in addition to a bar and nightclub.",R.drawable.armani));
        listBrand.add(new Brands("Chanel","Clothing","Chanel is a French privately held company owned by Alain Wertheimer and Gérard Wertheimer. Chanel is well-known for the perfume No. 5 de Chanel and Chanel Suit. Chanel's use of jersey fabric produced garments that were comfortable and affordable.Chanel revolutionized fashion — high fashion (haute couture) and everyday fashion by replacing structured-silhouettes, based upon the corset and the bodice, with garments that were functional and at the same time flattering to the woman's figure.",R.drawable.chanel));
        listBrand.add(new Brands("Louis Philippe","Clothing","Louis Philippe is a premium Indian brand of men's apparel. A subsidiary of Madura Fashion & Lifestyle, a division of the Aditya Birla Group, the brand was founded in 1989. Named after Louis Philippe, King of the French from 1830 to 1848, the brand is one of the largest apparel brands in India, as of 2018.",R.drawable.louisphilippe));
        listBrand.add(new Brands("Nykaa","Makeup","Falguni Nayar, a former managing director at Kotak Mahindra Capital Company, founded Nykaa in 2012. Nykaa was launched as an ecommerce portal curating a range of beauty and wellness products. The brand name Nykaa is derived from the Sanskrit word nayaka, meaning 'one in the spotlight'. Nykaa hosts the ‘Nykaa Femina Beauty Awards’ in partnership with women’s lifestyle magazine Femina (India).",R.drawable.nykaa));
        listBrand.add(new Brands("Swatch","Accessories","Swatch (stylized as swatch) is a Swiss watchmaker founded in 1983 by Nicolas Hayek and a flagship subsidiary of The Swatch Group. The Swatch product line was developed as a response to the \"quartz crisis\" of the 1970s and 1980s, in which Asian-made digital watches were competing against traditional European-made mechanical watches.  The name Swatch is a contraction of as the watches were intended as casual, disposable accessories.",R.drawable.swatch));

    }

     @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logoutMenu) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(BrandDisplay.this, Main2Activity.class));
        }

        if(Toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id= menuItem.getItemId();
        switch (id){
            case R.id.mySearch:
                Toast.makeText(this,"Search Selected",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BrandDisplay.this,ContactUs.class));
                break;
            case R.id.myAboutus:
                Toast.makeText(this,"About Us Selected",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BrandDisplay.this,Search.class));
                break;
            default:
                Toast.makeText(this,"Home Selected",Toast.LENGTH_SHORT).show();
        }
        DrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
