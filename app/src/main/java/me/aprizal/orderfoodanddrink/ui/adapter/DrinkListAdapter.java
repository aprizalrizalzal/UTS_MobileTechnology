package me.aprizal.orderfoodanddrink.ui.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import me.aprizal.orderfoodanddrink.R;
import me.aprizal.orderfoodanddrink.ui.DetailActivity;
import me.aprizal.orderfoodanddrink.ui.model.DrinkModel;

public class DrinkListAdapter extends RecyclerView.Adapter<DrinkListAdapter.ListViewHolder> {
    private final ArrayList<DrinkModel>drinkModelArrayList;

    public DrinkListAdapter(ArrayList<DrinkModel> drinkModelList) {
        this.drinkModelArrayList = drinkModelList;
    }

    @NonNull
    @NotNull
    @Override
    public DrinkListAdapter.ListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_drink,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DrinkListAdapter.ListViewHolder holder, int position) {
        DrinkModel drinkModel = drinkModelArrayList.get(position);
        holder.bind(drinkModel);
    }

    @Override
    public int getItemCount() {
        return drinkModelArrayList.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDrink;
        TextView tvName;
        TextView tvPrice;
        TextView tvDetail;
        Button btnBuy;
        public ListViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgDrink=itemView.findViewById(R.id.img_item_drink);
            tvName=itemView.findViewById(R.id.tv_item_name_drink);
            tvPrice=itemView.findViewById(R.id.tv_item_price_drink);
            tvDetail=itemView.findViewById(R.id.tv_item_detail_drink);
            btnBuy=itemView.findViewById(R.id.btn_buy_drink);
        }

        public void bind(DrinkModel drinkModel) {
            Glide.with(itemView.getContext()).load(drinkModel.getImg_drink()).apply(new RequestOptions().override(255, 255)).into(imgDrink);
            tvName.setText(drinkModel.getName_drink());
            tvPrice.setText(drinkModel.getPrice_drink());
            tvDetail.setText(drinkModel.getDetail_drink());

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(),DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_IMAGE_EAT,drinkModel.getImg_drink());
                intent.putExtra(DetailActivity.EXTRA_NAME_EAT,drinkModel.getName_drink());
                intent.putExtra(DetailActivity.EXTRA_PRICE_EAT,drinkModel.getPrice_drink());
                intent.putExtra(DetailActivity.EXTRA_DETAIL_EAT,drinkModel.getDetail_drink());
                itemView.getContext().startActivity(intent);
            });

            btnBuy.setOnClickListener(v -> Toast.makeText(v.getContext(),v.getContext().getString(R.string.buy_text,drinkModel.getName_drink()),Toast.LENGTH_SHORT).show());

        }
    }
}
