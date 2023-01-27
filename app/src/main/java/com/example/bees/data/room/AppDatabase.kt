package com.example.bees.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bees.data.dao.ProductDAO
import com.example.bees.data.dao.StoreDAO
import com.example.bees.data.model.ProductModel
import com.example.bees.data.model.StoreModel

@Database(entities = [ProductModel::class, StoreModel::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun ProductDAO(): ProductDAO
    abstract fun StoreDAO() : StoreDAO

    companion object {
        private lateinit var INSTANCE: AppDatabase
        fun getDatabase(context: Context): AppDatabase {

            if(!::INSTANCE.isInitialized) {

                synchronized(AppDatabase::class) {

                    INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "bees-database.db")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}