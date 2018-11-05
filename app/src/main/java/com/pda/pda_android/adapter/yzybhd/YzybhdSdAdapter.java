package com.pda.pda_android.adapter.yzybhd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.bean.JcBodybean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class YzybhdSdAdapter extends RecyclerView.Adapter<YzybhdSdAdapter.ViewHolder>{
    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<JcBodybean.Body> list;

    public YzybhdSdAdapter(Context context, List<JcBodybean.Body> list) {
        this.list = list;
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflater.inflate(R.layout.yzybhd_sd_body,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(list.get(position).getName());
        holder.data.setText(list.get(position).getData());
        holder.shebei.setText(list.get(position).getShebei());
        holder.project.setText(list.get(position).getProject());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,project,shebei,data;


        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.user_name);
            project=itemView.findViewById(R.id.project);
            shebei=itemView.findViewById(R.id.shebei);
            data=itemView.findViewById(R.id.data);
        }
    }
}