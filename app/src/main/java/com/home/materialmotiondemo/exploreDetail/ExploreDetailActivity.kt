package com.home.materialmotiondemo.exploreDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import com.home.materialmotiondemo.R
import com.home.materialmotiondemo.databinding.ActivityExploreDetailBinding

class ExploreDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA = "detailName"
        const val DETAIL_SERVICE = "DETAIL_SERVICE"
        const val DETAIL_BUSINESS = "DETAIL_BUSINESS"
        const val DETAIL_12H = "DETAIL_12H"
        const val DETAIL_CHILL = "DETAIL_CHILL"
    }

    private lateinit var binding: ActivityExploreDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        setContentView(binding.root)
    }

    private fun initBinding() {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        binding = ActivityExploreDetailBinding.inflate(layoutInflater)
        val detailName = intent.getStringExtra(EXTRA)
        binding.bean = initBean(detailName)
        binding.imageView.transitionName = detailName
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementEnterTransition = buildContainerTransform()
        window.sharedElementReturnTransition = buildContainerTransform()
    }

    private fun initBean(detailName: String?): ExploreDetailBean = when (detailName) {
        DETAIL_SERVICE -> ExploreDetailBean(R.drawable.icon_explore_detail_service)
        DETAIL_BUSINESS -> ExploreDetailBean(R.drawable.icon_explore_detail_business)
        DETAIL_12H -> ExploreDetailBean(R.drawable.icon_explore_detail_12h)
        DETAIL_CHILL -> ExploreDetailBean(R.drawable.icon_explore_detail_chill)
        else -> ExploreDetailBean()
    }

    private fun buildContainerTransform() =
        MaterialContainerTransform().apply {
            addTarget(binding.imageView)
            duration = 500
            interpolator = FastOutSlowInInterpolator()
            fadeMode = MaterialContainerTransform.FADE_MODE_IN
        }
}