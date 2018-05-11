package com.irmansyah.catalogmoviekotlin.ui.base

import android.app.ProgressDialog
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel<*>> : AppCompatActivity(), BaseFragment.Callback {

    private var progressDialog: ProgressDialog? = null

    private var viewDataBinding: T? = null
    private var mViewModel: V? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDI()
        performDataBinding()
    }

    private fun performDataBinding() {
        this.viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        this.mViewModel = if (mViewModel == null) getViewModel() else mViewModel
        this.viewDataBinding?.setVariable(getBindingVariable(), mViewModel)
        this.viewDataBinding?.executePendingBindings()
    }

//    override fun showProgress() {
//        hideProgress()
//        progressDialog = CommonUtil.showLoadingDialog(this)
//    }
//
//    override fun hideProgress() {
//        progressDialog?.let { if (it.isShowing) it.cancel() }
//    }

    fun getViewDataBinding(): T? = viewDataBinding

    abstract fun getViewModel(): V

    abstract fun getBindingVariable(): Int

    @LayoutRes
    abstract fun getLayoutId(): Int

    private fun performDI() = AndroidInjection.inject(this)
}