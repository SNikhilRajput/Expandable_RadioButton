package com.androidtutorialshub.expandablelistview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.androidtutorialshub.expandablelistview.adapter.ChildModel;
import com.androidtutorialshub.expandablelistview.adapter.ExpandableListViewAdapter;
import com.androidtutorialshub.expandablelistview.adapter.ModelList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;

    private ExpandableListViewAdapter expandableListViewAdapter;

    private List<ModelList> listDataGroup;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // initializing the views
        initViews();

        // initializing the listeners
        initListeners();

        // initializing the objects
        initObjects();

        // preparing list data
        initListData();

    }


    /**
     * method to initialize the views
     */
    private void initViews() {

        expandableListView = findViewById(R.id.expandableListView);

    }

    /**
     * method to initialize the listeners
     */
    private void initListeners() {

        // ExpandableListView on child click listener
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

//               set Unique Key
                    expandableListViewAdapter.ChilSelected(listDataGroup.get(groupPosition).getChildModel().get(childPosition).getId());
//                if(listDataGroup.get(groupPosition).getChildModel().get(childPosition).isStatus()){
//                    listDataGroup.get(groupPosition).getChildModel().get(childPosition).setStatus(false);
//                }else  listDataGroup.get(groupPosition).getChildModel().get(childPosition).setStatus(true);

                Toast.makeText(
                        getApplicationContext(),
                        listDataGroup.get(groupPosition).getName()
                                + " : "
                                + listDataGroup.get(groupPosition).getChildModel().get(childPosition).getName(), Toast.LENGTH_SHORT)
                        .show();

                expandableListViewAdapter.notifyDataSetChanged();
                return false;
            }
        });

        // ExpandableListView Group expanded listener
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataGroup.get(groupPosition) + " " + getString(R.string.text_collapsed),
                        Toast.LENGTH_SHORT).show();
            }
        });

        // ExpandableListView Group collapsed listener
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataGroup.get(groupPosition) + " " + getString(R.string.text_collapsed),
                        Toast.LENGTH_SHORT).show();

            }
        });

    }

    /**
     * method to initialize the objects
     */
    private void initObjects() {

        // initializing the list of groups
        listDataGroup = new ArrayList<>();

        // initializing the list of child

        // initializing the adapter object
        expandableListViewAdapter = new ExpandableListViewAdapter(this, listDataGroup);

        // setting list adapter
        expandableListView.setAdapter(expandableListViewAdapter);

    }

    /*
     * Preparing the list data
     *
     * Dummy Items
     */
    private void initListData() {
        ArrayList<ChildModel> childModel=new ArrayList<>();
        childModel.add(new ChildModel("1","Child1One",false));
        childModel.add(new ChildModel("2","Child1Two",false));
        childModel.add(new ChildModel("3","Child1Three",false));

        listDataGroup.add(new ModelList("0","First",childModel));

         childModel=new ArrayList<>();
        childModel.add(new ChildModel("4","Child2One",false));
        childModel.add(new ChildModel("5","Child2Two",false));

        listDataGroup.add(new ModelList("1","Secound",childModel));

         childModel=new ArrayList<>();
        childModel.add(new ChildModel("6","ChildOne3",false));

        listDataGroup.add(new ModelList("2","Third",childModel));

        childModel=new ArrayList<>();
        listDataGroup.add(new ModelList("2","Four",childModel));


        // notify the adapter
        expandableListViewAdapter.notifyDataSetChanged();
    }

}
