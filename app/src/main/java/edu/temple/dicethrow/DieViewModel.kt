package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel : ViewModel() {

    private val _currentRoll = MutableLiveData<Int>(1)
    val currentRoll: LiveData<Int> get() = _currentRoll

    private val _dieSides = MutableLiveData<Int>(6)
    val dieSides: LiveData<Int> get() = _dieSides

    fun setDieSides(sides: Int) {
        _dieSides.value = sides
    }

    fun rollDie() {
        _currentRoll.value = Random.nextInt(1, (_dieSides.value ?: 6) + 1)
    }

    fun setCurrentRoll(roll: Int) {
        _currentRoll.value = roll
    }
}
