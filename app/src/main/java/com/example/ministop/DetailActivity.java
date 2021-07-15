package com.example.ministop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView txtTen, txtGia, txtMoTa;
    Button button;
    Products products;

    //Y:192.168.22.102  //Ru:192.168.1.7
    String ip = "192.168.22.102";
    String url = "http://" + ip + "/wsministop/sanpham/";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chitietsanpham);

        //Hide action bar
        ActionBar actionBar = getSupportActionBar();
        //thanh tro ve home
        actionBar.setDisplayHomeAsUpEnabled(true);
        //doi mau thanh action bar
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#003894"));
        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle("Chi tiết sản phẩm"); //Thiết lập tiêu đề
        //String title = actionBar.getTitle().toString();

        //Anh xa
        imageView = findViewById(R.id.img_CTSP);
        txtTen = findViewById(R.id.tv_CTSP1);
        txtGia = findViewById(R.id.tv_CTSP2);
        txtMoTa = findViewById(R.id.tv_CTSP3);
        button = findViewById(R.id.btn_addCart);

        //Gui du lieu tu home qua
        Intent intent = getIntent();
        if(intent != null)
        {
            products = (Products) intent.getSerializableExtra("key1");

            //load hình từ url
            Picasso.with(this).load(url + products.getHinh()).placeholder(R.drawable.no_image_found).into(imageView);
            //Set lại id để load dữ liệu từ HomeActivity qua
            txtTen.setText(products.getTen());
            txtGia.setText(products.getGia());
            txtMoTa.setText(products.getMota());

        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DetailActivity.this,CartActivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}