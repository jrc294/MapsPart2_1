package com.learning.jonathan.mapspart2_1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap m_map;
    boolean mapReady = false;

    MarkerOptions renton;
    MarkerOptions kirkland;
    MarkerOptions everett;
    MarkerOptions lynnwood;
    MarkerOptions montlake;
    MarkerOptions kent;
    MarkerOptions showare;

    static final CameraPosition SEATTLE = CameraPosition.builder()
            .target(new LatLng(47.6284,-122.2491))
            .zoom(10)
            .bearing(0)
            .tilt(45)
            .build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        renton = new MarkerOptions().position(new LatLng(47.489805, -122.120502)).title("Renton").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        kirkland = new MarkerOptions().position(new LatLng(47.7301986, -122.1768858)).title("Kirkland").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        everett = new MarkerOptions().position(new LatLng(47.978748, -122.202001)).title("Everett").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        lynnwood = new MarkerOptions().position(new LatLng(47.819533, -122.32288)).title("Lynnwood").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        montlake = new MarkerOptions().position(new LatLng(47.7973733, -122.3281771)).title("Montlake").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        kent = new MarkerOptions().position(new LatLng(47.385938, -122.258212)).title("Kent").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        showare = new MarkerOptions().position(new LatLng(47.38702, -122.23985)).title("Showare").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        m_map = googleMap;
        m_map.addMarker(renton);
        m_map.addMarker(kirkland);
        m_map.addMarker(everett);
        m_map.addMarker(lynnwood);
        m_map.addMarker(montlake);
        m_map.addMarker(kent);
        m_map.addMarker(showare);
        flyTo(SEATTLE);
    }

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
