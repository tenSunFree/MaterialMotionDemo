package com.home.materialmotiondemo.explore

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.home.materialmotiondemo.databinding.ActivityExploreBinding
import com.home.materialmotiondemo.exploreDetail.ExploreDetailActivity

class ExploreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExploreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        setContentView(binding.root)
        initView()
    }

    private fun initBinding() {
        binding = ActivityExploreBinding.inflate(layoutInflater)
    }

    private fun initView() {
        binding.viewServiceBarService.setOnClickListener {
            jumpExploreDetail(binding.viewServiceBarService, ExploreDetailActivity.DETAIL_SERVICE)
        }
        binding.viewServiceBarBusiness.setOnClickListener {
            jumpExploreDetail(binding.viewServiceBarBusiness, ExploreDetailActivity.DETAIL_BUSINESS)
        }
        binding.view12hBar12h.setOnClickListener {
            jumpExploreDetail(binding.view12hBar12h, ExploreDetailActivity.DETAIL_12H)
        }
        binding.view12hBarChill.setOnClickListener {
            jumpExploreDetail(binding.view12hBarChill, ExploreDetailActivity.DETAIL_CHILL)
        }
    }

    private fun jumpExploreDetail(view: View, detailName: String) {
        val intent = Intent(this@ExploreActivity, ExploreDetailActivity::class.java)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this@ExploreActivity, view, detailName
        )
        intent.putExtra(ExploreDetailActivity.EXTRA, detailName)
        startActivity(intent, options.toBundle())
    }
}