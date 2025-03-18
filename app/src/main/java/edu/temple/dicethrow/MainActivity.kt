package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollDiceButton)

        rollButton.setOnClickListener {
            (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as DieFragment).throwDie()
        }
    }
}
