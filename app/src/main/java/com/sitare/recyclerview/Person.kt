package com.sitare.recyclerview

import java.io.Serializable

//serializable - nesne transferi interface
data class Person(var id:Int, var name:String, var telephone:String) : Serializable {
}