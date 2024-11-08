package com.quizzy.kids.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.quizzy.kids.R;
import com.quizzy.kids.databinding.ActivityDashBoardBinding;
import com.quizzy.kids.fragments.dashboardFragment.FunFragment;
import com.quizzy.kids.fragments.dashboardFragment.HomeFragment;
import com.quizzy.kids.fragments.dashboardFragment.RankFragment;

public class DashBoardActivity extends AppCompatActivity {
    ActivityDashBoardBinding binding;
    Fragment homeFragment = new HomeFragment();
    Fragment funFragment = new FunFragment();
    Fragment rankFragment = new RankFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navigate(homeFragment);

        binding.bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.home) {
                return navigate(homeFragment);
            } else if (id == R.id.fun) {
                return navigate(funFragment);
            } else {
                return navigate(rankFragment);
            }
        });
    }

    private boolean navigate(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(binding.fragmentContainer.getId(), fragment).commit();
        return true;
    }
}