package com.example.fern.myapplication;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RateListActivity extends ListActivity implements Runnable{

    private static final String TAG = "";
    String data[]={"wait..."};
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_rate_list);

        List<String> list1 = new ArrayList<String>();
        for(int i=0;i<100;i++){
            list1.add("item"+i);
        }

        ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,data);
        setListAdapter(adapter);

        Thread t = new Thread(this);
        t.start();

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if (msg.what==7){
                    List<String> list2= (List<String>) msg.obj;
                    ListAdapter adapter = new ArrayAdapter<String>(RateListActivity.this,android.R.layout.simple_list_item_activated_1,list2);
                    setListAdapter(adapter);
                }
                super.handleMessage(msg);
            }
        };
    }

    @Override
    public void run() {
        List<String> retList = new ArrayList<String>();
        Document doc = null;
        try{
            doc = Jsoup.connect("http://www.usd-cny.com/bankofchina.htm").get();
            Log.i("open","run:html"+doc.title());
            Elements tables = doc.getElementsByTag("table");
            for(Element table : tables){
                Log.i(TAG, "run: table"+table);
            }
            Element table= tables.get(0);
            //Log.i(TAG, "run: table1"+table1);
            Elements tds = doc.getElementsByTag("td");
            for (int i =0;i< tds.size();i+=6){
                Element td1=tds.get(i);
                Element td2=tds.get(i+5);

                Log.i("open", "run: "+td1.text()+"==>"+td2.text());
                retList.add(td1.text()+"==>"+td2.text());

            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        Message msg = handler.obtainMessage();
        msg.what = 7;
        msg.obj = retList;
        handler.sendMessage(msg);
    }
}
