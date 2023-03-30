package com.example.viikko9;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView userImage;
    TextView Name, email, degreeProgram, degrees;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        userImage = itemView.findViewById(R.id.ivUserImage);
        Name = itemView.findViewById(R.id.txtName);
        email = itemView.findViewById(R.id.txtEmail);
        degreeProgram = itemView.findViewById(R.id.txtDegreeProgram);
        degrees = itemView.findViewById(R.id.txtDegrees);
    }


}
