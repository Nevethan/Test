package com.example.bruger.test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruger on 21-12-2018.
 */

public class EstablishmentCustomList extends ArrayAdapter<Establishment> {

    /*private List<String> names = new ArrayList<>();
    private List<String> addresses = new ArrayList<>();
    private List<String> types = new ArrayList<>();
    private List<Double> ratings = new ArrayList<>();
    private List<Integer> imgs = new ArrayList<>();
    */
    List<Establishment> establishments = new ArrayList<>();

    public EstablishmentCustomList(Context context, List<Establishment> establishments){
        super(context, R.layout.establishment_custom_list);
        this.establishments = establishments;
    }

    /*public EstablishmentCustomList(Context context, List<String> names, List<String> addresses, List<String> types, List<Double> ratings, List<Integer> imgs) {
        super(context, R.layout.establishment_custom_list);
        this.names = names;
        this.addresses = addresses;
        this.types = types;
        this.ratings = ratings;
        this.imgs = imgs;
    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View row = layoutInflater.inflate(R.layout.establishment_custom_list, parent, false);

        TextView name = (TextView) row.findViewById(R.id.textView5);
        TextView address = (TextView) row.findViewById(R.id.textView9);
        TextView type = (TextView) row.findViewById(R.id.textView7);
        TextView rating = (TextView) row.findViewById(R.id.textView8);

        ImageView imgView = (ImageView) row.findViewById(R.id.img);

        name.setText(establishments.get(position).getName());
        address.setText(establishments.get(position).getAddress());
        type.setText(establishments.get(position).getType());
        rating.setText(String.valueOf(establishments.get(position).getRating()));

        imgView.setImageResource(establishments.get(position).getImg());

        return row;
    }
}
