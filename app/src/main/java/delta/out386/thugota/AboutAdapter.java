package delta.out386.thugota;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class AboutAdapter extends ArrayAdapter<AboutData> {
    private Context context;
    public AboutAdapter(Context context, int resource,List<AboutData> items) {
        super(context,resource,items);
        this.context = context;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        View v = convertView;
        if(v == null)
            v= LayoutInflater.from(getContext()).inflate(R.layout.about_list_item,null);
        final AboutData p = getItem(position);
        if(p != null) {
            TextView name = (TextView) v.findViewById(R.id.libraryNameText);
            TextView link = (TextView) v.findViewById(R.id.libraryLinkText);
            name.setText(p.name);
            link.setText(p.link);
        }
        return v;
    }
}

