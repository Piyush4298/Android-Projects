package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }
    private fun makeColored(view : View){
        when(view.id) {
            R.id.box_one_text_view -> view.setBackgroundColor(Color.RED)
            R.id.box_two_text_view -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_three_text_view -> view.setBackgroundColor(Color.BLUE)
            R.id.box_four_text_view -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text_view -> view.setBackgroundColor(Color.YELLOW)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }

    }
    private fun setListeners() {

        val boxOneText = findViewById<TextView>(R.id.box_one_text_view)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text_view)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text_view)
        val boxFourText = findViewById<TextView>(R.id.box_four_text_view)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text_view)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, rootConstraintLayout)
        for(item in clickableViews){
            item.setOnClickListener{makeColored(it)}
        }
    }
}