package com.example.eva.bats;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class User extends AppCompatActivity implements AsyncResponse {

    int count=0;
    TextView textView5,textView6;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18;
    int back =R.drawable.button_change;
    int off =R.drawable.circle_button;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        b1 =(Button) findViewById(R.id.button2);
        b2 =(Button) findViewById(R.id.button41);
        b3 =(Button) findViewById(R.id.button42);
        b4 =(Button) findViewById(R.id.button43);
        b5 =(Button) findViewById(R.id.button44);
        b6 =(Button) findViewById(R.id.button45);
        b7 =(Button) findViewById(R.id.button46);
        b8 =(Button) findViewById(R.id.button47);
        b9 =(Button) findViewById(R.id.button48);
        b10 =(Button) findViewById(R.id.button49);
        b11=(Button) findViewById(R.id.button50);
        b12 =(Button) findViewById(R.id.button51);
        b13 =(Button) findViewById(R.id.button52);
        b14 =(Button) findViewById(R.id.button53);
        b15 =(Button) findViewById(R.id.button54);
        b16 =(Button) findViewById(R.id.button55);
        b17 =(Button) findViewById(R.id.button56);
        b18 =(Button) findViewById(R.id.button39);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news(b1.getHint().toString());
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news(b2.getHint().toString());
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news(b3.getHint().toString());
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news(b4.getHint().toString());
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news(b5.getHint().toString());
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news(b6.getHint().toString());
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news(b7.getHint().toString());
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news(b8.getHint().toString());
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news(b9.getHint().toString());
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news(b10.getHint().toString());
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news(b11.getHint().toString());
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news(b12.getHint().toString());
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news(b13.getHint().toString());
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news(b14.getHint().toString());
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news(b15.getHint().toString());
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news(b16.getHint().toString());
            }
        });
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news(b17.getHint().toString());
            }
        });
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news(b18.getHint().toString());
            }
        });


        Thread t = new Thread()
        {
            @Override
            public void run()
            {
                while (!isInterrupted())
                {
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count++;
                                //textView5.setText("bus5");
                                 if(count%25==0) {
                                adi();
                                 }
                            }


                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                };


            }


        };

        adi();
       t.start();
   }
    public void news(String hints)
    {
        Intent intent= new Intent(User.this,MapsActivity.class);
        intent.putExtra("NAME",hints);
        startActivity(intent);

    }
    private void adi()
    {
        PostResponseAsyncTask task = new PostResponseAsyncTask(this);
        task.execute("https://stockernet.000webhostapp.com/client/online.php");
    }


    @Override
    public void processFinish(String s)
    {

        Boolean bus1,bus2,bus3,bus4,bus5,bus6,bus7,bus8,bus9,bus10,bus11,bus12,bus13,bus14,bus15,bus16,bus17,bus18;
        bus1 = s.contains("bus1b");
        bus2 = s.contains("bus2");
        bus3 = s.contains("bus3");
        bus4 = s.contains("bus4");
        bus5 = s.contains("bus5");
        bus6 = s.contains("bus6");
        bus7 = s.contains("bus7");
        bus8 = s.contains("bus8");
        bus9 = s.contains("bus9");
        bus10 = s.contains("bus10");
        bus11 = s.contains("bus11");
        bus12 = s.contains("bus12");
        bus13 = s.contains("bus13");
        bus14 = s.contains("bus14");
        bus15 = s.contains("bus15");
        bus16 = s.contains("bus16");
        bus17 = s.contains("bus17");
        bus18 = s.contains("bus18");

        if (bus1 == true)
        {
            b1.setBackgroundResource(back);
        }
        else{

            b1.setBackgroundResource(off);
        }
        if (bus2 == true)
        {
            b2.setBackgroundResource(back);
        }
        else{

            b2.setBackgroundResource(off);
        }
        if (bus3 == true)
        {
            b3.setBackgroundResource(back);
        }
        else{

            b3.setBackgroundResource(off);
        }
        if (bus4 == true)
        {
            b4.setBackgroundResource(back);
        }
        else{

            b4.setBackgroundResource(off);
        }
        if (bus5 == true)
        {
            b5.setBackgroundResource(back);
        }
        else{

            b5.setBackgroundResource(off);
        }
        if (bus6 == true)
        {
            b6.setBackgroundResource(back);
        }
        else{

            b6.setBackgroundResource(off);
        }
        if (bus7 == true)
        {
            b7.setBackgroundResource(back);
        }
        else{

            b7.setBackgroundResource(off);
        }
        if (bus8 == true)
        {
            b8.setBackgroundResource(back);
        }
        else{

            b8.setBackgroundResource(off);
        }
        if (bus9 == true)
        {
            b9.setBackgroundResource(back);
        }
        else{

            b9.setBackgroundResource(off);
        }
        if (bus10 == true)
        {
            b10.setBackgroundResource(back);
        }
        else{

            b10.setBackgroundResource(off);
        }
        if (bus11 == true)
        {
            b11.setBackgroundResource(back);
        }
        else{

            b11.setBackgroundResource(off);
        }
        if (bus12 == true)
        {
            b12.setBackgroundResource(back);
        }
        else{

            b12.setBackgroundResource(off);
        }
        if (bus13 == true)
        {
            b13.setBackgroundResource(back);
        }
        else{

            b13.setBackgroundResource(off);
        }
        if (bus14 == true)
        {
            b14.setBackgroundResource(back);
        }else{

            b14.setBackgroundResource(off);
        }
        if (bus15 == true)
        {
            b15.setBackgroundResource(back);
        }
        else{

            b15.setBackgroundResource(off);
        }
        if (bus16 == true)
        {
            b16.setBackgroundResource(back);
        }
        else{

            b16.setBackgroundResource(off);
        }
        if (bus17 == true)
        {
            b17.setBackgroundResource(back);
        }
        else{

            b17.setBackgroundResource(off);
        }
        if (bus18 == true)
        {
            b18.setBackgroundResource(back);
        }
        else{

            b18.setBackgroundResource(off);
        }
    }
}
