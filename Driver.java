package com.example.eva.bats;


        import android.*;
        import android.Manifest;
        import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.location.Location;
        import android.location.LocationListener;
        import android.location.LocationManager;
        import android.os.Build;
        import android.provider.Settings;
        import android.support.annotation.Nullable;
        import android.support.v4.app.ActivityCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.kosalgeek.asynctask.AsyncResponse;
        import com.kosalgeek.asynctask.PostResponseAsyncTask;

        import java.util.HashMap;

public class Driver extends AppCompatActivity implements AsyncResponse, View.OnClickListener {

    public Button button;
    public LocationManager locationManager,ad;
    public LocationListener listener;
    public  TextView t1,t2,t3;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);

        t1 = (TextView) findViewById(R.id.textView3);
        t2 = (TextView) findViewById(R.id.textView4);
        t3 = (TextView) findViewById(R.id.textView);

        button = (Button) findViewById(R.id.button4);
       button.setOnClickListener(this);
        t3.setText(getIntent().getStringExtra("NAME"));

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                // textView.append("\n " + location.getLongitude() + " " + location.getLatitude());
                String total2 = String.valueOf(location.getLatitude());
                String total = String.valueOf(location.getLongitude());
                t1.setText(total+", "+total2);
                adi();


            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);
            }
        };
        adipoli();
    }
    public void adipoli()
    {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            {

                requestPermissions(new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET}, 10);
            }
            return;
        }
        locationManager.requestLocationUpdates("gps", 5000, 0, listener);
       // t1.setText(locationManager.toString());


    }
    private void adi()
    {
        // textView4.setText(textView3.getText());
        HashMap postData = new HashMap();
        postData.put("position", t1.getText().toString());
        postData.put("name", t3.getText().toString());

        // PostResponseAsyncTask task=new PostResponseAsyncTask(this)
        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
        task.execute("https://stockernet.000webhostapp.com/client/loc.php");
    }

    @Override
    public void processFinish(String s)
    {
        t2.setText(s);

    }
    @Override
    public void onClick(View v) {
        HashMap postDatas = new HashMap();
        postDatas.put("name", t3.getText().toString());

        // PostResponseAsyncTask task=new PostResponseAsyncTask(this)
        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postDatas);
        task.execute("https://stockernet.000webhostapp.com/client/logout.php");
        Intent intent = new Intent(Driver.this,LoginActivity.class);
        startActivity(intent);
    }

}
