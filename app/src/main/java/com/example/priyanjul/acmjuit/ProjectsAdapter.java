package com.example.priyanjul.acmjuit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Priyanjul on 15-04-2017.
 */

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.MyViewHolder>{

    private ProjectsActivity mContext;
    private List<Project> projectList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, extra;
        public ImageView thumbnail;

        public MyViewHolder(View view){
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            extra = (TextView) view.findViewById(R.id.extra);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

        }
    }

    public ProjectsAdapter(ProjectsActivity mContext, List<Project> projectList){
        this.mContext=mContext;
        this.projectList=projectList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView  = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_cards,parent,false);
        return  new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Project project=projectList.get(position);
        holder.title.setText(project.getName());
        holder.extra.setText(project.getNumOfSongs() + "songs");

        //loading albumcover using Glide library
        Glide.with(mContext).load(project.getThumbnail()).into(holder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

}
