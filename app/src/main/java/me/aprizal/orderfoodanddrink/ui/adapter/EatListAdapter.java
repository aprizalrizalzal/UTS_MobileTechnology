package me.aprizal.orderfoodanddrink.ui.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.Button;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import me.aprizal.orderfoodanddrink.R;
import me.aprizal.orderfoodanddrink.ui.DetailActivity;
import me.aprizal.orderfoodanddrink.ui.model.EatModel;

public class EatListAdapter extends RecyclerView.Adapter<EatListAdapter.ListViewHolder> {
    private final ListEatFragmentCallback callback;
    private final ArrayList<EatModel> eatModelArrayList = new ArrayList<>();

    public EatListAdapter(ListEatFragmentCallback callback) {
        this.callback = callback;
    }

    public void setEatModelArrayList(List<EatModel> eatModels){
        eatModelArrayList.clear();
        eatModelArrayList.addAll(eatModels);
    }

    @NonNull
    @NotNull
    @Override
    public EatListAdapter.ListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_eat,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull EatListAdapter.ListViewHolder holder, int position) {
        EatModel eatModel = eatModelArrayList.get(position);
        holder.bind(eatModel);
    }

    @Override
    public int getItemCount() {
        return eatModelArrayList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgEat;
        TextView tvName;
        TextView tvPrice;
        TextView tvDetail;
        Button btnBuy;
        public ListViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgEat=itemView.findViewById(R.id.img_item_eat);
            tvName=itemView.findViewById(R.id.tv_item_name_eat);
            tvPrice=itemView.findViewById(R.id.tv_item_price_eat);
            tvDetail=itemView.findViewById(R.id.tv_item_detail_eat);
            btnBuy=itemView.findViewById(R.id.btn_buy_eat);
        }

        public void bind(EatModel eatModel) {
            Glide.with(itemView.getContext()).load(eatModel.getImg_eat()).apply(new RequestOptions().override(255,255)).into(imgEat);
            tvName.setText(eatModel.getName_eat());
            tvPrice.setText(eatModel.getPrice_eat());
            tvDetail.setText(eatModel.getDetail_eat());

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(),DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_IMAGE_EAT,eatModel.getImg_eat());
                intent.putExtra(DetailActivity.EXTRA_NAME_EAT,eatModel.getName_eat());
                intent.putExtra(DetailActivity.EXTRA_PRICE_EAT,eatModel.getPrice_eat());
                intent.putExtra(DetailActivity.EXTRA_DETAIL_EAT,eatModel.getDetail_eat());
                itemView.getContext().startActivity(intent);
            });

            btnBuy.setOnClickListener(v -> callback.onViewClick(eatModel));
        }
    }
}
