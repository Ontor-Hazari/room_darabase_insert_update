package com.example.personal_assistance.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.personal_assistance.model.ModelImdb;

import java.util.List;

@Dao

public interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InserSinglData(ModelImdb imdb);

    @Update
    void UpdateSingleData(ModelImdb imdb);

   /* @Delete
    void DeletesingleData( Integer ints);*/

    @Delete
    void DeletesingleData(ModelImdb imdb);

    @Query("SELECT * FROM info ORDER BY id DESC")
    LiveData<List<ModelImdb>> getAllData();

}
