package android.hunger.expensetracker.adaptors;

import android.content.Context;
import android.hunger.expensetracker.R;
import android.hunger.expensetracker.models.Member;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hunger on 3/6/2017.
 */

public class AddGroupRecyclerMembersAdaptor extends RecyclerView.Adapter<AddGroupRecyclerMembersAdaptor.ViewHolder> {
    private List<Member> memberList;
    private LayoutInflater layoutInflater;
    private Context context;

    public AddGroupRecyclerMembersAdaptor(Context context) {
        memberList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            memberList.add(new Member("Mahesh" + i, "myprofile"));
        }
        this.context = context;
        layoutInflater = layoutInflater.from(context);
        notifyDataSetChanged();
    }

    public void addMember(Member member){
        memberList.add(member);
        notifyItemInserted(memberList.size()-1);
    }

    @Override
    public AddGroupRecyclerMembersAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.viewholder_members, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }


    @Override
    public void onBindViewHolder(AddGroupRecyclerMembersAdaptor.ViewHolder holder, int position) {
        Member member = memberList.get(position);
        holder.memberNameInputEdtTxt.setText(member.getMembername());

    }


    @Override
    public int getItemCount() {
        return memberList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextInputEditText memberNameInputEdtTxt;
        Button buttonEditMember;

        public ViewHolder(View itemView) {
            super(itemView);
            memberNameInputEdtTxt = (TextInputEditText) itemView.findViewById(R.id.memberNameInputEdtTxt);
            buttonEditMember = (Button) itemView.findViewById(R.id.memberEditBtn);
        }

    }
}
