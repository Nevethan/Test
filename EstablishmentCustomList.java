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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruger on 21-12-2018.
 */

public class EstablishmentCustomList extends ArrayAdapter<Establishment> {

    List<Establishment> establishments = new ArrayList<>();
    private Context mContext;

    public EstablishmentCustomList(@NonNull Context context, @LayoutRes List<Establishment> list){
        super(context, 0,list);
        mContext = context;
        establishments = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        if(listItem == null){
            listItem = LayoutInflater.from(mContext).inflate(R.layout.establishment_custom_list,parent,false);
        }

        TextView name = (TextView) listItem.findViewById(R.id.textView5);
        TextView address = (TextView) listItem.findViewById(R.id.textView9);
        TextView type = (TextView) listItem.findViewById(R.id.textView7);
        TextView rating = (TextView) listItem.findViewById(R.id.textView8);

        ImageView imgView = (ImageView) listItem.findViewById(R.id.img);

        Establishment currentEstablishment = establishments.get(position);

        name.setText(currentEstablishment.getName());
        address.setText(currentEstablishment.getAddress());
        type.setText("Type: " + currentEstablishment.getType());
        rating.setText("Ratings: " + String.valueOf(currentEstablishment.getRating()));

        imgView.setImageResource(currentEstablishment.getImg());

        return listItem;
    }
}
