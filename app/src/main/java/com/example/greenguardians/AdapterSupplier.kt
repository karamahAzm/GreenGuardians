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

class AdapterSupplier (private val context: Context, private val dtLst:List<DataClassSupllier>):RecyclerView.Adapter<SuppViewAdapter>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuppViewAdapter {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.supplier_recycle_view_layout, parent, false)
        return SuppViewAdapter(v)
    }

    override fun onBindViewHolder(holder: SuppViewAdapter, position: Int) {
        Glide.with(context).load(dtLst[position].dtSupp_img19f19478).into(holder.recImageSupplier)
        holder.recTilteSupplier.text = dtLst[position].dtSupp_ttl19f19478

        holder.recViewSupplier.setOnClickListener {
            if (context is SupplierManagePage) {
                val intent = Intent(context, SupplierDetailsPage::class.java).apply {
                    putExtra("imageSupplier", dtLst[holder.adapterPosition].dtSupp_img19f19478)
                    putExtra("titleSupplier", dtLst[holder.adapterPosition].dtSupp_ttl19f19478)
                    putExtra("descriptionSupplier", dtLst[holder.adapterPosition].dtSupp_dsc19f19478)
                }
                context.startActivity(intent)
            } else if (context is UserDisplayProducts) {
                val int = Intent(context, UserDisplayPrductsDetails::class.java).apply {
                    putExtra("imageSupplier", dtLst[holder.adapterPosition].dtSupp_img19f19478)
                    putExtra("titleSupplier", dtLst[holder.adapterPosition].dtSupp_ttl19f19478)
                    putExtra("descriptionSupplier", dtLst[holder.adapterPosition].dtSupp_dsc19f19478)
                }
                context.startActivity(int)
            }
        }
    }
            override fun getItemCount(): Int {
                return dtLst.size
            }
}

class SuppViewAdapter(itemView:View):RecyclerView.ViewHolder(itemView) {
    var recImageSupplier: ImageView
    var recTilteSupplier: TextView
    var recViewSupplier: CardView

    init {
        recImageSupplier = itemView.findViewById(R.id.recImageSupplier)
        recTilteSupplier = itemView.findViewById(R.id.recTilteSupplier)
        recViewSupplier = itemView.findViewById(R.id.recViewSupplier)
    }
}


