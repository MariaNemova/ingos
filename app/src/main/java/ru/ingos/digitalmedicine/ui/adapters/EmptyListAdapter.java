package ru.ingos.digitalmedicine.ui.adapters;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;

public class EmptyListAdapter extends RecyclerView.Adapter<EmptyListAdapter.EmptyHolder> {

    private String globalInfo;
    private String globalBtn;
    private View.OnClickListener listener;


    public EmptyListAdapter(String globalInfo, String globalBtn){
        this.globalBtn = globalBtn;
        this.globalInfo = globalInfo;
    }

    public EmptyListAdapter(String globalInfo, String globalBtn, final Class<? extends Fragment> fragmentClass, final Activity activity){
        this.globalBtn = globalBtn;
        this.globalInfo = globalInfo;

        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.showFragmentSupportInActivity(fragmentClass, activity);
            }
        };
    }

    @Override
    public EmptyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_recycler, parent, false);
        if(listener != null) view.setOnClickListener(listener);
        return new EmptyHolder(view);
    }

    @Override
    public void onBindViewHolder(EmptyHolder holder, int position) {
        holder.setTvInfo(globalInfo, globalBtn);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class EmptyHolder extends RecyclerView.ViewHolder{

        private TextView tvInfo;
        private TextView btInfo;


        public EmptyHolder(View itemView) {
            super(itemView);

            this.tvInfo = (TextView)itemView.findViewById(R.id.item_empty_recycler_text);
            this.btInfo = (TextView) itemView.findViewById(R.id.item_empty_recycler_btn);
        }

        public void setTvInfo(String info, String btn){
            this.tvInfo.setText(info);
            this.btInfo.setText(btn);
        }
    }
}
