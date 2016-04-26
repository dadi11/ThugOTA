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
import eu.chainfire.libsuperuser.Shell;


public class Constants {
    final static String TAG = "ThugOTA";

    final static String ACTION_CLOSE_DIALOG = "delta.out386.thugota.CLOSE_DIALOG";
    final static String ACTION_APPLY_DIALOG = "delta.out386.thugota.APPLY_DIALOG";
    final static String ACTION_APPLY_DIALOG_FIRST_START = "delta.out386.thugota.APPLY_DIALOG_FIRST_START";
    final static String GENERIC_DIALOG = "delta.out386.thugota.GENERIC_DIALOG";
    final static String PROGRESS_DIALOG = "delta.out386.thugota.PROGRESS_DIALOG";
    final static String ACTION_NOT_ROM_DIALOG = "delta.out386.thugota.NOT_ROM_DIALOG";
    final static String AUTO_UPDATE = "delta.out386.thugota.AUTO_UPDATE";
    final static String NO_ROMS = "delta.out386.thugota.NO_ROMS";

    final static String PROGRESS = "delta.out386.thugota.PROGRESS";
    final static String DIALOG_MESSAGE = "delta.out386.thugota.DIALOG_MESSAGE";
    final static String GENERIC_DIALOG_MESSAGE = "delta.out386.thugota.GENERIC_DIALOG_MESSAGE";
    final static String AUTO_UPDATE_BASE = "delta.out386.thugota.AUTO_UPDATE_BASE";
    final static String AUTO_UPDATE_DELTA = "delta.out386.thugota.AUTO_UPDATE_DELTA";

    /**
     * Information about the supported rom.
     * To support all ROMs, set SUPPORTED_ROM_PROP to null.
     * Supporting all ROMs will disable delta auto apply.
     * SUPPORTED_ROM_PROP is the is the property that the ROM uses to identify itself.
     * SUPPORTED_ROM_PROP_NAME is any unique part of the SUPPORTED_ROM_PROP property.
     */

    final static String SUPPORTED_ROM_FULL_NAME = "Resurrection Remix";
    final static String SUPPORTED_ROM_PROP = "ro.rr.version";
    final static String SUPPORTED_ROM_PROP_NAME = "ResurrectionRemix";

    // The delimiter(s) used in the ROM zip to separate name, date, version, etc. 
    // Include "." in delimiter, adjust LOCATION constants appropiately
    final static String ROM_ZIP_DELIMITER = "-.";
    final static int ROM_ZIP_NAME_LOCATION = 1;
    final static int ROM_ZIP_DATE_LOCATION = 6;
    final static int ROM_ZIP_DEVICE_LOCATION = 7;
    final static String ROM_ZIP_NAME = "ResurrectionRemix";
    final static String ROM_ZIP_DEVICE_NAME = Shell.SH.run("getprop ro.rr.device").get(0);
    /**
     * EXAMPLE : ROMName-VersionMajor.VersionMinor-Device-Date.zip
     */
}
