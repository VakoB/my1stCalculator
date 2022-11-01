package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity(){

    private lateinit var resultTextView: TextView
    private var operand = 0.0
    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.enterValue)
    }
    fun numberClick(clickedView: View) {
        if (clickedView is TextView) {
            var text = resultTextView.text.toString()
            val number = clickedView.text.toString()
            if (text == "0") {
                text = ""

            }

            val result = text + number
            resultTextView.text= result


        }
    }
    fun operationClick(clickedView: View) {
        if (clickedView is TextView) {
            operand = resultTextView.text.toString().toDouble()
            operation = clickedView.text.toString()
            resultTextView.text = " "

        }
    }
    fun equalsClick(clickedView: View){

        val secondOperand = resultTextView.text.toString().toDouble()

        when (operation){
            "+" -> resultTextView.text = (operand + secondOperand).toString()
            "-" -> resultTextView.text = (operand - secondOperand).toString()
            "*" -> resultTextView.text = (operand * secondOperand).toString()
            "/" -> resultTextView.text = (operand / secondOperand).toString()

        }
    }
    fun Clear(clickedView: View){

        if(clickedView is TextView) {
            resultTextView.text = "0"
        }
    }
    fun backClick(clickedView: View){
        if(clickedView is TextView) {
            val n = 1
            resultTextView.text = resultTextView.text.dropLast(n)

        }
    }
}