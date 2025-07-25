package com.szxm.av.utils;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


public class SettingStorage {
    private static final String FILE_NAME = "AI_CALL_SETTING_STORAGE";
    private static class LAZY_HOLDER {
        private static SettingStorage sInstance = new SettingStorage();
    }

    public static final String KEY_ROBOT_ID = "KEY_ROBOT_ID";
    public static final String KEY_AUDIO_DUMP_SWITCH = "KEY_AUDIO_DUMP_SWITCH";
    public static final String KEY_AUDIO_TIPS_SWITCH = "KEY_AUDIO_TIPS_SWITCH";
    public static final String KEY_SHOW_EXTRA_DEBUG_CONFIG = "KEY_SHOW_EXTRA_DEBUG_CONFIG";
    public static final String KEY_APP_SERVER_TYPE = "KEY_APP_SERVER_TYPE";
    public static final String KEY_DEPOSIT_SWITCH = "KEY_DEPOSIT_SWITCH";
    public static final String KEY_USE_RTC_PRE_ENV_SWITCH = "KEY_USE_RTC_PRE_ENV_SWITCH";
    public static final String KEY_BOOT_ENABLE_PUSH_TO_TALK = "KEY_BOOT_ENABLE_PUSH_TO_TALK";
    public static final String KEY_BOOT_ENABLE_VOICE_PRINT = "KEY_BOOT_ENABLE_VOICE_PRINT";
    public static final String KEY_SHARE_BOOT_USE_DEMO_APP_SERVER = "KEY_SHARE_BOOT_USE_DEMO_APP_SERVER";
    public static final String KEY_BOOT_USER_EXTEND_DATA = "KEY_BOOT_USER_EXTEND_DATA";
    public static final String KEY_BOOT_ENABLE_EMOTION = "KEY_BOOT_ENABLE_EMOTION";
    public static final String KEY_BOOT_ENABLE_AUDIO_DELAY_INFO = "KEY_BOOT_ENABLE_AUDIO_DELAY_INFO";
    public static final String KEY_BOOT_ENABLE_AGENT_AUTO_EXIT = "KEY_BOOT_ENABLE_AGENT_AUTO_EXIT";
    public static final String KEY_BOOT_ENABLE_SEMATNIC = "KEY_BOOT_ENABLE_SEMATNIC";

    public static final String KEY_ENABLE_VOICE_INTERRUPT = "KEY_ENABLE_VOICE_INTERRUPT";
    public static final String KEY_VOICE_ID = "KEY_VOICE_ID";
    public static final String KEY_USER_OFFLINE_TIMEOUT = "KEY_USER_OFFLINE_TIMEOUT";
    public static final String KEY_MAX_IDLE_TIME = "KEY_MAX_IDLE_TIME";
    public static final String KEY_WORK_FLOW_OVERRIDE_PARAMS = "KEY_WORK_FLOW_OVERRIDE_PARAMS";
    public static final String KEY_BAILIAN_APP_PARAMS = "KEY_BAILIAN_APP_PARAMS";
    public static final String KEY_LLM_SYSTEM_PROMPT = "KEY_LLM_SYSTEM_PROMPT";
    public static final String KEY_VOLUME = "KEY_VOLUME";
    public static final String KEY_GREETING = "KEY_GREETING";
    public static final String KEY_VOICE_PRINT_ID = "KEY_VOICE_PRINT_ID";
    public static final String KEY_ENABLE_INTELLIGENT_SEGMENT = "KEY_ENABLE_INTELLIGENT_SEGMENT";
    public static final String KEY_AVATAR_ID = "KEY_AVATAR_ID";
    public static final String KEY_ASR_MAX_SILENCE = "KEY_ASR_MAX_SILENCE";
    public static final String KEY_USER_ONLINE_TIME_OUT = "KEY_USER_ONLINE_TIME_OUT";
    public static final String KEY_USER_ASR_LANGUAGE = "KEY_USER_ASR_LANGUAGE";
    public static final String KEY_INTERRUPT_WORDS = "KEY_INTERRUPT_WORDS";
    public static final String KEY_VAD_LEVEL = "KEY_VAD_LEVEL";
    public static final String KEY_USE_APP_SERVER_START_AGENT = "KEY_USE_APP_SERVER_START_AGENT";
    public static final String KEY_ASR_HOT_WORDS = "KEY_ASR_HOT_WORDS";
    public static final String KEY_TURN_END_WORDS = "KEY_TURN_END_WORDS";
    public static final String KEY_ASR_CUSTOM_PARAMS = "KEY_ASR_CUSTOM_PARAMS";
    public static final String KEY_PRONUNCIATION_RULES = "KEY_PRONUNCIATION_RULES";
    public static final String KEY_VCR_CONFIG_RULES = "KEY_VCR_CONFIG_RULES";
    public static final String KEY_BOOT_SEMATNIC_DURATION = "KEY_BOOT_SEMATNIC_DURATION";


    public static final boolean DEFAULT_DEPOSIT_SWITCH = true;
    public static final boolean DEFAULT_EXTRA_DEBUG_CONFIG = false;
    public static final boolean DEFAULT_APP_SERVER_TYPE = false;
    public static final boolean DEFAULT_USE_RTC_PRE_ENV = false;
    public static final boolean DEFAULT_ENABLE_PUSH_TO_TALK = false;
    public static final boolean DEFAULT_ENABLE_VOICE_PRINT = false;
    public static final boolean DEFAULT_SHARE_BOOT_USE_DEMO_APP_SERVER = false;
    public static final boolean DEFAULT_BOOT_ENABLE_EMOTION = false;
    public static final boolean DEFAULT_USE_APPSERVER_START_AGENT = false;



    private SharedPreferences mSP = null;

    public static SettingStorage getInstance() {
        return LAZY_HOLDER.sInstance;
    }

    public void init(Context context) {
        if (mSP == null) {
            Context applicationContext = context.getApplicationContext();
            mSP = applicationContext.getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        }
        Log.i("SettingStorage", "init: " + mSP);
    }

    public void set(String key, String value) {
        SharedPreferences.Editor editor = mSP.edit();
        editor.putString(key, value);
        editor.apply();
        Log.i("SettingStorage", "set " + key + ": " + value);
    }

    public String get(String key) {
        String value = mSP.getString(key, "");
        Log.i("SettingStorage", "get " + key + ": " + value);
        return value;
    }

    public String get(String key, String defaultValue) {
        String value = mSP.getString(key, defaultValue);
        Log.i("SettingStorage", "get " + key + ": " + value);
        return value;
    }


    public boolean getBoolean(String key, boolean defaultValue) {
        boolean value = mSP.getBoolean(key, defaultValue);
        Log.i("SettingStorage", "getBoolean " + key + ": " + value);
        return value;
    }

    public boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    public void setBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = mSP.edit();
        editor.putBoolean(key, value);
        editor.apply();
        Log.i("SettingStorage", "setBoolean " + key + ": " + value);
    }
}
