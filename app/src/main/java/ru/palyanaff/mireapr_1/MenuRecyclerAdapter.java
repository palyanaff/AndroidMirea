package ru.palyanaff.mireapr_1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MenuRecyclerAdapter extends RecyclerView.Adapter<MenuRecyclerAdapter.MenuItem> {
    private static final String TAG = "MenuRecyclerAdapter";
    private LayoutInflater inflater;
    private static List<OrderItem> list;

    MenuRecyclerAdapter(Context context, ArrayList<OrderItem> list){
        this.inflater = LayoutInflater.from(context);
        this.list = list;
    }

    @NonNull
    @Override
    public MenuItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.order_item, parent, false);
        return new MenuItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItem holder, int position) {
        OrderItem item = list.get(position);
        holder.imageView.setImageResource(item.getImage());
        holder.header.setText(item.getHeader());
        holder.description.setText(item.getDescription());
        holder.button.setText(item.getCost());
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
