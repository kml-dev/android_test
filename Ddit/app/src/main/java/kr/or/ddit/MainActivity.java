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

public class MainActivity extends AppCompatActivity {

    private ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        list = (ListView)findViewById(R.id.list);

        List<String> listCont = new ArrayList<String>();
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, listCont);

        list.setAdapter(adapter);

        List<BhfInfoVO> bhfInfoList = new ArrayList<BhfInfoVO>();
        Task networkTask = new Task();
        try{
            Map<String, String> params = new HashMap<String, String>();
            params.put("url", "andBhfList.do");
            params.put("get", "bhfList");

            String s = networkTask.execute(params).get();

            Gson gson = new Gson();
            JSONArray json = null;
            try {
                json = new JSONArray(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < json.length(); i++){
                try {
                    BhfInfoVO data = gson.fromJson(json.get(i).toString(), BhfInfoVO.class);
                    bhfInfoList.add(data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        for (BhfInfoVO vo : bhfInfoList){
            listCont.add(vo.getBHF_NAME());
        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strText = (String) parent.getItemAtPosition(position);
                int bhfNo = 0;
                for (BhfInfoVO vo : bhfInfoList){
                    if(vo.getBHF_NAME().equals(strText)){
                        bhfNo = vo.getBHF_NO();
                    }
                }

                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("bhfNo", bhfNo);
                startActivity(intent);
            }
        });

        adapter.notifyDataSetChanged();
    }
}