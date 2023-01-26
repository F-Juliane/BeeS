package com.example.bees.viewModel

import android.app.Application
import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bees.data.model.ProductModel
import com.example.bees.data.room.AppDatabase

class AddProductViewModel(application: Application) : AndroidViewModel(application) {

    private var savedMsg = MutableLiveData<Int>()

    fun getIsSaved(): LiveData<Int> {
        return savedMsg
    }

    fun saveProduct(p: ProductModel){
        val db = AppDatabase.getDatabase(getApplication()).ProductDAO()
        val resp: Long
        try {
            resp = db.insert(p)
            savedMsg.value = if(resp > 0) 1 else 0
        } catch (e: SQLiteConstraintException){
            savedMsg.value = 2
        }

    }
}