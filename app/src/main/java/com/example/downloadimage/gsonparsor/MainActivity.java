package com.example.downloadimage.gsonparsor;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.downloadimage.gsonparsor.Model.Post;
import com.example.downloadimage.gsonparsor.Thread.ILeadCaptureCallback;
import com.example.downloadimage.gsonparsor.Thread.PostHitAsyncTask;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MainActivity extends Activity {

    private String reqStringURL;
    private TextView txtDate;
    private List<Post> postModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postModelList = new ArrayList<>();

        txtDate = (TextView)findViewById(R.id.txtDate);
        reqStringURL = "http://kylewbanks.com/rest/posts";

        PostHitAsyncTask asyncTask = new PostHitAsyncTask(reqStringURL, new ILeadCaptureCallback() {
            @Override
            public void receivedLeadResponse(String response) {
                postModelList.clear();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for(int i=0; i<jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        Post model = new Gson().fromJson(object.toString(), Post.class);
                        postModelList.add(model);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                txtDate.setText(postModelList.get(0).getDate());

            }
        });
        asyncTask.execute();

    }

}
