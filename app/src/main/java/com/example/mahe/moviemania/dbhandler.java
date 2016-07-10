package com.example.mahe.moviemania;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.sql.SQLException;

import javax.xml.namespace.NamespaceContext;

public class dbhandler {


    public static final String g_id = "g_id";
    public static final String g_name = "g_name";


    public static final String m_id = "m_id";
    public static final String synopsis = "synopsis";
    public static final String rel_date = "rel_date";       //original medicine table attrbutes
    public static final String rating = "rating";


    public static final String a_id = "a_id";
    public static final String a_name = "a_name";       //generic medicine table attrbutes
    public static final String awards = "awards";


    private static final String database = "moviemania";
    private static final String genre = "genre";
    private static final String actor = "actor";
    private static final String movie_actor = "movie_actor";
    private static final String movie = "movie";

    public static final String actor_id = "actor_id";
    public static final String movie_id = "movie_id";

    private static final int version = 1;

    private DBhelper helper;
    private final Context our_context;
    private SQLiteDatabase our_database;


    private static class DBhelper extends SQLiteOpenHelper {
        public DBhelper(Context context) {
            super(context, database, null, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String table1 = "CREATE TABLE " + genre + " (" +
                    g_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    g_name + " TEXT NOT NULL);";


            String table2 = "CREATE TABLE " + movie + " (" +         //EDIT THIS
                    m_id + " TEXT PRIMARY KEY, " +
                    synopsis + " TEXT NOT NULL, " + rating + " INTEGER NOT NULL, " + rel_date + " DATE);";


            String table3 = "CREATE TABLE " + actor + " (" +         //EDIT THIS

                    a_id + " INTEGER PRIMARY KEY NOT NULL, " +
                    a_name + " TEXT NOT NULL, " +
                    awards + " TEXT);";

            String table4 = "CREATE TABLE " + movie_actor + " (" + movie_id + " TEXT NOT NULL, " + actor_id + " INTEGER NOT NULL, " + " PRIMARY KEY (" + actor_id  + " ," +  movie_id + "), " +  " FOREIGN KEY (" + movie_id + ") REFERENCES " + movie + " (" + m_id + "), " + " FOREIGN KEY (" + actor_id + ") REFERENCES " + actor + " (" + a_id + "));";


            db.execSQL(table1);
            // Toast.makeText(dbhandler.this, "table created ", Toast.LENGTH_LONG).show();
            db.execSQL(table2);
            db.execSQL(table3);
            db.execSQL(table4);


            db.execSQL("INSERT INTO " + movie + " VALUES('Deadpool','abc','5','23-03-2016')");
            db.execSQL("INSERT INTO " + movie + " VALUES('Deadpool1','abc','4','24-03-2016')");
            db.execSQL("INSERT INTO " + movie + " VALUES('Deadpool2','abc','3','25-03-2016')");

            //db.execSQL("INSERT INTO "+ med_table + " VALUES('pantop','200','pantaprazole')");


            db.execSQL("INSERT INTO " + genre + " VALUES('1','Romance')");
            db.execSQL("INSERT INTO " + genre + " VALUES('2','Action')");
            db.execSQL("INSERT INTO " + genre + " VALUES('3','Sci-Fi')");
            db.execSQL("INSERT INTO " + genre + " VALUES('4','Comedy')");


            db.execSQL("INSERT INTO " + actor + " VALUES('101','Snehil Verma','Oscar')");
            db.execSQL("INSERT INTO " + actor + " VALUES('102','Harshita Singh','Golden Globe')");
            db.execSQL("INSERT INTO " + actor + " VALUES('103','Salman Khan','null')");
            db.execSQL("INSERT INTO " + actor + " VALUES('104','SRK','null')");


            db.execSQL("INSERT INTO " + movie_actor + " VALUES('Deadpool','1')");
            db.execSQL("INSERT INTO " + movie_actor + " VALUES('Deadpool1','2')");
            db.execSQL("INSERT INTO " + movie_actor + " VALUES('Deadpool2','3')");


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + actor);
            db.execSQL("DROP TABLE IF EXISTS " + genre);
            db.execSQL("DROP TABLE IF EXISTS " + movie);
            db.execSQL("DROP TABLE IF EXISTS " + movie_actor);

            onCreate(db);
        }
    }

    public dbhandler(Context context) {
        our_context = context;
    }

    public dbhandler open() throws SQLException {
        helper = new DBhelper(our_context);
        our_database = helper.getWritableDatabase();
        return this;
    }

    public void close() {
        helper.close();
    }


    public String[] search(String mov) {



        String query = "SELECT " + m_id + "," + synopsis + "," + rel_date + "," + rating + " FROM " + movie + " WHERE " + m_id + "='" + mov + "'";
        Cursor c3 = our_database.rawQuery(query, null);
        String result[] = new String[4];
        int im_id = c3.getColumnIndex(m_id);
        int isynopsis = c3.getColumnIndex(synopsis);
        int irel_date = c3.getColumnIndex(rel_date);
        int irating = c3.getColumnIndex(rating);

        for (c3.moveToFirst(); !c3.isAfterLast(); c3.moveToNext()) {
            result[0] = c3.getString(im_id);
            result[1] = c3.getString(isynopsis);
            result[2] = c3.getString(irel_date);
            result[3] = c3.getString(irating);


        }

        return result;

    }
}
