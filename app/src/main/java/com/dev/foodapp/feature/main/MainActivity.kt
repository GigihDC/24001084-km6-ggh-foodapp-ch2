package com.dev.foodapp.feature.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.foodapp.R
import com.dev.foodapp.adapters.CatalogAdapter
import com.dev.foodapp.adapters.CategoryAdapter
import com.dev.foodapp.data.datasource.FoodCategoryDataSource
import com.dev.foodapp.data.datasource.FoodCategoryDataSourceImpl
import com.dev.foodapp.data.datasource.FoodDataSource
import com.dev.foodapp.data.datasource.FoodDataSourceImpl
import com.dev.foodapp.data.models.Catalog
import com.dev.foodapp.data.models.Category
import com.dev.foodapp.databinding.ActivityMainBinding
import com.dev.foodapp.feature.detail.DetailFoodActivity

class MainActivity : AppCompatActivity(), CatalogAdapter.OnItemClickListener {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val dataSourceCatalog: FoodDataSource by lazy { FoodDataSourceImpl() }
    private val dataSourceCategory: FoodCategoryDataSource by lazy { FoodCategoryDataSourceImpl() }
    private val adapterCategory = CategoryAdapter()
    private var adapterCatalog = CatalogAdapter(this)
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
        adapterCatalog.setOnItemClickListener(this)
    }

    override fun onItemClick(catalog: Catalog) {
        val intent = Intent(this, DetailFoodActivity::class.java)
        intent.putExtra("catalog", catalog)
        startActivity(intent)
    }

    private fun setListCategory() {
        binding.rvCategory.apply {
            adapter = this@MainActivity.adapterCategory
        }
        adapterCategory.submitData(dataSourceCategory.getFoodCategory())
    }

    private fun setListCatalog() {
        binding.rvCatalog.apply {
            adapter = this@MainActivity.adapterCatalog
        }
        adapterCatalog.submitData(dataSourceCatalog.getFoodDetail())
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