package com.example.greenguardians
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.greenguardians.databinding.ActivitySupplierManagePageBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SupplierManagePage : AppCompatActivity() {
    var database19f19478: DatabaseReference? = null
    var eventListener: ValueEventListener? = null
    private lateinit var dtlst: ArrayList<DataClassSupllier>
    private lateinit var adapter: AdapterSupplier
    private lateinit var binding: ActivitySupplierManagePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySupplierManagePageBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        val gridLayoutManager = GridLayoutManager(this@SupplierManagePage, 1)
        binding.RecyclerVw19f19478Supp.layoutManager = gridLayoutManager
        val builder = AlertDialog. Builder ( this@SupplierManagePage)
        builder.setCancelable(false)
        builder.setView(R.layout.prgrs_layout)
        val dialog = builder.create()
        dialog.show()

        dtlst = ArrayList()
        adapter = AdapterSupplier(this@SupplierManagePage, dtlst)
        binding.RecyclerVw19f19478Supp.adapter = adapter
        database19f19478 = FirebaseDatabase.getInstance().getReference("SupplierData")
        dialog.show()

        eventListener = database19f19478!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dtlst.clear()
                for (itemSnapshot in snapshot.children) {
                    val differentData = itemSnapshot.getValue(DataClassSupllier::class.java)
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
        binding.supplierFabBtn.setOnClickListener{
            val intent = Intent(this, SupplierUploadPage::class.java)
            startActivity(intent)
        }
    }
}
