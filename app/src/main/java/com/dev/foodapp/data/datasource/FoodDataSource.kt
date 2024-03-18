package com.dev.foodapp.data.datasource

import com.dev.foodapp.R
import com.dev.foodapp.data.models.Catalog

interface FoodDataSource {
    fun getFoodDetail(): List<Catalog>
}

class FoodDataSourceImpl() : FoodDataSource {
    override fun getFoodDetail(): List<Catalog> {
        return mutableListOf(
            Catalog(
                image = R.drawable.img_honey_grilled_chicken,
                name = "Lalapan Ayam Bakar Madu",
                price = 25000.0
            ),
            Catalog(
                image = R.drawable.img_fried_chicken,
                name = "Lalapan Ayam Goreng",
                price = 23000.0
            ),
            Catalog(
                image = R.drawable.img_ayam_geprek,
                name = "Lalapan Ayam Geprek",
                price = 23000.0
            ),
            Catalog(
                image = R.drawable.img_vegetable_meatballs,
                name = "Bakso Sayur",
                price = 12000.0
            ),
            Catalog(
                image = R.drawable.img_bakso_beranak,
                name = "Bakso Beranak",
                price = 20000.0
            ),
            Catalog(
                image = R.drawable.img_cwie_mie,
                name = "Cwie Mie",
                price = 8000.0
            ),
            Catalog(image = R.drawable.img_mie_gacoan,
                name = "Mie Gacoan",
                price = 13000.0),
            Catalog(
                image = R.drawable.img_dimsum,
                name = "Dimsum",
                price = 12000.0),
            Catalog(
                image = R.drawable.img_fried_fries,
                name = "Kentang Goreng",
                price = 10000.0),
            Catalog(
                image = R.drawable.img_sweet_and_sour_prawns,
                name = "Udang Asam Manis",
                price = 40000.0
            ),
            Catalog(
                image = R.drawable.img_sweet_and_sour_squid,
                name = "Cumi Asam Manis",
                price = 40000.0
            ),
            Catalog(
                image = R.drawable.img_drink,
                name = "Jus Buah",
                price = 10000.0),
            Catalog(
                image = R.drawable.img_smooth_ice,
                name = "Smooth Ice (All Variant)",
                price = 15000.0
            ),
            Catalog(image = R.drawable.img_ice_cream, name = "Ice Cream", price = 10000.0)
        )
    }
}