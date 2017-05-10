package ru.ingos.digitalmedicine.ui.adapters;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.SelectRegistryModel;

public class SelectRegistryAdapter extends RecyclerView.Adapter<SelectRegistryAdapter.SelectRegistryHolder>{

    List<SelectRegistryModel> selects = new ArrayList<>();

    public SelectRegistryAdapter() {
        selects.add(new SelectRegistryModel("Выбрать специальность", R.drawable.ic_clinic_sign));
        selects.add(new SelectRegistryModel("Выбрать врача", R.drawable.ic_doctor));
        selects.add(new SelectRegistryModel("Выбрать клинику рядом", R.drawable.ic_clinic_marker));
    }

    @Override
    public SelectRegistryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_select, parent, false);

        return new SelectRegistryHolder(view);
    }

    @Override
    public void onBindViewHolder(SelectRegistryHolder holder, int position) {
        SelectRegistryModel currentObject = this.selects.get(position);
        holder.setData(currentObject.getNameSelect(), currentObject.getIcon());

    }

    @Override
    public int getItemCount() {
        return selects.size();
    }

    public static class SelectRegistryHolder extends RecyclerView.ViewHolder {

        private CardView cvSelect;
        private TextView tvNameSelect;
        private AppCompatImageView aciIcon;

        public SelectRegistryHolder(View itemView) {
            super(itemView);

            cvSelect = (CardView) itemView.findViewById(R.id.item_select_card_view);
            tvNameSelect = (TextView) itemView.findViewById(R.id.iconed_list_item_name);
            aciIcon = (AppCompatImageView) itemView.findViewById(R.id.item_select_icon);

        }

        void setData(String nameSelect, int icon) {
            this.tvNameSelect.setText(nameSelect);
            this.aciIcon.setImageResource(icon);
        }
    }
}
