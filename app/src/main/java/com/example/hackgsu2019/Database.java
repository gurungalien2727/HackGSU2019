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
    public static final String DATABASE_NAME="GSU.db";
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
        createQuestions();

    }
    /*
     * Creating a todo
     */
    public long createQuestions() {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_QUESTION_TEXT, "Is It A Cat");
        values.put(KEY_IMAGE_URL, "https://pbs.twimg.com/profile_images/572905100960485376/GK09QnNG.jpeg");
        values.put(KEY_CATEGORY, "Animals");
        // insert row
        db.insert(TABLE_QUESTION, null, values);
        values.put(KEY_QUESTION_TEXT, "Is this a picture of strawberr(ies)?");
        values.put(KEY_IMAGE_URL, "https://upload.wikimedia.org/wikipedia/commons/7/7e/Strawberry_BNC.jpg");
        values.put(KEY_CATEGORY, "Plants");
        // insert row
        long todo_id = db.insert(TABLE_QUESTION, null, values);
        values.put(KEY_QUESTION_TEXT, "Is this a picture of raspberr(ies)?");
        values.put(KEY_IMAGE_URL, "https://cdn.sparkfun.com//assets/parts/1/2/8/2/8/14643-Raspberry_Pi_3_B_-02.jpg");
        values.put(KEY_CATEGORY, "Plants");
        db.insert(TABLE_QUESTION, null, values);
        values.put(KEY_QUESTION_TEXT, "Is this a picture of carrot(s)?");
        values.put(KEY_IMAGE_URL, "https://upload.wikimedia.org/wikipedia/commons/a/a7/Rutabaga%2C_variety_nadmorska.JPG");
        values.put(KEY_CATEGORY, "Plants");
        db.insert(TABLE_QUESTION, null, values);
        values.put(KEY_QUESTION_TEXT, "Is this a picture of strawberr(ies)?");
        values.put(KEY_IMAGE_URL, "https://i0.wp.com/www.healthline.com/hlcmsresource/images/AN_images/blueberries-1296x728-feature.jpg?w=1155&h=1528");
        values.put(KEY_CATEGORY, "Plants");
        db.insert(TABLE_QUESTION, null, values);
        values.put(KEY_QUESTION_TEXT, "Is this a picture of apple(s)");
        values.put(KEY_IMAGE_URL, "https://upload.wikimedia.org/wikipedia/commons/7/7b/Orange-Whole-%26-Split.jpg");
        values.put(KEY_CATEGORY, "Plants");
        db.insert(TABLE_QUESTION, null, values);


        values.put(KEY_QUESTION_TEXT, "Is this a picture of dog(s)?");
        values.put(KEY_IMAGE_URL, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Lion_waiting_in_Namibia.jpg/1200px-Lion_waiting_in_Namibia.jpg");
        values.put(KEY_CATEGORY, "Animals");
        db.insert(TABLE_QUESTION, null, values);
        values.put(KEY_QUESTION_TEXT, "Is this a picture of cheetah(s)?");
        values.put(KEY_IMAGE_URL, "https://kids.nationalgeographic.com/content/dam/kids/photos/animals/Mammals/A-G/cheetah-mom-cubs.ngsversion.1461770750320.adapt.1900.1.jpg");
        values.put(KEY_CATEGORY, "Animals");
        db.insert(TABLE_QUESTION, null, values);
        values.put(KEY_QUESTION_TEXT, "Is this a picture of a cat?");
        values.put(KEY_IMAGE_URL, "https://download.ams.birds.cornell.edu/api/v1/asset/60329071/1800");
        values.put(KEY_CATEGORY, "Animals");
        db.insert(TABLE_QUESTION, null, values);
        values.put(KEY_QUESTION_TEXT, "Is this a picture of a canary?");
        values.put(KEY_IMAGE_URL, "https://animals.sandiegozoo.org/sites/default/files/2016-08/hero_zebra_animals.jpg");
        values.put(KEY_CATEGORY, "Animals");
        db.insert(TABLE_QUESTION, null, values);
        values.put(KEY_QUESTION_TEXT, "Is this a picture of a giraffe?");
        values.put(KEY_IMAGE_URL, "https://animals.sandiegozoo.org/sites/default/files/2016-11/animals_hero_giraffe_1_0.jpg");
        values.put(KEY_CATEGORY, "Animals");
        db.insert(TABLE_QUESTION, null, values);


        values.put(KEY_QUESTION_TEXT, "Is this a picture of a heart?");
        values.put(KEY_IMAGE_URL, "https://upload.wikimedia.org/wikipedia/commons/a/a0/Heart_anterior_exterior_view.jpg");
        values.put(KEY_CATEGORY, "Medical");
        db.insert(TABLE_QUESTION, null, values);
        values.put(KEY_QUESTION_TEXT, "Is this a picture of a heart?");
        values.put(KEY_IMAGE_URL, "https://cdn1.medicalnewstoday.com/content/images/articles/322/322035/diagram-of-the-diaphragm.jpg");
        values.put(KEY_CATEGORY, "Medical");
        db.insert(TABLE_QUESTION, null, values);
        values.put(KEY_QUESTION_TEXT, "Is this a picture of lung(s)?");
        values.put(KEY_IMAGE_URL, "https://d2ebzu6go672f3.cloudfront.net/media/content/images/p4_LungsML0418_gi577938810.jpg");
        values.put(KEY_CATEGORY, "Medical");
        db.insert(TABLE_QUESTION, null, values);
        values.put(KEY_QUESTION_TEXT, "Is this a picture of an arm?");
        values.put(KEY_IMAGE_URL, "https://upload.wikimedia.org/wikipedia/commons/1/1d/Earrr.JPG");
        values.put(KEY_CATEGORY, "Medical");
        db.insert(TABLE_QUESTION, null, values);
        values.put(KEY_QUESTION_TEXT, "Is this a picture of a leg?");
        values.put(KEY_IMAGE_URL, "http://nextluxury.com/wp-content/uploads/mechanical-gear-leg-tattoo-sleeves.jpg");
        values.put(KEY_CATEGORY, "Medical");




        // insert row
        long todo_id1 = db.insert(TABLE_QUESTION, null, values);

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
        String selection= KEY_CATEGORY+ "=?";
        String [] selectionargs={category};

        String selectQuery="Select * From "+TABLE_QUESTION+" where "+KEY_CATEGORY+"="+'"'+category+'"';
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
