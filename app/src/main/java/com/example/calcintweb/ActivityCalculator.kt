package com.example.calcintweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.EditText

class ActivityCalculator : AppCompatActivity() {
    lateinit var Tv_answer:TextView
    lateinit var firstno:EditText
    lateinit var secondno:EditText
    lateinit var plus:Button
    lateinit var minus:Button
    lateinit var multiply:Button
    lateinit var divide:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        Tv_answer=findViewById(R.id.text_1)
        firstno=findViewById(R.id.firstno)
        secondno=findViewById(R.id.secondno)
        plus=findViewById(R.id.plus)
        minus=findViewById(R.id.minus)
        multiply=findViewById(R.id.minus)
        divide=findViewById(R.id.divide)

        plus.setOnClickListener {
            var myfirstnumber=firstno.text.toString()
            var mysecondnumber=secondno.text.toString()
            if (myfirstnumber.isEmpty() && mysecondnumber.isEmpty()){
                Tv_answer.text="Please fill in all inputs"
            }else{
                // calaculate now...
                var answer=myfirstnumber.toDouble()+mysecondnumber.toDouble()
                Tv_answer.text=answer.toString()
            }

        }
        minus.setOnClickListener {
            var myfirstnumber=firstno.text.toString()
            var mysecondnumber=secondno.text.toString()
            if (myfirstnumber.isEmpty() && mysecondnumber.isEmpty()){
                Tv_answer.text="Please fill in all inputs"
            }else{
                var answer=myfirstnumber.toDouble()-mysecondnumber.toDouble()
                Tv_answer.text=answer.toString()
            }
        }
        divide.setOnClickListener {
            var myfirstnumber=firstno.text.toString()
            var mysecondnumber=secondno.text.toString()
            if  (myfirstnumber.isEmpty() && mysecondnumber.isEmpty()){
                Tv_answer.text="Please fill in all inputs"
            }else{
                var answer=myfirstnumber.toDouble()/mysecondnumber.toDouble()
                Tv_answer.text=answer.toString()
            }
        }
    }
}