package com.example.petsystemtest4.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petsystemtest4.Data.ProductBean;
import com.example.petsystemtest4.Data.ProductDBHelper;
import com.example.petsystemtest4.R;
import com.example.petsystemtest4.Recycler.CartRecyclerAdapter;
import com.example.petsystemtest4.Recycler.ItemClickListener;

import java.util.ArrayList;


public class CartFragment extends Fragment implements ItemClickListener {
    private View view;
    private RecyclerView recyclerView;
    private CartRecyclerAdapter adapter;
    private ArrayList<ProductBean> data; //dao 아마도?
    private ProductDBHelper dbHelper; //vo


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_cart_fragment, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showProduct();
    }

    private void showProduct() {
       /* dbHelper = ProductDBHelper.getInstance(getContext());
        data = dbHelper.getAllProduct();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CartRecyclerAdapter(data, this);
        recyclerView.setAdapter(adapter);*/
    }

    @Override
    public void onItemClick(View v, int position) {

    }
}
