package com.jatin.fragmentdatapassing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.jatin.fragmentdatapassing.databinding.ActivityMainBinding
import com.jatin.fragmentdatapassing.databinding.FragmentFirstBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class FirstFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var mainActivity: MainActivity
    //lateinit var binding: FragmentFirstBinding
    lateinit var etPercentage: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivity = activity as MainActivity
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // binding = FragmentFirstBinding.inflate(layoutInflater)
        return inflater.inflate(R.layout.fragment_first, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val etName = view.findViewById<EditText>(R.id.etName)
        val etAge = view.findViewById<EditText>(R.id.etAge)
        val etHeight = view.findViewById<EditText>(R.id.etHeight)
        etPercentage = view.findViewById<EditText>(R.id.etPercentage)
        val btnSubmit = view.findViewById<Button>(R.id.btnSubmit)



        btnSubmit.setOnClickListener {
            if(etName.text.toString().isEmpty()
                || etAge.text.toString().isEmpty()
                || etHeight.text.toString().isEmpty()
                || etPercentage.text.toString().isEmpty())
            {
                Toast.makeText(requireActivity(), "All fields are compulsory!", Toast.LENGTH_SHORT).show()
            }
            else
            {
                var bundle = Bundle()
                bundle.putString("name",etName.text.toString())
                bundle.putInt("age",etAge.text.toString().toInt())
                bundle.putFloat("height",etHeight.text.toString().toFloat())
                bundle.putDouble("percentage",etPercentage.text.toString().toDouble())
                mainActivity.navController1.navigate(R.id.action_firstFragment_to_secondFragment, bundle)
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}