package com.example.bees.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.bees.R
import com.example.bees.data.model.ProductModel
import com.example.bees.databinding.ActivityAddProductBinding
import com.example.bees.viewModel.AddProductViewModel

class AddStoreActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAddProductBinding
    private lateinit var addProdVM: AddProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.imageBack.setOnClickListener(this)
        binding.buttonRegister.setOnClickListener(this)

        addProdVM = ViewModelProvider(this)[AddProductViewModel::class.java]
        setObserver()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.image_back){
            finish()
        } else if (view.id == R.id.button_register) {

            try {
                val p = ProductModel().apply {
                    this.name = binding.editProdName.text.toString()
                    this.prodCode = binding.editProdCode.text.toString()
                    this.amount = binding.editProdAmount.text.toString().toInt()
                    this.price = binding.editProdPrice.text.toString().toFloat()
                }
                if (p.name == "") {
                    Toast.makeText(this, R.string.empty_name_msg, Toast.LENGTH_SHORT).show()
                } else if (p.prodCode == "") {
                    Toast.makeText(this, R.string.empty_prod_code_msg, Toast.LENGTH_SHORT).show()
                } else {
                    addProdVM.saveProduct(p)
                }

            } catch (e: NumberFormatException){
                Toast.makeText(this, R.string.empty_number_msg, Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun clearEdits(){
        binding.editProdName.text.clear()
        binding.editProdCode.text.clear()
        binding.editProdAmount.text.clear()
        binding.editProdPrice.text.clear()
    }

    private fun setObserver(){
        addProdVM.getIsSaved().observe(this) {
            when (it) {
                1 -> {
                    Toast.makeText(this, R.string.success_add, Toast.LENGTH_SHORT).show()
                    clearEdits()
                }
                0 -> {
                    Toast.makeText(this, R.string.fail_add, Toast.LENGTH_SHORT).show()
                }
                2 -> {
                    Toast.makeText(this, R.string.constraint_add, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}