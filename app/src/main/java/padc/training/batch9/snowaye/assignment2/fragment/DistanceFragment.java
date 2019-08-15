package padc.training.batch9.snowaye.assignment2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import padc.training.batch9.snowaye.assignment2.R;
import padc.training.batch9.snowaye.assignment2.activity.DetailActivity;
import padc.training.batch9.snowaye.assignment2.adapter.CarListAdapter;
import padc.training.batch9.snowaye.assignment2.delegate.CarItemDelegate;

public class DistanceFragment extends Fragment implements CarItemDelegate {

    RecyclerView recvCar;
    LinearLayoutManager manager;

    public DistanceFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car_list, container, false);
        recvCar = view.findViewById(R.id.recv_car);
        manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recvCar.setLayoutManager(manager);
        recvCar.setAdapter(new CarListAdapter(this));
        return view;
    }

    @Override
    public void onClickEvent() {
        Intent intent = DetailActivity.newIntent(getContext());
        startActivity(intent);
    }
}
