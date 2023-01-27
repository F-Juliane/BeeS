package com.example.bees.data.dao

import androidx.room.*
import com.example.bees.data.model.StoreModel

@Dao
interface StoreDAO {

    @Insert
    fun insert(store: StoreModel): Long

    @Update
    fun update(store: StoreModel): Int

    @Delete
    fun delete(store: StoreModel)

    @Query("SELECT * FROM Store WHERE id = :id")
    fun getById(id: Int): StoreModel

    @Query("SELECT * FROM Store WHERE store_code = :store")
    fun getByStoreCode(store: String): StoreModel
}