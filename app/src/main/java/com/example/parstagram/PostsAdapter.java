package com.example.parstagram;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.parstagram.fragments.ProfileFragment;
import com.parse.Parse;
import com.parse.ParseFile;
import com.parse.ParseUser;

import org.parceler.Parcels;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {
    private Context context;
    private List<Post> posts;



    public PostsAdapter(Context context, List<Post> posts) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
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
        private TextView tvUsername;
        private TextView tvUsername2;
        private ImageView ivImage;
        private TextView tvDescription;
        private ImageView ivProfile;
        ImageButton btnFavorite;
        ImageButton btnComment;
        FragmentManager fragmentManager;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvUsername2 = itemView.findViewById(R.id.tvUsername2);
            ivProfile = itemView.findViewById(R.id.ivProfilePic);
            btnFavorite = itemView.findViewById(R.id.btnFavorite);
            fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();;


            tvUsername.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Post post = posts.get(position);
                    Bundle bundle = new Bundle();
                    bundle.putString("homeScreenBundle", "not null");
                    bundle.putParcelable("username", post.getUser());
                    bundle.putParcelable("image", post.getUser().getParseFile("profile"));
                    Fragment fragment = new ProfileFragment();
                    fragment.setArguments(bundle);
                    fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                }
            });


            //int position = getAdapterPosition();
//            if (position!=RecyclerView.NO_POSITION){
//                Post post = posts.get(position);
//                JSONArray array = post.getJSONArray("Likes");
//                for (int i = 0; i< array.length(); i++){
//                    JSONObject user = array.getJSONObject(i);
//                    if (user.equals(ParseUser.getCurrentUser().getObjectId())){
//                        btnFavorite.setImageResource(R.drawable.ic_baseline_favorite_24);
//                    }
//                }
//            }


            itemView.setOnClickListener(this);

//            btnFavorite.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position = getAdapterPosition();
//                    if (position!=RecyclerView.NO_POSITION){
//                        Post post = posts.get(position);
//                        JSONArray array = post.getJSONArray("Likes");
//                        if (btnFavorite.getTag().equals("empty heart")){
//                            btnFavorite.setImageResource(R.drawable.ic_baseline_favorite_24);
//                            btnFavorite.setTag("full heart");
//                            JSONObject jsonObj = new JSONObject();
//                            try {
//                                jsonObj.put(ParseUser.getCurrentUser().getObjectId(), array.length());
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//
//                        }
//
//                        else if (btnFavorite.getTag().equals("full heart")){
//                            btnFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24);
//                            btnFavorite.setTag("empty heart");
//                            JSONObject jsonObj = new JSONObject();
//                            jsonObj.remove(ParseUser.getCurrentUser().getObjectId());
//
//                        }
//
//                    }
//                }
//            });
        }

        public void bind(Post post) {
            // Bind the post data to the view elements
            tvDescription.setText(post.getDescription());
            tvUsername.setText(post.getUser().getUsername());


            tvUsername2.setText(post.getUser().getUsername());
            ParseFile image = post.getImage();
            ParseFile imageProf = post.getUser().getParseFile("profile");



            if (imageProf != null) {
                Glide.with(context).load(imageProf.getUrl()).circleCrop().into(ivProfile);

            }


            if (image != null) {
                Glide.with(context).load(image.getUrl()).into(ivImage);
            }
//
//            tvUsername.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
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
