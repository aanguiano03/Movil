package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.recyclerview.R;
import com.example.recyclerview.adaptador.RecyclerAdapter;
import com.example.recyclerview.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.RecyclerItemClick, SearchView.OnQueryTextListener {
    private RecyclerView rvLista;
    private SearchView svSearch;
    private RecyclerAdapter adapter;
    private List<ItemList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initValues();
        initListener();
    }

    private void initViews(){
        rvLista = findViewById(R.id.rvLista);
        svSearch = findViewById(R.id.svSearch);
    }

    private void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);

        items = getItems();
        adapter = new RecyclerAdapter(items, this);
        rvLista.setAdapter(adapter);
    }

    private void initListener() {
        svSearch.setOnQueryTextListener(this);
    }

    private List<ItemList> getItems() {
        List<ItemList> itemLists = new ArrayList<>();
        itemLists.add(new ItemList("Coraje", "Caricatura de un perro miedoso.", R.drawable.coraje));
        itemLists.add(new ItemList("Las chicas super poderosas", "Chicas super poderosas que salvan su ciudad.", R.drawable.Chicas));
        itemLists.add(new ItemList("Jonny Bravo", "Jonny Bravo el mas guapo y fuerte de su ciudad.", R.drawable.jonny));
        itemLists.add(new ItemList("Billy y Mandy", "Billy y Mandy, amigos de la muerte en busca de aventuras.", R.drawable.mandy));
        itemLists.add(new ItemList("Padrinos Magicos", "Padrinos magicos que salvan el mundo.", R.drawable.padrinos));
        itemLists.add(new ItemList("Pucca", "Pucca quiere a Garu.", R.drawable.puca));
        itemLists.add(new ItemList("La familia Griffin de Family Guy", "Este bebe es todo un show.", R.drawable.mom));
        itemLists.add(new ItemList("Vaca y Pollito", "Vaca y pollito hermanos desde pequeños.", R.drawable.vaca));
        itemLists.add(new ItemList("Los simpson", "Los simpson, con Homero sin trabajar y Bart todo un desastre.", R.drawable.simpson));
        itemLists.add(new ItemList("Garfield", "Garfiel un gato que se la pasa comiendo y durmiendo (me identificooo).", R.drawable.garfield));
        itemLists.add(new ItemList("Scooby-Doo", "Scooby-Doo resolviendo misterios.", R.drawable.scooby));
        itemLists.add(new ItemList("La Pantera Rosa", "La pantera rosa, nunca la dejan ser.", R.drawable.pink));

        return itemLists;
    }

    @Override
    public void itemClick(ItemList item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("itemDetail", item);
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;
    }
}
