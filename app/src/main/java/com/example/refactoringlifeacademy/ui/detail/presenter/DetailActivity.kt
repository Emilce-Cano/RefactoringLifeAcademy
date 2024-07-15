package com.example.refactoringlifeacademy.ui.detail.presenter

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.refactoringlifeacademy.databinding.ActivityDetailBinding
import com.example.refactoringlifeacademy.ui.descriptionFragmen.presenter.DescriptionFragment
import com.example.refactoringlifeacademy.ui.home.presenter.HomeActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firstLoad()
        initLeftBar()
        goToHome()

    }
    private fun firstLoad() {
        binding.ellipseImage.visibility = View.VISIBLE
        loadFragment(ImageFragment())
    }
    private fun initLeftBar() {
        binding.tvImag.setOnClickListener {
            binding.ellipseDescrip.visibility = View.INVISIBLE
            binding.ellipseFinance.visibility = View.INVISIBLE
            binding.ellipseComment.visibility = View.INVISIBLE
            binding.ellipseImage.visibility = View.VISIBLE
            loadFragment(ImageFragment())
        }

        binding.tvDescript.setOnClickListener {
            binding.ellipseFinance.visibility = View.INVISIBLE
            binding.ellipseComment.visibility = View.INVISIBLE
            binding.ellipseImage.visibility = View.INVISIBLE
            binding.ellipseDescrip.visibility = View.VISIBLE
            loadFragment(DescriptionFragment())
        }

        binding.tvFinanc.setOnClickListener {
            binding.ellipseComment.visibility = View.INVISIBLE
            binding.ellipseImage.visibility = View.INVISIBLE
            binding.ellipseDescrip.visibility = View.INVISIBLE
            binding.ellipseFinance.visibility = View.VISIBLE
            loadFragment(FinanceFragment())
        }

        binding.tvComent.setOnClickListener {
            binding.ellipseImage.visibility = View.INVISIBLE
            binding.ellipseDescrip.visibility = View.INVISIBLE
            binding.ellipseFinance.visibility = View.INVISIBLE
            binding.ellipseComment.visibility = View.VISIBLE
            loadFragment(CommentFragment())
        }
    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
    }
    private fun goToHome(){
        binding.arrowLeft1.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
