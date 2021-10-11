package com.appmetry.androidpatterns.ui.product.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appmetry.androidpatterns.databinding.ViewProductListItemBinding
import com.appmetry.androidpatterns.models.ProductModel
import com.appmetry.androidpatterns.utils.extensions.clear
import com.appmetry.androidpatterns.utils.extensions.setImage

class ProductListAdapter(private val listener: ProductListInterface) :
    RecyclerView.Adapter<ProductListAdapter.ProductItemViewHolder>() {

    private val mProductList = arrayListOf<ProductModel>()

    inner class ProductItemViewHolder(private val binding: ViewProductListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val data = mProductList[position]
            binding.root.setOnClickListener {
                listener.onProductSelected(data)
            }

            binding.titleTv.text = data.title
            binding.descriptionTv.text = data.description

            binding.image.setImage(data.image)
        }

        fun unBind() {
            binding.image.clear()
        }
    }

    override fun onViewRecycled(holder: ProductItemViewHolder) {
        super.onViewRecycled(holder)
        holder.unBind()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        val binding =
            ViewProductListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return mProductList.size
    }

    fun setProducts(products: ArrayList<ProductModel>) {
        mProductList.clear()
        mProductList.addAll(products)
        notifyDataSetChanged()
    }
}