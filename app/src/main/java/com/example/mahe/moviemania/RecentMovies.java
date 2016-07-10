package com.example.mahe.moviemania;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class RecentMovies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_movies);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        String[] Movies = {"Captain America : Civil War", "Fan", "The Angry Birds Movie", "X-Men: Apocalypse", "Warcraft", "Jagga Jasoos", "Alice Through The Looking Glass"};        //A LIST OF NAME OF CARS.

        Integer[] images = new Integer[]{R.drawable.civilwar, R.drawable.fan, R.drawable.theangrybirdsmovie, R.drawable.xmen, R.drawable.warcraft, R.drawable.jaggajasoos, R.drawable.alicethroughthtelookingglass};
        //A LIST OF RESOURCE POSITIONS OF IMAGES(INT) WHICH ARE TO BE USED.



        ListAdapter adapter=new CustomAdapter(this,Movies,images);               //SETTING THE ADAPTER TO CUSTOM ONE CREATED BY US.



        ListView listview = (ListView)findViewById(R.id.listView);
        listview.setAdapter(adapter);                           //ASSIGNING THE ADAPTER TO THE LIST VIEW.


        listview.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String food=String.valueOf(parent.getItemAtPosition(position));         //we are obtaining the value
                        // of the list item which is clicked.
                        Toast.makeText(RecentMovies.this,food,Toast.LENGTH_LONG).show();        //Make a toast!!!


                    }
                }

        );
    }

    //FUN ENDS :(//////



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
