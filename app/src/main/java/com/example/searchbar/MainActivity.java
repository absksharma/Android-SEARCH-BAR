package com.example.searchbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.searchbar.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ArrayList<String> al;

    ListView lv;

    SearchView sv;

    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        al = new ArrayList<>();

        al.add("ONE");
        al.add("TWO");
        al.add("THREE");
        al.add("FOUR");
        al.add("FIVE");
        al.add("SIX");
        al.add("SEVEN");
        al.add("EIGHT");
        al.add("NINE");

        lv = findViewById(R.id.lv);
        sv = findViewById(R.id.sv);

        ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,al);

        lv.setAdapter(ad);

        sv.setOnQueryTextListener(this);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You Clicked: "+ad.getItem(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onQueryTextSubmit(String query) {

        if (al.contains(query))
        {
            ad.getFilter().filter(query);
//            onQueryTextChange(query);
        }
        else
        {
            Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
        }
        return false;
    }


    @Override
    public boolean onQueryTextChange(String newText) {
         ad.getFilter().filter(newText);
//        if (newText.length()==0)
//        {
//            ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,al);
//
//            lv.setAdapter(ad);
//        }
        return false;
    }
}

