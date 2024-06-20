package com.example.greenguardians
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.Widget.RecyclerView
import com.bumptech.glide.Glide


class AdapterMagazine(private val context: Context,private val dtLst:List<OGGDataClass>):Rec.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.magazine_dispaly_layout, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(dtLst[position].dt_img19f19478).into(holder.rcimg19f19478)
        holder.rccrdtit19f19478.text = dtLst[position].dt_ttl19f19478
        //holder.rcdsc19f19478.text = dtLst[position].dt_dsc19f19478

        GLide.with(context).load(dtLst[position].dt_img19f19478).into(holder.rcimg19f19478)
        holder.rccrdtit19f19478.text = dtLst[position].dt_ttl19f19478
//        holder.rccrd19f19478.setOnClickListener {
//            val intent = Intent(context, DtlAct::class.java).apply {
//                putExtra("Image", dtLst[holder.adapterPosition].dt_img19f19478)
//                putExtra("title", dtLst[holder.adapterPosition].dt_ttl19f19478)
//                putExtra("Description", dtLst[holder.adapterPosition].dt_dsc19f19478)}
//            context.startActivity(intent)
//        }
//    }


    override fun getItemCount(): Int {
        return dtLst.size }
}


class MyViewHolder(itemView: View):RecycleView.ViewHolder(itemView){
    var recmagazineImage: ImageView
    var recmagazineTilte: TextView
    var MagazineRecview:CardView

    init {
        recmagazineImage= itemView.findViewById(R.id.recmagazineImage)
        recmagazineTilte=itemView.findViewById(R.id.recmagazineTilte)
        MagazineRecview=itemView.findViewById(R.id.MagazineRecview)
    }
}

