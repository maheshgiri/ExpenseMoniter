package android.hunger.expensetracker.activities;

import android.content.Intent;
import android.graphics.Rect;
import android.hunger.expensetracker.R;
import android.hunger.expensetracker.adaptors.GroupMainExpenseRecyAdaptor;
import android.hunger.expensetracker.utils.Callback;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Callback {
    private CollapsingToolbarLayout
            collapsingToolbar;
    private LinearLayoutManager linearLayManager;
    private RecyclerView mainRecyclerView;
    private GroupMainExpenseRecyAdaptor groupMainExpenseRecyAdaptor;
    private static final String TAG = "MainActivity";
    private AddGroupActivity addGroupActivity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("ExpenseTracker");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setTitle("Add Expenses");


        initViews();

        linearLayManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        groupMainExpenseRecyAdaptor = new GroupMainExpenseRecyAdaptor(this);
        mainRecyclerView.setAdapter(groupMainExpenseRecyAdaptor);
        mainRecyclerView.setLayoutManager(linearLayManager);
        mainRecyclerView.addItemDecoration(new SpacesItemDecoration(0));

    }

    private void initViews() {
        mainRecyclerView = (RecyclerView) findViewById(R.id.mainRecyView);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    public void onClikeCallback() {

        Intent intent=new Intent(this,AddGroupActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
                super.onBackPressed();
        }

    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private final int mSpace;

        public SpacesItemDecoration(int space) {
            this.mSpace = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = mSpace;
            outRect.right = mSpace;
            outRect.bottom = mSpace;
            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildAdapterPosition(view) == 1)
                outRect.top = 0;
        }
    }
}
