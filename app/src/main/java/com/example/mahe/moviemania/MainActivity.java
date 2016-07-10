package com.example.mahe.moviemania;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    }
    public void recent(View view){

        Intent i=new Intent(this,RecentMovies.class);
        startActivity(i);

    }



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


    public void searchmovie (View view)
    {

        EditText t1=(EditText)findViewById(R.id.ed0);
        String t=t1.getText().toString();

        Toast t3 = Toast.makeText(MainActivity.this,t , Toast.LENGTH_SHORT);
        t3.show();


        gotodb(t);

    }






    ///// remove comments to enable////
        /*try {
            dbhandler entry = new dbhandler(Customer.this);
            entry.open();
            EditText tu = (EditText) findViewById(R.id.medicine);
            String med = tu.getText().toString();

            String medinfo[] = new String[4];
            medinfo = entry.search(med);

            TextView m1 = (TextView) findViewById(R.id.m1);
            TextView m2 = (TextView) findViewById(R.id.m2);
            TextView m3 = (TextView) findViewById(R.id.m3);
            TextView m4 = (TextView) findViewById(R.id.m4);
            m1.setText(medinfo[0]);
            m2.setText(medinfo[1]);
            m3.setText(medinfo[2]);
            m4.setText(medinfo[3]);
            Toast t = Toast.makeText(Customer.this, medinfo[0], Toast.LENGTH_SHORT);
            t.show();


            entry.close();


        } catch (Exception e) {
            System.out.println(e);
        }
        */





    /////////////// progressDialog shit /////////////////temporary function///////
    private class Fetchresults extends AsyncTask<String,Void,String[]> {

        ProgressDialog mProgressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(MainActivity.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Fetching results!");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected String[] doInBackground(String... name) {

            //String medinfo[];
            String name1 = name[0];
            String movinfo[] = new String[4];

            try {
                Thread.sleep(2000);
                try {

                    dbhandler entry = new dbhandler(MainActivity.this);
                    entry.open();


                    movinfo = entry.search(name1);


                    entry.close();


                } catch (Exception e) {
                    System.out.println("darn, try again.");
                }


            } catch (InterruptedException e) {
                System.out.print(e);
            }
            return movinfo;
        }



        @Override
        protected void onPostExecute(String[] movinfo) {
            // Set the bitmap into ImageView
            mProgressDialog.dismiss();
            Toast t = Toast.makeText(MainActivity.this,movinfo[0], Toast.LENGTH_SHORT);
            t.show();
            Intent i=new Intent(getApplicationContext(),Results.class);
            Bundle extras=new Bundle();
            extras.putString("m_id",movinfo[0]);
            extras.putString("synopsis",movinfo[1]);
            extras.putString("rel_date",movinfo[2]);
            extras.putString("rating",movinfo[3]);
            i.putExtras(extras);
            startActivity(i);



        }
    }

    public void gotodb(String name){
        new Fetchresults().execute(name);
    }
}




