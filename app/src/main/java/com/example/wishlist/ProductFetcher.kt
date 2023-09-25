package com.example.wishlist

class ProductFetcher{
    companion object {
        var wishList : MutableList<Product> = ArrayList()

        fun addWish(name: String, url: String, price: Double) {
            wishList.add(Product(name, url, String.format("%.2f", price)))
        }

        fun getWishes(): MutableList<Product> {
            return wishList
        }
    }

}

