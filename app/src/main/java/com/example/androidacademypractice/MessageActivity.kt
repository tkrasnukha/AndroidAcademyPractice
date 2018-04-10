package com.example.androidacademypractice

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_message.*


class MessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        messageText.text = intent.getStringExtra(KEY_MESSAGE)
    }

    companion object {

        private const val KEY_MESSAGE = "KEY_MESSAGE"

        fun start(activity: Activity, message: String) {
            val intent = Intent(activity, MessageActivity::class.java)
            intent.putExtra(KEY_MESSAGE, message)
            activity.startActivity(intent)
        }
    }
}
