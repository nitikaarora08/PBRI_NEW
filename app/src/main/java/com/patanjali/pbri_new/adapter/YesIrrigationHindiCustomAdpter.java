package com.patanjali.pbri_new.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.fragments.FarmDetailsFragment;
import com.patanjali.pbri_new.model.InsectList;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.RecyclerView.Adapter;
import static android.support.v7.widget.RecyclerView.ViewHolder;


/**
 * Created by Lenovo on 15-10-2017.
 */

public class YesIrrigationHindiCustomAdpter extends Adapter<YesIrrigationHindiCustomAdpter.MyViewHolder> {
    FarmDetailsFragment context;
    List<InsectList> arr=new ArrayList<>();

    public YesIrrigationHindiCustomAdpter(FarmDetailsFragment context, List<InsectList> arr) {
        this.context = context;
        this.arr = arr;
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
        final String irrigationName=arr.get(position).getIrrigationName();
//        String s=String.valueOf(arr);
//        String s1=String.valueOf(context.yesirrigationserverdata);
        final String id=arr.get(position).getIrrigationId();
        holder.checkBox.setText(irrigationName);


        if(String.valueOf(context.yesirrigationserverdata).contains(id)){
    holder.checkBox.setChecked(true);

}

  else {
     holder.checkBox.setChecked(false);

}

  holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){


                    if(!context.yesirrigationserverdata.contains(arr.get(position).getIrrigationId())) {
                        context.yesirrigationserverdata.add(arr.get(position).getIrrigationId());

                        // Toast.makeText(context,""+context.machinedata ,Toast.LENGTH_SHORT).show();
                    }
                    //context.spinnerValueMap.put(position,arr.get(position));
                }
                else {
                   // context.spinnerValueMap.remove(position);

                    context.yesirrigationserverdata.remove(arr.get(position).getIrrigationId());

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != arr ? arr.size() : 0);
    }

}

