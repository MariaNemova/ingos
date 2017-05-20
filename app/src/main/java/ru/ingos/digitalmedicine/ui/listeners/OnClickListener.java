package ru.ingos.digitalmedicine.ui.listeners;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import ru.ingos.digitalmedicine.IngosApplication;

public class OnClickListener implements View.OnClickListener {

    private final Activity parent;
    private Class childActivityClass;
    private String TAG;
    private long value = 0;

    public OnClickListener(Activity parent, Class childActivityClass, String TAG) {
        this.parent = parent;
        this.childActivityClass = childActivityClass;
        this.TAG = TAG;
//        this.value = value;
    }

    public OnClickListener(Activity parent, Class childActivityClass, String TAG, long value) {
        this.parent = parent;
        this.childActivityClass = childActivityClass;
        this.TAG = TAG;
        this.value = value;
    }

    public void setValue(long value){
        this.value = value;
    }

    @Override
    public void onClick(View v) {
        if(parent == null){
            Log.w("MOJAR","Can't find parent activity reference");
            return;
        }
        if(childActivityClass == null){
            Log.w("MOJAR", "Can't find child activity");
            return;
        }

        Intent intent = new Intent(parent, childActivityClass);
        Log.d(IngosApplication.DEBUG_TAG, "Tag: "+TAG+" Value: "+this.value);
        if(TAG != null)intent.putExtra(TAG, (int) this.value);
        parent.startActivity(intent);
    }
}
