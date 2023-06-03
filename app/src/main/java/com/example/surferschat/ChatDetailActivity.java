package com.example.surferschat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.surferschat.databinding.ActivityChatDetailBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ChatDetailActivity extends AppCompatActivity {

    ActivityChatDetailBinding binding;
    FirebaseDatabase database;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }
        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();

        final String senderId = mAuth.getUid();
        String recId = getIntent().getStringExtra("userId");
        String recUserName = getIntent().getStringExtra("username");
        String profilePic = getIntent().getStringExtra("profilePic");

        binding.userNameChat.setText(recUserName);
        Picasso.get().load(profilePic).placeholder(R.drawable.usericon).into(binding.profileImage);
        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatDetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}