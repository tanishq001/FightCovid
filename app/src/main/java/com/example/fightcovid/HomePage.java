package com.example.fightcovid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class HomePage extends AppCompatActivity {
MaterialToolbar toolbar;
//DrawerLayout drawerLayout;
NavigationView navigationView;
FloatingActionButton floatingActionButton;
Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        toolbar=findViewById(R.id.topAppBar);
//        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navigation);
        floatingActionButton = findViewById(R.id.floating_action_button);

        floatingActionButton.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                addRequestDialog();
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                navigation();
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener( ) {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()==R.id.search){
                    search();
                }
                return false;
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener( ) {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.close){
                    closeNavigation();
                }
                item.setChecked(true);
                return false;
            }
        });
    }

    private void addRequestDialog() {
        dialog=new Dialog(this);
        dialog.setContentView(R.layout.addrequest);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        EditText description = dialog.findViewById(R.id.addDes);
        Button location = dialog.findViewById(R.id.addLocation);
        Button post = dialog.findViewById(R.id.postButton);
        Button close = dialog.findViewById(R.id.closeDialog);
        dialog.show();

        post.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                String sdescription =description.getText().toString();
            }
        });
        close.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(HomePage.this,"Closed",Toast.LENGTH_SHORT).show();

            }
        });
        location.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void closeNavigation() {
        navigationView.setVisibility(View.INVISIBLE);
    }

    private void navigation() {
//        drawerLayout.openDrawer(Gravity.LEFT);
        navigationView.setVisibility(View.VISIBLE);
    }

    private void search() {
        Toast.makeText(HomePage.this,"Search For Help",Toast.LENGTH_SHORT).show();
    }
}