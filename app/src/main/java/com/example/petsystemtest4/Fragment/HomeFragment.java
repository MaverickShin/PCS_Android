package com.example.petsystemtest4.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.petsystemtest4.CalenderAcitity;
import com.example.petsystemtest4.Data.ProductBean;
import com.example.petsystemtest4.Data.ProductDBHelper;
import com.example.petsystemtest4.MedicineActivity;
import com.example.petsystemtest4.MoneyActivity;
import com.example.petsystemtest4.MyPetActivity;
import com.example.petsystemtest4.Pet_searchActivity;
import com.example.petsystemtest4.R;
import com.example.petsystemtest4.Recycler.HomeGridAdapter;
import com.example.petsystemtest4.SelfActivity;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private View view;
    private GridView gridView;
    private HomeGridAdapter adapter;

    private ImageButton self_hospitalBtn,medicineBtn,calenderBtn,pet_searchBtn,moneyBtn,myPetBtn;

    // 메인. 슬라이드 형식 화면 절반치 광고, 아래에 상품 6개 정도 보여주기
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_home_fragment, container, false);

        // 자가진단페이지 이동
        self_hospitalBtn = view.findViewById(R.id.self_hospitalBtn);
        self_hospitalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SelfActivity.class);
                startActivity(intent);
            }
        });

        //약품식별페이지 이동
        medicineBtn = view.findViewById(R.id.medicineBtn);
        medicineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MedicineActivity.class);
                startActivity(intent);
            }
        });

        //캘린더페이지 이동
        calenderBtn = view.findViewById(R.id.calenderBtn);
        calenderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CalenderAcitity.class);
                startActivity(intent);
            }
        });

        //분실동물찾기페이지 이동
        pet_searchBtn = view.findViewById(R.id.pet_searchBtn);
        pet_searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Pet_searchActivity.class);
                startActivity(intent);
            }
        });

        //구독페이지 이동
        moneyBtn = view.findViewById(R.id.moneyBtn);
        moneyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MoneyActivity.class);
                startActivity(intent);
            }
        });

        //마이펫페이지 이동
        myPetBtn = view.findViewById(R.id.myPetBtn);
        myPetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyPetActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

   /* private void showProduct() {
        dbHelper = ProductDBHelper.getInstance(getContext());
        data = dbHelper.getRandomProduct();

        gridView = view.findViewById(R.id.gridView);
        adapter = new HomeGridAdapter(getContext(), data);
        gridView.setAdapter(adapter);
    }*/

}