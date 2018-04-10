package com.example.androidacademypractice

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityBtn.setOnClickListener { openActivity() }
        emailBtn.setOnClickListener { openEmail() }
    }

    private fun openActivity() = MessageActivity.start(this, messageEditText.toString())

    private fun openEmail() {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.setData(Uri.parse(getString(R.string.email_scheme)))
                .putExtra(Intent.EXTRA_EMAIL, getString(R.string.email_sender))
                .putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject))
                .putExtra(Intent.EXTRA_TEXT, messageEditText.toString())

        if (intent.resolveActivityInfo(packageManager, intent.flags).exported) {
            startActivity(intent)
        } else {
            Toast.makeText(this, R.string.email_client_error, Toast.LENGTH_LONG).show()
        }
    }
}
