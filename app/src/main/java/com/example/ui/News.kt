package com.example.ui

class News(var imgId01:Int,var imgId02:Int,var imgId03: Int,var title:String,var author:String,var comment:Int,var time:Int) {
    var type=0

    constructor(imgId:Int,title: String,author: String,comment: Int,time: Int):this(imgId,0,0,title,author,comment,time){
        type=1
    }
}
