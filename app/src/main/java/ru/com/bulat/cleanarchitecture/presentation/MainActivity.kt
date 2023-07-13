package ru.com.bulat.cleanarchitecture.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.com.bulat.cleanarchitecture.R

class MainActivity : AppCompatActivity(), MainView {


    private  val presenter = MainPresenterImpl()

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("AAA", "Activity created")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val dataEditView = findViewById<TextView>(R.id.dataEditView)

        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

//        vm.resultLive.observe(this) { text ->
//            dataTextVew.text = text
//        }

        sendButton.setOnClickListener {
            // Клик по кнопке Save data
            val text = dataEditView.text.toString()
            presenter.save(text)
        }

        receiveButton.setOnClickListener {
            // Клик по кнопке Get data
            presenter.load()
        }
    }

    override fun showResult(text: String) {
        val dataTextVew = findViewById<TextView>(R.id.dataTextView)
        dataTextVew.text = text
    }
}