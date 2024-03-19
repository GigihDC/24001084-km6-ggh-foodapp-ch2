package com.dev.foodapp.feature.menu.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.dev.foodapp.R
import com.dev.foodapp.adapters.catalog.CatalogAdapter
import com.dev.foodapp.adapters.catalog.OnItemClickedListener
import com.dev.foodapp.adapters.category.CategoryAdapter
import com.dev.foodapp.data.datasource.FoodCategoryDataSource
import com.dev.foodapp.data.datasource.FoodCategoryDataSourceImpl
import com.dev.foodapp.data.datasource.FoodDataSource
import com.dev.foodapp.data.datasource.FoodDataSourceImpl
import com.dev.foodapp.data.models.Catalog
import com.dev.foodapp.databinding.FragmentHomeBinding
import com.dev.foodapp.feature.detail.DetailFoodActivity

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val dataSourceCatalog: FoodDataSource = FoodDataSourceImpl()
    private val dataSourceCategory: FoodCategoryDataSource = FoodCategoryDataSourceImpl()
    private val adapterCategory = CategoryAdapter()
    private var adapterCatalog: CatalogAdapter? = null
    private var isGridLayout = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListCategory()
        setListCatalog()
        setClickAction()
    }

    private fun setClickAction() {
        binding.ivListSwitch.setOnClickListener {
            isGridLayout = !isGridLayout
            setButtonIcon(isGridLayout)
            bindCatalogList(isGridLayout)
        }
    }

    private fun setButtonIcon(usingGridMode: Boolean) {
        val iconResChange = if (usingGridMode) {
            R.drawable.ic_list
        } else {
            R.drawable.ic_grid
        }
        binding.ivListSwitch.setImageResource(iconResChange)
    }

    private fun onItemClick(catalog: Catalog) {
        val intent = Intent(requireContext(), DetailFoodActivity::class.java)
        intent.putExtra("catalog", catalog)
        startActivity(intent)
    }

    private fun setListCategory() {
        binding.rvCategory.adapter = adapterCategory
        adapterCategory.submitData(dataSourceCategory.getFoodCategory())
    }

    private fun setListCatalog() {
        binding.rvCatalog.adapter = adapterCatalog
        bindCatalogList(isGridLayout)
        adapterCatalog?.submitData(dataSourceCatalog.getFoodDetail())
    }

    private fun bindCatalogList(isGridLayout: Boolean) {
        val listMode = if (isGridLayout) CatalogAdapter.MODE_GRID else CatalogAdapter.MODE_LIST
        adapterCatalog =
            CatalogAdapter(listMode = listMode, listener = object : OnItemClickedListener<Catalog> {
                override fun onItemClicked(item: Catalog) {
                    onItemClick(item)
                }
            })
        binding.rvCatalog.apply {
            adapter = this@HomeFragment.adapterCatalog
            layoutManager = GridLayoutManager(requireContext(), if (isGridLayout) 2 else 1)
        }
        adapterCatalog?.submitData(dataSourceCatalog.getFoodDetail())
    }
}
