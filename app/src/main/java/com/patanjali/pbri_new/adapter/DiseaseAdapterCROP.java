//package com.patanjali.pbri_new.adapter;
//
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.CheckBox;
//import android.widget.CompoundButton;
//
//import com.patanjali.pbri_new.R;
//import com.patanjali.pbri_new.fragments.CropInfoFragment;
//import com.patanjali.pbri_new.fragments.FarmDetailsFragment;
//import com.patanjali.pbri_new.model.MachinaryList;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static android.support.v7.widget.RecyclerView.Adapter;
//import static android.support.v7.widget.RecyclerView.ViewHolder;
//
//
///**
// * Created by Lenovo on 15-10-2017.
// */
//
//public class DiseaseAdapterCROP extends Adapter<DiseaseAdapterCROP.MyViewHolder> {
//    CropInfoFragment context;
//    List<MachinaryList> arr=new ArrayList<>();
//
//
//    public DiseaseAdapterCROP(CropInfoFragment activity, List<MachinaryList> messagess) {
//        this.context = activity;
//        this.arr = messagess;
//    }
//
//    public class MyViewHolder extends ViewHolder {
//    public CheckBox checkBox;
//
//    public MyViewHolder(View view) {
//        super(view);
//        this.checkBox = (CheckBox) view.findViewById(R.id.chbx_machinery);
//    }
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
//        final String machinename=arr.get(position).getMachinaryName();
//        holder.checkBox.setText(machinename);
//
//
//        Log.e("array machine: ", arr.get(position).getMachinaryId()+" position "+position+" diseaseArray "+context.diseaseArray);
//        if(context.diseaseArray.contains(arr.get(position).getMachinaryId())){
//            holder.checkBox.setChecked(true);
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
//                    if(!context.diseaseArray.contains(arr.get(position).getMachinaryId())) {
//                        context.diseaseArray.add(arr.get(position).getMachinaryId());
//
//                        // Toast.makeText(context,""+context.diseaseArray ,Toast.LENGTH_SHORT).show();
//                    }
//                    //context.spinnerValueMap.put(position,arr.get(position));
//                }
//                else {
//                   // context.spinnerValueMap.remove(position);
//
//                    context.diseaseArray.remove(arr.get(position).getMachinaryId());
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
