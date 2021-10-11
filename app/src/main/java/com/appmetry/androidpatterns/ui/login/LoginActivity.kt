package com.appmetry.androidpatterns.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.appmetry.androidpatterns.databinding.ActivityLoginBinding
import com.appmetry.androidpatterns.ui.product.ProductActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityLoginBinding
    private val mViewModel: LoginActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initViewModel()
    }

    private fun initViewModel() {
        mBinding.lifecycleOwner = this
        mBinding.viewModel = mViewModel

        attachObservers()
    }

    private fun attachObservers() {
        mViewModel.errorMLD.observe(this) {
            if (it != null) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                mViewModel.errorMLD.value = null
            }
        }

        mViewModel.loginSuccessMLD.observe(this) {
            if (it) {
                startActivity(Intent(this, ProductActivity::class.java))
                finish()
            }
        }
    }
}