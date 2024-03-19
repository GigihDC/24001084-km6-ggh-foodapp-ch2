package com.dev.foodapp.adapters.catalog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dev.foodapp.base.ViewHolderBinder
import com.dev.foodapp.data.models.Catalog
import com.dev.foodapp.databinding.ItemCatalogGridBinding
import com.dev.foodapp.databinding.ItemCatalogListBinding

class CatalogAdapter(
    private val listener: OnItemClickedListener<Catalog>,
    private val listMode: Int = MODE_GRID
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val MODE_LIST = 0
        const val MODE_GRID = 1
    }

    private val asyncDataDiffer =
        AsyncListDiffer<Catalog>(this, object : DiffUtil.ItemCallback<Catalog>() {
            override fun areItemsTheSame(oldItem: Catalog, newItem: Catalog): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Catalog, newItem: Catalog): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        })

    fun submitData(data: List<Catalog>) {
        asyncDataDiffer.submitList(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (listMode == MODE_GRID) {
            val binding = ItemCatalogGridBinding.inflate(inflater, parent, false)
            CatalogGridItem(binding, listener)
        } else {
            val binding = ItemCatalogListBinding.inflate(inflater, parent, false)
            CatalogListItem(binding, listener)
        }
    }

    override fun getItemCount(): Int = asyncDataDiffer.currentList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolderBinder<*>) {
            (holder as ViewHolderBinder<Catalog>).bind(asyncDataDiffer.currentList[position])
        }
    }
}

interface OnItemClickedListener<T> {
    fun onItemClicked(item: T)
}
