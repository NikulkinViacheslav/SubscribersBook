package com.example.subscribersbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.subscribersbook.adapters.SubscribersAdapter;
import com.example.subscribersbook.models.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvItems;
    List<Subscriber> people = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItems = findViewById(R.id.lvItems);
        ArrayList<Subscriber> people = new ArrayList<>();

        people.add(new Subscriber("FirstName 1", "LastName 1", 20, "https://www.zagran-pasport.online/wp-content/uploads/2021/03/65.png"));
        people.add(new Subscriber("FirstName 2", "LastName 2", 33, "https://www.zagran-pasport.online/wp-content/uploads/2021/03/65.png"));
        people.add(new Subscriber("FirstName 3", "LastName 3", 18, "https://www.zagran-pasport.online/wp-content/uploads/2021/03/65.png"));

        SubscribersAdapter adapter = new SubscribersAdapter(this, R.layout.subscriber_layout, people);
        lvItems.setAdapter(adapter);

    }
}