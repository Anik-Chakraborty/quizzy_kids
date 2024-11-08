package com.quizzy.kids.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.quizzy.kids.databinding.ActivityLandingBinding;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.quizzy.kids.R;
import com.quizzy.kids.viewModels.interfaces.OnClickInterface;

public class LandingActivity extends AppCompatActivity implements OnClickInterface {
    ActivityLandingBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLandingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SpannableStringBuilder spannableString = new SpannableStringBuilder();

        SpannableString firstSpan = new SpannableString("Welcome to ");
        firstSpan.setSpan(new StyleSpan(Typeface.NORMAL), 0, firstSpan.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.append(firstSpan);
        // Bold text
        SpannableString boldSpan = new SpannableString("Quizzy Kids");
        boldSpan.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, boldSpan.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.append(boldSpan);
        SpannableString lastSpan = new SpannableString(" Academy!");
        lastSpan.setSpan(new StyleSpan(Typeface.NORMAL), 0, lastSpan.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.append(lastSpan);

        binding.welcomeText.setText(spannableString);

        binding.setGoogleTitle("Login With Google");
        binding.setGoogleIcon(ContextCompat.getDrawable(this, R.drawable.google_logo));
        binding.setClickHandler(this);

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Google Login", Toast.LENGTH_SHORT).show();
        if(R.id.include == view.getId()){
            Intent intent = new Intent(LandingActivity.this, DashBoardActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}