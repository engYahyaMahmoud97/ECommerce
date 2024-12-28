package com.yahyam.ecommerce;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.card.MaterialCardView;

public class BottomSheetFragmentPayCard extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_sheet_pay_card, container, false);

        MaterialCardView button_complete_order = view.findViewById(R.id.button_complete_order);
        button_complete_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),OrderComplete.class));
                dismiss();
            }
        });
        // Close button functionality
//        Button closeButton = view.findViewById(R.id.buttonClose);
//        closeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dismiss(); // Close the BottomSheet
//            }
//        });

        return view;
    }
}