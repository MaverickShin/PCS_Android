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
import com.example.petsystemtest4.Fragment.MyPetFragment;
import com.example.petsystemtest4.Fragment.ShopFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MyPetActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private HomeFragment homeFragment = new HomeFragment();
    private ShopFragment shopFragment = new ShopFragment();
    private CartFragment cartFragment = new CartFragment();
    private MyFragment myFragment = new MyFragment();
    private MyPetFragment myPetFragment = new MyPetFragment();

    private ImageView ivMenu; // 햄버거바
    private DrawerLayout drawerLayout; // 옆에서 나오는 창
    private Toolbar toolbar;
    private static final String TAG = "MyPet_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pet);

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

        // 하단바
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation_view);
        bottomNav.setOnNavigationItemSelectedListener(new MyPetActivity.ItemSelectListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 상단 메뉴 선택
        switch (item.getItemId()){
            //자가진단
            case R.id.action_menu1:
                Intent selfIntent = new Intent(this,SelfActivity.class);
                Toast.makeText(this, "자가진단 선택", Toast.LENGTH_SHORT).show();
                startActivity(selfIntent);
                return true;

            //약품식별
            case R.id.action_menu2:
                Intent medicIntent = new Intent(this,MedicineActivity.class);
                Toast.makeText(this, "약품식별 선택", Toast.LENGTH_SHORT).show();
                startActivity(medicIntent);
                return true;

            //캘린더
            case R.id.action_menu3:
                Intent calenderIntent = new Intent(this,CalenderAcitity.class);
                Toast.makeText(this, "캘린더 선택", Toast.LENGTH_SHORT).show();
                startActivity(calenderIntent);
                return true;

            //분실동물찾기
            case R.id.action_menu4:
                Intent searchIntent = new Intent(this, Pet_searchActivity.class);
                Toast.makeText(this, "분실동물찾기 선택", Toast.LENGTH_SHORT).show();
                startActivity(searchIntent);
                return true;

            //정기구독
            case R.id.action_menu5:
                Intent moneyIntent = new Intent(this,MoneyActivity.class);
                Toast.makeText(this, "정기구독 선택", Toast.LENGTH_SHORT).show();
                startActivity(moneyIntent);
                return true;

            //마이펫
            case R.id.action_menu6:
                Intent petIntent = new Intent(this, MyPetActivity.class);
                Toast.makeText(this, "마이펫 선택", Toast.LENGTH_SHORT).show();
                startActivity(petIntent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ItemSelectListener implements BottomNavigationView.OnNavigationItemSelectedListener{


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (menuItem.getItemId()) {
                //하단바 - 홈
                case R.id.nav_home:
                    transaction.replace(R.id.PetFrameLayout, homeFragment).commitAllowingStateLoss();
                    break;

                //하단바 - Sitter
                case R.id.nav_shop:
                    transaction.replace(R.id.PetFrameLayout, shopFragment).commitAllowingStateLoss();
                    break;

                //하단바 - Trainer
                case R.id.nav_cart:
                    transaction.replace(R.id.PetFrameLayout, cartFragment).commitAllowingStateLoss();
                    break;

                //하단바 - My
                case R.id.nav_my:
                    transaction.replace(R.id.PetFrameLayout, myFragment).commitAllowingStateLoss();
                    break;

                //자가진단
                case R.id.action_menu1:
                    transaction.replace(R.id.selfFrameLayout, myFragment).commitAllowingStateLoss();
                    break;

                //약품식별
                case R.id.action_menu2:
                    transaction.replace(R.id.madicFrameLayout, myFragment).commitAllowingStateLoss();
                    break;

                //캘린더
                case R.id.action_menu3:
                    transaction.replace(R.id.CalFrameLayout, myFragment).commitAllowingStateLoss();
                    break;

                //분실동물찾기
                case R.id.action_menu4:
                    transaction.replace(R.id.searchFrameLayout, myFragment).commitAllowingStateLoss();
                    break;

                //정기구독
                case R.id.action_menu5:
                    transaction.replace(R.id.moneyFrameLayout, myFragment).commitAllowingStateLoss();
                    break;

                //마이펫
                case R.id.action_menu6:
                    transaction.replace(R.id.PetFrameLayout,myPetFragment).commitAllowingStateLoss();
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