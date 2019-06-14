package com.example.eva.bats;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,AsyncResponse {

    public GoogleMap mMap;
    String name;
    String loc;
    Double a,b;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        name = getIntent().getStringExtra("NAME");

        adi();
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
                                if(count%5==0) {
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
       // t.start();
    }
    private void adi() {
        // textView4.setText(textView3.getText());
        HashMap postData = new HashMap();
        postData.put("names", name);
        // PostResponseAsyncTask task=new PostResponseAsyncTask(this)
        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
        task.execute("https://stockernet.000webhostapp.com/client/pos.php");
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng vidya = new LatLng(10.626772, 76.144730);
        mMap.addMarker(new MarkerOptions().position(vidya).title("VAST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vidya, 16));
        LatLng stop1 = new LatLng(10.469996, 76.243689);
        mMap.addMarker(new MarkerOptions().position(stop1).title("Busstop").icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop)));
        LatLng stop2 = new LatLng(10.475632, 76.240492);
        mMap.addMarker(new MarkerOptions().position(stop2).title("Busstop").icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop)));
        //LatLng bus = new LatLng(a, b);
       // mMap.addMarker(new MarkerOptions().position(bus).title("bus"));
      //  LatLng bus1 = new LatLng(10.468142, 76.246037);
      //  mMap.addMarker(new MarkerOptions().position(bus1).title("Bus1"));

    }
    @Override
    public void processFinish(String s)
    {
        if(!(s.equals("failed")))
        {
            String[] strings = s.split(", ");
            a= Double.parseDouble(strings[0]);
            b= Double.parseDouble(strings[1]);
            LatLng bus = new LatLng(a,b);
            mMap.addMarker(new MarkerOptions().position(bus).title("VAST").icon(BitmapDescriptorFactory.fromResource(R.drawable.busicon)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bus, 18));
        }
        else
        {
            new AlertDialog.Builder(this).setTitle(name + "  is offline").setMessage("the bus is offline").setPositiveButton("Go back",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface diag, int which)
                {
                    Intent intent = new Intent(MapsActivity.this,User.class);
                    startActivity(intent);
                }
            }).setNegativeButton("check Map",null).create().show();

        }

    }
}
