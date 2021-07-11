package org.utarid.parcelable

import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import org.utarid.parcelable.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private var binding: ActivitySecondBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding!!.root
        setContentView(view)

        getDataFromFirstActivity()
    }

    private fun getDataFromFirstActivity() {
        val data = intent.extras!!.getParcelable<Parcelable>("data") as Data?
        binding!!.txtInt.text = data!!.dataInt.toString()
        binding!!.txtStr.text = data.dataStr
    }
}