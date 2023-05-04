package com.anitac.photoexpo.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.anitac.photoexpo.ImageList
import com.anitac.photoexpo.R
import com.anitac.photoexpo.dagger.components.ActivityComponent
import com.anitac.photoexpo.databinding.ActivityHomeBinding
import com.anitac.photoexpo.viewmodel.HomeViewModel

class HomeActivity : BaseActivity<HomeViewModel>(),RecyclerViewActionListener {
    var dataBinding: ActivityHomeBinding? = null
    private var mAdapter: ImageListAdapter? = null
    private var imageList = ArrayList<ImageList>()
    override fun setDataBindingLayout() {
        dataBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_home)
        dataBinding?.viewModel = viewModel
        dataBinding?.lifecycleOwner = this
    }

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
        mAdapter = ImageListAdapter(this, this)
        callImageList()
        dataBinding!!.spImageList.setColorScheme(R.color.black,
            R.color.purple_200, R.color.teal_200, R.color.white);
        dataBinding!!.spImageList.setOnRefreshListener {
            imageList.clear()
            callImageList()
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun initImageRecyclerview(imageList: ArrayList<ImageList>) {
        mAdapter = ImageListAdapter(this, this)
        dataBinding!!.rcvPhotoList.setHasFixedSize(true)
        dataBinding!!.rcvPhotoList.adapter = mAdapter
        if (imageList.size != 0) {
            mAdapter?.addAllItem(imageList)

        }

        mAdapter!!.notifyDataSetChanged()

    }
    private fun callImageList()
    {
        if (checkInternet()) {
            showProgressDialog(
                isCheckNetwork = true,
                isSetTitle = true,
                title = ""
            )
            viewModel.callGetImageList()
        }
    }
    override fun setupObservers() {
        super.setupObservers()
        viewModel.imageListLiveData.observe(this, Observer { it ->
            hideProgressDialog()
            if (it.size != 0) {
                imageList = it
                dataBinding!!.spImageList.isRefreshing = false
                initImageRecyclerview(imageList)
            }
        })
    }
    override fun onItemClick(viewId: Int, position: Int, childPosition: Int?) {
        TODO("Not yet implemented")
    }

    override fun onLoadMore(itemCount: Int, nextPage: Int) {
        TODO("Not yet implemented")
    }


}