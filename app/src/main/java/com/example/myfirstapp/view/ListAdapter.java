package com.example.myfirstapp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstapp.R;
import com.example.myfirstapp.model.DataEntitiy;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListItemViewHolder>{
    private ArrayList<DataEntitiy> listThing = new ArrayList<DataEntitiy>();;
    ListAdapter(){
        listThing = new ArrayList<>();
    }

    public void initialize(ArrayList<DataEntitiy> list){
        this.listThing = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);
        return new ListItemViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder ItemViewHolder, int i) {
        ItemViewHolder.doThing(listThing.get(i));
    }

    @Override
    public int getItemCount() {
        return listThing.size();
    }
    class ListItemViewHolder extends RecyclerView.ViewHolder {

        private TextView text;

        ListItemViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.textVu);
        }
        void doThing(DataEntitiy Item) {
            text.setText(Item.getStringText());
        }
    }
}
