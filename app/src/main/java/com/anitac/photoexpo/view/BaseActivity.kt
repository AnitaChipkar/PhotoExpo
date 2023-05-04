package com.anitac.photoexpo.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.anitac.photoexpo.AppApplication
import com.anitac.photoexpo.dagger.modules.ActivityModule
import com.anitac.photoexpo.dagger.components.ActivityComponent
import com.anitac.photoexpo.dagger.components.DaggerActivityComponent
import com.anitac.photoexpo.databinding.DialogLoadingBinding
import com.anitac.photoexpo.viewmodel.BaseViewModel
import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: VM
    private var retryAttempt = 0.0
    private var progressDialog: Dialog? = null

    /**
     * @author Anita Chipkar
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        setDataBindingLayout()
        setupObservers()
        setupView(savedInstanceState)
        viewModel.onCreate()
    }

    /**
     * @author Anita Chipkar
     * @return
     */
    private fun buildActivityComponent() =
        DaggerActivityComponent
            .builder()
            .applicationComponent((application as AppApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()

    /**
     * @author Anita Chipkar
     * @return
     */
    fun checkInternet(): Boolean {
        return when {
            isNetworkAvailable() -> true
            else -> {
                //showMessage(getString(R.string.network_connection_error))
                false
            }
        }
    }


    /**
     * @author Anita Chipkar
     */
    protected open fun setupObservers() {
        /*viewModel.messageString.observe(this, Observer {
            it.data?.run {
                hideProgressDialog()
                showMessage(this)
            }
        })

        viewModel.messageStringId.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })*/
    }
    private fun isNetworkAvailable(): Boolean {
        val conMgr = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = conMgr.activeNetworkInfo
        return netInfo != null
    }
    protected abstract fun setDataBindingLayout()

    protected abstract fun injectDependencies(activityComponent: ActivityComponent)

    protected abstract fun setupView(savedInstanceState: Bundle?)

    override fun onResume() {
        super.onResume()
        Log.i(this@BaseActivity::class.java.simpleName, "onResume: ")
    }

    /**
     * @author Anita Chipkar
     * Called Ads function when leaving the activity
     */
    override fun onPause() {
        super.onPause()
        Log.i(this@BaseActivity::class.java.simpleName, "onPause: ")
    }

    /**
     * @author Anita Chipkar
     * Called Ads function before the activity is destroyed
     */
    override fun onDestroy() {
        super.onDestroy()
        Log.i(this@BaseActivity::class.java.simpleName, "onDestroy: ")
    }
    /**
     * @author Anita Chipkar
     * @param isCheckNetwork
     * @param isSetTitle
     * @param title
     */
    fun showProgressDialog(
        isCheckNetwork: Boolean = true,
        isSetTitle: Boolean,
        title: String
    ) {
        if (isCheckNetwork) {
            if (isNetworkAvailable()) {
                if (progressDialog == null) {
                    progressDialog = Dialog(this)
                    val binding: DialogLoadingBinding =
                        DialogLoadingBinding.inflate(LayoutInflater.from(this))
                    progressDialog?.setContentView(binding.root)
                    progressDialog?.setCancelable(false)
                    progressDialog?.window!!.setBackgroundDrawable(
                        ColorDrawable(Color.TRANSPARENT)
                    )

                    when {
                        isSetTitle -> binding.tvTitle.text = title
                    }
                }
                progressDialog?.show()
            }
        } else {
            if (progressDialog == null) {
                progressDialog = Dialog(this)
                val binding: DialogLoadingBinding =
                    DialogLoadingBinding.inflate(LayoutInflater.from(this))
                progressDialog?.setContentView(binding.root)
                progressDialog?.setCancelable(false)
                progressDialog?.window!!.setBackgroundDrawable(
                    ColorDrawable(Color.TRANSPARENT)
                )

                when {
                    isSetTitle -> binding.tvTitle.text = title
                }
            }
            progressDialog?.show()
        }
    }

    /**
     * @author Anita Chipkar
     */
    fun hideProgressDialog() {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog?.dismiss()
            progressDialog = null
        }
    }

}