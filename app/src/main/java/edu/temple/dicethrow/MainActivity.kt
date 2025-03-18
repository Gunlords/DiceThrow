package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollDiceButton)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, DieFragment())
                .commit()
        }

        rollButton.setOnClickListener {
            val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as? DieFragment
            fragment?.throwDie()
        }
    }
}
