package com.example.parstagram;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import org.parceler.Parcels;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {
    private Context context;
    private List<Post> posts;



    public ProfileAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }
    // Clean all elements of the recycler
    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Post> list) {
        posts.addAll(list);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_profile, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }




    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //private TextView tvUsername;
        //private TextView tvUsername2;
        private ImageView ivImage;
        //private TextView tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //tvUsername = itemView.findViewById(R.id.tvUsername);
            ivImage = itemView.findViewById(R.id.ivImage);
            //tvDescription = itemView.findViewById(R.id.tvDescription);
            //tvUsername2 = itemView.findViewById(R.id.tvUsername2);

            itemView.setOnClickListener(this);
        }

        public void bind(Post post) {
            // Bind the post data to the view elements
            //tvDescription.setText(post.getDescription());
            //tvUsername.setText(post.getUser().getUsername());
            //tvUsername2.setText(post.getUser().getUsername());
            ParseFile image = post.getImage();
            if (image != null) {
                Glide.with(context).load(image.getUrl()).into(ivImage);
            }
        }





        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                // get the movie at the position, this won't work if the class is static
                Post post = posts.get(position);
                // create intent for the new activity
                Intent intent = new Intent(context, PostDetailsActivity.class);
                // serialize the movie using parceler, use its short name as a key
                intent.putExtra(Post.class.getSimpleName(), Parcels.wrap(post));
                // show the activity
                context.startActivity(intent);
            }


        }
    }


}
