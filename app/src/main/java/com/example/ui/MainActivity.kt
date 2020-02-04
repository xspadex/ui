package com.example.ui

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var btn01:Button
    private lateinit var btn02:Button
    private lateinit var pb01:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn01=findViewById(R.id.btn01)
        btn02=findViewById(R.id.btn02)
        pb01=findViewById(R.id.pb01)

        btn01.setOnClickListener {

            //AlertDialog
            val dialog=AlertDialog.Builder(this@MainActivity)
            dialog.setTitle("您确定？")
            dialog.setMessage("移动到ListView页面？")
            dialog.setCancelable(true)
            dialog.setPositiveButton("OK") { _, _ ->
                startActivity(Intent(this,ListViewActivity::class.java))
            }
            dialog.setNegativeButton("Cancel") { _, _ ->  }
            dialog.show()

        }

        btn02.setOnClickListener {
            pb01.progress = pb01.progress+10
        }

        supportActionBar?.hide()

    }
}
