package com.example.a1.homework3;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;


public class Main3Activity extends Activity {
        int mYear, mMonth, mDay;
        Button chooseDate,end;
        TextView dateDisplay,aa;
        EditText name;

        final int DATE_DIALOG = 1;

        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main3);

            chooseDate = (Button) findViewById(R.id.dateChoose);
            dateDisplay = (TextView) findViewById(R.id.textView5);
            end =(Button)findViewById(R.id.button10);
            name=(EditText)findViewById(R.id.editText3);
            //aa=(TextView)findViewById(R.id.textView6) ;
            final EditText editText1 = (EditText) findViewById(R.id.editText3);
            final TextView textView=(TextView)findViewById(R.id.textView5);
            final EditText editText2 = (EditText) findViewById(R.id.editText6);
            final EditText editText3 = (EditText) findViewById(R.id.editText7);
            final EditText editText4 = (EditText) findViewById(R.id.editText8);




            chooseDate.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    showDialog(DATE_DIALOG);
                }
            });
            end.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   Intent i = new Intent(Main3Activity.this, endpage.class);
                   startActivity(i);
                   //sendMessage1(v);
                    Intent intent = new Intent(Main3Activity.this, endpage.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("name", String.valueOf(editText1.getText()));
                    bundle.putString("date", String.valueOf(textView.getText()));
                    bundle.putString("gift1", String.valueOf(editText2.getText()));
                    bundle.putString("gift2", String.valueOf(editText3.getText()));
                    bundle.putString("gift3", String.valueOf(editText4.getText()));


                    intent.putExtras(bundle);
                    startActivity(intent);





//                    String result = getJson("assets/"+"text.json");
//
//                    try {
//                        JSONArray json = new JSONArray(result);
//                        for(int i=0;i<json.length();i++)
//                        {
//                            JSONObject jb=json.getJSONObject(i);
//                            aa.setText(jb.getString("name"));
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }


                }
            });

            final Calendar ca = Calendar.getInstance();
            mYear = ca.get(Calendar.YEAR);
            mMonth = ca.get(Calendar.MONTH);
            mDay = ca.get(Calendar.DAY_OF_MONTH);


        }



    public String getJson(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = Main3Activity.this.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
                Log.d("AAA", line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


        @Override
        protected Dialog onCreateDialog(int id) {
            switch (id) {
                case DATE_DIALOG:
                    return new DatePickerDialog(this, mdateListener, mYear, mMonth, mDay);
            }
            return null;
        }

        /**
         * 设置日期 利用StringBuffer追加
         */
        public void display() {
            dateDisplay.setText(new StringBuffer().append(mYear).append("-").append(mMonth+1).append("-").append(mDay).append(" "));
        }

        private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
                mYear = year;
                mMonth = monthOfYear;
                mDay = dayOfMonth;
                display();
            }
        };
       /* public void save(Context context, String jsonString) throws IOException {
            File rootFolder = context.getExternalCacheDir();
            File jsonFile = new File(rootFolder, "assets/"+"text.json");
            FileWriter writer = new FileWriter(jsonFile);
            writer.write(jsonString);
            writer.close();
            //or IOUtils.closeQuietly(writer);
        }*/

        public boolean writeFile(String filePath, String sets) {
            FileWriter fw;
            try {
                fw = new FileWriter(filePath,true);
                PrintWriter out = new PrintWriter(fw);
                out.write(sets);
                out.println();
                fw.close();
                out.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();

                return false;
            }

        }




    }
