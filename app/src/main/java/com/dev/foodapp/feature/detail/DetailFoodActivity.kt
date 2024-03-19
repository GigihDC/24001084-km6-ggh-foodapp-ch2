package com.dev.foodapp.feature.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dev.foodapp.data.models.Catalog
import com.dev.foodapp.databinding.ActivityDetailFoodBinding
import com.dev.foodapp.utils.toIndonesianFormat

class DetailFoodActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val catalog = intent.getParcelableExtra<Catalog>("catalog")
        catalog?.let {
            binding.svDetailFood.layoutDetail.tvCatalogName.text = it.name
            binding.svDetailFood.layoutDetail.tvCatalogPrice.text = it.price.toIndonesianFormat()
            binding.svDetailFood.ivCatalogImage.setImageResource(it.image)
        }
    }
}