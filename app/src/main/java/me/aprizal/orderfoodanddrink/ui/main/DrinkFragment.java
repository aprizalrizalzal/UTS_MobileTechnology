package me.aprizal.orderfoodanddrink.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import me.aprizal.orderfoodanddrink.R;
import me.aprizal.orderfoodanddrink.ui.adapter.DrinkListAdapter;
import me.aprizal.orderfoodanddrink.ui.data.DrinkData;
import me.aprizal.orderfoodanddrink.ui.model.DrinkModel;

public class DrinkFragment extends Fragment {
    private final ArrayList<DrinkModel> drinkModelArrayList = new ArrayList<>();

    public DrinkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drink, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        RecyclerView rv_menu_drink;
        super.onViewCreated(view, savedInstanceState);

        rv_menu_drink=view.findViewById(R.id.rv_menu_drink);
        rv_menu_drink.setHasFixedSize(true);

        drinkModelArrayList.addAll(DrinkData.getDrinkModelArrayList());
        showMenuRecyclerView(rv_menu_drink);
    }

    private void showMenuRecyclerView(RecyclerView rv_menu_drink) {
        rv_menu_drink.setLayoutManager(new LinearLayoutManager(getActivity()));
        DrinkListAdapter drinkListAdapter = new DrinkListAdapter(drinkModelArrayList);
        rv_menu_drink.setAdapter(drinkListAdapter);
    }
}