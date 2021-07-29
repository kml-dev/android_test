package kr.or.ddit;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Task extends AsyncTask<Map<String, String>, Integer, String> {

    public static String ip = "192.168.41.30"; // 자신의 IP주소를 쓰시면 됩니다.
    private List<BhfInfoVO> bhfList = new ArrayList<BhfInfoVO>();

    public List<BhfInfoVO> getBhfList() {
        return bhfList;
    }

    public void setBhfList(List<BhfInfoVO> bhfList) {
        this.bhfList = bhfList;
    }

    @Override
    protected String doInBackground(Map<String, String>... maps) {
        // Http 요청 준비 작업
        HttpClient.Builder http = new HttpClient.Builder
                ("POST", "http://" + ip + ":80/" + maps[0].get("url")); //포트번호,서블릿주소

        // Parameter 를 전송한다.
        http.addAllParameters(maps[0]);

        //Http 요청 전송
        HttpClient post = http.create();
        post.request();

        // 응답 상태코드 가져오기
        int statusCode = post.getHttpStatusCode();

        // 응답 본문 가져오기
        String body = post.getBody();

        return body;
    }

}

