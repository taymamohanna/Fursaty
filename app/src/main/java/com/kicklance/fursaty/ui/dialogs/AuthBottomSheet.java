package com.kicklance.fursaty.ui.dialogs;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.kicklance.fursaty.R;

public class AuthBottomSheet extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_auth, container, false);

        view.findViewById(R.id.action_login).setOnClickListener(v -> {
            Toast.makeText(getContext(), "Login clicked", Toast.LENGTH_SHORT).show();
            dismiss();
        });

        view.findViewById(R.id.action_signup).setOnClickListener(v -> {
            Toast.makeText(getContext(), "Sign Up clicked", Toast.LENGTH_SHORT).show();
            dismiss();
        });

        return view;
    }
}
