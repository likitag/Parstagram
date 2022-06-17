package com.example.parstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import org.parceler.Parcels;

import java.util.Date;

public class PostDetailsActivity extends AppCompatActivity {
    Post post;
    TextView tvUsername;
    TextView tvDescription;
    ImageView ivImage;
    TextView tvTimestamp;
    TextView tvUsername2;
    ImageView ivProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);
        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        ivImage = (ImageView) findViewById(R.id.ivImage);
        tvTimestamp = (TextView) findViewById(R.id.tvTimestamp);
        ivProfile = (ImageView) findViewById(R.id.ivProfilePic);
      //  tvUsername2 = (TextView) findViewById(R.id.tvUsername2);

        post = (Post) Parcels.unwrap(getIntent().getParcelableExtra(Post.class.getSimpleName()));

        tvUsername.setText(post.getUser().getUsername());
//        tvUsername2.setText(post.getUser().getUsername());
        tvDescription.setText(post.getDescription());
        Date createdAt = post.getCreatedAt();
        String timeAgo = Post.calculateTimeAgo(createdAt);
        tvTimestamp.setText(timeAgo);

        ParseFile image = post.getImage();

        ParseFile profile = post.getUser().getParseFile("profile");

        if (profile != null) {
            Glide.with(this).load(profile.getUrl()).circleCrop().into(ivProfile);

        }


        if (image != null) {
            Glide.with(this).load(image.getUrl()).into(ivImage);

        }

    }

}