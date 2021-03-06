package com.vppank.cricketadventure.screen.main;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.squareup.picasso.Picasso;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.app.CricketApplication;
import com.vppank.cricketadventure.customview.NonSwipeableViewPager;
import com.vppank.cricketadventure.screen.announce.AnnouncemetFragment;
import com.vppank.cricketadventure.screen.common.BaseActivity;
import com.vppank.cricketadventure.screen.home.HomeFragment;
import com.vppank.cricketadventure.screen.item.ItemActivity;
import com.vppank.cricketadventure.screen.meo.MeoFragment;
import com.vppank.cricketadventure.screen.mission.NewFragment;
import com.vppank.cricketadventure.screen.notification.NotificationFragment;
import com.vppank.cricketadventure.screen.shopping.ShoppingActivity;
import com.vppank.cricketadventure.screen.social.SocialFragment;
import com.vppank.cricketadventure.screen.splash.SplashActivity;
import com.vppank.cricketadventure.service.api.model.User;
import com.vppank.cricketadventure.storage.share.UserInfo;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @BindView(R.id.bottom_navigation)
    protected BottomNavigationViewEx bottomNavigationView;

    @BindView(R.id.balance)
    protected TextView balance;

    @BindView(R.id.drawer_layout)
    protected DrawerLayout drawer;

    @BindView(R.id.nav_view)
    protected NavigationView navigationView;

    @BindView(R.id.container)
    protected NonSwipeableViewPager viewPager;

    User user;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        if (id == R.id.nav_home) {
            replaceFragment(new HomeFragment(), R.id.container, "home");
            drawer.closeDrawer(GravityCompat.START);

        } else if (id == R.id.nav_logout) {
            drawer.closeDrawer(GravityCompat.START);
            CricketApplication.getPrefManager().clearPreferences();
            startActivity(SplashActivity.newIntent(this));
            LoginManager.getInstance().logOut();
            finish();

        } else if (id == R.id.nav_rate) {
            drawer.closeDrawer(GravityCompat.START);

        } else if (id == R.id.nav_feedback) {
            drawer.closeDrawer(GravityCompat.START);

        } else if (id == R.id.nav_share) {
            drawer.closeDrawer(GravityCompat.START);
        }
        //else if (id == R.id.action_home) {
//            Log.d("quydz", "home");
//            setTitle(item.getTitle());
//            replaceFragment(new HomeFragment(), R.id.container, "home");
//        } else if (id == R.id.action_history) {
//            Log.d("quydz", "home");
//            replaceFragment(new AnnouncemetFragment(), R.id.container, "announcement");
//            setTitle(item.getTitle());
//        } else if (id == R.id.action_meo) {
//            replaceFragment(new MeoFragment(), R.id.container, "meo");
//            setTitle(item.getTitle());
//        } else if (id == R.id.action_notification) {
//            replaceFragment(new NotificationFragment(), R.id.container, "notification");
//            setTitle(item.getTitle());
//        } else if (id == R.id.action_social) {
//            replaceFragment(new SocialFragment(), R.id.container, "social");
//            setTitle(item.getTitle());
//        }
        return true;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        setSupportActionBar(toolbar);
        setTitle("Home");

        user = CricketApplication.getPrefManager().getUser();

        Log.d("quydz", CricketApplication.getPrefManager().getAuth());
        if (user == null) finish();


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);



        bottomNavigationView.enableAnimation(false);
        bottomNavigationView.enableItemShiftingMode(false);
        bottomNavigationView.enableShiftingMode(false);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        MainViewPagerAdapter viewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new HomeFragment(), "Trang chủ");
        viewPagerAdapter.addFragments(new AnnouncemetFragment(), "Lịch sử");
        viewPagerAdapter.addFragments(new MeoFragment(), "Meow");
        viewPagerAdapter.addFragments(new NewFragment(), "Thông báo");
        viewPagerAdapter.addFragments(new SocialFragment(), "Xã Hội");
        viewPager.setOffscreenPageLimit(5);
        viewPager.setAdapter(viewPagerAdapter);

        bottomNavigationView.setupWithViewPager(viewPager);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                switch (id){
                    case R.id.action_home:
                        viewPager.setCurrentItem(0);
                        setTitle("Trang chủ");
                        break;
                    case R.id.action_history:
                        viewPager.setCurrentItem(1);
                        setTitle("Lịch sử");
                        break;
                    case R.id.action_meo:
                        viewPager.setCurrentItem(2);
                        setTitle("Meow");
                        break;
                    case R.id.action_notification:
                        viewPager.setCurrentItem(3);
                        setTitle("Thông báo");
                        break;
                    case R.id.action_social:
                        viewPager.setCurrentItem(4);
                        setTitle("Xã hội");
                        break;
                }
                return true;
            }
        });


        View headerLayout = navigationView.getHeaderView(0);

        TextView userName = headerLayout.findViewById(R.id.user_name);
        TextView date = headerLayout.findViewById(R.id.user_date);
        ImageView avatar = headerLayout.findViewById(R.id.imageView);
        userName.setText(user.getName());
        date.setText(user.getEmail());
        Picasso.get().load(user.getAvatar()).into(avatar);
        myRef = database.getReference("balances/"+UserInfo.getInstance().getUser().getId());

        myRef.child("balance").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("value change", dataSnapshot.toString());
                UserInfo.getInstance().getUser().setBalance(Integer.parseInt(dataSnapshot.getValue().toString()));
                balance.setText(getString(R.string.grass) + UserInfo.getInstance().getUser().getBalance());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        balance.setText(getString(R.string.grass) + user.getBalance());


    }

    private void setTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @OnClick(R.id.balance)
    public void onBalanceClicked() {
        startActivity(ShoppingActivity.newIntent(this));
    }

    @Override
    protected void loadData() {
        super.loadData();
        getMeoInfo();
    }

    public void getMeoInfo() {

    }
}
