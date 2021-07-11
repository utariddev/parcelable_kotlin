package org.utarid.parcelable

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import org.utarid.parcelable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)

        binding!!.btnSend.setOnClickListener {
            openSecondActivityWithData()
        }
    }

    private fun openSecondActivityWithData() {
        val data = Data(binding!!.txtInt.text.toString().toInt(), binding!!.txtString.text.toString())
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("data", data)
        startActivity(intent)
    }
}
