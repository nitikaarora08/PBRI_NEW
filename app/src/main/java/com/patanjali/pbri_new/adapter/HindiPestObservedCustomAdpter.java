//package com.patanjali.pbri_new.adapter;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.CheckBox;
//import android.widget.CompoundButton;
//
//import java.util.ArrayList;
//import java.util.ListFarmBook;
//
//import info.androidhive.materialtabs.R;
//import info.androidhive.materialtabs.fragments.HindiCropInformationFragment;
//import info.androidhive.materialtabs.model.InsectList;
//
//import static android.support.v7.widget.RecyclerView.Adapter;
//import static android.support.v7.widget.RecyclerView.ViewHolder;
//
//
///**
// * Created by Lenovo on 15-10-2017.
// */
//
//public class HindiPestObservedCustomAdpter extends Adapter<HindiPestObservedCustomAdpter.MyViewHolder> {
//    HindiCropInformationFragment context;
//    ListFarmBook<InsectList> arr=new ArrayList<>();
//
//
//    public HindiPestObservedCustomAdpter(HindiCropInformationFragment context, ListFarmBook<InsectList> arr) {
//        this.context = context;
//        this.arr = arr;
//    }
//
//
//    public class MyViewHolder extends ViewHolder {
//
//        public CheckBox checkBox;
//
//        public MyViewHolder(View view) {
//            super(view);
//            this.checkBox = (CheckBox) view.findViewById(R.id.chbx_machinery);
//
//        }
//
//}
//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.adapter_checkbox_spinner, parent, false);
//
//
//        MyViewHolder mh = new MyViewHolder(itemView);
//        return mh;
//
//    }
//
//    @Override
//    public void onBindViewHolder(final MyViewHolder holder, final int position) {
//        final String pestName=arr.get(position).getInsectName();
//        holder.checkBox.setText(pestName);
//
//
//        if(context.pestobserveddata.contains(arr.get(position).getInsectId())){
//    holder.checkBox.setChecked(true);
//
//}
//
//  else {
//     holder.checkBox.setChecked(false);
//
//}
//
//  holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//
//                if(b){
//
//                    if(!context.pestobserveddata.contains(arr.get(position).getInsectId())) {
//                        context.pestobserveddata.add(arr.get(position).getInsectId());
//
//                        // Toast.makeText(context,""+context.machinedata ,Toast.LENGTH_SHORT).show();
//                    }
//                    //context.spinnerValueMap.put(position,arr.get(position));
//                }
//                else {
//                   // context.spinnerValueMap.remove(position);
//
//                    context.pestobserveddata.remove(arr.get(position).getInsectId());
//
//                }
//            }
//        });
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return (null != arr ? arr.size() : 0);
//    }
//
//}
//
