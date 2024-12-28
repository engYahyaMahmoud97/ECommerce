package com.yahyam.ecommerce;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.card.MaterialCardView;

public class BottomSheetFragment extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_sheet, container, false);

        MaterialCardView button_pay_with_card = view.findViewById(R.id.button_pay_with_card);
        MaterialCardView button_pay_on_delivery = view.findViewById(R.id.button_pay_on_delivery);
        button_pay_with_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetFragmentPayCard bottomSheetFragmentPayCard = new BottomSheetFragmentPayCard();
                bottomSheetFragmentPayCard.show(requireActivity().getSupportFragmentManager(), bottomSheetFragmentPayCard.getTag());
                dismiss();
            }
        });
        button_pay_on_delivery.setOnClickListener(new View.OnClickListener() {
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