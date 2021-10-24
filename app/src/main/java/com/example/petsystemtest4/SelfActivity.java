package com.example.petsystemtest4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
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
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.Nullable;

import kotlin.jvm.internal.Intrinsics;

public class SelfActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private HomeFragment homeFragment = new HomeFragment();
    private ShopFragment shopFragment = new ShopFragment();
    private CartFragment cartFragment = new CartFragment();
    private MyFragment myFragment = new MyFragment();

    private ImageView ivMenu; // 햄버거바
    private DrawerLayout drawerLayout; // 옆에서 나오는 창
    private Toolbar toolbar;
    private static final String TAG = "Self_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self);

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

        Spinner spinner = (Spinner)this.findViewById(R.id.spinner);
        final Spinner spinner2 = (Spinner)this.findViewById(R.id.spinner2);
        final TextView title_tv = (TextView)this.findViewById(R.id.title_tv);
        final TextView name_tv = (TextView)this.findViewById(R.id.name_tv);
        final TextView content_tv = (TextView)this.findViewById(R.id.content_tv);

        Intrinsics.checkNotNullExpressionValue(spinner, "spinner");
        spinner.setAdapter((SpinnerAdapter) ArrayAdapter.createFromResource((Context)this, R.array.typeList, android.R.layout.simple_spinner_dropdown_item));
        Intrinsics.checkNotNullExpressionValue(spinner2, "spinner2");
        spinner2.setAdapter((SpinnerAdapter)ArrayAdapter.createFromResource((Context)this, R.array.symptionList, android.R.layout.simple_spinner_item));
        spinner2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(@Nullable AdapterView parent) {
            }

            public void onItemSelected(@Nullable AdapterView parent, @Nullable View view, int position, long id) {
                TextView var10000;
                Spinner var10001;
                switch(position) {
                    case 0:
                        title_tv.setText((CharSequence)"증상 부위를 선택해주세요!");
                        name_tv.setText((CharSequence)"");
                        content_tv.setText((CharSequence)"");
                        break;
                    case 1:
                        var10000 = title_tv;
                        var10001 = spinner2;
                        Intrinsics.checkNotNullExpressionValue(var10001, "spinner2");
                        var10000.setText((CharSequence)var10001.getSelectedItem().toString());
                        name_tv.setText((CharSequence)"");
                        content_tv.setText(R.string.ear_text);
                        break;
                    case 2:
                        var10000 = title_tv;
                        var10001 = spinner2;
                        Intrinsics.checkNotNullExpressionValue(var10001, "spinner2");
                        var10000.setText((CharSequence)var10001.getSelectedItem().toString());
                        name_tv.setText((CharSequence)"");
                        content_tv.setText(R.string.eye_text);
                        break;
                    case 3:
                        var10000 = title_tv;
                        var10001 = spinner2;
                        Intrinsics.checkNotNullExpressionValue(var10001, "spinner2");
                        var10000.setText((CharSequence)var10001.getSelectedItem().toString());
                        name_tv.setText((CharSequence)"");
                        content_tv.setText(R.string.teeth_text);
                        break;
                    case 4:
                        var10000 = title_tv;
                        var10001 = spinner2;
                        Intrinsics.checkNotNullExpressionValue(var10001, "spinner2");
                        var10000.setText((CharSequence)var10001.getSelectedItem().toString());
                        name_tv.setText((CharSequence)"");
                        content_tv.setText(R.string.leg_text);
                        break;
                    case 5:
                        var10000 = title_tv;
                        var10001 = spinner2;
                        Intrinsics.checkNotNullExpressionValue(var10001, "spinner2");
                        var10000.setText((CharSequence)var10001.getSelectedItem().toString());
                        name_tv.setText((CharSequence)"");
                        content_tv.setText(R.string.head_text);
                        break;
                    case 6:
                        var10000 = title_tv;
                        var10001 = spinner2;
                        Intrinsics.checkNotNullExpressionValue(var10001, "spinner2");
                        var10000.setText((CharSequence)var10001.getSelectedItem().toString());
                        name_tv.setText((CharSequence)"");
                        content_tv.setText(R.string.stomach_text);
                        break;
                    case 7:
                        var10000 = title_tv;
                        var10001 = spinner2;
                        Intrinsics.checkNotNullExpressionValue(var10001, "spinner2");
                        var10000.setText((CharSequence)var10001.getSelectedItem().toString());
                        name_tv.setText((CharSequence)"");
                        content_tv.setText(R.string.behavior_text);
                        break;
                    default:
                        title_tv.setText((CharSequence)"메뉴");
                        name_tv.setText((CharSequence)"");
                        content_tv.setText((CharSequence)"");
                }

            }
        }));


        // 하단바
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation_view);
        bottomNav.setOnNavigationItemSelectedListener(new SelfActivity.ItemSelectListener());
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
                case R.id.nav_home:
                    transaction.replace(R.id.selfFrameLayout, homeFragment).commitAllowingStateLoss();
                    break;

                case R.id.nav_shop:
                    transaction.replace(R.id.selfFrameLayout, shopFragment).commitAllowingStateLoss();
                    break;

                case R.id.nav_cart:
                    transaction.replace(R.id.selfFrameLayout, cartFragment).commitAllowingStateLoss();
                    break;

                case R.id.nav_my:
                    transaction.replace(R.id.selfFrameLayout, myFragment).commitAllowingStateLoss();
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