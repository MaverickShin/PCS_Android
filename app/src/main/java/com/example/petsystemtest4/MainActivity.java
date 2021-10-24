package com.example.petsystemtest4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.petsystemtest4.Fragment.CartFragment;
import com.example.petsystemtest4.Fragment.HomeFragment;
import com.example.petsystemtest4.Fragment.MyFragment;
import com.example.petsystemtest4.Fragment.ShopFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private HomeFragment homeFragment = new HomeFragment();
    private ShopFragment shopFragment = new ShopFragment();
    private CartFragment cartFragment = new CartFragment();
    private MyFragment myFragment = new MyFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 첫 화면 지정
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, homeFragment).commitAllowingStateLoss();

        // 하단바
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation_view);
        bottomNav.setOnNavigationItemSelectedListener(new ItemSelectListener());

    }


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //MenuInflater로 메뉴를 생성하여 menu 객체에 설정
        //MenuInflater : 메뉴와 연결하기 위한 객체
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_menu1:
                Toast.makeText(MainActivity.this, "첫번재 메뉴", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_menu2:
                Toast.makeText(MainActivity.this, "두번재 메뉴", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_menu3:
                Toast.makeText(MainActivity.this, "세번재 메뉴", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_menu4:
                Toast.makeText(MainActivity.this, "네번재 메뉴", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    private class ItemSelectListener implements BottomNavigationView.OnNavigationItemSelectedListener{

        // 하단바 작동 버튼
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (menuItem.getItemId()) {
                case R.id.nav_home:
                    transaction.replace(R.id.frameLayout, homeFragment).commitAllowingStateLoss();
                    break;

                case R.id.nav_shop:
                    transaction.replace(R.id.frameLayout, shopFragment).commitAllowingStateLoss();
                    break;

                case R.id.nav_cart:
                    transaction.replace(R.id.frameLayout, cartFragment).commitAllowingStateLoss();
                    break;

                case R.id.nav_my:
                    transaction.replace(R.id.frameLayout, myFragment).commitAllowingStateLoss();
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
