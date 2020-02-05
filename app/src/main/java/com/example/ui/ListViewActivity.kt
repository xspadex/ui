package com.example.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ListViewActivity : AppCompatActivity() {

    //private val data= arrayOf("Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango","Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango")

    private lateinit var news:Array<News>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        supportActionBar?.hide()

        var aNews=News(R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,"这是标题","这是作者",99,1)
        var bnews=News(R.drawable.ic_launcher_background,"这是标题","这是作者",999,0)
        news= arrayOf(aNews,aNews,bnews,aNews,aNews,bnews,aNews,bnews,aNews,aNews,aNews,aNews)

        val adapter=NewsAdapter(this,R.layout.news3pics_item,news)
        findViewById<ListView>(R.id.lw01).adapter=adapter

    }


}
