package com.example.playlistmaker

import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class SearchActivity : AppCompatActivity() {

    var searchText = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val backButton = findViewById<ImageView>(R.id.arrow_back)
        val searchInput = findViewById<EditText>(R.id.input_search)
        val clearButton = findViewById<ImageView>(R.id.clear_button)

        backButton.setOnClickListener {
            finish()
        }

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(seq: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(seq: CharSequence?, start: Int, count: Int, after: Int) {
                clearButton.visibility = if (seq.isNullOrEmpty())
                    View.GONE
                else
                    View.VISIBLE
            }

            override fun afterTextChanged(seq: Editable?) {
                searchText = searchInput.text.toString()
            }

        }

        searchInput.addTextChangedListener(textWatcher)


        clearButton.setOnClickListener {
            searchInput.clearFocus()
            val imm: InputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
            searchInput.setText("")
        }
    }

    companion object {
        const val SEARCH_TEXT = "SEARCH_TEXT"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(SEARCH_TEXT, searchText)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        searchText = savedInstanceState.getString(SEARCH_TEXT, "")
    }
}