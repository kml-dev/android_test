package kr.or.ddit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailsActivity extends AppCompatActivity {
    ListView lv_details;
    Button btn_1;
    Button btn_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // 버튼
        Button btn_pickup = findViewById(R.id.btn_1);
        Button btn_deliver = findViewById(R.id.btn_2);

        // 인텐트 처리
        Intent intent = getIntent();
        int useStatusNo = intent.getIntExtra("useStatusNo", 0);

        // ListView 처리
        lv_details = (ListView)findViewById(R.id.lv_details);

        List<String> listCont = new ArrayList<String>();
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, listCont);

        lv_details.setAdapter(adapter);

        // Task 처리
        Task networkTask = new Task();
        OrderDetailsVO data = null;
        try{
            Map<String, String> params = new HashMap<String, String>();
            params.put("url", "andOrderDetails.do");
            params.put("useStatusNo", String.valueOf(useStatusNo));

            String s = networkTask.execute(params).get();

            Gson gson = new Gson();
            data = gson.fromJson(s, OrderDetailsVO.class);

        }catch (Exception e){
            e.printStackTrace();
        }
        listCont.add("주문 번호 : " + data.getUseStatusNo());
        listCont.add("아이디 : " + data.getId());
        listCont.add("고객명 : " + data.getCustomerName());
        listCont.add("주소 : ");
        listCont.add(data.getAdd1() + "  " + data.getAdd2());
        listCont.add("물빨래 : " + data.getWaterLndrCnt());
        listCont.add("드라이 : " + data.getDryLndrCnt());
        listCont.add("이불 : " + data.getBlanketLndrCnt());
        listCont.add("요청일 : " + data.getRegistDe());
        listCont.add("승인일 : " + data.getRequstDe());

        btn_pickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = null;
                try{
                    Task networkTask = new Task();

                    Map<String, String> params = new HashMap<String, String>();
                    params.put("url", "andPickup.do");
                    params.put("useStatusNo", String.valueOf(useStatusNo));

                    s = networkTask.execute(params).get();
                }catch (Exception e){
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                Result result = gson.fromJson(s, Result.class);

                if("1".equals(result.getResult())) {
                    Toast.makeText(getApplicationContext(),"처리완료", Toast.LENGTH_SHORT)
                            .show();

                }else{
                    Toast.makeText(getApplicationContext(), "처리 도중 오류 발생",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });

        btn_deliver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = null;
                try{
                    Task networkTask = new Task();

                    Map<String, String> params = new HashMap<String, String>();
                    params.put("url", "andDeliver.do");
                    params.put("useStatusNo", String.valueOf(useStatusNo));

                    s = networkTask.execute(params).get();
                }catch (Exception e){
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                Result result = gson.fromJson(s, Result.class);

                if("1".equals(result.getResult())){
                    Toast.makeText(getApplicationContext(), "처리완료", Toast.LENGTH_SHORT)
                            .show();

                    Intent intent = new Intent(DetailsActivity.this,
                            MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(), "처리 도중 오류 발생",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}