package com.example.marcado_baloncesto

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.marcado_baloncesto.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {

    companion object {
        const val LOCAL_SCORE_KEY = "local_score"
        const val VISITOR_SCORE_KEY = "visitor_score"
    }
    private lateinit var binding: ActivityScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val localScore = intent.extras!!.getInt(LOCAL_SCORE_KEY)
        val visitorScore = intent.extras!!.getInt(VISITOR_SCORE_KEY)

        binding.scoreText.text = getString(R.string.local_visitor_score_format, localScore,
            visitorScore)

        when {
            localScore > visitorScore -> binding.whoWonText.text = getString(R.string.local_won)
            visitorScore > localScore -> binding.whoWonText.text = getString(R.string.visitor_won)
            else -> binding.whoWonText.text = getString(R.string.it_was_a_tie)
        }
    }
}