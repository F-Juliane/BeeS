package com.example.bees.data.dao

import androidx.room.*
import com.example.bees.data.model.ProductModel

@Dao
interface ProductDAO {

    @Insert
    fun insert(p: ProductModel): Long

    @Update
    fun update(p: ProductModel): Int

    @Delete
    fun delete(p: ProductModel)

    @Query("SELECT * FROM Product WHERE id = :id")
    fun getById(id: Int): ProductModel

    @Query("SELECT * FROM Product WHERE prod_code = :pd")
    fun getByProdCode(pd: String): ProductModel
}