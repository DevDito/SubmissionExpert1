package com.example.expertsub1.list_movie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.expertsub1.R;

import java.util.ArrayList;

public class ListMovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ArrayList<MovieModel> modelList;

    private OnItemClickListener mItemClickListener;


    public ListMovieAdapter(Context context, ArrayList<MovieModel> modelList) {
        this.mContext = context;
        this.modelList = modelList;
    }

    public void updateList(ArrayList<MovieModel> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_movie, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        //Here you can fill your row view
        if (holder instanceof ViewHolder) {
            final MovieModel model = getItem(position);
            ViewHolder vh = (ViewHolder) holder;

            vh.itemTitle.setText(model.getTitle());

            if(model.getOverview().length()>50){
                vh.itemOverview.setText(model.getOverview().substring(0,49)+" ...");
            }else{
                vh.itemOverview.setText(model.getOverview());
            }

            vh.imgPoster.setImageResource(model.getPoster());


        }
    }


    @Override
    public int getItemCount() {

        return modelList.size();
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    private MovieModel getItem(int position) {
        return modelList.get(position);
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position, MovieModel model);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgPoster;
        private TextView itemTitle;
        private TextView itemOverview;

        public ViewHolder(final View itemView) {
            super(itemView);

            this.imgPoster = itemView.findViewById(R.id.img_poster);
            this.itemTitle = itemView.findViewById(R.id.item_title);
            this.itemOverview = itemView.findViewById(R.id.item_overview);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), modelList.get(getAdapterPosition()));
                }
            });

        }
    }

}
