package com.techrz.loaddata;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class customCourseAdapter extends BaseAdapter {

    Context context;
    ArrayList<courseArrayList> arrayList;
    String data;
    public customCourseAdapter(Context context, ArrayList<courseArrayList> arrayList){
        this.context = context;
        this.arrayList = arrayList;

    }
    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.datacustomview, parent, false);

        TextView coursename = rowView.findViewById(R.id.coursename);



        courseArrayList courseArrayList = arrayList.get(position);


        data = courseArrayList.getData();
        coursename.setText(courseArrayList.getData());
        //System.out.println(data);


        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MyAttendanceActivity.class);
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
