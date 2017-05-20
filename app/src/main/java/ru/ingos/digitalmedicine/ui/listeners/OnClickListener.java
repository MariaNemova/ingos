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

    public OnClickListener(Activity parent, Class childActivityClass, String TAG) {
        this.parent = parent;
        this.childActivityClass = childActivityClass;
        this.TAG = TAG;
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
        intent.putExtra(TAG, 2);
        parent.startActivity(intent);
    }
}
