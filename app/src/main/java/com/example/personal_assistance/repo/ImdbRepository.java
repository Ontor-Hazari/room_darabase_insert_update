package com.example.personal_assistance.repo;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import com.example.personal_assistance.model.ModelImdb;
import com.example.personal_assistance.room.MyRoomDataBase;
import com.example.personal_assistance.room.RoomDao;

import java.util.List;

public class ImdbRepository {

    private RoomDao roomDao;
    private MyRoomDataBase myRoomDataBase;
    private LiveData<List<ModelImdb>> allData;
    private Context context;

    public ImdbRepository(Context context) {

        this.context = context;

        myRoomDataBase = MyRoomDataBase.getInstance(context);
        roomDao = myRoomDataBase.roomDao();
        allData = roomDao.getAllData();

    }

    public LiveData<List<ModelImdb>> getAllData() {
        return this.allData;
    }

    public void UpdateSingleData(ModelImdb imdb)
    {
        new  UpdateSingleData(roomDao).execute(imdb);
    }


  public void  DeleteSingleData(ModelImdb imdb)
  {
      new DeleteSingleData(roomDao).execute(imdb);
  }


    public void InsertSingleData(ModelImdb imdb) {
        new InsertData(roomDao).execute(imdb);
    }


    public class InsertData extends AsyncTask<ModelImdb, Void, Void> {
        RoomDao roomDao;

        public InsertData(RoomDao roomDao) {
            this.roomDao = roomDao;
        }

        @Override
        protected Void doInBackground(ModelImdb... modelImdbs) {

            roomDao.InserSinglData(modelImdbs[0]);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(context, "Insert SuccesFully", Toast.LENGTH_LONG).show();
        }

    }

    private class DeleteSingleData extends AsyncTask<ModelImdb,Void,Void>{

        RoomDao roomDao;

        public DeleteSingleData(RoomDao roomDao) {

             this.roomDao = roomDao;
        }


        @Override
        protected Void doInBackground(ModelImdb... modelImdbs) {

                      roomDao.DeletesingleData(modelImdbs[0]);
            return null;
        }
    }

    private class UpdateSingleData extends AsyncTask<ModelImdb,Void,Void>{
        RoomDao roomDao;

        public UpdateSingleData(RoomDao roomDao) {
            this.roomDao = roomDao;
        }

        @Override
        protected Void doInBackground(ModelImdb... modelImdbs) {

              roomDao.UpdateSingleData(modelImdbs[0]);
            return null;
        }
    }
}