package com.example.auction.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.auction.DAO.ItemDAO;
import com.example.auction.DAO.UserDAO;
import com.example.auction.model.Category;
import com.example.auction.model.Item;

@Database(entities = (Item.class), version = 1)
public abstract class ItemDatabase extends RoomDatabase {
    private static final String DB_NAME = "Auction_APP.sqlite";
    private static UserDatabase instance;

    public static synchronized UserDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, DB_NAME)
                    .allowMainThreadQueries().build();
        }
        return instance;
    }

    public abstract ItemDAO itemDAO();
}
