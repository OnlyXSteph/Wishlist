package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var products : MutableList<Product> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.addBT)

        val productEdit = findViewById<EditText>(R.id.productET)

        val storeEdit = findViewById<EditText>(R.id.storeET)

        val priceEdit = findViewById<EditText>(R.id.priceET)


        val productsRV = findViewById<RecyclerView>(R.id.wishRV) as RecyclerView

        products = ProductFetcher.getWishes()
        val adapter = ProductAdapter(products)
        productsRV.adapter = adapter
        productsRV.layoutManager = LinearLayoutManager(this)


        button.setOnClickListener {
            var productName : String = productEdit.text.toString()
            var productStore : String = storeEdit.text.toString()
            var productPrice : String = priceEdit.text.toString()
            var newProduct = ProductFetcher.addWish(productName, productStore, productPrice.toDouble())
            products = ProductFetcher.getWishes()
            adapter.notifyDataSetChanged()
        }
    }

}
