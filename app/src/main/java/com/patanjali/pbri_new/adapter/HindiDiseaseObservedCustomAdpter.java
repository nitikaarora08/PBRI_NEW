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
//import info.androidhive.materialtabs.model.DeseaseList;
//
//import static android.support.v7.widget.RecyclerView.Adapter;
//import static android.support.v7.widget.RecyclerView.ViewHolder;
//
//
///**
// * Created by Lenovo on 15-10-2017.
// */
//
//public class HindiDiseaseObservedCustomAdpter extends Adapter<HindiDiseaseObservedCustomAdpter.MyViewHolder> {
//    HindiCropInformationFragment context;
//    ListFarmBook<DeseaseList> arr=new ArrayList<>();
//
//    public HindiDiseaseObservedCustomAdpter(HindiCropInformationFragment context, ListFarmBook<DeseaseList> arr) {
//        this.context = context;
//        this.arr = arr;
//    }
//
//    public class MyViewHolder extends ViewHolder {
//
//        public CheckBox checkBox;
//
//        public MyViewHolder(View view) {
//
//
//            super(view);
//
//            this.checkBox = (CheckBox) view.findViewById(R.id.chbx_machinery);
//
//        }
//    }
//
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
//        final String diseaseName=arr.get(position).getDiseaseName();
//        holder.checkBox.setText(diseaseName);
//
//
//        if(context.diseaseserverdata.contains(arr.get(position).getDiseaseId())){
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
//
//                    if(!context.diseaseserverdata.contains(arr.get(position).getDiseaseId())) {
//                        context.diseaseserverdata.add(arr.get(position).getDiseaseId());
//
//                        // Toast.makeText(context,""+context.machinedata ,Toast.LENGTH_SHORT).show();
//
//                    }
//
//                    //context.spinnerValueMap.put(position,arr.get(position));
//                }
//
//                else {
//                   // context.spinnerValueMap.remove(position);
//
//                    context.diseaseserverdata.remove(arr.get(position).getDiseaseId());
//
//                }
//            }
//
//  });
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return (null != arr ? arr.size() : 0);
//    }
//
//}
