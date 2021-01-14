package com.example.myfirstapp.model;

import android.os.Parcelable;
import android.os.Parcel;
import androidx.room.Entity;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

@Entity(tableName = "RoomResults")
public class DataEntitiy implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "firstOp")
    private String firstThing;
    @ColumnInfo(name = "secondOp")
    private String secondThing;
    @ColumnInfo(name = "result")
    private String resultThing;

    @Override
    public int describeContents() {
        return 0;
    }

    public String getFirstThing(){
        return firstThing;
    }
    public String getSecondThing(){
        return secondThing;
    }
    public String getResultThing(){
        return resultThing;
    }
    public DataEntitiy(String firstThing, String secondThing,String resultThing){
        this.firstThing = firstThing;
        this.secondThing = secondThing;
        this.resultThing = resultThing;
    }
    public String getStringText(){
        String strig;
        strig = String.format("%1s + %2s = %3s", firstThing, secondThing, resultThing);
        return strig;
        //return new String((firstThing + " + " + secondThing + " = " + resultThing));
    }
    public static final Creator<DataEntitiy> CREATOR = new Creator<DataEntitiy>() {
        @Override
        public DataEntitiy createFromParcel(Parcel get) {
            return new DataEntitiy(get);
        }

        @Override
        public DataEntitiy[] newArray(int size) {
            return new DataEntitiy[size];
        }
    };
    protected DataEntitiy(Parcel get){
        firstThing = get.readString();
        secondThing = get.readString();
        resultThing = get.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstThing);
        parcel.writeString(secondThing);
        parcel.writeString(resultThing);
    }
}
