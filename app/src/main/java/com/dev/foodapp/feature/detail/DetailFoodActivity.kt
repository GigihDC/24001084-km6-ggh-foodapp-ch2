package com.dev.foodapp.feature.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dev.foodapp.data.models.Catalog
import com.dev.foodapp.databinding.ActivityDetailFoodBinding
import com.dev.foodapp.utils.toIndonesianFormat

class DetailFoodActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailFoodBinding
    private lateinit var catalog: Catalog
    private lateinit var countNumberTextView: TextView
    private lateinit var priceTextView: TextView
    private lateinit var plusButton: ImageButton
    private lateinit var minusButton: ImageButton
    private var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        catalog = intent.getParcelableExtra<Catalog>("catalog") ?: return

        binding.svDetailFood.layoutDetail.tvCatalogName.text = catalog.name
        binding.svDetailFood.layoutDetail.tvCatalogPrice.text = catalog.price.toIndonesianFormat()
        binding.svDetailFood.ivCatalogImage.setImageResource(catalog.image)
        binding.svDetailFood.layoutDetail.tvCatalogDesc.text = catalog.description

        binding.ibBack.setOnClickListener {
            onBackPressed()
        }

        binding.svDetailFood.layoutLocation.cardLocation.setOnClickListener {
            openLocationOnMaps()
        }

        initializeViews()

        countNumberTextView.text = count.toString()
        priceTextView.text = (catalog.price * count).toIndonesianFormat()

        plusButton.setOnClickListener {
            increaseCount()
        }

        minusButton.setOnClickListener {
            decreaseCount()
        }
    }

    private fun openLocationOnMaps() {
        val uri = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        intent.setPackage("com.google.android.apps.maps")
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            intent.setPackage(null)
            startActivity(intent)
        }
    }

    private fun initializeViews() {
        countNumberTextView = binding.layoutCart.tvCountNumber
        priceTextView = binding.layoutCart.tvCatalogPriceCount
        plusButton = binding.layoutCart.btnPlus
        minusButton = binding.layoutCart.btnMinus
    }

    private fun increaseCount() {
        count++
        updateCountAndPrice()
    }

    private fun decreaseCount() {
        if (count > 1) {
            count--
            updateCountAndPrice()
        }
    }

    private fun updateCountAndPrice() {
        countNumberTextView.text = count.toString()
        priceTextView.text = (catalog.price * count).toIndonesianFormat()
    }
}