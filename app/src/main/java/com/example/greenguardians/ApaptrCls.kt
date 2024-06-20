package com.example.greenguardians

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ApaptrCls(private val context: Context,private val dtLst:List<OGGDataClass>):RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.rcycl_layout, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(dtLst[position].dt_img19f19478).into(holder.rcimg19f19478)
        holder.rccrdtit19f19478.text = dtLst[position].dt_ttl19f19478
        //holder.rcdsc19f19478.text = dtLst[position].dt_dsc19f19478

        holder.rccrd19f19478.setOnClickListener {
            if (context is AdminManagePage) {
                val intent = Intent(context, DtlAct::class.java).apply {
                    putExtra("Image", dtLst[holder.adapterPosition].dt_img19f19478)
                    putExtra("title", dtLst[holder.adapterPosition].dt_ttl19f19478)
                    putExtra("Description", dtLst[holder.adapterPosition].dt_dsc19f19478)
                }
                context.startActivity(intent)
            } else if (context is Challenges) {
                val int = Intent(context, ChallengesDetails::class.java).apply {
                    putExtra("Image", dtLst[holder.adapterPosition].dt_img19f19478)
                    putExtra("title", dtLst[holder.adapterPosition].dt_ttl19f19478)
                    putExtra("Description", dtLst[holder.adapterPosition].dt_dsc19f19478)
                }
                context.startActivity(int)
            }
        }
    }


    override fun getItemCount(): Int {
        return dtLst.size }
}

class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var rcimg19f19478: ImageView
    var rccrdtit19f19478: TextView
    var rccrd19f19478:CardView

    init {
        rcimg19f19478= itemView.findViewById(R.id.rcimg19f19478)
        rccrdtit19f19478=itemView.findViewById(R.id.rccrdtit19f19478)
        rccrd19f19478=itemView.findViewById(R.id.rccrd19f19478)
    }
}

