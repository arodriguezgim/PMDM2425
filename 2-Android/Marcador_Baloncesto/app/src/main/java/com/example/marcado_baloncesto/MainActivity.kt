package com.example.marcado_baloncesto

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.marcado_baloncesto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var localScore = 0
    private var visitorScore = 0
    private lateinit var binding: ActivityMainBinding


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

        setupButtons()
    }

    private fun setupButtons() {
        binding.localMinusButton.setOnClickListener {
            if (localScore > 0) {
                localScore--
                binding.localScoreText.text = localScore.toString()
            }
        }

        binding.localPlusButton.setOnClickListener {
            addPointsToScore(1, isLocal = true)
        }

        binding.localTwoPointsButton.setOnClickListener {
            addPointsToScore(2, isLocal = true)
        }

        binding.visitorMinusButton.setOnClickListener {
            if (visitorScore > 0) {
                visitorScore--
                binding.visitorScoreText.text = visitorScore.toString()
            }
        }

        binding.visitorPlusButton.setOnClickListener {
            addPointsToScore(1, isLocal = false)
        }

        binding.visitorTwoPointsButton.setOnClickListener {
            addPointsToScore(2, isLocal = false)
        }

        binding.restartButton.setOnClickListener {
            resetScores()
        }

        binding.resultsButton.setOnClickListener {
            startScoreActivity()
        }
    }

    private fun resetScores() {
        localScore = 0
        visitorScore = 0
        binding.visitorScoreText.text = localScore.toString()
        binding.localScoreText.text = visitorScore.toString()
    }

    private fun addPointsToScore(points: Int, isLocal: Boolean) {
        if (isLocal) {
            localScore += points
            binding.localScoreText.text = localScore.toString()
        } else {
            visitorScore += points
            binding.visitorScoreText.text = visitorScore.toString()
        }
    }

    private fun startScoreActivity() {
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra(ScoreActivity.LOCAL_SCORE_KEY, localScore)
        intent.putExtra(ScoreActivity.VISITOR_SCORE_KEY, visitorScore)
        startActivity(intent)
    }
}