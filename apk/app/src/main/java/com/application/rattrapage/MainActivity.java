package com.application.rattrapage;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    public static ArrayList<Cours> cours = new ArrayList<>();
    public static boolean loadAll = true;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_to_home:
                        loadFragment(new HomeFragment());
                        performToast("Home");
                        break;
                    case R.id.menu_to_calendar:
                        loadFragment(new PlaningFragment());
                        performToast("Planing");
                        break;
                    case R.id.menu_to_settings:
                        loadFragment(new AccountFragment());
                        performToast("Account");
                        break;
                    case R.id.menu_to_details:
                        loadFragment(new TopCoursesFragment());
                        performToast("Top courses");
                        break;
                }
                return true;
            }
        });

        if (loadAll){
            loadCourses();
        }else{
            load();
        }
    }


    private void loadFragment(Fragment fragment){
        if (fragmentManager == null)
            fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
        transaction.replace(R.id.frame_holder,fragment);
        transaction.commit();
    }

    private void performToast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }

    private void loadCourses(){
        StringRequest stringRequestCours = new StringRequest(Request.Method.POST, VolleySingleton.BASE_URL+"get_cours.php", response -> {
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(response);
                int success = jsonObject.getInt("success");
                if (success == 1){
                    JSONArray data = jsonObject.getJSONArray("datas");
                    for (int i = 0; i<data.length();i++){
                        JSONObject obj = data.getJSONObject(i);

                        Cours c = jsonToCours(obj);
                        cours.add(c);
                    }
                }
                loadFragment(new HomeFragment());

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, error -> error.printStackTrace());

        stringRequestCours.setRetryPolicy(new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleySingleton.getInstance(this).getRequestQueue().add(stringRequestCours);

    }

    private void load(){
        Toast.makeText(this,"Filter",Toast.LENGTH_LONG).show();
        StringRequest stringRequestCours = new StringRequest(Request.Method.POST, VolleySingleton.BASE_URL+"get_apprenant_cours.php", response -> {
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(response);
                int success = jsonObject.getInt("success");
                if (success == 1){
                    JSONArray data = jsonObject.getJSONArray("datas");
                    for (int i = 0; i<data.length();i++){
                        JSONObject obj = data.getJSONObject(i);

                        Cours c = jsonToCours(obj);
                        cours.add(c);
                    }
                }
                loadFragment(new HomeFragment());

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, error -> error.printStackTrace()){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("apprenant_id","1");
                return params;
            }
        };

        stringRequestCours.setRetryPolicy(new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleySingleton.getInstance(this).getRequestQueue().add(stringRequestCours);

    }

    public Cours jsonToCours(JSONObject jsonObject){
        Cours cours = null;

        try {
            cours = new Cours();
            cours.setId(jsonObject.getInt("id"));
            cours.setName(jsonObject.getString("nom"));
            cours.setLevel(jsonObject.getString("niveau"));
            cours.setType(jsonObject.getString("type"));
            cours.setDescription(jsonObject.getString("description"));
            cours.setPrice(jsonObject.getInt("prix"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cours;
    }




}
