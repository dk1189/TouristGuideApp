package pvc.applikation;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.*;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapsActivity extends Activity implements OnMapReadyCallback {

    TextView final_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_map);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);

        onMapReady(mapFragment.getMap());


    }


    @Override
    public void onMapReady(GoogleMap map) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(48.774232, 9.182537), 13));

        // You can customize the marker image using images bundled with
        // your app, or dynamically generated bitmaps.
        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.780215, 9.172672))
                .title("Hochschule für Technik Stuttgart"))
                .setSnippet("Schellingstr. 24");

        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.778525, 9.179702))
                .title("Schlossplatz"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.citysquare));

        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.8005461, 9.20591))
                .title("Schloss Rosenstein"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.citysquare));

        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.790216, 9.183022))
                .title("Stadtbibliothek Stuttgart"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.library));

        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.755601, 9.189134))
                .title("Fernsehturm"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.tower));

        /*map.addMarker(new MarkerOptions()
                .position(new LatLng(48.778919, 9.183205))
                .title("Landtag Baden-Württemberg"));*/

        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.7824661, 9.182158))
                .title("Touristen Information"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.information));


        //EINKAUFEN
        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.7824091, 9.181874))
                .title("Königstraße und Umgebung"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.mall));

        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.790676, 9.181450))
                .title("MILANEO"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.mall));

        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.771458, 9.172468))
                .title("Gerber"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.mall));

        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.779083, 178259))
                .title("KönigsbauPassagen"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.mall));


        //GASTRONOMIE
        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.779979, 9.177996))
                .title("5 Cafe Bar Restaurant"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.restaurant));

        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.780107, 9.177680))
                .title("Brauhaus Schönbuch"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.bar));

        //KULTUR UND TEATHER
               //KINO
        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.793640, 9.191668))
                .title("Ufa-Palast"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.cinema));

        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.779622, 9.179321))
                .title("Innenstadt Kinos"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.cinema));

        //MUSEEN
        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.788785, 9.235010))
                .title("Mercedes-Benz Museum"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.historicalquarter));

        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.834514, 9.151926))
                .title("Porsche Museum"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.historicalquarter));

        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.777199, 9.178968))
                .title("Altes Schloss/Landesmuseum"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.historicalquarter));

        //map.addMarker(new MarkerOptions()
                //.position(new LatLng(48.780949, 9.186604))
                //.title("Staatsgalerie"));

        //THEATER
        map.addMarker(new MarkerOptions()
        .position(new LatLng(48.780240, 9.184431))
        .title("Staatstheater"))
        .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.theater));

        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.810632, 9.179364))
                .title("Theaterhaus"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.theater));

        //ZOO
        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.804070, 9.207977))
                .title("Wilhelma"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.zoo));

        //MESSE und FLUGHAFEN
        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.691701, 9.189355))
                .title("Flughafen und Messe"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.airport));

        //PARKS
        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.806851, 9.189754))
                .title("Rosensteinpark"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.citysquare));

        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.769603, 9.163972))
                .title("Karlshöhe"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.citysquare));


        //PARKHÄUSER
        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.780037, 9.172893))
                .title("Parkhaus Hofdienergarage"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.parkinggarage));

        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.779414, 9.168422))
                .title("APCOA Parkhaus Liederhalle-Bosch Areal"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.parkinggarage));

        map.addMarker(new MarkerOptions()
                .position(new LatLng(48.782542, 9.176243))
                .title("APCOA Parkhaus City Garage"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.parkinggarage));


    }


    public void buttonOnClick(View v){
        setContentView(R.layout.kategorien);

    }

}


