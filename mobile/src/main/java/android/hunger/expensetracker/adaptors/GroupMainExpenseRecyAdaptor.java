package android.hunger.expensetracker.adaptors;

import android.content.Context;
import android.hunger.expensetracker.R;
import android.hunger.expensetracker.holders.ExpenseEmptyHolder;
import android.hunger.expensetracker.utils.Callback;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hunger on 2/25/2017.
 */


public class GroupMainExpenseRecyAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int GROUP_ITEM_EMPTY = 101;
    private LayoutInflater groupLayoutInflater;
    private Callback callback;
    public GroupMainExpenseRecyAdaptor(Context context) {
        groupLayoutInflater = LayoutInflater.from(context);
        callback= (Callback) context;
    }

    void setData(){

    }

    void updateDataByPosition(int position){

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =null;
        RecyclerView.ViewHolder viewHolder=null;
        if(viewType==GROUP_ITEM_EMPTY) {
            view = groupLayoutInflater.inflate(R.layout.viewholder_item_group_empty, parent, false);
            viewHolder=new ExpenseEmptyHolder(view);
        }
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         ExpenseEmptyHolder expenseEmptyHolder= (ExpenseEmptyHolder) holder;
        expenseEmptyHolder.getButton_addGroup().setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 callback.onClikeCallback();
             }
         });

    }


    @Override
    public int getItemViewType(int position) {
       if(getItemCount()==1){
           return GROUP_ITEM_EMPTY;
       }else return super.getItemViewType(position);
    }


    @Override
    public int getItemCount() {
        return 1;
    }


}
