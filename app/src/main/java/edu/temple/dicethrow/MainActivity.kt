package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var dieViewModel: DieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dieViewModel = ViewModelProvider(this)[DieViewModel::class.java]

        val rollDiceButton: Button = findViewById(R.id.rollDiceButton)

        rollDiceButton.setOnClickListener {
            dieViewModel.rollDie()
        }

        if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, DieFragment.newInstance(6))
                .commit()
        }
    }
}
