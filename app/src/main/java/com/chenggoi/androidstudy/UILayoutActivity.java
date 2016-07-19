package com.chenggoi.androidstudy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenggoi on 16-7-13.
 */

public class UILayoutActivity extends Activity {
    private List<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();
//    private String[] data = {"1", "2", "3", "4", "5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        float xdpi = getResources().getDisplayMetrics().xdpi;
        initList();
        ListViewAdapter adapter = new ListViewAdapter(UILayoutActivity.this, R.layout.list_view_item, listViewItemList);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(UILayoutActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListViewItem item = listViewItemList.get(position);
                Toast.makeText(UILayoutActivity.this, item.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initList() {
        ListViewItem item = new ListViewItem("xxxx", R.drawable.ic_launcher);
        listViewItemList.add(item);
        ListViewItem item2 = new ListViewItem("ttt", R.drawable.ic_launcher);
        listViewItemList.add(item2);
        ListViewItem item3 = new ListViewItem("uuuu", R.drawable.ic_launcher);
        listViewItemList.add(item3);

    }
}
