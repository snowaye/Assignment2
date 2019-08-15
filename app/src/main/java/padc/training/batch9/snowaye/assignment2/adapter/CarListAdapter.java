package padc.training.batch9.snowaye.assignment2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import padc.training.batch9.snowaye.assignment2.R;
import padc.training.batch9.snowaye.assignment2.delegate.CarItemDelegate;
import padc.training.batch9.snowaye.assignment2.view.viewholder.CarViewHolder;

public class CarListAdapter extends RecyclerView.Adapter<CarViewHolder> {

    CarItemDelegate carItemDelegate;

    public CarListAdapter(CarItemDelegate carItemDelegate) {
        this.carItemDelegate = carItemDelegate;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_car, viewGroup, false);
        return new CarViewHolder(view, carItemDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder carViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
