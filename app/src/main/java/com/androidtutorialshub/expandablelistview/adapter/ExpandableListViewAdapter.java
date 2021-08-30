package com.androidtutorialshub.expandablelistview.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.androidtutorialshub.expandablelistview.R;

import java.util.HashMap;
import java.util.List;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    private Context context;

    // group titles
     List<ModelList> listDataGroup;
     String selectedId="";

    // child data in format of header title, child title


    public ExpandableListViewAdapter(Context context, List<ModelList> listDataGroup) {
        this.context = context;
        this.listDataGroup = listDataGroup;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this.listDataGroup.get(groupPosition).getChildModel().get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {


        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_row_child, null);
        }

        CheckBox textViewChild = convertView
                .findViewById(R.id.textViewChild);

        textViewChild.setText(listDataGroup.get(groupPosition).getChildModel().get(childPosition).getName());
        textViewChild.setChecked(listDataGroup.get(groupPosition).getChildModel()
                .get(childPosition).getId().equalsIgnoreCase(selectedId));

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listDataGroup.get(groupPosition).getChildModel().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataGroup.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listDataGroup.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_row_group, null);
        }

        TextView textViewGroup = convertView
                .findViewById(R.id.textViewGroup);
        textViewGroup.setTypeface(null, Typeface.BOLD);
        textViewGroup.setText(listDataGroup.get(groupPosition).getName());

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void ChilSelected(String selectedId){
        this.selectedId=selectedId;
        notifyDataSetChanged();
    }
}
