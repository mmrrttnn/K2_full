package com.example.k2_full;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClothingDialog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClothingDialog extends DialogFragment {

    private Clothing clothing;
    private TextView clothingType;
    private EditText clothingPrice, clothingQty, clothingOrigin;
    private Button btnSave, btnCancel;
    private OnClothingUpdatedListener listener;

    public ClothingDialog() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     /* @param param1 Parameter 1.
     /* @param param2 Parameter 2.
     * @return A new instance of fragment ClothingDialog.
     */
    // TODO: Rename and change types and number of parameters
    public static ClothingDialog newInstance(Clothing clothing) {
        ClothingDialog fragment = new ClothingDialog();
        Bundle args = new Bundle();
        args.putParcelable("clothing", clothing);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            clothing = getArguments().getParcelable("clothing");
        }
        Log.i("tag", "Dialog Fragment Started");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clothing_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        clothingType = view.findViewById(R.id.dialogType);
        clothingPrice = view.findViewById(R.id.dialogPrice);
        clothingQty = view.findViewById(R.id.dialogQty);
        clothingOrigin = view.findViewById(R.id.dialogOrigin);

        btnCancel = view.findViewById(R.id.dialogCancelBtn);
        btnSave = view.findViewById(R.id.dialogSaveBtn);

        clothingType.setText(clothing.getType());
        clothingPrice.setText(String.valueOf(clothing.getPrice()));
        clothingQty.setText(String.valueOf(clothing.getQuantity()));
        clothingOrigin.setText(clothing.getOrigin());

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clothing.setPrice(Double.parseDouble(clothingPrice.getText().toString()));
                clothing.setQuantity(Integer.parseInt(clothingQty.getText().toString()));
                clothing.setOrigin(clothingOrigin.getText().toString());

                if(listener != null){
                    listener.onClothingUpdated(clothing);
                }
                dismiss();
            }
        });
    }

    public void setOnClothingUpdatedListener(OnClothingUpdatedListener listener){
        this.listener = listener;
    }

    public interface OnClothingUpdatedListener {
        void onClothingUpdated(Clothing clothing);
    }
}