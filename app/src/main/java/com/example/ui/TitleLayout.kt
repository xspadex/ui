package com.example.ui

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast


class TitleLayout(context: Context,attrs:AttributeSet):LinearLayout(context,attrs){
    init {
        LayoutInflater.from(context).inflate(R.layout.title, this)
        val btn_title_back=findViewById<Button>(R.id.btn_title_back)
        val btn_edit=findViewById<Button>(R.id.btn_edit)

        btn_title_back.setOnClickListener {
            Toast.makeText(getContext(),"登录",Toast.LENGTH_SHORT).show()
        }

        btn_edit.setOnClickListener {
            Toast.makeText(getContext(),"发布",Toast.LENGTH_SHORT).show()
        }
    }
}