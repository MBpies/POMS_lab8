package com.example.myfirstapp.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DataAccessObject {
    @Insert
    public void addData(DataEntitiy entry);
    @Query("SELECT * FROM RoomResults")
    public List<DataEntitiy> getAll();

    @Query("DELETE FROM RoomResults")
    public void deleteAll();

    @Query("SELECT * FROM RoomResults WHERE id==:id")
    public List<DataEntitiy> getEntryById(int id);
}
