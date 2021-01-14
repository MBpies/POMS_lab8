package com.example.myfirstapp.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

/*DatabaseRoom db = Room.databaseBuilder(getApplicationContext(),
            DatabaseRoom.class, "RoomResults").build();*/
@Database(entities = {DataEntitiy.class},version = 1)
public abstract class DatabaseRoom extends RoomDatabase{
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "local_data";
    private static DatabaseRoom sInstance;
    /*SIDE NOTE: why the heck did i used singletone
    quote from developers.android.com
    Note: If your app runs in a single process, you should follow the singleton design pattern when instantiating an AppDatabase object.
    Each RoomDatabase instance is fairly expensive, and you rarely need access to multiple instances within a single process.

    so heres why
    */
    public static DatabaseRoom getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        DatabaseRoom.class, DatabaseRoom.DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries().addCallback(new Callback() {
                            @Override
                            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                super.onCreate(db);
                            }
                        }).build();
            }
        }
        return sInstance;
    }
    public abstract DataAccessObject dataAccessObject();
}
