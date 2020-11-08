package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView:TextView
    private var operand:Double = 0.0
    private var operation:String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTextView = findViewById(R.id.resultTextView)
    }

    fun numberClick(view: View){
        if(view is TextView){

            var result:String = resultTextView.text.toString()
            val number: String = view.text.toString()
            if (result=="0" || result=="."){
                result = ""
            }

            resultTextView.text = result + number

        }
    }

    fun operationClick(view:View){
        if (view is TextView){

            if(!TextUtils.isEmpty(resultTextView.text)){
                operand = resultTextView.text.toString().toDouble()
            }
            operation = view.text.toString()

            resultTextView.text=""

        }
    }

    fun equalsClick(view: View){
        val secOperandText:String = resultTextView.text.toString()
        var secOperand: Double = 0.0

        if(!TextUtils.isEmpty(secOperandText)){
            secOperand = secOperandText.toDouble()
        }
        when (operation){
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "*" -> resultTextView.text = (operand * secOperand).toString()
            "/" -> resultTextView.text = (operand / secOperand).toString()
            "^2" -> resultTextView.text = (operand * operand).toString()
            }

        }

    fun clearClick(view:View){
        resultTextView.text=""

    }

    fun delClick(view:View){
        val del = resultTextView.text.toString()
        if(!del.isEmpty()){
            resultTextView.text = del.substring(0, del.length -1)
        }
    }





}