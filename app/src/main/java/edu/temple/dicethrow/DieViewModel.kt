package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

private var dieSides: Int =6

class DieViewModel : ViewModel() {

    private val _currentRoll: MutableLiveData<Int> by lazy {
        MutableLiveData()
    }

    val currentRoll: LiveData<Int> get() = _currentRoll

    fun rollDie(sides: Int) {
        _currentRoll.value = Random.nextInt(1, sides + 1)
    }

    fun setCurrentRoll(roll: Int) {
        _currentRoll.value = roll
    }
}
