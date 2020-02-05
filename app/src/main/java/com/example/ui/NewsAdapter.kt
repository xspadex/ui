package com.example.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class NewsAdapter(context: Context, textViewResourceId:Int, objects:Array<News>):
    ArrayAdapter<News>(context,textViewResourceId,objects){
    private var recourceId=textViewResourceId

    companion object{
        const val TYPE_COUNT=2
        const val TYPE_3PICS=0
        const val TYPE_1PIC=1
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var news=getItem(position)
        var viewHolder:ViewHolder?=null
        var viewHolder2:ViewHolder2?=null
        val type=getItemViewType(position)


        recourceId = if(type== TYPE_3PICS) R.layout.news3pics_item
        else R.layout.news1pic_item

        var view:View = LayoutInflater.from(context).inflate(recourceId,parent,false)

        if(type== TYPE_3PICS){
            viewHolder= ViewHolder(view.findViewById(R.id.tv_title),view.findViewById(R.id.iv_news3pics_01),
                view.findViewById(R.id.iv_news3pics_02),view.findViewById(R.id.iv_news3pics_03),view.findViewById(R.id.tv_info))
        }

        else{
            viewHolder2=ViewHolder2(view.findViewById(R.id.tv_title),view.findViewById(R.id.iv_news1pic),view.findViewById(R.id.tv_info))
        }



        if(news==null) return view

        if(type== TYPE_3PICS && viewHolder!=null){
            viewHolder.title.text=news.title
            viewHolder.img01.setImageResource(news.imgId01)
            viewHolder.img02.setImageResource(news.imgId02)
            viewHolder.img03.setImageResource(news.imgId03)
            viewHolder.info.text="${news.author}  评论人数：${news.comment}  发布时间：${news.time}"
        }
        else if(type== TYPE_1PIC && viewHolder2!=null){
            viewHolder2.title.text=news.title
            viewHolder2.img.setImageResource(news.imgId01)
            viewHolder2.info.text="${news.author}  评论人数：${news.comment}  发布时间：${news.time}"
        }

        return view
    }

    class ViewHolder(var title:TextView,var img01:ImageView,var img02:ImageView,var img03:ImageView,var info:TextView){}

    class ViewHolder2(var title:TextView,var img:ImageView,var info:TextView){}

    override fun getItemViewType(position: Int): Int {
        val news=getItem(position)
        if(news?.type== TYPE_3PICS) return TYPE_3PICS
        else if(news?.type== TYPE_1PIC) return TYPE_1PIC
        return TYPE_3PICS
    }

    override fun getViewTypeCount(): Int {
        return TYPE_COUNT
    }


}