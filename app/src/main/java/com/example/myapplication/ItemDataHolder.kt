package com.example.myapplication
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ItemDataAdapter(private val names: List<ItemData>, val activity: FirstFragment):
    RecyclerView.Adapter<ItemDataAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var largeTextView: TextView = itemView.findViewById(R.id.textViewLarge)
        var smallTextView: TextView = itemView.findViewById(R.id.textViewSmall)
        var iView: ImageView = itemView.findViewById(R.id.imageView)
        var button: Button = itemView.findViewById(R.id.button)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.largeTextView.text = names[position].name
        holder.smallTextView.text = names[position].descriptionShort
        Glide.with(activity)
            .load(names[position].imageId)
            .into(holder.iView)

        //holder.itemView.setBackgroundResource(names[position].imageId)
        //holder.largeTextView.setTextColor(names[position].textColor)
        //holder.smallTextView.setTextColor(names[position].textColor)

        holder.button.setOnClickListener {
            //activity.startActivity(names[position].descriptionLong)
            //navController.navigate(R.id.action_SecondFragment_to_FirstFragment)
            activity.findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, Bundle().apply
            {
                putString("description", names[position].descriptionLong)
                putInt("imageID", names[position].imageId)
            })
        }
    }

    override fun getItemCount(): Int {
        return names.size
    }
}