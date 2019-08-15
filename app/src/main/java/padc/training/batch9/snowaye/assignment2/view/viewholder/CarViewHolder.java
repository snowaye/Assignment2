package padc.training.batch9.snowaye.assignment2.view.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import padc.training.batch9.snowaye.assignment2.delegate.CarItemDelegate;

public class CarViewHolder extends RecyclerView.ViewHolder {

    public CarViewHolder(@NonNull View itemView, final CarItemDelegate delegate) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.onClickEvent();
            }
        });
    }
}
