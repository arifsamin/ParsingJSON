package com.example.parsingjson.parsingjson_example;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URLEncoder;


public class MainActivity extends ActionBarActivity {

    public static String TAG = "ParsingJSON";

    static String parsedJson;

    protected JSONObject mValidData;
    protected TextView tv;
    protected TextView tv2;
    protected String bufferedJson;

    protected String jsonTestUrl1 = "http://date.jsontest.com/";
    protected String customJsonUrl = "http://echo.jsontest.com/key/value/one/two";
    protected String testValidationUrl = "http://validate.jsontest.com/?json=";



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        Person person = PersonObject.create();
        parsedJson = JsonUtil.toJSon(person);

        GetJsonOutput getJsonOutput = new GetJsonOutput();
        getJsonOutput.execute();

    }



    private class GetJsonOutput extends AsyncTask<Object, Void, String> {

        @Override
        protected String doInBackground(Object... params) {

            String json = "";

            try {
                String url = testValidationUrl + URLEncoder.encode(parsedJson);
                InputStream is;

                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpGet httpGet = new HttpGet(url);

                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();

                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(
                            is, "iso-8859-1"), 8);
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                    is.close();
                    json = sb.toString();
                } catch (Exception e) {
                    Log.e("Buffer Error", "Error converting result " + e.toString());
                }

                try {
                    mValidData = new JSONObject(json);
                } catch(JSONException e) {
                    Log.e(TAG, "Holey shet");
                }

            } catch (MalformedURLException e) {
                Log.e(TAG, e.toString());
            } catch (IOException e) {
                Log.e(TAG, e.toString());
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }

            return json;
        }

        @Override
        protected void onPostExecute(String json) {
            super.onPostExecute(json);

            bufferedJson = json;
            updateTextView();
        }
    }

    public void updateTextView() {
        if (bufferedJson == "") {
            tv.setText(getString(R.string.error_message));

        } else {
            tv.setText(bufferedJson);
            try {
                tv2.setText(mValidData.getString("validate"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
