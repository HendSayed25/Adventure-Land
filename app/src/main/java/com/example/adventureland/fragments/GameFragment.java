package com.example.adventureland.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import com.example.adventureland.R;

public class GameFragment extends Fragment {
    ImageView favIcon,purpleIcon,backIcon;
    private boolean isStarred = false; // To track the state

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        favIcon=view.findViewById(R.id.loveIcon);
        purpleIcon=view.findViewById(R.id.lovePurpleIcon);
        backIcon=view.findViewById(R.id.backgame);

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });

        //when click to fav icon change it's color to purple and when click again change it to be white
        favIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favIcon.setVisibility(View.INVISIBLE);
                purpleIcon.setVisibility(View.VISIBLE);
            }
        });
        purpleIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favIcon.setVisibility(View.VISIBLE);
                purpleIcon.setVisibility(View.INVISIBLE);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.game_design, container, false);
    }
}
