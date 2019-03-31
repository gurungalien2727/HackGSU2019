package com.example.hackgsu2019;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static android.widget.Toast.*;
import static android.widget.Toast.LENGTH_SHORT;

public class Database extends SQLiteOpenHelper {


    public int userId;
    public static final String DATABASE_NAME="HackGSU19.db";
    public  final String TABLE_NAME="user";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="EMAIL";
    public static final String COL_4="PASSWORD";

    public  static final String TABLE_QUESTION="question";
    public static final String KEY_QUESTION_ID="QUESTIONID";
    public static final String KEY_QUESTION_TEXT="QUESTIONTEXT";
    public static final String KEY_IMAGE_URL="IMAGEURL";
    public static final String KEY_CATEGORY="CATEGORY";

    public static final String TABLE_RESULT="result";
    public static final String KEY_RESULT_ID="RESULT_ID";
    public static final String KEY_LABEL="LABEL";

    private static final String CREATE_TABLE_TODO = "CREATE TABLE "
            + TABLE_QUESTION + "(" + KEY_QUESTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_QUESTION_TEXT
            + " TEXT," + KEY_IMAGE_URL + " TEXT," + KEY_CATEGORY
            + " TEXT" + ")";
    private static final String CREATE_TABLE_TO = "CREATE TABLE "
            + TABLE_RESULT + "(" + KEY_RESULT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_LABEL
            + " INTEGER," + KEY_QUESTION_ID + " INTEGER," + COL_1
            + " INTEGER" + ")";

    public Database(Context context){

        super(context,DATABASE_NAME,null,1);
        SQLiteDatabase db=this.getWritableDatabase();

    }


    public void onCreate(SQLiteDatabase db){

        db.execSQL("create table "+TABLE_NAME+ "(ID INTEGER PRIMARY KEY  AUTOINCREMENT, NAME TEXT, EMAIL TEXT, PASSWORD TEXT)");
        db.execSQL(CREATE_TABLE_TODO);
        db.execSQL(CREATE_TABLE_TO);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_QUESTION);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_RESULT);
        this.onCreate(db);

    }
    /*
     * Creating a todo
     */
    public long createQuestions() {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_QUESTION_TEXT, "Is It A Cat");
        values.put(KEY_IMAGE_URL, "https://pbs.twimg.com/profile_images/572905100960485376/GK09QnNG.jpeg");
        values.put(KEY_CATEGORY, "Animal");




        // insert row
        long todo_id = db.insert(TABLE_QUESTION, null, values);

        return todo_id;
    }
    public long insertResult(int label) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LABEL, label);
        values.put(KEY_QUESTION_ID, 1);
        values.put(COL_1, 1);

        // insert row
        long todo_id = db.insert(TABLE_RESULT, null, values);

        return todo_id;
    }


    public boolean insertData(String name, String email, String password){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(COL_2,name);
        cv.put(COL_3,email);
        cv.put(COL_4,password);

        long num=db.insert(TABLE_NAME,null,cv);

        if(num==-1){
            return false;
        }
        else{
            return true;
        }

    }


    public boolean checkUser(String email, String password){

         SQLiteDatabase db=this.getWritableDatabase();

         String [] column={COL_1};
         String selection= COL_3+"=?"+" and "+COL_4+ "=?";
         String [] selectionargs={email,password};

        Cursor cur=db.query(TABLE_NAME,column,selection,selectionargs,null,null,null);
        if(cur !=null && cur.moveToFirst()){

        }
        int count=cur.getCount();

        cur.close();
        if(count>0){
            return true;
        }
        else
        {
            return false;
        }

    }

    public List<cards> getQuestion(String category){

        SQLiteDatabase db=this.getReadableDatabase();
        String selectQuery="Select * From "+TABLE_QUESTION;
        List<cards> result=new ArrayList<cards>();
        Cursor cur1=db.rawQuery(selectQuery, null);
        if(cur1 !=null && cur1.moveToFirst()) {
            do {
                cards item = new cards();
                item.setQuestion(cur1.getString(1));
                item.setImageId(cur1.getString(2));
                item.setCategory(cur1.getString(3));
                result.add(item);
            } while (cur1.moveToNext());
        }

        return result;

    }


    public Cursor getCursor() {

        SQLiteDatabase db=this.getWritableDatabase();

        Cursor  cur=db.rawQuery("select * from "+ TABLE_NAME, null);
        return cur;

    }
}
