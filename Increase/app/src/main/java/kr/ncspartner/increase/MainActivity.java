package kr.ncspartner.increase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText mEt = findViewById(R.id.mEt);
        Button mBtn = findViewById(R.id.mBtn);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("LKM", "Hello");
                String str = mEt.getText().toString();
                int num = Integer.parseInt(str) + 1;
                mEt.setText(num + "");
            }
        });
    }
}