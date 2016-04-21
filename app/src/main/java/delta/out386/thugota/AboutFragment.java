/*
 * Copyright (C) 2016 Ritayan Chakraborty (out386)
 */
/*
 * This file is part of ThugDelta.
 *
 * ThugDelta is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ThugDelta is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with ThugDelta. If not, see <http://www.gnu.org/licenses/>.
 */

package delta.out386.thugota;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {
    View rootView;
    public static AboutFragment newInstance() {
        return new AboutFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_about, container, false);
        ListView lv=(ListView) rootView.findViewById(R.id.aboutListView);
        List<AboutData> aboutList = new ArrayList<>();
        aboutList.add(new AboutData("Apache Commons IO", "Apache License V 2.0", "http://commons.apache.org/io"));
        AboutAdapter adapter = new AboutAdapter(getContext(),
                R.layout.about_list_item, aboutList);
        lv.setAdapter(adapter);

        return rootView;
    }
}
