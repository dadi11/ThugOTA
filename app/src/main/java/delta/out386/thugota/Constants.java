package delta.out386.thugota;

public class Constants {
    final static String TAG = "ThugOTA";

    final static String ACTION_CLOSE_DIALOG = "delta.out386.thugota.CLOSE_DIALOG";
    final static String ACTION_APPLY_DIALOG = "delta.out386.thugota.APPLY_DIALOG";
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
    final static String ROM_ZIP_DEVICE_NAME = "lettuce";
    /**
     * EXAMPLE : ROMName-VersionMajor.VersionMinor-Device-Date.zip
     */
}
