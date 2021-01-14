package com.example.myfirstapp.viewmodel;

import android.content.Context;

import androidx.room.Room;

import com.example.myfirstapp.model.DataEntitiy;
import com.example.myfirstapp.model.DatabaseRoom;

import java.util.List;

public class DataInterface {
    /*DatabaseRoom db = Room.databaseBuilder(getApplicationContext(),
            DatabaseRoom.class, "RoomResults").build();*/
    public static void addItem(Context context, DataEntitiy newItem){
        //DatabaseRoom db = Room.databaseBuilder(context.getApplicationContext(), DatabaseRoom.class, "RoomResults").build();
        //db.dataAccessObject().addData(newItem);
        DatabaseRoom.getInstance(context).dataAccessObject().addData(newItem);
    }
    public static void deleteAll(Context context){
        //DatabaseRoom db = Room.databaseBuilder(context.getApplicationContext(), DatabaseRoom.class, "RoomResults").build();
        //db.dataAccessObject().deleteAll();
        DatabaseRoom.getInstance(context).dataAccessObject().deleteAll();
    }
    public static String getAllAsString(Context context) {
        //DatabaseRoom db = Room.databaseBuilder(context.getApplicationContext(), DatabaseRoom.class, "RoomResults").build();
        List<DataEntitiy> dataList = DatabaseRoom.getInstance(context).dataAccessObject().getAll();//db.dataAccessObject().getAll();
        StringBuilder resultBuilder = new StringBuilder();
        for(DataEntitiy historyEntry: dataList){
            resultBuilder.append(historyEntry.getStringText()).append("\n");
        }
        return resultBuilder.toString();
    }

    public static List<DataEntitiy> getAllAsList(Context context) {
        //DatabaseRoom db = Room.databaseBuilder(context.getApplicationContext(), DatabaseRoom.class, "RoomResults").build();
        //return db.dataAccessObject().getAll();
        return DatabaseRoom.getInstance(context).dataAccessObject().getAll();
    }
}
