package com.example.bruger.test;

import android.content.Context;
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

    public PostCustomList(Context context, List<Post> posts){
        super(context, R.layout.post_custom_list);
        this.posts = posts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View row = layoutInflater.inflate(R.layout.post_custom_list, parent, false);

        TextView title = (TextView) row.findViewById(R.id.textView10);
        TextView location = (TextView) row.findViewById(R.id.textView12);
        TextView Type = (TextView) row.findViewById(R.id.textView13);

        return row;
    }

}
