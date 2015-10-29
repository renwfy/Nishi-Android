package nishi.android.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;

import nishi.android.net.NSCallback;

/**
 * Created by LSD on 15/10/16.
 */
public abstract class BaseActivity extends FragmentActivity implements NSCallback.OnShowProgressDialogListener, NSCallback.OnNotLoginListener {
}
