package kr.ncspartner.hellokt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.Random

class HolActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hol)

        val mEtMine : EditText = findViewById(R.id.mEtMine)
        val mEtCom : EditText = findViewById(R.id.mEtCom)
        val mEtResult : EditText = findViewById(R.id.mEtResult)

        val mBtn : Button = findViewById(R.id.mBtn)
        val random = Random()

        mBtn.setOnClickListener{
                var a = arrayOf("짝", "홀")
                var com : Int = random.nextInt(2)

                mEtCom.setText(a[com])
                var mine : String = mEtMine.text.toString()

                if(mine.equals(a[com])){
                    mEtResult.setText("맞췄음")
                }else{
                    mEtResult.setText("틀렸음")
                }

        }
    }

}