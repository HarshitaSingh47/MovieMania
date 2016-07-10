package com.example.mahe.moviemania;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by MAHE on 4/9/2016.
 */
public class TopSectionFragment extends Fragment {



    @Nullable

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.top_fargment, container, false);
        return view;
    }




    //////////////////delete this shit////////////////
    /*
    public void searchmovie (View view)
    {

        EditText t1=(EditText)getActivity().findViewById(R.id.ed0);
        String t=t1.toString();
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






    /////////////// progressDialog shit /////////////////temporary function///////
    private class Fetchresults extends AsyncTask<String,Void,String[]> {

        ProgressDialog mProgressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(getActivity());
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

                    dbhandler entry = new dbhandler(getActivity());
                    entry.open();


                    movinfo = entry.search(name1);


                    entry.close();


                } catch (Exception e) {
                    System.out.println(e);
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
            Intent i=new Intent(getActivity(),Results.class);
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
    }*/
}
