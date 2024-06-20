package com.example.greenguardians

import android.net.Uri
import android.content.Intent
import android.os.Bundle
import com.google.firebase.storage.FirebaseStorage
import androidx.activity.result.ActivityResult
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.result.contract.ActivityResultContracts
import com.example.greenguardians.databinding.ActivityUpldBinding


class Upld_Act : AppCompatActivity() {

    private lateinit var dbR: FirebaseDatabase
    private lateinit var binding:ActivityUpldBinding
    var uniform_resource_ident: Uri? = null
    var URLForImg: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpldBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val outcome = registerForActivityResult<Intent, ActivityResult>(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val dta = result.data
                uniform_resource_ident = dta!!.data
                binding.ImgLd.setImageURI(uniform_resource_ident)
            } else {
                Toast.makeText(this@Upld_Act, "Failed to Select An Image", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        binding.ImgLd.setOnClickListener {
            val pckrfoto = Intent(Intent.ACTION_PICK)
            pckrfoto.type = "image/*"
            outcome.launch(pckrfoto)
        }
        binding.SvBtn.setOnClickListener {
            data_save()
        }
    }
    private fun dta_apld() {
        val Title19f19478 = binding.txtTitle.text.toString()
        val Desc19f19478 = binding.txtDesc.text.toString()
        val DtaCls = OGGDataClass(Title19f19478,Desc19f19478,URLForImg)
        val dtR= FirebaseDatabase.getInstance().getReference("OmanGreenGuardians").child(Title19f19478)
            .setValue(DtaCls).addOnSuccessListener{ Toast.makeText(this@Upld_Act, "Data are Saved", Toast.LENGTH_SHORT).show()
                finish()
            }.addOnFailureListener() { e -> Toast.makeText(this@Upld_Act, e.message.toString(), Toast.LENGTH_SHORT).show()}
    }
    private fun data_save() {
        val storageReference = FirebaseStorage.getInstance().reference.child("Images")
            .child(uniform_resource_ident!!.lastPathSegment!!)
        val blrdr = AlertDialog.Builder(this@Upld_Act)
        blrdr.setCancelable(false)
        blrdr.setView(R.layout.prgrs_layout)
        val dialog = blrdr.create()
        dialog.show()
        storageReference.putFile(uniform_resource_ident!!).addOnSuccessListener { taskSnapshot ->
            val uriTask = taskSnapshot.storage.downloadUrl
            while (!uriTask.isComplete);
            val urlImage = uriTask.result
            URLForImg = urlImage.toString()
            dta_apld()
            dialog.dismiss()
        }.addOnFailureListener {
            dialog.dismiss()
        }
    }

}
