package paba.c14220151.recycleview

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class detWayang : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_det_wayang)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detWayang)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var _ivFoto = findViewById<ImageView>(R.id.ivFoto)
        var _tvNama = findViewById<TextView>(R.id.tvNama)
        var _tvDes = findViewById<TextView>(R.id.tvDetail)

        val dataIntent = intent.getParcelableExtra<wayang>("kirimData",
            wayang::class.java)
        if (dataIntent != null) {
            Picasso.get()
                .load(dataIntent.foto)
                .into(_ivFoto)
        }

    }
}