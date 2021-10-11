package com.appmetry.androidpatterns.ui.product.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.appmetry.androidpatterns.databinding.ProductListFragmentBinding
import com.appmetry.androidpatterns.models.ProductModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment(), ProductListInterface {

    private lateinit var mBinding: ProductListFragmentBinding
    private val mViewModel: ProductListViewModel by viewModels()
    private lateinit var mAdapter: ProductListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding = ProductListFragmentBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.lifecycleOwner = viewLifecycleOwner
        mBinding.viewModel = mViewModel

        initViews()

        attachObservers()
    }

    private fun attachObservers() {
        mViewModel.productListMLD.observe(viewLifecycleOwner) {
            if (it != null) {
                mAdapter.setProducts(it)
            }
        }

        mViewModel.errorMLD.observe(viewLifecycleOwner) {
            if (it != null) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                mViewModel.errorMLD.value = null
            }
        }
    }

    private fun initViews() {
        mAdapter = ProductListAdapter(this)
        mBinding.productListRv.adapter = mAdapter
    }

    override fun onProductSelected(product: ProductModel) {
        findNavController().navigate(ProductListFragmentDirections.actionProductListFragmentToProductDetailFragment(
            product))
    }
}