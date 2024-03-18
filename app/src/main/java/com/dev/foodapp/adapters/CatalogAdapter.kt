package com.dev.foodapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.foodapp.databinding.ItemCatalogBinding
import com.dev.foodapp.data.models.Catalog
import com.dev.foodapp.feature.main.MainActivity
import com.dev.foodapp.utils.toIndonesianFormat

class CatalogAdapter(mainActivity: MainActivity) :
    RecyclerView.Adapter<CatalogAdapter.CatalogViewHolder>() {

    private val data = mutableListOf<Catalog>()
    private var itemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    fun submitData(items: List<Catalog>) {
        data.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        return CatalogViewHolder(
            ItemCatalogBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        val currentItem = data[position]
        holder.bind(currentItem)

        holder.itemView.setOnClickListener {
            itemClickListener?.onItemClick(currentItem)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(catalog: Catalog)
    }

    class CatalogViewHolder(private val binding: ItemCatalogBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Catalog) {
            binding.tvCatalogName.text = item.name
            binding.tvCatalogPrice.text = item.price.toIndonesianFormat()
            binding.ivCatalogImage.setImageResource(item.image)
        }
    }
}