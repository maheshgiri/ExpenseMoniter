package android.hunger.expensetracker.adaptors;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hunger on 3/6/2017.
 */

public class MemberListRecyclerAdaptor extends RecyclerView.Adapter<MemberListRecyclerAdaptor.ViewHolder> {
    @Override
    public MemberListRecyclerAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(MemberListRecyclerAdaptor.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
