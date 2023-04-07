package com.example.myapplication

import android.content.ClipData.Item
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = mutableListOf<ItemData>()
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this.context)

        data.add(ItemData("Сніданок", "Батончик з горыховою начинкою", R.drawable.firstp, this.resources.getString(R.string.RyanGosling)))
        data.add(ItemData("Обід", "Батончик з кокосовою начинкою", R.drawable.secondp, this.resources.getString(R.string.RyanGoslingsecond)))
        data.add(ItemData("Вечеря", "Батончик з чорним шоколадом", R.drawable.thirdp, this.resources.getString(R.string.RyanGoslingthird)))

        recyclerView.adapter = ItemDataAdapter(data, this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}