package net.ebisoba.omikuji

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            val random = Random.nextInt(7)

            // 画面遷移
            val intent = Intent(this, Main2Activity::class.java)
            intent.putExtra("RANDOM", random)
            startActivity(intent)
        }

    }
}
