package kr.ncspartner.hellokt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mTv : TextView = findViewById(R.id.mTv)
        val mBtn : Button = findViewById(R.id.mBtn)

        mBtn.setOnClickListener{
                mTv.setText("Bad Morning")
        }
    }

}