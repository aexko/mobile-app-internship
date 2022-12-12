package ca.qc.bdeb.c5gm.zoeken;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;

import ca.qc.bdeb.c5gm.zoeken.databinding.ActivityMapsBinding;

// SOURCE: Exemple du professeur

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int LOCATION_REQUEST_CODE = 101;

    private ActivityMapsBinding binding;
    private GoogleMap googleMap;
    private FusedLocationProviderClient fusedLocationProviderClient;

//    private ArrayList<String> nom_compagnie, adresse, ville, code_postal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        // demande des permissions avant d'accéder à l'activité
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.
                            ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    LOCATION_REQUEST_CODE);

        } else {
            activerLocalisation();
        }

        mettreMarqueurs();

    }

    /**
     * Met les marqueurs de l'emplacement des compagnies
     */
    private void mettreMarqueurs() {
        for (int i = 0; i < 4; i++) {
            String nom_compagnie = getIntent().getStringExtra("nom_compagnie");
            String adresse = getIntent().getStringExtra("adresse");
            String ville = getIntent().getStringExtra("ville");
            String code_postal = getIntent().getStringExtra("code_postal");
            Log.d("nomCompagnie", "mettreMarqueurs: " + nom_compagnie);
        }
//        ZoekenDatabaseHelper bd = new ZoekenDatabaseHelper(MapsActivity.this);
//        Cursor curseur = bd.lireBd();
//        if (curseur.getCount() != 0) {
//            while (curseur.moveToNext()) {
//                nom_compagnie.add(curseur.getString(1));
//                adresse.add(curseur.getString(6));
//                ville.add(curseur.getString(7));
//                code_postal.add(curseur.getString(8));
//                System.out.println( nom_compagnie.add(curseur.getString(1)));
//            }
//        } else {
//            Toast.makeText(this, "Aucune compagnie à afficher", Toast.LENGTH_SHORT).show();
//        }
        // loop dans un array qui contient tous les compagnies

//        https://stackoverflow.com/questions/15731029/array-list-intent-extra-in-java
        LatLng collegeBdeB = new LatLng(45.5380, -73.6760);
        googleMap.addMarker(new MarkerOptions().position(collegeBdeB)
                .title("Collège Bois-de-Boulogne"));
    }

    /**
     * Permet la localisation de l'appareil si les permissions sont autorisées
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == LOCATION_REQUEST_CODE) {
            if (isPermissionAuth(permissions, grantResults,
                    Manifest.permission.ACCESS_FINE_LOCATION) || isPermissionAuth(permissions,
                    grantResults, Manifest.permission.ACCESS_COARSE_LOCATION)) {
                activerLocalisation();
            }
        }
    }

    /**
     * Vérifie les permissions
     *
     * @param permissions
     * @param grantResults
     * @param accessLocation
     * @return
     */
    private boolean isPermissionAuth(String[] permissions, int[] grantResults,
                                     String accessLocation) {
        for (int i = 0; i < permissions.length; i++) {
            if (permissions[i].compareToIgnoreCase(accessLocation) == 0) {
                return grantResults[i] == PackageManager.PERMISSION_GRANTED;
            }
        }
        return false;
    }

    /**
     * Permet la localisation de l'appareil
     */
    @SuppressLint("MissingPermission")
    private void activerLocalisation() {
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this,
                new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            LatLng position = new LatLng(location.getLatitude(),
                                    location.getLongitude());
                            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position,
                                    12));
                        }
                    }
                });
        if (googleMap != null) {
            googleMap.setMyLocationEnabled(true);
        }
    }


//    private void activerLocalisation() {
//        @SuppressLint("MissingPermission") Task<Location> task = fusedLocationProviderClient.getLastLocation();
//        task.addOnSuccessListener(new OnSuccessListener<Location>() {
//            @Override
//            public void onSuccess(final Location location) {
//                if (location != null) {
//                    supportMapFragment.getMapAsync(new OnMapReadyCallback() {
//                        @Override
//                        public void onMapReady(@NonNull GoogleMap googleMap) {
//                            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
//                            MarkerOptions options = new MarkerOptions().position(latLng).title("Ma position");
//                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
//                            googleMap.addMarker(options);
//                        }
//                    });
//                }
//            }
//        });
//    }

}