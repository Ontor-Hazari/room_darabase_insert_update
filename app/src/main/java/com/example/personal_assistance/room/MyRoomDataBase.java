package com.example.personal_assistance.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.personal_assistance.model.ModelImdb;

@Database( entities = ModelImdb.class , version = 1, exportSchema = false)

public  abstract class MyRoomDataBase  extends RoomDatabase {


    private static MyRoomDataBase myRoomDataBase = null;

    public abstract  RoomDao roomDao();

    public static synchronized  MyRoomDataBase getInstance(Context context)
    {
        if(myRoomDataBase==null)
        {
            myRoomDataBase = Room.databaseBuilder(context,MyRoomDataBase.class,"imdb").fallbackToDestructiveMigration().build();
        }

        return myRoomDataBase;
    }




}
