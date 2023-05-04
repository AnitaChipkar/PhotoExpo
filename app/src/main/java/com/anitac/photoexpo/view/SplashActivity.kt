package com.anitac.photoexpo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import com.anitac.photoexpo.R
import com.anitac.photoexpo.dagger.components.ActivityComponent
import com.anitac.photoexpo.databinding.ActivitySplashBinding
import com.anitac.photoexpo.viewmodel.SplashViewModel

class SplashActivity : BaseActivity<SplashViewModel>() {

    var dataBinding: ActivitySplashBinding? = null

    override fun setDataBindingLayout() {
        dataBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_splash)
      //  dataBinding?.viewModel = viewModel
        dataBinding?.lifecycleOwner = this
    }

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            finish()
        }, 1000)
    }
}