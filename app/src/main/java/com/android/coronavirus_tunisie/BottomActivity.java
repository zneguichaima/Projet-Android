package com.android.coronavirus_tunisie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.android.coronavirus_tunisie.fragments.HelpFragment;
import com.android.coronavirus_tunisie.fragments.NewsFragment;
import com.android.coronavirus_tunisie.fragments.StaticFragment;
import com.android.coronavirus_tunisie.fragments.SymptomesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class BottomActivity extends AppCompatActivity { 
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(StaticFragment.newInstance("", ""));
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_static:
                            openFragment(StaticFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_news:
                            openFragment(new NewsFragment());
                            return true;

                        case R.id.navigation_sympthome:
                            openFragment(new SymptomesFragment());
                            return true;
                        case R.id.navigation_help:
                            openFragment(HelpFragment.newInstance("", ""));
                            return true;
                    }
                    return false;
                }
            };
    /**/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0,2,0,"Envoyer message");
        menu.add(0,3,0,"Appel urgence");
        //menu.add(0,4,0,"Paramétres");
        menu.add(0,5,0,"Vaccination");
        menu.add(0,6,0,"Deconnecter");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case 1:
               //Intent i=new Intent(BottomActivity.this, mapActivity.class);
                //startActivity(i);

                break;
            case 2:
                Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address","1111");
                smsIntent.putExtra("sms_body","votre message souhaité");
                smsIntent.setFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(smsIntent);

                break;

            case 3:
                String phone = " 197";
                //Intent.ACTION_CALL
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);

                break;

            case 5:
                Intent In=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.evax.tn/verifUpdate.xhtml"));
                startActivity(In);
                break;
            case 6:
                Intent i=new Intent(BottomActivity.this, LoginActivity.class);
                startActivity(i);
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}
