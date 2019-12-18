package net.ebisoba.omikuji

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    lateinit var mMediaPlayer_change: MediaPlayer
    lateinit var mMediaPlayer1: MediaPlayer
    lateinit var mMediaPlayer8: MediaPlayer
    lateinit var mMediaPlayer9: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        mMediaPlayer_change = MediaPlayer.create(this, R.raw.decision26)
        mMediaPlayer1 = MediaPlayer.create(this, R.raw.info_girl1_info_girl1_atari1)
        mMediaPlayer8 = MediaPlayer.create(this, R.raw.info_girl1_info_girl1_zannen1)
        mMediaPlayer9 = MediaPlayer.create(this, R.raw.info_girl1_info_girl1_zannendeshita1)

        mMediaPlayer_change.isLooping = false
        mMediaPlayer1.isLooping = false
        mMediaPlayer8.isLooping = false
        mMediaPlayer9.isLooping = false


    }

    override fun onResume() {
        super.onResume()


        mMediaPlayer_change.start()

        val num = intent.getIntExtra("RANDOM", 1)
        var luck = "運勢"
        var answer = "運勢"
        when(num) {
            0 -> {
                imageView2.setImageResource(R.drawable.daikyou)
                luck = "大凶"
            }
            1 -> {
                imageView2.setImageResource(R.drawable.kyou)
                luck = "凶"
            }
            2 -> {
                imageView2.setImageResource(R.drawable.kichi)
                luck = "吉"
            }
            3 -> {
                imageView2.setImageResource(R.drawable.suekichi)
                luck = "末吉"
            }
            4 -> {
                imageView2.setImageResource(R.drawable.shokichi)
                luck = "小吉"
            }
            5 -> {
                imageView2.setImageResource(R.drawable.daikichi)
                luck = "大吉"

            }
            6 -> {
                imageView2.setImageResource(R.drawable.chukichi)
                luck = "中吉"
            }
        }

        answer = luck + "です。"

        when(num){
            0 -> {
                answer += "残念でした。"
                mMediaPlayer9.start()
            }
            1 -> {
                answer += "残念。"
                mMediaPlayer8.start()
            }
            5 ->{
                answer += "おめでとうございます！"
                mMediaPlayer1.start()
            }
        }
        textView2.text = answer

        imageView2.setOnClickListener {

            finish()
        }


    }

    override fun onPause() {
        super.onPause()
        mMediaPlayer1.stop()
        mMediaPlayer8.stop()
        mMediaPlayer9.stop()

    }
}
