package com.eict.webbrowserapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.eict.webbrowserapp.databinding.ActivityHomeBinding;

import java.util.List;

public class Home extends AppCompatActivity {


    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = getLayoutInflater().inflate(R.layout.activity_home, null, false);
        setContentView(view);
        binding = ActivityHomeBinding.bind(view);

        binding.tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
            }
        });
        binding.search.setOnClickListener(this);
    }




    private void openWebsite() {
        String Url_Address = binding.text.getText().toString();
        if (TextUtils.isEmpty(Url_Address)) {
            Toast empty = Toast.makeText(Home.this, "Please enter Url or Web address", Toast.LENGTH_LONG);
            empty.show();
        } else {
            Intent search = new Intent(Home.this, UrlSearch.class);
            search.putExtra("url_address", "Url_Address");
            startActivity(search);
        }
    }
    private List<DefaultUrlEntity> defaultUrlEntities;

    public interface UrlClickListener {
         void onClick(int pos);
    }
}