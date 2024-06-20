package com.example.greenguardians
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.greenguardians.databinding.ActivityChallengesBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Challenges : AppCompatActivity() {
    var database19f19478: DatabaseReference? = null
    var eventListener: ValueEventListener? = null
    private lateinit var dtlst: ArrayList<OGGDataClass>
    private lateinit var adapter: ApaptrCls
    private lateinit var binding: ActivityChallengesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChallengesBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        val gridLayoutManager = GridLayoutManager(this@Challenges, 1)
        binding.RecyclerVw19f19478.layoutManager = gridLayoutManager
        val builder = AlertDialog. Builder ( this@Challenges)
        builder.setCancelable(false)
        builder.setView(R.layout.prgrs_layout)
        val dialog = builder.create()
        dialog.show()

        dtlst = ArrayList()
        adapter = ApaptrCls(this@Challenges, dtlst)
        binding.RecyclerVw19f19478.adapter = adapter
        database19f19478 = FirebaseDatabase.getInstance().getReference("OmanGreenGuardians")
        dialog.show()

        eventListener = database19f19478!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dtlst.clear()
                for (itemSnapshot in snapshot.children) {
                    val differentData = itemSnapshot.getValue(OGGDataClass::class.java)
                    if (differentData != null) {
                        dtlst.add(differentData)
                    }
                }
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            }
            override fun onCancelled(error: DatabaseError) {
                dialog.dismiss()
            }
        })
    }
}
