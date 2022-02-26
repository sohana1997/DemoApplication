package com.example.demoapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.demoapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var mainViewModel: MainViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        init()

    }

    fun init() {
        mainViewModel = MainViewModel()
        binding.apply {
            button.setOnClickListener {
                try {
                    if (mainViewModel?.isValidPan(binding.nameEditPan.text.toString()) == true) {
                        var dob: String =
                            "${binding?.nameEditDob.text}-${binding?.nameEditMonth.text}-${binding.nameEditYear.text}"
                        when (mainViewModel?.haveFun(dob) == true) {
                            true -> Toast.makeText(
                                this@MainActivity,
                                "Details submitted successfully",
                                Toast.LENGTH_SHORT
                            ).show()
                            else -> Toast.makeText(
                                this@MainActivity,
                                "DOB invalid",
                                Toast.LENGTH_SHORT
                            ).show()


                        }
                    } else {

                        Toast.makeText(this@MainActivity, "Pan Number invalid", Toast.LENGTH_SHORT)
                            .show()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(this@MainActivity, "Dob invalid", Toast.LENGTH_SHORT).show()

                }


            }

            dontHavePan.setOnClickListener { finish() }



        }
    }


}
