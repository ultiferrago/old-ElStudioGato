package edu.auburn.eng.csse.comp3710.team6;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Tyler Hoover on 4/27/15.
 */
public class SectionAdapter extends BaseAdapter {

    private ArrayList<Section> sections;
    private Context ctx;
    private static LayoutInflater layoutInflater;

    public SectionAdapter(Context ctx, Subject sub) {
        sections = new ArrayList();
        for (Section sec : sub.getSections()) {
            sections.add(sec);
        }
        this.ctx = ctx;
        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return sections.size();
    }

    @Override
    public Object getItem(int position) {
        return sections.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View rowView = layoutInflater.inflate(R.layout.adapter_layout, null);

        TextView tv = (TextView) rowView.findViewById(R.id.SubjectText);
        tv.setText(sections.get(position).getName());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //A button was clicked launch the section fragment.
                Log.i("SectionClick", sections.get(position).getName());


            }
        });
        return rowView;

    }
}
