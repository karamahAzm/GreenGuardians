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
import com.example.greenguardians.databinding.ActivityMagazineUploadPageBinding

class MagazineUploadPage : AppCompatActivity() {
    private lateinit var dbR: FirebaseDatabase
    private lateinit var binding:ActivityMagazineUploadPageBinding
    var varUri: Uri? = null
    var ImgURL: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMagazineUploadPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val outcome = registerForActivityResult<Intent, ActivityResult>(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val dta = result.data
                varUri = dta!!.data
                binding.LoadMagazineImage.setImageURI(varUri)
            } else {
                Toast.makeText(this@MagazineUploadPage, "Failed to Select An Image", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        binding.LoadMagazineImage.setOnClickListener {
            val pckrfoto = Intent(Intent.ACTION_PICK)
            pckrfoto.type = "image/*"
            outcome.launch(pckrfoto)
        }
        binding.SaveMagBtn.setOnClickListener {
            data_save()
        }
    }
    private fun dta_apld() {
        val title = binding.LoadMagazineTitle.text.toString()
        val desc = binding.LoadMagazineDesc.text.toString()
        val DtaCls = MagazineDataClass(title,desc,ImgURL)
        val dtR= FirebaseDatabase.getInstance().getReference("DigitalMagazine").child(title)
            .setValue(DtaCls).addOnSuccessListener{ Toast.makeText(this@MagazineUploadPage, "Data are Saved", Toast.LENGTH_SHORT).show()
                finish()
            }.addOnFailureListener() { e -> Toast.makeText(this@MagazineUploadPage, e.message.toString(), Toast.LENGTH_SHORT).show()}
    }
    private fun data_save() {
        val storageReference = FirebaseStorage.getInstance().reference.child("Images")
            .child(varUri!!.lastPathSegment!!)
        val blrdr = AlertDialog.Builder(this@MagazineUploadPage)
        blrdr.setCancelable(false)
        blrdr.setView(R.layout.prgrs_layout)
        val dialog = blrdr.create()
        dialog.show()
        storageReference.putFile(varUri!!).addOnSuccessListener { taskSnapshot ->
            val uriTask = taskSnapshot.storage.downloadUrl
            while (!uriTask.isComplete);
            val urlImage = uriTask.result
            ImgURL = urlImage.toString()
            dta_apld()
            dialog.dismiss()
        }.addOnFailureListener {
            dialog.dismiss()
        }
    }

}
