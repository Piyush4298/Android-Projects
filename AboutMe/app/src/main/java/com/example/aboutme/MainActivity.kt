package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }
        findViewById<TextView>(R.id.nickname_text_view).setOnClickListener {
            updateNickname(it)
        }

    }



    private fun addNickname(view : View){
        val editText = findViewById<EditText>(R.id.nickname_edit_text)
        val nickNameTextView = findViewById<TextView>(R.id.nickname_text_view)
        nickNameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nickNameTextView.visibility = View.VISIBLE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit_text)
        val button_nick_name = findViewById<Button>(R.id.done_button)
        editText.visibility = View.VISIBLE
        button_nick_name.visibility = View.VISIBLE
        view.visibility = View.GONE

        editText.requestFocus()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }
}