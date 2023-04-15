package ru.palyanaff.mireapr_1.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.palyanaff.mireapr_1.data.model.OrderItem;
import ru.palyanaff.mireapr_1.R;
import ru.palyanaff.mireapr_1.ui.view_model.OrderViewModel;

public class MenuRecyclerAdapter extends RecyclerView.Adapter<MenuRecyclerAdapter.MenuItem> {
    private static final String TAG = "MenuRecyclerAdapter";
    private final LayoutInflater inflater;
    private static List<OrderItem> list;
    private View view;
    OrderViewModel viewModel;

    public MenuRecyclerAdapter(Context context, List<OrderItem> list){
        this.inflater = LayoutInflater.from(context);
        this.list = list;
    }

    @NonNull
    @Override
    public MenuItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.menu_item, parent, false);
        return new MenuItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItem holder, int position) {
        OrderItem item = list.get(position);
        holder.imageView.setImageResource(item.getImageResource());
        holder.header.setText(item.getHeaderResource());
        holder.description.setText(item.getDescriptionResource());
        String str = String.format(view.getContext().getResources().getString(R.string.price), item.getCost());
        holder.button.setText(str);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MenuItem extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView header;
        TextView description;
        Button button;
        public MenuItem(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);
            header = itemView.findViewById(R.id.item_name);
            description = itemView.findViewById(R.id.item_description);
            button = itemView.findViewById(R.id.item_button);

            button.setOnClickListener(v -> {
                Log.i(TAG, header.getText().toString());
            });
        }
    }
}
