package com.example.ministop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CartAdapterListView extends BaseAdapter {
    Context context;
    ArrayList<CART> carts;

    String url = "http://" + DEPRESS.ip + "/wsministop/sanpham/";

    public CartAdapterListView(Context context, ArrayList<CART> carts)
    {
        this.context = context;
        this.carts = carts;
    }

    @Override
    public int getCount() {
        return carts.size();
    }

    @Override
    public Object getItem(int position) {
        return carts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

//    public class ViewHolderListCart
//    {
//        public TextView tvTenspCart, tvGiaspCart, tvSLspCart;
//        Button btnAdd, btnMin;
//        ImageView imgspCart;
//    }


    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
//        ViewHolderListCart viewHolderListCart = null;
//        if(view == null)
//        {
//            viewHolderListCart = new ViewHolderListCart();
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view = inflater.inflate(R.layout.layout_1dong_giohang, null);
//            // anh xa
//            viewHolderListCart.tvTenspCart = (TextView)view.findViewById(R.id.tv_Cart_tensp);
//            viewHolderListCart.tvGiaspCart = (TextView)view.findViewById(R.id.tv_Cart_giasp);
//            viewHolderListCart.tvSLspCart = (TextView)view.findViewById(R.id.txt_Cart_soluong_1dong);
//            viewHolderListCart.imgspCart = (ImageView)view.findViewById(R.id.img_Cart_hinhsp);
//            viewHolderListCart.btnAdd = (Button)view.findViewById(R.id.btn_Cart_AddNumber);
//            viewHolderListCart.btnMin = (Button)view.findViewById(R.id.btn_Cart_MinNumber);
//            view.setTag(viewHolderListCart);
//        }
//        else
//        {
//            viewHolderListCart = (ViewHolderListCart) view.getTag();
//        }

        if(convertview == null)
        {
            convertview = LayoutInflater.from(context).inflate(R.layout.layout_1dong_giohang, null);
            // gen
            ImageView cart_img;
            TextView cart_name, cart_cost, cart_qlty;
            Button btn_add, btn_min;

            // mapping

            cart_img = convertview.findViewById(R.id.img_Cart_hinhsp);
            cart_name = convertview.findViewById(R.id.tv_Cart_tensp);
            cart_cost = convertview.findViewById(R.id.tv_Cart_giasp);
            cart_qlty = convertview.findViewById(R.id.txt_Cart_soluong_1dong);
            btn_add = convertview.findViewById(R.id.btn_Cart_AddNumber);
            btn_min = convertview.findViewById(R.id.btn_Cart_MinNumber);

            //hooking
            CART cart = (CART)getItem(position);

            cart_name.setText(cart.getTensp());
            cart_cost.setText(cart.getGiasp());

            Picasso.with(context)
                    .load(url + cart.getHinhsp())
                    .placeholder(R.drawable.no_image_found)
                    .into(cart_img);
            cart_qlty.setText(cart.getSoluong() + "");

            btn_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DEPRESS.carts.get(position).soluong++;
                    cart_qlty.setText(DEPRESS.carts.get(position).soluong + "");
                    ((CartActivity)(context)).xuLyThanhTien();


                }
            });

            btn_min.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int soluong;
                    soluong = Integer.parseInt(cart_qlty.getText().toString());
                    if(soluong <= 1)
                    {
                        btn_min.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        DEPRESS.carts.get(position).soluong--;
                        cart_qlty.setText(DEPRESS.carts.get(position).soluong + "");
                        ((CartActivity)(context)).xuLyThanhTien();
                    }

                }
            });

        }



//        viewHolderListCart.tvTenspCart.setText(cart.getTensp());
//        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
//        viewHolderListCart.tvGiaspCart.setText(decimalFormat.format(cart.getGiasp()));
//        viewHolderListCart.tvGiaspCart.setText(cart.getGiasp());

        //load anh


        //Them "" de chuyen ve kieu String
//        viewHolderListCart.tvSLspCart.setText(cart.getSoluong() + "");

//        int sl = Integer.parseInt(viewHolderListCart.tvSLspCart.getText().toString());

//        viewHolderListCart.btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                DEPRESS.carts.get(position).soluong++;
//                viewHolderListCart.tvSLspCart.setText(DEPRESS.carts.get(position).soluong + "");
//                // chờ xíu
//                //cái nút tăng giảm số lượng đâu, từ, nãy t mới debug ra :v
//                // t nghĩ là m dùng BaseAdapter thì k cần dùng VH
//
//            }
//        });


        return convertview;
    }


}
