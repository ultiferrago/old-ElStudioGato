package edu.auburn.eng.csse.comp3710.team6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tyler Hoover on 4/27/15.
 */
public class SectionDeleteAdapter extends BaseAdapter {

    private ArrayList<Section> sections;
    private Context ctx;
    private static LayoutInflater layoutInflater;

    private ArrayList<Integer> selected = new ArrayList<>();

    public SectionDeleteAdapter(Context ctx, ArrayList<Section> sections) {
        this.sections = sections;
        this.ctx = ctx;
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        View rowView = layoutInflater.inflate(R.layout.delete_list_item_layout, null);
        final ImageView paw = (ImageView) rowView.findViewById(R.id.pawIcon);

        if (selected.contains(position)) {
            paw.setBackgroundResource(R.drawable.paw_selected);
        }

        TextView tv = (TextView) rowView.findViewById(R.id.delete_item_name);
        tv.setText(sections.get(position).getName());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!selected.contains(position)) {
                    paw.setBackgroundResource(R.drawable.paw_selected);
                    selected.add((Integer) position);
                } else {
                    paw.setBackgroundResource(R.drawable.paw_unselected);
                    selected.remove((Integer) position);
                }
            }
        });
        return rowView;

    }

    public ArrayList<Integer> getSelected() {
        return selected;
    }

    public void setSelected(ArrayList<Integer> selected) {
        this.selected = (ArrayList<Integer>) selected.clone();
    }
}
