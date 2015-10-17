package com.lib.utils;

import java.io.File;

/**
 * Created by LSD on 15/9/23.
 */
public class FileUtil {
    public static String CACHE_BASE = "";

    /**
     * @return
     */
    public static File getFoder(){
        if(!FileUtil.isSDExist()){
            return null;
        }
        File folder = new File(getFolderPath());
        if(!folder.exists()){
            folder.mkdir();
        }
        return folder;
    }

    public static String getCacheFolderPath(){
        return getFolderPath() + "/" + CACHE_BASE;
    }
    public static String getFolderPath(){
        return android.os.Environment.getExternalStorageDirectory().toString() + CACHE_BASE;
    }

    public static boolean isSDExist(){
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }

}
