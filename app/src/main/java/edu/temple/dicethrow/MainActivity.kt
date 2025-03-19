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
                .replace(R.id.fragmentContainerView1, DieFragment.newInstance(6)) // First Die
                .replace(R.id.fragmentContainerView2, DieFragment.newInstance(6)) // Second Die
                .commit()
        }

        rollButton.setOnClickListener {
            val fragment1 = supportFragmentManager.findFragmentById(R.id.fragmentContainerView1) as? DieFragment
            val fragment2 = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as? DieFragment

            fragment1?.throwDie()
            fragment2?.throwDie()
        }
    }
}
