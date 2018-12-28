package com.example.hp.androak;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.AppsViewHolder> {

    Context context;
    List<Apps> appsList;

    public AppsAdapter(Context context,List<Apps> appsList)
    {
        this.context=context;
        this.appsList=appsList;
    }
    @NonNull
    @Override
    public AppsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.apps_layout,viewGroup,false);
        AppsViewHolder appsViewHolder=new AppsViewHolder(view);
        return appsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AppsViewHolder appsViewHolder, int i) {
    Apps app=appsList.get(i);
    appsViewHolder.description.setText(app.getDescription());
    appsViewHolder.link.setText(app.getLink());
    appsViewHolder.name.setText(app.getName());
    }

    @Override
    public int getItemCount() {
        return appsList.size();
    }

    class AppsViewHolder extends RecyclerView.ViewHolder{

        TextView description,link,name;
        public AppsViewHolder(@NonNull View itemView) {
            super(itemView);
            link=itemView.findViewById(R.id.link);
            name=itemView.findViewById(R.id.name);
            description=itemView.findViewById(R.id.description);
        }
    }
}
