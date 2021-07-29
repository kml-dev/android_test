package kr.or.ddit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // 인텐트 처리
        Intent intent = getIntent();
        int bhfNo = intent.getIntExtra("bhfNo", 0);

        // ListView 처리
        lv = (ListView)findViewById(R.id.lv);
        
        List<String> listCont = new ArrayList<String>();
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, listCont);
        
        lv.setAdapter(adapter);
        
        // Task 처리
        Task networkTask = new Task();
        List<OrderInfoVO> orderList = new ArrayList<>();
        try{
            Map<String, String> params = new HashMap<String, String>();
            params.put("url", "andOrderList.do");
            params.put("bhfNo", String.valueOf(bhfNo));

            String s = networkTask.execute(params).get();

            Gson gson = new Gson();
            JSONArray json = null;
            try {
                json = new JSONArray(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            System.out.println(json.toString());

            for (int i = 0; i < json.length(); i++) {
                try {
                    OrderInfoVO data = gson.fromJson(json.get(i).toString(), OrderInfoVO.class);
                    orderList.add(data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        for (OrderInfoVO vo : orderList){
            listCont.add("주문 번호:" + vo.getUseStatusNo() + "      승인 날짜:" + vo.getRequstDe());
        }

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strText = (String) parent.getItemAtPosition(position);
                strText = String.valueOf(strText.split(":")[1].charAt(0));
                System.out.println("str:"+strText);
                int useStatusNo = 0;
                for (OrderInfoVO vo : orderList){
                    if(String.valueOf(vo.getUseStatusNo()).equals(strText)){
                        useStatusNo = vo.getUseStatusNo();
                    }
                }

                Intent intent = new Intent(SubActivity.this, DetailsActivity.class);
                intent.putExtra("useStatusNo", useStatusNo);
                startActivity(intent);
            }
        });

        adapter.notifyDataSetChanged();
    }
}