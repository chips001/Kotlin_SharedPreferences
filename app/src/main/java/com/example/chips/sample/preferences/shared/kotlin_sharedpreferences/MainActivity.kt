package com.example.chips.sample.preferences.shared.kotlin_sharedpreferences

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferences = getSharedPreferences("file_name", Context.MODE_PRIVATE)
        val storedText = preferences.getString("key", "未登録")

        val inputEditText = findViewById<EditText>(R.id.input_edit_text)
        inputEditText.setText(storedText)

        val saveButton = findViewById<Button>(R.id.save_button)
        saveButton.setOnClickListener {
            val inputText = inputEditText.text.toString()
            preferences.edit().putString("key", inputText).apply()
        }
    }
}
