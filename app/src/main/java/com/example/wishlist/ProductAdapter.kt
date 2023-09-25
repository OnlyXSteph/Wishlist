package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val wishList: List <Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productTextView: TextView
        val siteTextView: TextView
        val priceTextView: TextView

        init {
            productTextView = itemView.findViewById(R.id.productTV)
            siteTextView = itemView.findViewById(R.id.storeTV)
            priceTextView = itemView.findViewById(R.id.priceTV)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.wish_item, parent, false)
        return ViewHolder(contactView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = wishList.get(position)

        holder.productTextView.text = product.name
        holder.siteTextView.text = product.url
        holder.priceTextView.text = product.price
    }

    override fun getItemCount(): Int {
        return wishList.size
    }

}