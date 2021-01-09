package com.martin.training.recyclerviewchallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder>{

    //initializing intance variables
    ItemClicked activity;
    private ArrayList<Car> cars;

    public interface ItemClicked{
        void onItemCLicked(int index);
    }

    public CarAdapter(Context context, ArrayList<Car> carList){
        cars = carList;
        activity = (ItemClicked) context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycling_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder holder, int position) {

        //setting tag and binding view
        holder.itemView.setTag(cars.get(position));

        holder.model.setText(cars.get(position).getModel());
        holder.name.setText(cars.get(position).getName());

        if(cars.get(position).getMake().equals("Mercedes")){
            holder.make.setImageResource(R.drawable.mercedes);
        } else if(cars.get(position).getMake().equals("Volkswagen")){
            holder.make.setImageResource(R.drawable.volkswagen);
        } else{
            holder.make.setImageResource(R.drawable.nissan);
        }


    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    //making my own viewHolder which I will use
    public class ViewHolder extends RecyclerView.ViewHolder{

        //needed instance variables
        TextView name, model;
        ImageView make;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.TVowner);
            model = itemView.findViewById(R.id.TVmodel);
            make = itemView.findViewById(R.id.IVlogo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    activity.onItemCLicked(cars.indexOf((Car) v.getTag()));
                }
            });

        }
    }
}
