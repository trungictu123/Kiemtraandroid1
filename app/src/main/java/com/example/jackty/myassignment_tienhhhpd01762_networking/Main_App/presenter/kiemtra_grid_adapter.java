package com.example.jackty.myassignment_tienhhhpd01762_networking.Main_App.presenter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jackty.myassignment_tienhhhpd01762_networking.Main_App.model.sode_kiemtra;
import com.example.jackty.myassignment_tienhhhpd01762_networking.R;

import java.util.ArrayList;

/**
 * Created by jackty on 06/08/2017.
 */

public class kiemtra_grid_adapter extends ArrayAdapter<sode_kiemtra> {

    public kiemtra_grid_adapter(Context context, ArrayList<sode_kiemtra> exam) {
        super(context, 0, exam);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView= inflater.inflate(R.layout.item_gridv_kiemtra, parent, false);
        }
        TextView tvName= (TextView) convertView.findViewById(R.id.tvNumExam);
        ImageView imgIcon= (ImageView) convertView.findViewById(R.id.imgIcon);

        sode_kiemtra p= getItem(position);
        if(p!=null){
            tvName.setText(""+ p.getDe());
            imgIcon.setImageResource(R.drawable.test);
        }

        return convertView;
    }
}
