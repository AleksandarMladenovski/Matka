package com.extremedesign.matka.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.extremedesign.matka.R;
import com.extremedesign.matka.listener.RecyclerViewChangeLayout;
import com.extremedesign.matka.model.Exhibit;

import java.util.List;

public class ExhibitAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Exhibit> exhibits;
    private  Context context;
    public ExhibitAdapter(List<Exhibit> exhibits,Context context) {
        this.exhibits = exhibits;
        this.context=context;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return 0;
        }
        else{
            return 1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new ExhibitHolder
                    (LayoutInflater.from(parent.getContext()).inflate(R.layout.ehxibit_first_item_list, parent, false));
        }
        else{
            return new ExhibitHolder
                    (LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exhibit_linear, parent, false));

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int final_position=holder.getAdapterPosition();
        Exhibit exhibit=exhibits.get(final_position);

        if(getItemViewType(final_position)==0){
            ((ExhibitHolder)holder).exhibitTitle.setText(exhibit.getTitle());
            ((ExhibitHolder)holder).exhibitContent.setText(exhibit.getContent());
        }
        else if(getItemViewType(final_position)==1){
            ((ExhibitHolder)holder).exhibitTitle.setText(exhibit.getTitle());
            ((ExhibitHolder)holder).exhibitContent.setText(exhibit.getContent());
            ((ExhibitHolder)holder).exhibitImage
                    .setImageDrawable(context.getResources().getDrawable(exhibit.getDrawableImage()));
        }

    }
    @Override
    public int getItemCount() {
        return exhibits.size();
    }

    class ExhibitHolder extends RecyclerView.ViewHolder {
        private TextView exhibitTitle;
        private TextView exhibitContent;
        private ImageView exhibitImage;
        public ExhibitHolder(@NonNull View itemView) {
            super(itemView);
            exhibitTitle=itemView.findViewById(R.id.exhibit_title);
            exhibitImage=itemView.findViewById(R.id.exhibit_image);
            exhibitContent=itemView.findViewById(R.id.exhibit_content);

        }
    }
}
