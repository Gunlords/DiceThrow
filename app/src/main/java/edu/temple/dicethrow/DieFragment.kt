package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class DieFragment : Fragment() {

    val DIESIDE = "sidenumber"

    private lateinit var dieTextView: TextView
    private lateinit var dieViewModel: DieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dieViewModel = ViewModelProvider(requireActivity())[DieViewModel::class.java]

        arguments?.let {
            dieViewModel.setDieSides(it.getInt(DIESIDE, 6)) // Default to 6 sides
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_die, container, false)
        dieTextView = view.findViewById(R.id.dieTextView)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (dieViewModel.currentRoll.value == null) {
            dieViewModel.setCurrentRoll(1)
        }

        dieViewModel.currentRoll.observe(viewLifecycleOwner) { roll ->
            dieTextView.text = roll.toString()
        }
    }

    companion object {
        fun newInstance(sides: Int): DieFragment {
            return DieFragment().apply {
                arguments = Bundle().apply {
                    putInt("sidenumber", sides)
                }
            }
        }
    }
}
