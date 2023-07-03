package com.example.playlistmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val backButton = findViewById<ImageView>(R.id.arrow_back)
        val shareButton = findViewById<FrameLayout>(R.id.share_button)
        val supportButton = findViewById<FrameLayout>(R.id.support_button)
        val agreementButton = findViewById<FrameLayout>(R.id.agreement_button)

        backButton.setOnClickListener {
            finish()
        }

        shareButton.setOnClickListener {
            val message = getString(R.string.share_link)
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(shareIntent)
        }

        supportButton.setOnClickListener {
            Intent(Intent.ACTION_SENDTO).apply{
                val subject = getString(R.string.support_subject)
                val message = getString(R.string.support_message)
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(getString(R.string.support_mail)))
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, message)
                startActivity(this)
            }

        }

        agreementButton.setOnClickListener {
            val url = getString(R.string.agreement_link)
            val shareIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(shareIntent)
        }

    }
}