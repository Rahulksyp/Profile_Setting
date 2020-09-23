package com.example.profilesetting.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.profilesetting.R;
import com.example.profilesetting.adapter.ViewPagerAdapter;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private Button inviteBtn,otherSetting;
    private ExtendedFloatingActionButton mainFab,fabRec,lookfab,offFab;
    private TextView lookTv,offTv,recoTv;
    private boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayot);
        viewPager = findViewById(R.id.viewPager);
        inviteBtn = findViewById(R.id.inviteBtn);
        otherSetting = findViewById(R.id.otheSetting);
        inviteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,"Downlaod App");
                sendIntent.setType("text/plain");
                Intent.createChooser(sendIntent,"Share via");
                startActivity(sendIntent);
            }
        });
        otherSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,OtherSetting.class));
            }
        });

        mainFab = findViewById(R.id.mainFab);
        fabRec = findViewById(R.id.fabReco);
        offFab = findViewById(R.id.fabOff);
        lookfab = findViewById(R.id.fabLooking);
        lookTv = findViewById(R.id.lookTv);
        offTv = findViewById(R.id.offTv);
        recoTv = findViewById(R.id.recTv);
        fabButtonFunction();
        createTabFragment();

    }

    private void fabButtonFunction() {
        final Animation fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        final Animation fabClose = AnimationUtils.loadAnimation(
                this,
                R.anim.fab_close
        );
        final Animation fabRClockwise = AnimationUtils.loadAnimation(
                this,
                R.anim.rotate_clockwise
        );
        final Animation fabRAntiClockwise = AnimationUtils.loadAnimation(
                this,
                R.anim.rotate_anticlockwise
        );

        mainFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isOpen) {
                    fabRec.startAnimation(fabClose);
                    offFab.startAnimation(fabClose);
                    lookfab.startAnimation(fabClose);
                    lookTv.startAnimation(fabClose);
                    offTv.startAnimation(fabClose);
                    recoTv.startAnimation(fabClose);


                    //visibility//
                    fabRec.setVisibility(View.INVISIBLE);
                    fabRec.setVisibility(View.INVISIBLE);
                    fabRec.setVisibility(View.INVISIBLE);
                    lookTv.setVisibility(View.INVISIBLE);
                    offTv.setVisibility(View.INVISIBLE);
                    recoTv.setVisibility(View.INVISIBLE);

                    //clickable
                    fabRec.setClickable(false);
                    offFab.setClickable(false);
                    lookfab.setClickable(false);


                    //disabling when fab close
                    fabRec.setEnabled(false);
                    offFab.setEnabled(false);
                    lookfab.setEnabled(false);

                    mainFab.startAnimation(fabRClockwise);
                    isOpen = false;
                } else {
                    fabRec.startAnimation(fabOpen);
                    offFab.startAnimation(fabOpen);
                    lookfab.startAnimation(fabOpen);
                    recoTv.startAnimation(fabOpen);
                    offTv.startAnimation(fabOpen);
                    lookTv.startAnimation(fabOpen);

                    //visibility//
                    fabRec.setVisibility(View.VISIBLE);
                    offFab.setVisibility(View.VISIBLE);
                    lookfab.setVisibility(View.VISIBLE);
                    lookTv.setVisibility(View.VISIBLE);
                    offTv.setVisibility(View.VISIBLE);
                    recoTv.setVisibility(View.VISIBLE);

                    //clickable
                    fabRec.setClickable(true);
                    offFab.setClickable(true);
                    lookfab.setClickable(true);

                    //enbling when fab close
                    fabRec.setEnabled(true);
                    offFab.setEnabled(true);
                    lookfab.setEnabled(true);

                    mainFab.startAnimation(fabRAntiClockwise);
                    isOpen = true;

                }

            }
        });
    }


    private void createTabFragment() {

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}