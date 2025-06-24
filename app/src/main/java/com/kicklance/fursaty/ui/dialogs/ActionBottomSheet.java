package com.kicklance.fursaty.ui.dialogs;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.kicklance.fursaty.R;

public class ActionBottomSheet extends BottomSheetDialogFragment {

    private final String phoneNumber;

    public ActionBottomSheet(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_actions, container, false);

        view.findViewById(R.id.action_call).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            startActivity(intent);
            dismiss();
        });

        view.findViewById(R.id.action_sms).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + phoneNumber));
            startActivity(intent);
            dismiss();
        });

        view.findViewById(R.id.action_whatsapp).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://wa.me/" + phoneNumber));
            startActivity(intent);
            dismiss();
        });

        return view;
    }
}
