package com.dev.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.foodapp.adapters.CatalogAdapter
import com.dev.foodapp.adapters.CategoryAdapter
import com.dev.foodapp.databinding.ActivityMainBinding
import com.dev.foodapp.models.Catalog
import com.dev.foodapp.models.Category

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val adapterCategory = CategoryAdapter()
    private val adapterCatalog = CatalogAdapter()
    private var isGridLayout = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListCategory()
        setListCatalog()
        binding.ivListSwitch.setOnClickListener {
            isGridLayout = !isGridLayout
            toggleLayout(isGridLayout)
        }
    }

    private fun setListCategory() {
        val dataCategory = listOf(
            Category(image = R.drawable.img_rice, name = "Nasi"),
            Category(image = R.drawable.img_mie, name = "Mie"),
            Category(image = R.drawable.img_meatball, name = "Bakso"),
            Category(image = R.drawable.img_seafood, name = "Seafood"),
            Category(image = R.drawable.img_snack, name = "Snack"),
            Category(image = R.drawable.img_drink, name = "Minuman"),
            Category(image = R.drawable.img_ice_cream, name = "Ice Cream")
        )
        binding.rvCategory.apply {
            adapter = this@MainActivity.adapterCategory
        }
        adapterCategory.submitData(dataCategory)
    }

    private fun setListCatalog() {
        val dataCatalog = listOf(
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
            Catalog(image = R.drawable.img_bakso_beranak, name = "Bakso Beranak", price = 20000.0),
            Catalog(image = R.drawable.img_cwie_mie, name = "Cwie Mie", price = 8000.0),
            Catalog(image = R.drawable.img_mie_gacoan, name = "Mie Gacoan", price = 13000.0),
            Catalog(image = R.drawable.img_dimsum, name = "Dimsum", price = 12000.0),
            Catalog(image = R.drawable.img_fried_fries, name = "Kentang Goreng", price = 10000.0),
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
            Catalog(image = R.drawable.img_drink, name = "Jus Buah", price = 10000.0),
            Catalog(
                image = R.drawable.img_smooth_ice,
                name = "Smooth Ice (All Variant)",
                price = 15000.0
            ),
            Catalog(image = R.drawable.img_ice_cream, name = "Ice Cream", price = 10000.0)
        )
        binding.rvCatalog.apply {
            adapter = this@MainActivity.adapterCatalog
        }
        adapterCatalog.submitData(dataCatalog)
    }

    private fun toggleLayout(isGridLayout: Boolean) {
        val layoutManager = if (isGridLayout) {
            GridLayoutManager(this, 2)
        } else {
            LinearLayoutManager(this)
        }

        binding.rvCatalog.layoutManager = layoutManager
        adapterCatalog.notifyDataSetChanged()
    }
}