package com.example.android.somow;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.util.Log;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

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

        String DATABASE_PATH = "images";
        mDatabaseRef = FirebaseDatabase.getInstance().getReference(DATABASE_PATH);
        listView = (ListView) findViewById(R.id.listview);
        mStorageRef = FirebaseStorage.getInstance().getReference();

        final ArrayList<ImageUpload> imgs=new ArrayList<>();



       /* if(mchild==null) {
            Log.v("DASHBOARD","in here :p");
            mchild = new ChildEventListener() {
                //  Log.v("DASHBOARD","over here :p");
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    Log.v("DASHBOARD","here bro!! :p");
                    ImageUpload friendlyMessage = dataSnapshot.getValue(ImageUpload.class);
                    Log.v("DASHBOARD","DATA taken :p");
                    imgs.add(friendlyMessage);
                    Log.v("DASHBOARD","DATA dISPLAYED :p");
                    ImageAdapter adapter= new ImageAdapter(getApplicationContext(),imgs);
                    Log.v("DASHBOARD","DATA shown :p");
                    // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
                    // {@link ListView} will display list items for each {@link Word} in the list.
                    listView.setAdapter(adapter);
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            };
            mDatabaseRef.addChildEventListener(mchild);
        }*/

       /* mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                // Log.e("Count " ,""+snapshot.getChildrenCount());
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Log.v("DASHBOARD","DATA RETRIEVED :p");
                    //ethu bilkul houni
                    ImageUpload post = postSnapshot.getValue(ImageUpload.class);
                    Log.v("DASHBOARD","DATA SHOWN :p");
                    imgs.add(post);
                }
                ImageAdapter adapter= new ImageAdapter(getApplicationContext(),imgs);
                // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
                // {@link ListView} will  display list items for each {@link Word} in the list.
                listView.setAdapter(adapter);
                Log.v("DASHBOARD","DATA dISPLAYED :p");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("TAG!!!", "Failed to read value.", databaseError.toException());
            }
        });*/

        mDatabaseRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Log.v("dashboard","here  also  :P");
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                Log.v("dashboard","here 78  :P");
                for(DataSnapshot child :children){
                    Iterable<DataSnapshot> ch = child.getChildren();

                    Log.v("dashboard","here  90 :P");
                    for(DataSnapshot q :ch) {

                        Log.v("dashboard","here  :P");
                       // String mUuid = q.getKey();
                       // if (mUuid.equals(uuid)) {             static uuid nhi h
                          //  String mBidName = q.child("name").getValue(String.class);
                            String mBidDes = q.child("description").getValue(String.class);
                            String timelimit = q.child("time").getValue(String.class);
                            String mCurrentPrice =q.child("price").getValue(String.class);
                           // String mStatus = q.child("status").getValue(String.class);
Log.v("dashboard",mBidDes+"   "+mCurrentPrice+"   "+timelimit+"  :P");
                            ImageUpload temp = new ImageUpload(mBidDes,null,timelimit,mCurrentPrice);//uri or picture
                            imgs.add(temp);

                            //myBidAdapter.notifyItemInserted(mBidsList.size()-1);
                       // }
                    }
                }
                ImageAdapter adapter = new ImageAdapter(dashboard.this,imgs);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

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