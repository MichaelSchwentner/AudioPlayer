package com.example.playaudio

import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.io.IOException

class MainActivity : AppCompatActivity() {
    // Audioplayer
    private lateinit var btnPlayAudio : Button
    private lateinit var btnPauseAudio : Button
    var mediaPlayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPlayAudio = findViewById(R.id.btnPlayAudio)
        btnPauseAudio = findViewById(R.id.btnPauseAudio)

        btnPlayAudio.setOnClickListener {
            playAudio()
        }

        btnPauseAudio.setOnClickListener {
            pauseAudio()
        }
    }

    private fun pauseAudio() {
        if (mediaPlayer!!.isPlaying){
            mediaPlayer!!.stop()
            mediaPlayer!!.reset()
            mediaPlayer!!.release()
        }else{
            Toast.makeText(this,"Audio has not played", Toast.LENGTH_LONG).show()
        }
    }

    private fun playAudio() {
        val audioURL = "https://www.learningcontainer.com/wp-content/uploads/2020/02/Kalimba.mp3"

        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)
        try {
            mediaPlayer!!.setDataSource(audioURL)
            mediaPlayer!!.prepare()
            mediaPlayer!!.start()
        }catch (e : IOException) {
            e.printStackTrace()
        }
        Toast.makeText(this,"Audio started playing", Toast.LENGTH_LONG).show()
    }
}