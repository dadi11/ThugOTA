/*
 * Copyright (C) 2016 Ritayan Chakraborty (out386)
 */
/*
 * This file is part of ThugOTA.
 *
 * ThugOTA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ThugOTA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with ThugOTA. If not, see <http://www.gnu.org/licenses/>.
 */

package delta.out386.thugota;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.content.Intent;
import java.util.List;
import android.support.v4.widget.DrawerLayout;
import eu.chainfire.libsuperuser.Shell;
import android.util.Log;

public class MainActivity extends Activity
implements NavigationDrawerFragment.NavigationDrawerCallbacks
{
    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Checking if the app has been made ROM specific or not
        if(Constants.SUPPORTED_ROM_PROP != null) {
            List<String> romVersion = Shell.SH.run("getprop " + Constants.SUPPORTED_ROM_PROP);
            if (romVersion == null || romVersion.size() == 0 || !romVersion.get(0).contains(Constants.SUPPORTED_ROM_PROP_NAME)) {
                // Unsupported ROM. Let's quit.
                new NotSupportedRom().execute();
            }
        }

        mNavigationDrawerFragment = (NavigationDrawerFragment)
			getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position)
	{
        // update the main content by replacing fragments
        Fragment fragment=new Fragment();
        switch (position)
        {
            case 0: fragment = AutoApplyFragment.newInstance();
				break;
            case 1: fragment = BaseFragment.newInstance(position + 1);
                break;
            case 2: fragment = BaseFragment.newInstance(position + 1);
                break;
            case 3: fragment = BaseFragment.newInstance(position + 1);
                break;
            case 4: fragment = BaseFragment.newInstance(position + 1);
                break;
            case 5: fragment = QueueFragment.newInstance(position + 1);
                break;
            case 6: fragment = AboutFragment.newInstance();
                break;
        }
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
			.replace(R.id.container, fragment)
			.commit();
    }
    @Override
    public void onRequestPermissionsResult(int code, String[] permissions, int[] result) {
        if(result.length > 0 && result[0] == PackageManager.PERMISSION_GRANTED)
        {
            FragmentManager fragmentManager = getFragmentManager();
            BaseFragment fragment = BaseFragment.newInstance(1);
            View mFragmentContainerView = findViewById(R.id.navigation_drawer);
            DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            mDrawerLayout.closeDrawer(mFragmentContainerView);
            fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }
    }
    private class NotSupportedRom extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(Void... voids) {
            Intent notRomDialog = new Intent(Constants.ACTION_NOT_ROM_DIALOG);
            startActivity(new Intent(getApplication(), DeltaDialogActivity.class)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            try {
                Thread.sleep(4000);
                // Delay needed as the activity needs time to register the receiver
            }
            catch (InterruptedException e)
            {}
            LocalBroadcastManager.getInstance(getApplication()).sendBroadcast(notRomDialog);
            finish();
            return null;
        }
    }
}