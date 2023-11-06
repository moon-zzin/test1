package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentExamineBinding
import com.example.myapplication.databinding.FragmentResultBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ExamineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExamineFragment : Fragment() {

    var binding : FragmentExamineBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentExamineBinding.inflate(inflater)
        return binding?.root
    }

    fun examineMBTI():String{
        binding?.let{
            val ieStr= if(it.chkE.isChecked) "E" else "I"
            val snStr= if(it.chkN.isChecked) "N" else "S"
            val tfStr= if(it.chkF.isChecked) "F" else "T"
            val jpStr= if(it.chkJ.isChecked) "J" else "P"
            return ieStr + snStr + tfStr + jpStr
        }
        return "null"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnResult?.setOnClickListener{
            val result = examineMBTI()
            val bundle = bundleOf("MBTI" to result)
            findNavController().navigate(R.id.action_examineFragment_to_resultFragment, bundle)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}