package com.vppank.cricketadventure.screen.meo.dialog;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.service.api.model.Item;

import java.util.ArrayList;

public class PickItemDialog extends DialogFragment {

    ItemPickListener listener;

    ImageView item1;
    ImageView item2;
    ImageView item3;

    ArrayList<Item> items = new ArrayList<>();

    public PickItemDialog() {
        // Required empty public constructor
    }

    public static PickItemDialog newInstance(ArrayList<Item> items, ItemPickListener listener) {
        PickItemDialog fragment = new PickItemDialog();
        fragment.listener = listener;
        fragment.items = items;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_pick_item_dialog, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        item1 = v.findViewById(R.id.ic_item1);
        item2 = v.findViewById(R.id.ic_item2);
        item3 = v.findViewById(R.id.ic_item3);
        if (items.size() > 0) {
            item1.setImageDrawable(getActivity().getDrawable(items.get(0).getIcon()));
        }

        if (items.size() > 1) {
            item2.setImageDrawable(getActivity().getDrawable(items.get(1).getIcon()));
        }

        if (items.size() > 2) {
            item3.setImageDrawable(getActivity().getDrawable(items.get(2).getIcon()));
        }

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (items.size() > 0) {
                    listener.onItemPicked(items.get(0));
                    PickItemDialog.this.dismiss();
                }
            }
        });

        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (items.size() > 1) {
                    listener.onItemPicked(items.get(1));
                    PickItemDialog.this.dismiss();
                }
            }
        });

        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (items.size() > 2) {
                    listener.onItemPicked(items.get(2));
                    PickItemDialog.this.dismiss();
                }
            }
        });
    }


    interface ItemPickListener {
        void onItemPicked(Item item);
    }

}
