package com.example.demoapplication

import androidx.lifecycle.ViewModel
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import kotlin.jvm.Throws

class MainViewModel: ViewModel() {


    fun isValidPan(input: String):Boolean{
      when(input.length >= 10){
        true ->  return true
      }
        return false
    }

    fun haveFun(dateStr: String):Boolean {
        try {
            var formatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val date = formatter.parse(dateStr)
            return true
        }catch (e:Exception){
            e.printStackTrace()
            return false
        }

    }



}