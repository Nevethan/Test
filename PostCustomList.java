package com.example.bruger.test;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruger on 21-12-2018.
 */

public class PostCustomList extends ArrayAdapter<Post>{

    List<Post> posts = new ArrayList<>();

    private Context mContext;

    public PostCustomList(@NonNull Context context, @LayoutRes List<Post> list){
        super(context, 0,list);
        mContext = context;
        posts = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        if(listItem == null){
            listItem = LayoutInflater.from(mContext).inflate(R.layout.post_custom_list,parent,false);
        }

        Post currentPost = posts.get(position);

        TextView title = (TextView) listItem.findViewById(R.id.textView10);
        TextView location = (TextView) listItem.findViewById(R.id.textView12);
        TextView type = (TextView) listItem.findViewById(R.id.textView13);

        title.setText(currentPost.getTitle());
        location.setText(currentPost.getLocation());
        type.setText(currentPost.getType());

        return listItem;
    }

}
