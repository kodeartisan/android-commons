package net.xpece.android.content.res;

import android.content.Context;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyUtils;

import static net.xpece.android.content.XpResources.resolveString;

/**
 * @author Eugen on 20. 4. 2016.
 *
 * @deprecated Support library version 26 supports fonts out-of-the-box.
 */
@Deprecated
public class XpCalligraphyUtils {

    public static void applyFontToTextView(final TextView titleTextView, final int titleTextAppearance) {
        final Context context = titleTextView.getContext();
        String fontPath = getCalligraphyFontPath(context, titleTextAppearance);
        if (fontPath != null) {
            CalligraphyUtils.applyFontToTextView(context, titleTextView, fontPath);
        }
    }

    public static String getCalligraphyFontPath(final Context context, final int titleTextAppearance) {
        int attrId = CalligraphyConfig.get().getAttrId();
        return resolveString(context, titleTextAppearance, attrId);
    }
}
