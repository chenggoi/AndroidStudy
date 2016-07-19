package com.chenggoi.androidstudy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by chenggoi on 16-7-19.
 */

public class ListViewAdapter extends ArrayAdapter<ListViewItem> {
    private int resourseId;

    public ListViewAdapter(Context context, int resource, List<ListViewItem> objects) {
        super(context, resource, objects);
        resourseId = resource;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ListViewItem item = getItem(position);
//        View view = LayoutInflater.from(getContext()).inflate(resourseId, null);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourseId, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.img);
            viewHolder.textView = (TextView) view.findViewById(R.id.list_item);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

//        ImageView imageView = (ImageView) view.findViewById(R.id.img);
//        TextView textView = (TextView) view.findViewById(R.id.list_item);
        viewHolder.imageView.setImageResource(item.getImgId());
        viewHolder.textView.setText(item.getName());

        return view;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
