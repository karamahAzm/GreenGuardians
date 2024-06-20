package com.example.greenguardians
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.greenguardians.databinding.ActivityUserDisplayProductsBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class UserDisplayProducts : AppCompatActivity() {
    var database19f19478: DatabaseReference? = null
    var eventListener: ValueEventListener? = null
    private lateinit var dtlist: ArrayList<DataClassSupllier>
    private lateinit var adapter: AdapterSupplier
    private lateinit var binding: ActivityUserDisplayProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDisplayProductsBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        val gridLayoutManager = GridLayoutManager(this@UserDisplayProducts, 1)
        binding.RecyclerVw19f19478Supp.layoutManager = gridLayoutManager
        val builder = AlertDialog. Builder ( this@UserDisplayProducts)
        builder.setCancelable(false)
        builder.setView(R.layout.prgrs_layout)
        val dialog = builder.create()
        dialog.show()

        dtlist = ArrayList()
        adapter = AdapterSupplier(this@UserDisplayProducts, dtlist)
        binding.RecyclerVw19f19478Supp.adapter = adapter
        database19f19478 = FirebaseDatabase.getInstance().getReference("SupplierData")
        dialog.show()

        eventListener = database19f19478!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dtlist.clear()
                for (itemSnapshot in snapshot.children) {
                    val differentData = itemSnapshot.getValue(DataClassSupllier::class.java)
                    if (differentData != null) {
                        dtlist.add(differentData)
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
