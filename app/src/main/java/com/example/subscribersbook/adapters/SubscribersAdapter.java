package com.example.subscribersbook.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.subscribersbook.R;
import com.example.subscribersbook.models.Subscriber;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SubscribersAdapter extends ArrayAdapter<Subscriber> {

    private LayoutInflater inflater;
    private List<Subscriber> people;
    private int resource;

    public SubscribersAdapter(@NonNull Context context, int resource, List<Subscriber> people) {
        super(context, resource, people);
        this.people = people;
        this.inflater = LayoutInflater.from(context);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(resource, parent, false);

        TextView tvFirstName = view.findViewById(R.id.tvFirstName);
        TextView tvLastName = view.findViewById(R.id.tvLastName);
        TextView tvAge = view.findViewById(R.id.tvAge);
        ImageView ivPhoto = view.findViewById(R.id.imageViewPhoto);

        Subscriber subscriber = people.get(position);

        tvFirstName.setText(subscriber.getFirstName());
        tvLastName.setText(subscriber.getLastName());
        tvAge.setText(String.valueOf(subscriber.getAge()));
        Picasso.get().load(subscriber.getImagePath()).into(ivPhoto);

        Button btnRemove = view.findViewById(R.id.btnRemove);
        btnRemove.setOnClickListener(v -> {
            people.remove(subscriber);
            notifyDataSetChanged();
        });

        return view;
    }
}
