package com.example.marcado_baloncesto.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.marcado_baloncesto.R
import com.example.marcado_baloncesto.ScoreActivity
import com.example.marcado_baloncesto.databinding.ActivityMainBinding
import com.example.marcado_baloncesto.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    // 2 - Creamos variable global con lateinit
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel.localScore.observe(this, Observer {
            localScoreValue ->
            binding.localScoreText.text = localScoreValue.toString()
        })
        viewModel.visitorScore.observe(this, Observer {
                visitorScoreValue ->
            binding.visitorScoreText.text = visitorScoreValue.toString()
        })


        setupButtons()
    }

    private fun setupButtons() {
        binding.localMinusButton.setOnClickListener {
            viewModel.decreaseLocalScore()
        }

        binding.localPlusButton.setOnClickListener {
            viewModel.addPointsToScore(1, isLocal = true)
        }

        binding.localTwoPointsButton.setOnClickListener {
            viewModel.addPointsToScore(2, isLocal = true)
        }

        binding.visitorMinusButton.setOnClickListener {
            viewModel.decreaseVisitorScore()
        }

        binding.visitorPlusButton.setOnClickListener {
            viewModel.addPointsToScore(1, isLocal = false)
        }

        binding.visitorTwoPointsButton.setOnClickListener {
            viewModel.addPointsToScore(2, isLocal = false)
        }

        binding.restartButton.setOnClickListener {
            viewModel.resetScores()
        }

        binding.resultsButton.setOnClickListener {
            startScoreActivity()
        }
    }



    private fun startScoreActivity() {
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra(ScoreActivity.LOCAL_SCORE_KEY, viewModel.localScore.value)
        intent.putExtra(ScoreActivity.VISITOR_SCORE_KEY, viewModel.visitorScore.value)
        startActivity(intent)
    }
}