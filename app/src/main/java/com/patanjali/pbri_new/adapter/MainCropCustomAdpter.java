//package com.patanjali.pbri_new.adapter;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.CheckBox;
//import android.widget.CompoundButton;
//
//import com.patanjali.pbri_new.fragments.FarmDetailsFragment;
//
//import java.util.ArrayList;
//import java.util.ListFarmBook;
//
//import info.androidhive.materialtabs.R;
//import info.androidhive.materialtabs.fragments.FarmDetailsFragment;
//import info.androidhive.materialtabs.model.TypeOfmaincropList;
//
//import static android.support.v7.widget.RecyclerView.Adapter;
//import static android.support.v7.widget.RecyclerView.ViewHolder;
//
//
///**
// * Created by Lenovo on 15-10-2017.
// */
//
//public class MainCropCustomAdpter extends Adapter<MainCropCustomAdpter.MyViewHolder> {
//    FarmDetailsFragment context;
//    ListFarmBook<TypeOfmaincropList> arr=new ArrayList<>();
//
//    public MainCropCustomAdpter(FarmDetailsFragment context, ListFarmBook<TypeOfmaincropList> arr) {
//        this.context = context;
//        this.arr = arr;
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
//        final String mainCropName=arr.get(position).getMainCropName();
//        holder.checkBox.setText(mainCropName);
//
//
//        if(context.maincropserverlist.contains(arr.get(position).getMainCropName())){
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
//                    if(!context.maincropserverlist.contains(arr.get(position).getMainId())) {
//                        context.maincropserverlist.add(arr.get(position).getMainId());
//
//                        // Toast.makeText(context,""+context.machinedata ,Toast.LENGTH_SHORT).show();
//                    }
//                    //context.spinnerValueMap.put(position,arr.get(position));
//                }
//                else {
//                   // context.spinnerValueMap.remove(position);
//
//                    context.maincropserverlist.remove(arr.get(position).getMainId());
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
