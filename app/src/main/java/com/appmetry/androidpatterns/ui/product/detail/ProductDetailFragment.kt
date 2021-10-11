package com.appmetry.androidpatterns.ui.product.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.appmetry.androidpatterns.R
import com.appmetry.androidpatterns.databinding.ProductDetailFragmentBinding

class ProductDetailFragment : Fragment() {

    private lateinit var mBinding : ProductDetailFragmentBinding
    private val mViewModel: ProductDetailViewModel by viewModels()
    private val mArgs : ProductDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding = ProductDetailFragmentBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.lifecycleOwner = viewLifecycleOwner
        mBinding.viewModel = mViewModel

        if (mViewModel.productDetail.value == null){
            mViewModel.productDetail.value = mArgs.productDetail
        }

    }
}