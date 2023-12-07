package com.example.k2_full;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClothingAdapter extends RecyclerView.Adapter<ClothingHolder> implements ClothingDialog.OnClothingUpdatedListener {
    private List<Clothing> clothingList;
    private Context context;
    private FragmentManager fragmentManager;

    public ClothingAdapter(FragmentManager fragmentManager, List<Clothing> clothingList) {
        this.fragmentManager = fragmentManager;
        this.clothingList = clothingList;
    }

    @NonNull
    @Override
    public ClothingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.clothing_list_item_layout, parent, false);
        return new ClothingHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClothingHolder holder, int position) {
        Clothing clothing = clothingList.get(position);
        holder.setClothingType(clothing.getType());
        holder.setClothingPrice(String.valueOf(clothing.getPrice()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClothingDialog clothingDialog = ClothingDialog.newInstance(clothing);
                clothingDialog.setOnClothingUpdatedListener(ClothingAdapter.this);
                clothingDialog.show(fragmentManager, "clothing_dialog");
            }
        });
    }

    @Override
    public int getItemCount() {
        return clothingList.size();
    }

    @Override
    public void onClothingUpdated(Clothing clothing) {
        notifyDataSetChanged();
    }
}
