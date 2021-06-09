package me.aprizal.orderfoodanddrink.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import me.aprizal.orderfoodanddrink.R;
import me.aprizal.orderfoodanddrink.ui.adapter.EatListAdapter;
import me.aprizal.orderfoodanddrink.ui.adapter.ListEatFragmentCallback;
import me.aprizal.orderfoodanddrink.ui.model.EatModel;

public class EatFragment extends Fragment implements ListEatFragmentCallback {
    private final EatListAdapter eatListAdapter = new EatListAdapter(this);

    public EatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rv_menu_eat = view.findViewById(R.id.rv_menu_eat);

        if (getActivity() !=null){
            EatListViewModel eatListViewModel = new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(EatListViewModel.class);
            List<EatModel> eatModels = eatListViewModel.eatModelList();

            eatListAdapter.setEatModelArrayList(eatModels);

            rv_menu_eat.setLayoutManager(new LinearLayoutManager(getContext()));
            rv_menu_eat.setHasFixedSize(true);
            rv_menu_eat.setAdapter(eatListAdapter);
        }
    }

    @Override
    public void onViewClick(EatModel eatModel) {
        Toast.makeText(getContext(),this.getString(R.string.buy_text,eatModel.getName_eat()),Toast.LENGTH_SHORT).show();
    }
}