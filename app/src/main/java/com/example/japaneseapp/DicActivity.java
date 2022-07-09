package com.jmaster.japaneseapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DicActivity extends AppCompatActivity {

    EditText editTextSearch;
    Button btnSearch;
    TextView txtResults;
    private AdView adView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dic);
        editTextSearch = (EditText)findViewById(R.id.editTxtSearch);
        btnSearch = (Button)findViewById(R.id.btnSubmit);
        txtResults = (TextView) findViewById(R.id.txtViewResults);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        adView1 = findViewById(R.id.banner1);
        MobileAds.initialize(this);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView1.loadAd(adRequest);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(editTextSearch.getText().toString())){
                    Toast.makeText(DicActivity.this,"No empty keyboard allowed",Toast.LENGTH_SHORT).show();
                }
                else{
                    DatabaseReference mRef = FirebaseDatabase.getInstance().getReference("meaning");
                    mRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String searchKeyword = editTextSearch.getText().toString();
                            if(dataSnapshot.child(editTextSearch.getText().toString()).exists()){
                                txtResults.setText(dataSnapshot.child(searchKeyword).getValue().toString().replace("&","\n"));
                            }else {
                                Toast.makeText(DicActivity.this, "No search results found", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
            }
        });
    }
}
