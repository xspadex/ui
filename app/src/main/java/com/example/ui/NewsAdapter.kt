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

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var news=getItem(position)
        var view:View
        var viewHolder:ViewHolder

        if(convertView==null){
            view=LayoutInflater.from(context).inflate(recourceId,parent,false)
            viewHolder= ViewHolder(view.findViewById(R.id.tv_title),view.findViewById(R.id.iv_news3pics_01),
                view.findViewById(R.id.iv_news3pics_02),view.findViewById(R.id.iv_news3pics_03),view.findViewById(R.id.tv_info))
            view.setTag(viewHolder)
        }
        else{
            view=convertView
            viewHolder=view.getTag() as ViewHolder
        }

        if(news==null) return view

        viewHolder.title.text=news.title
        viewHolder.img01.setImageResource(news.imgId01)
        viewHolder.img02.setImageResource(news.imgId02)
        viewHolder.img03.setImageResource(news.imgId03)
        viewHolder.info.text="${news.author}  评论人数：${news.comment}  发布时间：${news.time}"

        return view
    }

    class ViewHolder(var title:TextView,var img01:ImageView,var img02:ImageView,var img03:ImageView,var info:TextView){}

//    override fun getItemViewType(position: Int): Int {
//        return super.getItemViewType(position)
//    }
//
//    override fun getViewTypeCount(): Int {
//        return super.getViewTypeCount()
//    }


}