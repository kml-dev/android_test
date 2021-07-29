package kr.ncspartner.hellokt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class IncreaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_increase)

        val mEt : EditText = findViewById(R.id.mEt)
        val mBtn : Button = findViewById(R.id.mBtn)

        mBtn.setOnClickListener{
                var num : Int = Integer.parseInt(mEt.text.toString())
                num++
                mEt.setText(num.toString())
        }
    }

}