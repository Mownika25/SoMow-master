package com.example.android.somow;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.android.somow.MainActivity;
import com.example.android.somow.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;

public class dashboard extends AppCompatActivity {
    ListView listView;
    private DatabaseReference mDatabaseRef;
    private ChildEventListener mchild;
    private StorageReference mStorageRef;


    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);





       drawer = findViewById(R.id.drawer);

        NavigationView navigationView = findViewById(R.id.nav);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                      //  menuItem.setChecked(true);
                        // close drawer when item is tapped
                        drawer.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        int id = menuItem.getItemId();
                        if (id == R.id.action_new) {
                            Intent t=new Intent(dashboard.this,newauctions.class);
                            startActivity(t);
                        }
                        if (id == R.id.action_mine) {
                            Intent t=new Intent(dashboard.this,myauctions.class);
                            startActivity(t);
                        }
                        if (id == R.id.action_history) {
                            Intent t=new Intent(dashboard.this,history.class);
                            startActivity(t);
                        }

                        return true;
                    }
                });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.app_bar_icons,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();
        if(id==R.id.sign_out) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(dashboard.this,MainActivity.class));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}