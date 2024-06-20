package com.example.greenguardians
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.greenguardians.databinding.ActivityMainBinding
import com.google.firebase.database.ValueEventListener

class HomePg : AppCompatActivity() {
    private lateinit var recyclerViewHome: RecyclerView
    var eventListener: ValueEventListener? = null
    private lateinit var dtalst: ArrayList<HomePageDataClass>
    lateinit var imglst: Array<Int>
    lateinit var ttlst: Array<String>
    private lateinit var adapter: AdapterHomePage
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imglst = arrayOf(
            R.drawable.ch,
            R.drawable.img_13,
            R.drawable.emaga,
            R.drawable.contact
        )
        ttlst = arrayOf(
            "Selected Challenges",
            "Shop By Category",
            "Digital Magazine",
            "Contact Us"
        )
        recyclerViewHome = findViewById(R.id.recyclerView19f19478)
        recyclerViewHome.layoutManager = GridLayoutManager(this,1)
        recyclerViewHome.setHasFixedSize(true)
        dtalst = arrayListOf<HomePageDataClass>()
        getData()

        adapter = AdapterHomePage(dtalst).apply {
            clickitem = { dataItem ->
                val intent =
                    when (dataItem.dtitle) { // Use dataTitle to match your previous setup
                        "Selected Challenges" -> Intent(this@HomePg, Challenges::class.java)
                        "Shop By Category" -> Intent(this@HomePg, UserDisplayProducts::class.java)
                        "Digital Magazine"-> Intent(this@HomePg, ActivityUserDisplayMagazine::class.java)
                        "Contact Us"-> Intent(this@HomePg, ContactDetails::class.java)
                        else -> null
                    }
                intent?.let { startActivity(it) }
            }
        }
        recyclerViewHome.adapter= adapter

    }
    private fun getData() {
        for (i in imglst.indices) {
            val dcls = HomePageDataClass(imglst[i], ttlst[i])
            dtalst.add(dcls)
        }
    }
}


