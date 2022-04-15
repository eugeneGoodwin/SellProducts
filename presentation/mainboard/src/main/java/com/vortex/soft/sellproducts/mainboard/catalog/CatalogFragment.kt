package com.vortex.soft.sellproducts.mainboard.catalog

import android.os.Bundle
import android.view.View
import com.vortex.soft.sellproducts.base.presentation.base.BaseFragment
import com.vortex.soft.sellproducts.base.presentation.tool.extentions.hide
import com.vortex.soft.sellproducts.base.presentation.tool.extentions.observeOnce
import com.vortex.soft.sellproducts.base.presentation.tool.extentions.show
import com.vortex.soft.sellproducts.base.presentation.tool.extentions.viewModelInit
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.dto.product.ProductDto
import com.vortex.soft.sellproducts.mainboard.R
import kotlinx.android.synthetic.main.fragment_catalog.*
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class CatalogFragment : BaseFragment(), AndroidScopeComponent {

    override val scope by fragmentScope()

    private val catalogViewModel: CatalogViewModel by viewModel()

    lateinit var catalogAdapter: CatalogAdapter

    override fun layoutId(): Int = R.layout.fragment_catalog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews(view)
        initializeViewModel()
    }

    override fun initializeViews(view: View) {
        catalogAdapter = CatalogAdapter(requireActivity(), {
            catalogViewModel.addToCart(it)
        })
        initializeRecyclerView()
        getProducts()
    }

    private fun getProducts() {
        openPreloader()
        catalogViewModel.getProducts()
    }

    override fun initializeViewModel() {
        viewModelInit(catalogViewModel) {
            observeOnce(productsData, ::handleProducts)
            observeOnce(failureData, ::handleError)
        }
    }


    private fun initializeRecyclerView() {
        with(listProducts) {
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
            adapter = catalogAdapter
        }
    }

    private fun handleProducts(cards: List<ProductDto>?) {
        closePreloader()
        catalogAdapter.productsList = cards?.toMutableList() ?: mutableListOf()
    }

    private fun handleError(fail: FailureType?) { closePreloader() }

    override fun openPreloader() {
        preloaderLayout.show()
        mainLayout.hide()
    }

    override fun closePreloader() {
        preloaderLayout.hide()
        mainLayout.show()
    }
}