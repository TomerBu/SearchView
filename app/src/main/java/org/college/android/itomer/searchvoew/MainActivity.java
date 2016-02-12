package org.college.android.itomer.searchvoew;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupSearchView();

        Intent intent = getIntent();
        if (intent.getAction().equals(Intent.ACTION_SEARCH)) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }
    }

    private void doMySearch(String query) {
        Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
    }

    private void setupSearchView() {
        SearchView searchView = (SearchView) findViewById(R.id.search);
// Sets searchable configuration defined in searchable.xml for this SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                doMySearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                filterSearchFor(query);
                return true;
            }
        });
    }

    private void filterSearchFor(String query) {
        //filter the list
        Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
    }
}
