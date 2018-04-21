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

import com.squareup.picasso.Picasso;
import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.service.api.ApiClient;
import com.vppank.cricketadventure.service.api.model.GetMailResponse;
import com.vppank.cricketadventure.service.api.model.Mail;
import com.vppank.cricketadventure.storage.share.UserInfo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MailDialogFragment extends DialogFragment {

    private ArrayList<Mail> listMail = new ArrayList<>();

    RecyclerView recyclerView;

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
        getData();
        return v;
    }

    private void initView(View v) {
        recyclerView = v.findViewById(R.id.list_item);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(new MailItemDialogAdapter());
    }

    public void getData() {
        ApiClient.getRestInstance().getMails(UserInfo.getInstance().getAccessToken())
                .enqueue(new Callback<GetMailResponse>() {
                    @Override
                    public void onResponse(Call<GetMailResponse> call, Response<GetMailResponse> response) {
                        listMail = response.body().getMails();
                        recyclerView.getAdapter().notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<GetMailResponse> call, Throwable t) {

                    }
                });
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
            Picasso.get().load(listMail.get(position).getImage()).into(holder.imageView);
            holder.txtTime.setText(listMail.get(position).getCreatedAtString());
        }

        @Override
        public int getItemCount() {
            return listMail.size();
        }

        class ItemViewHolder extends RecyclerView.ViewHolder {


            ImageView imageView;

            TextView txtTime;


            public ItemViewHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.image);
                txtTime = itemView.findViewById(R.id.time);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ShareImageDialog baloDialog = ShareImageDialog.newInstance(listMail.get(getLayoutPosition()));//where MyFragment is my fragment I want to show
                        baloDialog.setCancelable(true);

                        baloDialog.show(getActivity().getSupportFragmentManager(), "baloDialog");
                    }
                });

            }
        }
    }

}
