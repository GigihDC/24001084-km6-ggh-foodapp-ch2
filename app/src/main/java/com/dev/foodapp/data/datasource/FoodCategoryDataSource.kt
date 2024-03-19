package com.dev.foodapp.data.datasource

import com.dev.foodapp.R
import com.dev.foodapp.data.models.Category

interface FoodCategoryDataSource {
    fun getFoodCategory(): List<Category>
}

class FoodCategoryDataSourceImpl() : FoodCategoryDataSource {
    override fun getFoodCategory(): List<Category> {
        return mutableListOf(
            Category(image = R.drawable.img_rice, name = "Nasi"),
            Category(image = R.drawable.img_mie, name = "Mie"),
            Category(image = R.drawable.img_meatball, name = "Bakso"),
            Category(image = R.drawable.img_seafood, name = "Seafood"),
            Category(image = R.drawable.img_snack, name = "Snack"),
            Category(image = R.drawable.img_drink, name = "Minuman"),
            Category(image = R.drawable.img_ice_cream, name = "Ice Cream")
        )
    }
}