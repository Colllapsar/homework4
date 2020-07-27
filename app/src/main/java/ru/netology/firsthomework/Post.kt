package ru.netology.firsthomework

data class Post(
    val content:String,
    val date:String,
    val author:String,
    var liked:Boolean = true,
    val numberOfLikes:String,
    val numberOfComments:String,
    val numberOfShares:String,
    val address:String,
    val coordinate: Pair<Double, Double>
)