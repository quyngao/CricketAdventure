package com.vppank.cricketadventure.screen.meo.dialog;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.vppank.cricketadventure.R;

public class MailDialogFragment extends DialogFragment {

    public MailDialogFragment() {
        // Required empty public constructor
    }

    public static MailDialogFragment newInstance() {
        MailDialogFragment fragment = new MailDialogFragment();

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
        View v = inflater.inflate(R.layout.fragment_mail_dialog, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        RecyclerView recyclerView = v.findViewById(R.id.list_item);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(new MailItemDialogAdapter());
    }

    class MailItemDialogAdapter extends RecyclerView.Adapter<MailItemDialogAdapter.ItemViewHolder> {

        @Override
        public MailItemDialogAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater mLayoutInflater = LayoutInflater.from(getActivity());
            View v = mLayoutInflater.inflate(R.layout.item_mail_viewholder, parent, false);
            return new MailItemDialogAdapter.ItemViewHolder(v);
        }

        @Override
        public void onBindViewHolder(MailItemDialogAdapter.ItemViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 20;
        }

        class ItemViewHolder extends RecyclerView.ViewHolder {


            ImageView icon;

            TextView txtTitle;

            TextView txtPrice;

            Button btnBuy;

            public void onBuyClicked(View v) {

            }

            public ItemViewHolder(View itemView) {
                super(itemView);

            }
        }
    }

}
