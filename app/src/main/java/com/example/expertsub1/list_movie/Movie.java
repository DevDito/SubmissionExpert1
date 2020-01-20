package com.example.expertsub1.list_movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expertsub1.R;
import com.example.expertsub1.detail_movie.DetailMovie;

import java.util.ArrayList;

public class Movie extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListMovieAdapter mAdapter;

    private ArrayList<MovieModel> modelList = new ArrayList<>();
    public static final String SELECTED_MOVIE = "selected_movie";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);
        findViews();
        setAdapter();
    }

    private void findViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }


    private void setAdapter() {
        modelList.add(new MovieModel(getResources().getString(R.string.title_avenger_end_game),getString(R.string.overview_avenger_end_game),R.drawable.poster1));
        modelList.add(new MovieModel(getResources().getString(R.string.title_parasite),getString(R.string.overview_parasite),R.drawable.poster2));
        modelList.add(new MovieModel(getResources().getString(R.string.title_toy_story_4),getString(R.string.overview_toy_story_4),R.drawable.poster3));
        modelList.add(new MovieModel(getResources().getString(R.string.title_joker),getString(R.string.title_joker),R.drawable.poster4));
        modelList.add(new MovieModel(getResources().getString(R.string.title_the_farewell),getString(R.string.overview_the_farewell),R.drawable.poster5));
        modelList.add(new MovieModel(getResources().getString(R.string.title_booksmart),getString(R.string.overview_booksmart),R.drawable.poster6));
        modelList.add(new MovieModel(getResources().getString(R.string.title_shazam),getString(R.string.overview_shazam),R.drawable.poster7));
        modelList.add(new MovieModel(getResources().getString(R.string.title_glass),getString(R.string.overview_glass),R.drawable.poster8));
        modelList.add(new MovieModel(getResources().getString(R.string.title_aquaman),getString(R.string.overview_aquaman),R.drawable.poster9));
        modelList.add(new MovieModel(getResources().getString(R.string.title_avengerinfinity),getString(R.string.overview_avengerinfinity),R.drawable.poster10));
        modelList.add(new MovieModel(getResources().getString(R.string.title_deadpool),getString(R.string.overview_deadpool),R.drawable.poster11));
        modelList.add(new MovieModel(getResources().getString(R.string.title_bumblebee),getString(R.string.overview_bumblebee),R.drawable.poster12));
        modelList.add(new MovieModel(getResources().getString(R.string.title_venom),getString(R.string.overview_venom),R.drawable.poster13));
        modelList.add(new MovieModel(getResources().getString(R.string.title_spiderman),getString(R.string.overview_spiderman),R.drawable.poster14));
        modelList.add(new MovieModel(getResources().getString(R.string.title_dragon),getString(R.string.overview_dragon),R.drawable.poster15));

        mAdapter = new ListMovieAdapter(Movie.this, modelList);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        mAdapter.SetOnItemClickListener(new ListMovieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, MovieModel model) {
                Intent goToDetailMovie = new Intent(Movie.this, DetailMovie.class);
                goToDetailMovie.putExtra(Movie.SELECTED_MOVIE,model);
                startActivity(goToDetailMovie);
            }
        });
    }


}
