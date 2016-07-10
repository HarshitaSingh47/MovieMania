package com.example.mahe.moviemania;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;


public class CustomAdapter extends ArrayAdapter<String> {                  //we are creating a custom array adapter.

    private final Context context;                                      //CREATING A REFERENCE TO ALL THE TEXT,IMAGE ARRAYS AND CONTEXT.
    private final String[] Movies;
    private final Integer[] images;


    public CustomAdapter(Context context, String[] Movies,Integer[] images) {
        super(context,R.layout.custom_row ,Movies);                        //VERY IMPORTANT STUFF.
        this.Movies=Movies;
        this.images=images;
        this.context=context;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layout=LayoutInflater.from(getContext());                //housekeeping stuff
        View customview=layout.inflate(R.layout.custom_row, parent, false);      //refe. to the custom row file.

        /////we need four things( the cars_array element,the images_array element,the reference to the image and refe. to the text view in custom row/////



        TextView view=(TextView)customview.findViewById(R.id.rowtext);
        ImageView image=(ImageView)customview.findViewById(R.id.image);

        view.setText(Movies[position]);                               //  SETTING THE TEXTVIEW TO THE CORRESPONDING ARRAY ELEMENT.
        image.setImageResource(images[position]);                   //SETTING THE IMAGEVIEW TO THE CORRESPONDING IMAGE.
        return customview;

    }
}
