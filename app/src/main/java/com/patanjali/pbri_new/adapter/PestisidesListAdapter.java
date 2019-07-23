package com.patanjali.pbri_new.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.fragments.CropInfoFragment;
import com.patanjali.pbri_new.model.MachinaryList;
import com.patanjali.pbri_new.model1.PesticidesNameList;
import com.patanjali.pbri_new.model1.PesticidesNameList;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.RecyclerView.Adapter;
import static android.support.v7.widget.RecyclerView.ViewHolder;
import static com.patanjali.pbri_new.fragments.CropInfoFragment.pestisides_array;


/**
 * Created by Lenovo on 15-10-2017.
 */

public class PestisidesListAdapter extends Adapter<PestisidesListAdapter.MyViewHolder> {
    CropInfoFragment context;
    List<PesticidesNameList> arr=new ArrayList<>();


    public PestisidesListAdapter(CropInfoFragment activity, List<PesticidesNameList> messagess) {
        this.context = activity;
        this.arr = messagess;
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
        final String machinename=arr.get(position).getPesticidesName();
        holder.checkBox.setText(machinename);


//        Log.e("array machine: ", arr.get(position).getPesticidesId()+" position "+position+" machinedata "+context.pestisides_array);
//      String pest=pestisides_array+"";
//        if(pest.contains(arr.get(position).getPesticidesId()+"")){
//            holder.checkBox.setChecked(true);

//}

for (int i=0;i<pestisides_array.size(); i++) {
    String s = pestisides_array.get(i);
    if (s.equalsIgnoreCase(arr.get(position).getPesticidesId() + "")) {
        holder.checkBox.setChecked(true);
    }
}

  holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){


                    if(!(pestisides_array+"").contains(arr.get(position).getPesticidesId())) {


                         Toast.makeText(context.getActivity(),arr.get(position).getPesticidesId()+"" ,Toast.LENGTH_SHORT).show();
                        for (int i=0;i<pestisides_array.size(); i++) {
                            String s = pestisides_array.get(i);
                            if (!s.equalsIgnoreCase(arr.get(position).getPesticidesId() + "")) {
                                pestisides_array.add(arr.get(position).getPesticidesId());
                                break;
                            }
                        }
                    }
                    //context.spinnerValueMap.put(position,arr.get(position));
                }
                else {
                   // context.spinnerValueMap.remove(position);

//                    if((pestisides_array+"").contains(arr.get(position).getPesticidesId()))
//                        pestisides_array.remove(arr.get(position).getPesticidesId());
                    Toast.makeText(context.getActivity(),arr.get(position).getPesticidesId()+"" ,Toast.LENGTH_SHORT).show();

                    for (int i=0;i<pestisides_array.size(); i++) {
                        String s = pestisides_array.get(i);
                        if (s.equalsIgnoreCase(arr.get(position).getPesticidesId() + "")) {
                            pestisides_array.remove(arr.get(position).getPesticidesId());
                        }
                    }

                }
                Toast.makeText(context.getActivity(),pestisides_array+"" ,Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != arr ? arr.size() : 0);
    }

}

