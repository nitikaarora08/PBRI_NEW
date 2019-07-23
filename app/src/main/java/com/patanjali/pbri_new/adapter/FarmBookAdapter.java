package com.patanjali.pbri_new.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.patanjali.pbri_new.Config;
import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;
import com.patanjali.pbri_new.fragments.FarmLabFragment;
import com.patanjali.pbri_new.fragments.FarmLabHome;
import com.patanjali.pbri_new.model1.ListFarmBook;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.patanjali.pbri_new.fragments.FarmLabFragment.RLaddBook;
import static com.patanjali.pbri_new.fragments.FarmLabFragment.etComplaint;
import static com.patanjali.pbri_new.fragments.FarmLabFragment.imageAttached;
import static com.patanjali.pbri_new.fragments.FarmLabFragment.txtfilePath;

public   class FarmBookAdapter extends RecyclerView.Adapter<FarmBookAdapter.MyViewHolder> {
    private Context context;
    public  SharedPrefrenceUtil sharedPrefrenceUtil;
    View itemView;
     java.util.List<ListFarmBook> getVoucher;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // CheckBox c1;
        public TextView txtLabID,txtLabIDShow, txtText,txtDate,id,txtExpire,txtProduct;
        public ImageView imgFile;
        Button btnMinus,btnPlus;
        LinearLayout linlayoutDetails;
        int amount=0;
        //public Button buttonInc,buttonDec,orderNow;
        public MyViewHolder(View view) {
            super(view);
            txtLabIDShow = view.findViewById(R.id.txtLabIDShow);
            txtText = view.findViewById(R.id.txtText);
            txtDate = view.findViewById(R.id.txtDate);
            imgFile = view.findViewById(R.id.imgFile);
            linlayoutDetails = view.findViewById(R.id.linlayoutDetails);

        }
    }

    public FarmBookAdapter(Context context, java.util.List<ListFarmBook> getVoucher) {
        this.context = context;
        this.getVoucher = getVoucher;
    }


    @NonNull
    @Override
    public FarmBookAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.farm_book_layout, parent, false);
        sharedPrefrenceUtil = new SharedPrefrenceUtil(context);



        return new FarmBookAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final FarmBookAdapter.MyViewHolder holder, final int position) {
         final ListFarmBook movie = getVoucher.get(position);
        holder.txtLabIDShow.setText(movie.getFarmlabBookId());
        holder.txtText.setText(movie.getText());
        holder.txtDate.setText(movie.getCreatedAt());

        try{
            if (movie.getImage().contains(".jpg") || movie.getImage().contains(".png")) {
                Picasso.with(context)
                        .load(movie.getImage())
                        .into(holder.imgFile);

            }
            else if( movie.getImage().contains(".pdf")) {
                holder.imgFile.setImageResource(R.drawable.pdf);
            }
        }catch (Exception e){}
//            Config.toast(context,movie.getImage());


        holder.imgFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 try{
                     Uri uri = Uri.parse(movie.getImage()); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    context.startActivity(intent);
                 }catch (Exception e){}


            }
        });

        holder.linlayoutDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    String id=getVoucher.get(position).getFarmLabId();
                Config.toast(context,holder.txtLabIDShow.getText().toString());
                sharedPrefrenceUtil.setFarmBookID(holder.txtLabIDShow.getText().toString());
                RLaddBook.setVisibility(View.VISIBLE);
                etComplaint.setText(holder.txtText.getText().toString());


                try{
                    if (movie.getImage().contains(".jpg") || movie.getImage().contains(".png")) {
                        Picasso.with(context)
                                .load(movie.getImage())
                                .into(imageAttached);
                    }else{
                        imageAttached.setImageResource(R.drawable.pdf);
                    }
                    txtfilePath.setText(movie.getImage());
                }catch (Exception e){}
//                Config.CallFragment(context,new FarmLabFragment());
            }
        });

    }

    @Override
    public int getItemCount() {
        return getVoucher.size();
    }
}



