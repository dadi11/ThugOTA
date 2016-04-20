package delta.out386.thugota;

public class Constants {
    final static String TAG = "borked";

    final static String ACTION_CLOSE_DIALOG = "delta.out386.thugota.CLOSE_DIALOG";
    final static String ACTION_APPLY_DIALOG = "delta.out386.thugota.APPLY_DIALOG";
    final static String GENERIC_DIALOG = "delta.out386.thugota.GENERIC_DIALOG";
    final static String PROGRESS_DIALOG = "delta.out386.thugota.PROGRESS_DIALOG";
    final static String ACTION_NOT_ROM_DIALOG = "delta.out386.thugota.NOT_ROM_DIALOG";

    final static String PROGRESS = "delta.out386.thugota.PROGRESS";
    final static String DIALOG_MESSAGE = "delta.out386.thugota.DIALOG_MESSAGE";
    final static String GENERIC_DIALOG_MESSAGE = "delta.out386.thugota.GENERIC_DIALOG_MESSAGE";

    /**
     * Information about the supported rom.
     * To support all ROMs, set SUPPORTED_ROM_PROP to null.
     * SUPPORTED_ROM_PROP is the is the property that the ROM uses to identify itself.
     * SUPPORTED_ROM_PROP_NAME is any unique part of the SUPPORTED_ROM_PROP property.
     */

    final static String SUPPORTED_ROM_FULL_NAME = "Resurrection Remix";
    final static String SUPPORTED_ROM_PROP = "ro.rr.version";
    final static String SUPPORTED_ROM_PROP_NAME="ResurrectionRemix";
}
