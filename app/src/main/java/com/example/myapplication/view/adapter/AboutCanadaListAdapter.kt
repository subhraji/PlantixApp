package com.example.myapplication.view.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.helper.inflate
import com.example.myapplication.model.pojo.Row
import kotlinx.android.synthetic.main.about_canada_item_layout.view.*

class AboutCanadaListAdapter(private val rowList: List<Row>, private val context: Context): RecyclerView.Adapter<AboutCanadaListAdapter.AboutCanadaListViewHolder>() {

    inner class AboutCanadaListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutCanadaListViewHolder {
        return AboutCanadaListViewHolder(parent.inflate(R.layout.about_canada_item_layout))
    }
    override fun getItemCount(): Int {
        return rowList.size
    }
    override fun onBindViewHolder(holder: AboutCanadaListAdapter.AboutCanadaListViewHolder, position: Int) {

        val rowData = rowList[position]
        holder.itemView.apply {

            if(rowData.imageHref != null){
                val imgUrl = rowData.imageHref.replace("http","https")
                Glide.with(context)
                    .load(imgUrl)
                    .centerCrop()
                    .placeholder(R.drawable.ic_notfound)
                    .into(about_canada_img)
            }else{
                Glide.with(context)
                    .load(R.drawable.ic_notfound)
                    .centerCrop()
                    .placeholder(R.drawable.ic_notfound)
                    .into(about_canada_img)
            }

            about_canada_title_txt.text = rowData.title

        }
    }
}