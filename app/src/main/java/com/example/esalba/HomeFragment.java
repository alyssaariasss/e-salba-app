package com.example.esalba;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class HomeFragment extends Fragment {
    TextView deviceTab, electricityTab;
    private int selectedTabNumber = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        deviceTab = view.findViewById(R.id.deviceTab);
        electricityTab = view.findViewById(R.id.electricityTab);

        getParentFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentLayout, DeviceFragment.class, null)
                .commit();

        deviceTab.setOnClickListener(view1 -> selectTab(1));

        electricityTab.setOnClickListener(view1 -> selectTab(2));

        // Inflate the layout for this fragment
        return view;
    }

    private void selectTab(int tabNumber) {
        TextView selectedTextView, nonSelectedTextView;

        if (tabNumber == 1) {
            selectedTextView = deviceTab;
            nonSelectedTextView = electricityTab;

            getParentFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentLayout,DeviceFragment.class, null)
                    .commit();
        }
        else {
            selectedTextView = electricityTab;
            nonSelectedTextView = deviceTab;

            getParentFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentLayout,ElectricityFragment.class, null)
                    .commit();
        }

        float slideTo = (tabNumber - selectedTabNumber) * selectedTextView.getWidth();

        TranslateAnimation translateAnimation = new TranslateAnimation(0, slideTo, 0, 0);
        translateAnimation.setDuration(200);

        if (selectedTabNumber == 1) {
            deviceTab.startAnimation(translateAnimation);
        }
        else {
            electricityTab.startAnimation(translateAnimation);
        }

        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                selectedTextView.setBackgroundResource(R.drawable.round_btn_selected);
                selectedTextView.setTypeface(null, Typeface.BOLD);
                selectedTextView.setTextColor(Color.WHITE);

                nonSelectedTextView.setBackgroundResource(R.drawable.round_btn_unselected);
                selectedTextView.setTypeface(null, Typeface.NORMAL);
                nonSelectedTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.black));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        selectedTabNumber = tabNumber;
    }
}