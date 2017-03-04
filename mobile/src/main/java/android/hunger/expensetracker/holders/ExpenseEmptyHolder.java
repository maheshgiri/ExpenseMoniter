package android.hunger.expensetracker.holders;

import android.hunger.expensetracker.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

/**
 * Created by hunger on 3/4/2017.
 */

public class ExpenseEmptyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
private Button button_addGroup;


    public ExpenseEmptyHolder(View itemView) {
        super(itemView);
        button_addGroup=(Button) itemView.findViewById(R.id.createGroupBtn);
        button_addGroup.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

    }

    public Button getButton_addGroup() {
        return button_addGroup;
    }

    public void setButton_addGroup(Button button_addGroup) {
        this.button_addGroup = button_addGroup;
    }
}


