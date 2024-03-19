package com.dev.foodapp.adapters.catalog

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.dev.foodapp.base.ViewHolderBinder
import com.dev.foodapp.data.models.Catalog
import com.dev.foodapp.databinding.ItemCatalogListBinding
import com.dev.foodapp.utils.toIndonesianFormat

class CatalogListItem(
    private val binding: ItemCatalogListBinding,
    private val listener: OnItemClickedListener<Catalog>
) : ViewHolder(binding.root), ViewHolderBinder<Catalog> {
    override fun bind(item: Catalog) {
        item.let {
            binding.ivCatalogImage.setImageResource(it.image)
            binding.tvCatalogName.text = it.name
            binding.tvCatalogPrice.text = it.price.toIndonesianFormat()
            itemView.setOnClickListener {
                listener.onItemClicked(item)
            }
        }
    }
}