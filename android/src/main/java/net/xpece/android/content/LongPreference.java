package net.xpece.android.content;

import android.annotation.TargetApi;
import android.content.SharedPreferences;

/**
 * @since API 9
 */
@TargetApi(9)
@Deprecated
public class LongPreference {
    private final SharedPreferences preferences;
    private final String key;
    private final long defaultValue;

    public LongPreference(SharedPreferences preferences, String key) {
        this(preferences, key, 0);
    }

    public LongPreference(SharedPreferences preferences, String key, long defaultValue) {
        this.preferences = preferences;
        this.key = key;
        this.defaultValue = defaultValue;
    }

    public long get() {
        return preferences.getLong(key, defaultValue);
    }

    public boolean isSet() {
        return preferences.contains(key);
    }

    public void set(long value) {
        preferences.edit().putLong(key, value).apply();
    }

    public void delete() {
        preferences.edit().remove(key).apply();
    }
}
