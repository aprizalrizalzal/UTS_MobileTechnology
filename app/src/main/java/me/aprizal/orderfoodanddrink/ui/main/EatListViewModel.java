package me.aprizal.orderfoodanddrink.ui.main;

import androidx.lifecycle.ViewModel;

import java.util.List;

import me.aprizal.orderfoodanddrink.ui.data.EatData;
import me.aprizal.orderfoodanddrink.ui.model.EatModel;

public class EatListViewModel extends ViewModel {
    List<EatModel> eatModelList(){
        return EatData.getEatModelArrayList();
    }
}
