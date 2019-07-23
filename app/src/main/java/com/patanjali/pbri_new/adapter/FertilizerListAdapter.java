package com.patanjali.pbri_new.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.patanjali.pbri_new.Config;
import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;
import com.patanjali.pbri_new.fragments.CropInfoFragment;
import com.patanjali.pbri_new.fragments.OthersFragment;
import com.patanjali.pbri_new.model.SaveMachineData;
import com.patanjali.pbri_new.model1.FertilizerList;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.RecyclerView.Adapter;
import static android.support.v7.widget.RecyclerView.ViewHolder;
import static com.patanjali.pbri_new.fragments.CropInfoFragment.alertDialog;
import static com.patanjali.pbri_new.fragments.CropInfoFragment.cbFertilizer;
import static com.patanjali.pbri_new.fragments.CropInfoFragment.fertilizerArray;
import static com.patanjali.pbri_new.fragments.CropInfoFragment.frame_layout_others;
import static com.patanjali.pbri_new.fragments.CropInfoFragment.pestisides_array;


/**
 * Created by Lenovo on 15-10-2017.
 */

public class FertilizerListAdapter extends Adapter<FertilizerListAdapter.MyViewHolder> {
    CropInfoFragment context;
    Context ctx;
    List<FertilizerList> arr=new ArrayList<>();


    public FertilizerListAdapter(CropInfoFragment activity, List<FertilizerList> messagess,Context ctx) {
        this.context = activity;
        this.arr = messagess;
        this.ctx = ctx;
    }

    public class MyViewHolder extends ViewHolder {
    public CheckBox checkBox;

    public MyViewHolder(View view) {
        super(view);
        this.checkBox = (CheckBox) view.findViewById(R.id.chbx_machinery);
    }
}
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_checkbox_spinner, parent, false);


        MyViewHolder mh = new MyViewHolder(itemView);
        return mh;

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final String machinename=arr.get(position).getFertilizerName();
        holder.checkBox.setText(machinename);


        for (int i=0;i<fertilizerArray.size(); i++) {
            String s = fertilizerArray.get(i);
            if (s.equalsIgnoreCase(arr.get(position).getFertilizerId() + "")) {
                holder.checkBox.setChecked(true);
            }
        }

  holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        for (int i=0;i<fertilizerArray.size(); i++) {
                            String s = fertilizerArray.get(i);
                            if (!s.equalsIgnoreCase(arr.get(position).getFertilizerId() + "")) {
                                fertilizerArray.add(arr.get(position).getFertilizerId());
                            break;
                            }
                        }
                    } else {

                        for (int i=0;i<fertilizerArray.size(); i++) {
                            String s = fertilizerArray.get(i);
                            if (s.equalsIgnoreCase(arr.get(position).getFertilizerId() + "")) {
                                fertilizerArray.remove(arr.get(position).getFertilizerId());
                            }
                        }

                    }
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != arr ? arr.size() : 0);
    }

}

