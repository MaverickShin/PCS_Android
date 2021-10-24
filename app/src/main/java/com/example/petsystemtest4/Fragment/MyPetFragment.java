package com.example.petsystemtest4.Fragment;

import android.view.View;
import android.widget.ViewFlipper;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petsystemtest4.Data.PetVO;
import com.example.petsystemtest4.Recycler.SelectRecyclerAdapter;

public class MyPetFragment extends Fragment {
    private static final String TYPE_INSERT = "펫 등록";
    private static final String TYPE_ListUpdate = "펫 목록/수정";

    private View view;
    private RecyclerView recyclerView;
    private SelectRecyclerAdapter petAdapter;
    private String[] petData; //등록된 펫을 담을 바구니
    private PetVO petvo;
}
