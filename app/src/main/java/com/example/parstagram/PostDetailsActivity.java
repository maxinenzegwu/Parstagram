package com.example.parstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.parceler.Parcels;

public class PostDetailsActivity extends AppCompatActivity {

    Post post;

    TextView tvDescriptionDetails;
    TextView createdAt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        tvDescriptionDetails = findViewById(R.id.tvDescriptionDetails);
        createdAt = findViewById(R.id.tvCreatedAt);

        post = (Post) Parcels.unwrap(getIntent().getParcelableExtra(Post.class.getSimpleName()));
        Log.d("PostDetailsActivity", String.format("Showing details for post with description '%s'", post.getDescription()));

        tvDescriptionDetails.setText(post.getDescription());
        createdAt.setText(post.getCreatedAt().toString());

    }
}