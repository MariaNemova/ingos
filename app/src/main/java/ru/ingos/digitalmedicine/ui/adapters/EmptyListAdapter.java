package ru.ingos.digitalmedicine.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ru.ingos.digitalmedicine.R;

public class EmptyListAdapter extends RecyclerView.Adapter<EmptyListAdapter.EmptyHolder> {

    public String globalInfo;
    public String globalBtn;

    public EmptyListAdapter(String globalInfo, String globalBtn){
        this.globalBtn = globalBtn;
        this.globalInfo = globalInfo;
    }

    @Override
    public EmptyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_recycler, parent, false);
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
