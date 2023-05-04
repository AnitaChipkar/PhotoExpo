package com.anitac.photoexpo.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.anitac.photoexpo.IConstants
import com.anitac.photoexpo.R
import com.anitac.photoexpo.dagger.components.ActivityComponent
import com.anitac.photoexpo.databinding.ActivityDetailsBinding
import com.anitac.photoexpo.viewmodel.DetailsViewModel
import com.squareup.picasso.Picasso

class DetailsActivity : BaseActivity<DetailsViewModel>() {

    companion object {
        fun getStartIntent(mContext: Context, title: String,url: String): Intent {
            return Intent(mContext, DetailsActivity::class.java).apply {
                putExtra(IConstants.IMAGE_TITLE, title)
                putExtra(IConstants.IMAGE_URL, url)
            }
        }
    }
    var dataBinding: ActivityDetailsBinding? = null
    private var imageTitle: String = ""
    private var imageUrl: String = ""
    override fun setDataBindingLayout() {
        dataBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_details)
        dataBinding?.viewModel = viewModel
        dataBinding?.lifecycleOwner = this
    }

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        imageTitle = intent.getStringExtra(IConstants.IMAGE_TITLE).toString()
        imageUrl = intent.getStringExtra(IConstants.IMAGE_URL).toString()
        dataBinding!!.tvImageTitle.text = imageTitle
        Picasso.get().load(imageUrl).into(dataBinding!!.ivImage);

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}