package kr.ncspartner.increase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class HolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hol);

        EditText mEtMine    = findViewById(R.id.mEtMine);
        EditText mEtCom     = findViewById(R.id.mEtCom);
        EditText mEtResult  = findViewById(R.id.mEtResult);

        Button mBtn = findViewById(R.id.mBtn);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] list = {"홀", "짝"};
                int com = (int)(Math.random() * 2);
                mEtCom.setText(list[com]);

                if(mEtMine.getText().toString().equals(mEtCom.getText().toString())){
                    mEtResult.setText("맞았음");
                }else{
                    mEtResult.setText("틀렸음");
                }
            }
        });
    }
}