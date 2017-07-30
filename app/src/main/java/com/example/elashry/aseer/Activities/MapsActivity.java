package com.example.elashry.aseer.Activities;

import android.Manifest;
import android.app.ActionBar;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.elashry.aseer.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import static android.R.attr.action;
import static com.example.elashry.aseer.Activities.Select.y;
import static com.example.elashry.aseer.dataProccess.JsonParser.latitudesc;
import static com.example.elashry.aseer.dataProccess.JsonParser.longitudesc;


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


       /* face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
                startActivity(intent);

            }
        });

        snap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.snapchat.com"));
                startActivity(intent);

            }
        });

        tube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com"));
                startActivity(intent);

            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+966 14 832 0405"));
                startActivity(intent);

            }
        });

*/
        // getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //   getSupportActionBar().setDisplayShowCustomEnabled(true);
        //  getSupportActionBar().setCustomView(R.layout.custom_actionbar);

        // View view =getSupportActionBar().getCustomView();

//        ImageButton imageButton= (ImageButton)view.findViewById(R.id.contact);
//
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//
//        ImageButton imageButton2= (ImageButton)view.findViewById(R.id.contact);
//
//        imageButton2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Toast.makeText(getApplicationContext(),"Forward Button is clicked",Toast.LENGTH_LONG).show();
//            }
//        });



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
//        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
//            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
//                @Override
//                public void onLocationChanged(Location location) {
//                    double latitude=location.getLatitude();
//                    double longitude=location.getLongitude();
//                    LatLng lating =new LatLng(latitude,longitude);
//                    Geocoder geocoder=new Geocoder(getApplicationContext());
//                    try {
//                        List<Address> addressList=geocoder.getFromLocation(latitude,longitude,1);
//                        String str =addressList.get(0).getLocality()+" ,";
//                        str+=addressList.get(0).getCountryName();
//                        mMap.addMarker(new MarkerOptions().position(lating).title(str));
//                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lating,18));
//                      //  mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//
//                @Override
//                public void onStatusChanged(String provider, int status, Bundle extras) {
//
//                }
//
//                @Override
//                public void onProviderEnabled(String provider) {
//
//                }
//
//                @Override
//                public void onProviderDisabled(String provider) {
//
//                }
//            });
//        }else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
//            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
//                @Override
//                public void onLocationChanged(Location location) {
//
//                }
//
//                @Override
//                public void onStatusChanged(String provider, int status, Bundle extras) {
//
//                }
//
//                @Override
//                public void onProviderEnabled(String provider) {
//
//                }
//
//                @Override
//                public void onProviderDisabled(String provider) {
//
//                }
//            });
//        }

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
            Intent i1 =new Intent(MapsActivity.this,Arcmenu.class);
            startActivity(i1);
        LatLng Soudia = new LatLng(27.510612, 41.681779);

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
            case R.id.help:
               // Toast.makeText(this, emailsc, Toast.LENGTH_SHORT).show();

//                Intent intent4 = new Intent(Intent.ACTION_DIAL, Uri.parse(emailsc));
//                startActivity(intent4);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}




/*
package com.example.elashry.aseer.Activities;

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
import android.widget.ImageButton;

import com.example.elashry.aseer.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import static com.example.elashry.aseer.Activities.Arcmenu.x;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LocationManager locationManager;


    ImageButton face, youtube, snap, call, help;
    com.sa90.materialarcmenu.ArcMenu arcMenuAndroid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        setTitle(getIntent().getStringExtra("title"));


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling

            return;
        }

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        LatLng Soudia = new LatLng(24.444818, 39.535823);
        mMap.addMarker(new MarkerOptions().position(Soudia).title("ثانوي بنين"));
        mMap.addPolyline(new PolylineOptions().add(

        ));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Soudia, 18));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling

            return;
        }
        mMap.setMyLocationEnabled(true);
       */
/* if (x.equals("1")) {
            mMap = googleMap;

            LatLng Soudia = new LatLng(24.444818, 39.535823);
            mMap.addMarker(new MarkerOptions().position(Soudia).title("ثانوي بنين"));
            mMap.addPolyline(new PolylineOptions().add(

            ));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Soudia, 18));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling

                return;
            }
            mMap.setMyLocationEnabled(true);  } else if (x.equals("2")) {
            mMap = googleMap;

            LatLng Soudia = new LatLng(24.475944, 39.552578);
            mMap.addMarker(new MarkerOptions().position(Soudia).title("ابتدائي بنين"));
            mMap.addPolyline(new PolylineOptions().add(

            ));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Soudia, 18));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling

                return;
            }
            mMap.setMyLocationEnabled(true);  } else if (x.equals("3")) {
            mMap = googleMap;

            LatLng Soudia = new LatLng(24.4978932, 39.6085078);
            mMap.addMarker(new MarkerOptions().position(Soudia).title("بنات"));
            mMap.addPolyline(new PolylineOptions().add(

            ));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Soudia, 18));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling

                return;
            }
            mMap.setMyLocationEnabled(true);    }
*//*


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (x.equals("1")) {
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
                Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+966 14 832 0405"));
                startActivity(intent2);
                break;
            case R.id.snapchat:
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.snapchat.com"));
                startActivity(intent3);
                break;
            case R.id.help:
                Intent intent4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+966 14 832 0405"));
                startActivity(intent4);
                break;
        }

        } else if (x.equals("2")) {
            switch (item.getItemId()) {
            case R.id.facebook:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Eng.asmaa.Ellotf"));
                startActivity(intent);
                break;
            case R.id.youtube:
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com"));
                startActivity(intent1);

                break;
            case R.id.call:
                Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+966 14 832 0405"));
                startActivity(intent2);
                break;
            case R.id.snapchat:
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.snapchat.com"));
                startActivity(intent3);
                break;
            case R.id.help:
                Intent intent4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+966 14 832 0405"));
                startActivity(intent4);
                break;
         }} else if (x.equals("2")) {
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
                    Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+966 14 832 0405"));
                    startActivity(intent2);
                    break;
                case R.id.snapchat:
                    Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.snapchat.com"));
                    startActivity(intent3);
                    break;
                case R.id.help:
                    Intent intent4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+966 14 832 0405"));
                    startActivity(intent4);
                    break;
            }}

        return super.onOptionsItemSelected(item);
    }


}
*/
