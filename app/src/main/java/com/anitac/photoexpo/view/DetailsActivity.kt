package com.anitac.photoexpo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.anitac.photoexpo.R
import com.anitac.photoexpo.dagger.components.ActivityComponent
import com.anitac.photoexpo.databinding.ActivityDetailsBinding
import com.anitac.photoexpo.databinding.ActivityHomeBinding
import com.anitac.photoexpo.viewmodel.DetailsViewModel

class DetailsActivity : BaseActivity<DetailsViewModel>() {
    var dataBinding: ActivityDetailsBinding? = null
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
        TODO("Not yet implemented")
    }

}