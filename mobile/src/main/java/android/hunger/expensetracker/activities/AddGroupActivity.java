package android.hunger.expensetracker.activities;

import android.hunger.expensetracker.R;
import android.hunger.expensetracker.adaptors.AddGroupRecyclerMembersAdaptor;
import android.hunger.expensetracker.models.Member;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by hunger on 3/4/2017.
 */

public class AddGroupActivity extends AppCompatActivity {

    private RecyclerView recyclerViewfrdsList;
    private LinearLayoutManager linearLayoutManager;
    private AddGroupRecyclerMembersAdaptor addGroupRecyclerMembersAdaptor;
    private TextInputEditText groupNameEdtTxt,membersSearchEdtTxt;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addgroup);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add Expenses");

        recyclerViewfrdsList = (RecyclerView) findViewById(R.id.membersRecyList);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        addGroupRecyclerMembersAdaptor = new AddGroupRecyclerMembersAdaptor(this);
        recyclerViewfrdsList.setLayoutManager(linearLayoutManager);
        recyclerViewfrdsList.setAdapter(addGroupRecyclerMembersAdaptor);
        groupNameEdtTxt=(TextInputEditText) findViewById(R.id.groupNameEdtTxt);
        membersSearchEdtTxt=(TextInputEditText)findViewById(R.id.membersSearchEdtTxt);

    }


    public void addMembersClick(View view){
        String membernameStr=membersSearchEdtTxt.getText().toString();
        if(!membernameStr.isEmpty()&&membernameStr.length()>0){
          addGroupRecyclerMembersAdaptor.addMember(new Member(membernameStr,"some url"));
        }else {
            Snackbar snackbar=Snackbar.make(recyclerViewfrdsList,"Please enter member name", Snackbar.LENGTH_SHORT);
            snackbar.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.done_button) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
