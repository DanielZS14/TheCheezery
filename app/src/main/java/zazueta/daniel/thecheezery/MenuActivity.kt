package zazueta.daniel.thecheezery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnCold: Button = findViewById(R.id.button_cold_drinks) as Button
        var btnHot: Button = findViewById(R.id.button_hot_drinks) as Button
        var btnSweets: Button = findViewById(R.id.button_sweets) as Button
        var btnSalties: Button = findViewById(R.id.button_salties) as Button

        btnCold.setOnClickListener {
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("grupo","cold_drinks")
            startActivity(intent)
        }

        btnHot.setOnClickListener {
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("grupo","hot_drinks")
            startActivity(intent)
        }

        btnSweets.setOnClickListener {
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("grupo","sweets")
            startActivity(intent)
        }

        btnSalties.setOnClickListener {
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("grupo","salties")
            startActivity(intent)
        }
    }
}