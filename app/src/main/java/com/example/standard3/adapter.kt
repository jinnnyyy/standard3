package com.example.standard3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import androidx.recyclerview.widget.RecyclerView
import com.example.standard3.databinding.ItemBinding

class adapter(val mItems: MutableList<item>) : RecyclerView.Adapter<adapter.Holder>() {

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            itemClick?.onClick(it, position)
        }
        holder.name.text = mItems[position].name
        holder.when3.text = mItems[position].when3
        holder.number.text = mItems[position].number
        holder.price.text = mItems[position].price

        if (position % 3 == 0) {
            holder.binding.imageView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.c1))
        } else if (position % 3 == 1) {
            holder.binding.imageView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.c2))
        } else {
            holder.binding.imageView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.c3))
        }



    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
//        Log.i("adapter","${mItems.size}")
        return mItems.size

    }

    inner class Holder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.name
        val when3 = binding.when3
        val number = binding.number
        var price = binding.price
    }
}


