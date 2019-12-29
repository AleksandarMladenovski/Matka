package com.extremedesign.matka.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.extremedesign.matka.FullScreenDialog;
import com.extremedesign.matka.MainActivity;
import com.extremedesign.matka.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPagerFragment extends Fragment {

    private int position;
    private int drawableImage;

    public ViewPagerFragment() {
        // Required empty public constructor
    }

    public ViewPagerFragment(int position) {
        // Required empty public constructor
        this.position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_view_pager, container, false);
        ImageView imageView = itemView.findViewById(R.id.view_pager_image);
        TextView textViewHistory = (TextView) itemView.findViewById(R.id.view_pager_fragment_text);
        drawableImage = -1;
        switch (position) {
            case 0:
                drawableImage = R.drawable.istorija_2;
                imageView.setImageDrawable(getResources().getDrawable(drawableImage));
                textViewHistory.setText(getResources().getString(R.string.history_text_1));
                break;
            case 1:
                drawableImage = R.drawable.istorija_3;
                imageView.setImageDrawable(getResources().getDrawable(drawableImage));
                textViewHistory.setText(getResources().getString(R.string.history_text_2));
                break;
            case 2:
                drawableImage = R.drawable.istorija_4;
                imageView.setImageDrawable(getResources().getDrawable(drawableImage));
                textViewHistory.setText(getResources().getString(R.string.history_text_3));
                break;
            case 3:
                drawableImage = R.drawable.istorija_5;
                imageView.setImageDrawable(getResources().getDrawable(drawableImage));
                textViewHistory.setText(getResources().getString(R.string.history_text_4));
                break;
        }
        itemView.findViewById(R.id.enter_full_screen_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawableImage != -1) {
                    FullScreenDialog dialog = new FullScreenDialog(drawableImage);

                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialog.show(ft, FullScreenDialog.TAG);
                }
            }
        });
        return itemView;
    }

}
