package com.techrz.loaddata;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.GridView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private GridView gridView;
    private String URL = "https://muthosoft.com/univ/photos/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        String[] keys = {"my_courses", "sid"};
        String[] values = {"true", "2019160036"};
        httpRequest(keys, values);
    }
    @SuppressLint("StaticFieldLeak")
    private void httpRequest(final String keys[], final String values[]){
        new AsyncTask<Void, Void, String>(){
            @Override
            protected String doInBackground(Void... param){
                try{
                    List<NameValuePair> params = new ArrayList<NameValuePair>();
                    for(int i=0; i<keys.length; i++){
                        params.add(new BasicNameValuePair(keys[i], values[i]));
                    }
                    String data = JSONParser.getInstance().makeHttpRequest(URL, "POST", params);
                    return data;
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(String data){

                if(data!=null){
                    try{
                        System.out.println(data);
                        //webView.loadDataWithBaseURL(null, data, "text/html", "UTF-8",  null);
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
            }
        }.execute();
    }
}