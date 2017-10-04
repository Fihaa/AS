package com.alatheer.anwaralfyaha.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alatheer.anwaralfyaha.Models.ListRecycle;
import com.alatheer.anwaralfyaha.R;

import java.util.List;



public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.IndanMovieHolder> {

    List<ListRecycle> movelist;
    public RecycleAdapter(List<ListRecycle> movelist){
        this.movelist=movelist;
    }



    @Override
    public IndanMovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item,parent,false);
        IndanMovieHolder Holder=new IndanMovieHolder(row);
        return Holder;
    }

    @Override
    public void onBindViewHolder(IndanMovieHolder holder, int position) {
        ListRecycle movie = movelist.get(position);
        holder.Titile.setText(movie.movieName);
        holder.Rate.setText(movie.movieRate);
        holder.Desc.setText(movie.movieStory);
        holder.poster.setImageResource(movie.posterImage);

    }

    @Override
    public int getItemCount() {
        return movelist.size();
    }

    class IndanMovieHolder extends RecyclerView.ViewHolder{
        TextView Titile,Rate,Desc;
        ImageView poster;


        public IndanMovieHolder(View itemView) {
            super(itemView);

            Titile = (TextView) itemView.findViewById(R.id.Tital);
            Rate =(TextView) itemView.findViewById(R.id.num);
            Desc =(TextView) itemView.findViewById(R.id.comment);
            poster = (ImageView) itemView.findViewById(R.id.movimg);

        }
    }
}
