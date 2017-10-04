package com.alatheer.anwaralfyaha.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import com.alatheer.anwaralfyaha.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import static com.alatheer.anwaralfyaha.Activities.PaySchool.slatitude;
import static com.alatheer.anwaralfyaha.Activities.PaySchool.slongitude;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LocationManager locationManager;
    //ImageView contact;

  //  ImageButton face,youtube,snap,call,help;
    com.sa90.materialarcmenu.ArcMenu arcMenuAndroid;
    ImageView face, snap, tube;
    TextView phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

//        face = (ImageButton) findViewById(R.id.facebook);
//        youtube = (ImageButton) findViewById(R.id.youtube);
//        snap = (ImageButton) findViewById(R.id.snapchat);
//        call = (ImageButton) findViewById(R.id.call);
//        help = (ImageButton) findViewById(R.id.call);

        setTitle(getIntent().getStringExtra("title"));

        face = (ImageView) findViewById(R.id.facebook);
        snap = (ImageView) findViewById(R.id.snapchat);
        tube = (ImageView) findViewById(R.id.youtube);
       // phone = (TextView) findViewById(R.id.phone1);






        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }


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
       /* if(y.equals("2")|y.equals("3")){
            LatLng Soudia = new LatLng(latitudesc, longitudesc);

            mMap.addMarker(new MarkerOptions().position(Soudia).title("Marker in Soudia"));
            mMap.addPolyline(new PolylineOptions().add(

            ));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Soudia, 18));
        }else {*/

        LatLng Soudia = new LatLng(slatitude, slongitude);

      //  Toast.makeText(this, phonesc, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, (int) latitudesc, Toast.LENGTH_SHORT).show();
     //   Toast.makeText(this, emailsc, Toast.LENGTH_SHORT).show();

        mMap.addMarker(new MarkerOptions().position(Soudia).title("Marker in Soudia"));
        mMap.addPolyline(new PolylineOptions().add(

        ));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Soudia, 18));
    //}
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.list, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.facebook:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
                startActivity(intent);
                break;
            case R.id.youtube:
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com"));
                startActivity(intent1);

                break;
            case R.id.call:
              //  Toast.makeText(this, phonesc, Toast.LENGTH_SHORT).show();
//                Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse(phonesc));
//                startActivity(intent2);
                break;
            case R.id.snapchat:
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.snapchat.com"));
                startActivity(intent3);
                break;
         //   case R.id.help:
               // Toast.makeText(this, emailsc, Toast.LENGTH_SHORT).show();

//                Intent intent4 = new Intent(Intent.ACTION_DIAL, Uri.parse(emailsc));
//                startActivity(intent4);
              //  break;
        }

        return super.onOptionsItemSelected(item);
    }


}


