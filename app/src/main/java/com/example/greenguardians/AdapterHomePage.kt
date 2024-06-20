package com.example.greenguardians
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterHomePage(private val dtlist: List<HomePageDataClass>) :RecyclerView.Adapter<AdapterHomePage.HomeVHolder> () {
    var clickitem: ((HomePageDataClass) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):HomeVHolder {
       val itemView=LayoutInflater.from(parent.context).inflate(R.layout.recycle_view_home_layout,parent,false)
        return HomeVHolder(itemView)
    }
    override fun onBindViewHolder(holder: HomeVHolder, position: Int) {
        val crnitm=dtlist[position]
        holder.rttle.text=crnitm.dtitle
        holder.rImg.setImageResource(crnitm.dimage)


        holder.itemView.setOnClickListener{
            clickitem?.invoke(crnitm)
        }
    }

    override fun getItemCount(): Int {
        return dtlist.size
    }
    class HomeVHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rImg:ImageView = itemView.findViewById(R.id.imageHome)
        val rttle:TextView = itemView.findViewById(R.id.titleHome)
    }
}