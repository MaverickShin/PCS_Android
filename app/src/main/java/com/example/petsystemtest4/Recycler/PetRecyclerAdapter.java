package com.example.petsystemtest4.Recycler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petsystemtest4.Data.PetVO;
import com.example.petsystemtest4.Data.ProductBean;
import com.example.petsystemtest4.R;

import java.util.ArrayList;

public class PetRecyclerAdapter extends RecyclerView.Adapter<PetRecyclerAdapter.PetViewHolder> {
    private ArrayList<PetVO> data;
    private ItemClickListener listener;

    public PetRecyclerAdapter(ArrayList<PetVO> data, ItemClickListener listener){
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PetRecyclerAdapter.PetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_pet_card,viewGroup,false);
        return new PetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetViewHolder petViewHolder, int position) {
        PetVO petVO = data.get(position);

        petViewHolder.PetImage.setImageDrawable(getImage(petVO.getPET_IMG()));
        petViewHolder.PetName.setText(petVO.getPET_NM());
        petViewHolder.PetAge.setText(petVO.getPET_AGE());
        petViewHolder.PetNotes.setText(petVO.getPET_CON());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void updateData(ArrayList<PetVO> data){
        this.data = data;
        notifyDataSetChanged();
    }

    //SQLite에 담을 이미지
    public Drawable getImage(byte[] bytes){
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        Drawable drawable = new BitmapDrawable(null, bitmap);
        return drawable;
    }

    //펫 목록창
    public class PetViewHolder extends RecyclerView.ViewHolder{
        ImageView PetImage; //펫 이미지
        TextView PetName; // 펫 이름
        TextView PetAge; // 펫 나이
        TextView PetNotes; // 특이사항
        private Context context;

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);

            PetImage = itemView.findViewById(R.id.petImageView);
            PetName = itemView.findViewById(R.id.petNameTv);
            PetAge = itemView.findViewById(R.id.petAgeTv);
            PetNotes = itemView.findViewById(R.id.petNotesTv);
            context = itemView.getContext();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    BottomSheetDialog bottomSheetDialog = DialogInterface.OnClickListener;
//                    bottomSheetDialog.show(((AppCompatActivity) context).getSupportFragmentManager(), "bottomSheet");
                }
            });
        }
    }
}

