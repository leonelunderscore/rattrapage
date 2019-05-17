package com.application.rattrapage;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DetailsActivity extends AppCompatActivity {

    ImageView img_back;
    Button button_register;
    TextView description,price_cours,level_cours,nom_cours;
    ConstraintLayout header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        header = findViewById(R.id.header);

        Cours cours = getIntent().getParcelableExtra("COURS");


        int nbre = getRandomDoubleBetweenRange(1,3);
        switch (nbre){
            case 1:
                header.setBackgroundResource(R.drawable.img1);
                break;
            case 2:
                header.setBackgroundResource(R.drawable.img2);
                break;
            case 3:
                header.setBackgroundResource(R.drawable.img3);
                break;
        }

        description = findViewById(R.id.description_cours);
        price_cours = findViewById(R.id.price_cours);
        level_cours = findViewById(R.id.level_cours);
        nom_cours = findViewById(R.id.nom_cours);
        description.setText(cours.getDescription());
        price_cours.setText(cours.getPrice()+ " XAF");
        level_cours.setText(cours.getLevel());
        nom_cours.setText(cours.getName());
        img_back = findViewById(R.id.img_back);
        button_register = findViewById(R.id.button_register);


        img_back.setOnClickListener((v)->{
            this.onBackPressed();
        });

        button_register.setOnClickListener((v)->{
            subscribe(cours);
        });
    }


    private int getRandomDoubleBetweenRange(double min, double max){
        double x = (Math.random()*((max-min)+1))+min;
        return (int) x;
    }

    private void displayDialog(String title, String msg, @DrawableRes int icon){
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(msg)

                .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                    switch (icon){
                        case android.R.drawable.ic_dialog_info:
                            MainActivity.loadAll = false;
                            startActivity(new Intent(this,MainActivity.class));
                            break;
                        case android.R.drawable.ic_dialog_alert:
                            this.onBackPressed();
                            break;
                    }
                })

                .setIcon(icon)
                .show();
    }

    private void subscribe(Cours cours){
        StringRequest stringRequestCours = new StringRequest(Request.Method.POST, VolleySingleton.BASE_URL+"add_apprenant_cours.php", response -> {
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(response);
                int success = jsonObject.getInt("success");
                if (success == 1){
                    displayDialog("Félicitations","Vous avez été inscrit au cours "+cours.getName(),android.R.drawable.ic_dialog_info);
                }
                else if(success == 2){
                    displayDialog("Désolé","Vous êtes déjà inscrit à ce cours",android.R.drawable.ic_dialog_alert);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, error -> error.printStackTrace()){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("apprenant_id","1");
                params.put("cours_id",cours.getId()+"");
                return params;
            }
        };

        stringRequestCours.setRetryPolicy(new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleySingleton.getInstance(this).getRequestQueue().add(stringRequestCours);
    }
}
