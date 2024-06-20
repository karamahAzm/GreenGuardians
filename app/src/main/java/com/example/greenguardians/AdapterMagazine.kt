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

class AdapterMagazine(private val context: Context,private val dtLst:List<MagazineDataClass>):RecyclerView.Adapter<VH> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.magazine_dispaly_layout, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        Glide.with(context).load(dtLst[position].dtMaga_img19f19478).into(holder.recmagazineImage)
        holder.recmagazineTitle.text = dtLst[position].dtMaga_ttl19f19478

        holder.MagazineRecview.setOnClickListener {
            if (context is EMagazine) {
                val intent = Intent(context, MagazineAdminDetailsPage::class.java).apply {
                    putExtra("MagazineImage", dtLst[holder.adapterPosition].dtMaga_img19f19478)
                    putExtra("Magazinetitle", dtLst[holder.adapterPosition].dtMaga_ttl19f19478)
                    putExtra("MagazineDescription", dtLst[holder.adapterPosition].dtMaga_dsc19f19478)
                }
                context.startActivity(intent)
            } else if (context is ActivityUserDisplayMagazine) {
                val int = Intent(context, MagazineDetailsPage::class.java).apply {
                    putExtra("MagazineImage", dtLst[holder.adapterPosition].dtMaga_img19f19478)
                    putExtra("Magazinetitle", dtLst[holder.adapterPosition].dtMaga_ttl19f19478)
                    putExtra("MagazineDescription", dtLst[holder.adapterPosition].dtMaga_dsc19f19478)
                }
                context.startActivity(int)
            }
        }
    }

    override fun getItemCount(): Int {
        return dtLst.size }
    }


class VH(itemView: View):RecyclerView.ViewHolder(itemView) {
    var recmagazineImage: ImageView
    var recmagazineTitle: TextView
    var MagazineRecview: CardView

    init {
        recmagazineImage = itemView.findViewById(R.id.recmagazineImage)
        recmagazineTitle = itemView.findViewById(R.id.recmagazineTitle)
        MagazineRecview = itemView.findViewById(R.id.MagazineRecview)
    }

}
