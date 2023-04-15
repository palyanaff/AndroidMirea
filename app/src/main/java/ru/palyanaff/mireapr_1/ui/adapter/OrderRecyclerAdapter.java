package ru.palyanaff.mireapr_1.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.palyanaff.mireapr_1.R;
import ru.palyanaff.mireapr_1.data.model.OrderItem;

public class OrderRecyclerAdapter extends RecyclerView.Adapter<OrderRecyclerAdapter.OrderViewItem>{
    private static final String TAG = "OrderRecyclerAdapter";
    private final LayoutInflater inflater;
    private static List<OrderItem> list;
    private View view;

    public OrderRecyclerAdapter(Context context, List<OrderItem> list) {
        this.inflater = LayoutInflater.from(context);
        this.list = list;
    }

    @NonNull
    @Override
    public OrderViewItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.menu_item, parent, false);
        return new OrderViewItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewItem holder, int position) {
        OrderItem item = list.get(position);
        holder.imageView.setImageResource(item.getImageResource());
        holder.header.setText(item.getHeaderResource());
        holder.description.setText(item.getDescriptionResource());
        String str = String.format(view.getContext().getResources().getString(R.string.price), item.getCost());
        holder.itemCost.setText(str);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateOrderList(List<OrderItem> orderList) {
        list.clear();
        list = orderList;
        notifyDataSetChanged();
    }

    public static class OrderViewItem extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView header;
        TextView description;
        TextView itemCost;
        Button minusButton, plusButton;
        public OrderViewItem(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);
            header = itemView.findViewById(R.id.item_name);
            description = itemView.findViewById(R.id.item_description);
            itemCost = itemView.findViewById(R.id.item_cost);
            minusButton = itemView.findViewById(R.id.minus_button);
            plusButton = itemView.findViewById(R.id.plus_button);

            minusButton.setOnClickListener(v -> {
                Log.i(TAG, "Minus item");
            });

            plusButton.setOnClickListener(v -> {
                Log.i(TAG, "Plus item");
            });
        }
    }
}
