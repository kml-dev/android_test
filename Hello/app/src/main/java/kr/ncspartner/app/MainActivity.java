package kr.ncspartner.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mTv = findViewById(R.id.mTv);
        Button mBtn = findViewById(R.id.mBtn);
        mBtn.setOnClickListener(new Button.OnClickListener(){
            boolean flag = false;
            @Override
            public void onClick(View view){
                flag = !flag;
                if(flag){
                    mTv.setText("Bad Morning");
                }else{
                    mTv.setText("Good Morning");
                }
            }
        });
    }

    protected void onClick(){

    }
}