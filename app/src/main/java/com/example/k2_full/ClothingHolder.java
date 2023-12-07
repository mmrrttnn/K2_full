package com.example.k2_full;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClothingHolder extends RecyclerView.ViewHolder {
    private TextView clothingType;
    private TextView clothingPrice;

    public TextView getClothingType() {
        return clothingType;
    }

    public void setClothingType(String clothingType) {
        this.clothingType.setText(clothingType.toString());
    }

    public TextView getClothingPrice() {
        return clothingPrice;
    }

    public void setClothingPrice(String clothingPrice) {
        this.clothingPrice.setText(clothingPrice.toString());
    }

    public ClothingHolder(@NonNull View itemView) {
        super(itemView);
        clothingType = itemView.findViewById(R.id.tvType);
        clothingPrice = itemView.findViewById(R.id.tvPrice);
    }
}
