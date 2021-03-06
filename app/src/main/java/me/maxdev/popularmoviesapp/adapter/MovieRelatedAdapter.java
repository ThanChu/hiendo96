package me.maxdev.popularmoviesapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.maxdev.popularmoviesapp.R;


public class MovieRelatedAdapter extends RecyclerView.Adapter<MovieRelatedAdapter.MyViewHolder> {


    @Override
    public MovieRelatedAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie_reated, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieRelatedAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(View view) {
            super(view);
        }
    }
}
