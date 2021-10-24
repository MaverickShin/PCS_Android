package com.example.petsystemtest4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.petsystemtest4.Fragment.CartFragment;
import com.example.petsystemtest4.Fragment.HomeFragment;
import com.example.petsystemtest4.Fragment.MyFragment;
import com.example.petsystemtest4.Fragment.ShopFragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Pet_searchActivity extends AppCompatActivity implements OnMapReadyCallback {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private HomeFragment homeFragment = new HomeFragment();
    private ShopFragment shopFragment = new ShopFragment();
    private CartFragment cartFragment = new CartFragment();
    private MyFragment myFragment = new MyFragment();

    private ImageView ivMenu; // 햄버거바
    private DrawerLayout drawerLayout; // 옆에서 나오는 창
    private Toolbar toolbar;
    private static final String TAG = "Pet_search_Activity";

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_search);

        //toolbar 액션
        ivMenu=findViewById(R.id.iv_menu);
        drawerLayout=findViewById(R.id.drawer);
        toolbar=findViewById(R.id.toolbar);

        //액션바 변경하기(들어갈 수 있는 타입 : Toolbar type
        setSupportActionBar(toolbar);

        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: 클릭됨");
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.google_map);
        mapFragment.getMapAsync(this);

        // 하단바
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation_view);
        bottomNav.setOnNavigationItemSelectedListener(new Pet_searchActivity.ItemSelectListener());
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        mMap = googleMap;

        LatLng SEOUL = new LatLng(37.56, 126.97);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("서울");
        markerOptions.snippet("한국의 수도");
        mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL, 17));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_menu1:
                Intent selfIntent = new Intent(this,SelfActivity.class);
                Toast.makeText(this, "자가진단 선택", Toast.LENGTH_SHORT).show();
                startActivity(selfIntent);
                return true;
            case R.id.action_menu2:
                Intent medicIntent = new Intent(this,MedicineActivity.class);
                Toast.makeText(this, "약품식별 선택", Toast.LENGTH_SHORT).show();
                startActivity(medicIntent);
                return true;
            case R.id.action_menu3:
                Intent calenderIntent = new Intent(this,CalenderAcitity.class);
                Toast.makeText(this, "캘린더 선택", Toast.LENGTH_SHORT).show();
                startActivity(calenderIntent);
                return true;
            case R.id.action_menu4:
                Intent searchIntent = new Intent(this, Pet_searchActivity.class);
                Toast.makeText(this, "분실동물찾기 선택", Toast.LENGTH_SHORT).show();
                startActivity(searchIntent);
                return true;
            case R.id.action_menu5:
                Intent moneyIntent = new Intent(this,MoneyActivity.class);
                Toast.makeText(this, "정기구독 선택", Toast.LENGTH_SHORT).show();
                startActivity(moneyIntent);
                return true;
            case R.id.action_menu6:
                Intent petIntent = new Intent(this, MyPetActivity.class);
                Toast.makeText(this, "마이펫 선택", Toast.LENGTH_SHORT).show();
                startActivity(petIntent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ItemSelectListener implements BottomNavigationView.OnNavigationItemSelectedListener{

        // 하단바 작동 버튼
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (menuItem.getItemId()) {
                case R.id.nav_home:// 하단바 Home
                    transaction.replace(R.id.searchFrameLayout, homeFragment).commitAllowingStateLoss();
                    break;

                case R.id.nav_shop:// 하단바 Sitter
                    transaction.replace(R.id.searchFrameLayout, shopFragment).commitAllowingStateLoss();
                    break;

                case R.id.nav_cart:// 하단바 Trainer
                    transaction.replace(R.id.searchFrameLayout, cartFragment).commitAllowingStateLoss();
                    break;

                case R.id.nav_my:// 하단바 내정보
                    transaction.replace(R.id.searchFrameLayout, myFragment).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        ActivityCompat.finishAffinity(this); // app 종료
    }
}