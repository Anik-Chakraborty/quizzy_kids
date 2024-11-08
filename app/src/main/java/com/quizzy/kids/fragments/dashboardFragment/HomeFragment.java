package com.quizzy.kids.fragments.dashboardFragment;

import android.graphics.Point;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quizzy.kids.adapters.HomeSliderAdapter;
import com.quizzy.kids.adapters.UnFinishListAdapter;
import com.quizzy.kids.databinding.FragmentHomeBinding;
import com.quizzy.kids.services.AppService;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    UnFinishListAdapter unFinishListAdapter;
    HomeSliderAdapter homeSliderAdapter;
    LinearLayoutManager sliderLayoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater);
        binding.setScorePoint("200");
        binding.setUserName("Anik");

        List data = new ArrayList<>();
        binding.unFinishList.setLayoutManager(new LinearLayoutManager(getContext()));
        unFinishListAdapter = new UnFinishListAdapter(data ,getContext());
        binding.unFinishList.setAdapter(unFinishListAdapter);

        sliderLayoutManager = new LinearLayoutManager(getContext());
        sliderLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.slider.setLayoutManager(sliderLayoutManager);
        Point screenSize = AppService.getScreenSize(getContext());
        homeSliderAdapter = new HomeSliderAdapter(data ,getContext(), screenSize.x);
        binding.slider.setAdapter(homeSliderAdapter);
        binding.slider.setNestedScrollingEnabled(false);
        binding.slider.setOnScrollChangeListener((view, i, i1, i2, i3) -> {
            int currentCompletelyVisibleLab = sliderLayoutManager.findFirstCompletelyVisibleItemPosition();
            Log.d("Page change", "onPageScrolled: "+currentCompletelyVisibleLab);
        });




        return binding.getRoot();
    }
}