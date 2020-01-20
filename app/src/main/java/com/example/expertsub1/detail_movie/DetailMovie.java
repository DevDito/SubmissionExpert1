package com.example.expertsub1.detail_movie;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.expertsub1.list_movie.Movie;
import com.example.expertsub1.list_movie.MovieModel;
import com.example.expertsub1.R;

public class DetailMovie extends AppCompatActivity {
    private TextView tvTitle, tvOverview;
    private ImageView imgPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        tvTitle = findViewById(R.id.tv_title);
        tvOverview = findViewById(R.id.tv_overview);
        imgPoster = findViewById(R.id.img_poster);
        MovieModel movieModel = getIntent().getParcelableExtra(Movie.SELECTED_MOVIE);
        tvTitle.setText(movieModel.getTitle());
        tvOverview.setText(movieModel.getOverview());
        imgPoster.setImageResource(movieModel.getPoster());
        setTitle(movieModel.getTitle());
    }
}

