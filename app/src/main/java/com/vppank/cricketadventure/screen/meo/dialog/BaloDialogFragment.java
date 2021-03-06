package com.vppank.cricketadventure.screen.meo.dialog;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.service.api.ApiClient;
import com.vppank.cricketadventure.service.api.model.BaseResonse;
import com.vppank.cricketadventure.service.api.model.Item;
import com.vppank.cricketadventure.storage.share.UserInfo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaloDialogFragment extends DialogFragment{

    ImageView imgDoAn;
    ImageView imgTuTrang;
    ImageView imgVe;


    public BaloDialogFragment() {
        // Required empty public constructor
    }

    public static BaloDialogFragment newInstance() {
        BaloDialogFragment fragment = new BaloDialogFragment();
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
        View v = inflater.inflate(R.layout.fragment_balo_dialog, container, false);
        initView(v);
        return v;
    }

    public void initView(View v) {

        imgDoAn = v.findViewById(R.id.ic_doan);
        imgTuTrang = v.findViewById(R.id.ic_tutrang);
        imgVe = v.findViewById(R.id.ic_ve);
        for (Integer item : UserInfo.getInstance().getUser().getItemsInBalo()){
            if ( 0 <= item && item <= 2) {
                imgDoAn.setImageDrawable(getActivity().getDrawable(ShopFragmentDialog.LIST_ITEMS.get(item).getIcon()));
            }

            if ( 3 <= item && item <= 5) {
                imgTuTrang.setImageDrawable(getActivity().getDrawable(ShopFragmentDialog.LIST_ITEMS.get(item).getIcon()));
            }

            if ( 6 <= item && item <= 8) {
                imgVe.setImageDrawable(getActivity().getDrawable(ShopFragmentDialog.LIST_ITEMS.get(item).getIcon()));
            }

        }

        v.findViewById(R.id.doan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList doAnDangCo = new ArrayList<Item>();
                for (Integer item: UserInfo.getInstance().getUser().getItems()){
                    if(item < 3){
                        doAnDangCo.add(ShopFragmentDialog.LIST_ITEMS.get(item));
                    }
                }

                PickItemDialog pickDialog = PickItemDialog.newInstance(doAnDangCo, new PickItemDialog.ItemPickListener() {
                    @Override
                    public void onItemPicked(Item item) {
                        imgDoAn.setImageDrawable(getActivity().getDrawable(item.getIcon()));
                        for (Integer i: UserInfo.getInstance().getUser().getItems()){
                            if (i == item.getCode()){
                                UserInfo.getInstance().getUser().getItems().remove(i);
                                break;
                            }
                        }
                        for (Integer itemInBalo : UserInfo.getInstance().getUser().getItemsInBalo()){
                            if ( 0 <= itemInBalo && itemInBalo <= 2) {
                                UserInfo.getInstance().getUser().getItemsInBalo().remove(itemInBalo);
                                UserInfo.getInstance().getUser().getItems().add(itemInBalo);
                                break;
                            }
                        }
                        UserInfo.getInstance().getUser().getItemsInBalo().add(item.getCode());
                    }
                });
                pickDialog.setCancelable(true);
                pickDialog.show(getActivity().getSupportFragmentManager(), "pickDialog");
            }
        });

        v.findViewById(R.id.tutrang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList doAnDangCo = new ArrayList<Item>();

                for (Integer item: UserInfo.getInstance().getUser().getItems()){
                    if(item <= 5 && item >= 3){
                        doAnDangCo.add(ShopFragmentDialog.LIST_ITEMS.get(item));
                    }
                }

                PickItemDialog pickDialog = PickItemDialog.newInstance(doAnDangCo, new PickItemDialog.ItemPickListener() {
                    @Override
                    public void onItemPicked(Item item) {
                        imgTuTrang.setImageDrawable(getActivity().getDrawable(item.getIcon()));
                        for (Integer i: UserInfo.getInstance().getUser().getItems()){
                            if (i == item.getCode()){
                                UserInfo.getInstance().getUser().getItems().remove(i);
                                break;
                            }
                        }
                        for (Integer itemInBalo : UserInfo.getInstance().getUser().getItemsInBalo()){
                            if ( 3 <= itemInBalo && itemInBalo <= 5) {
                                UserInfo.getInstance().getUser().getItemsInBalo().remove(itemInBalo);
                                UserInfo.getInstance().getUser().getItems().add(itemInBalo);
                                break;
                            }
                        }
                        UserInfo.getInstance().getUser().getItemsInBalo().add(item.getCode());

                    }
                });
                pickDialog.setCancelable(true);
                pickDialog.show(getActivity().getSupportFragmentManager(), "pickDialog");
            }
        });

        v.findViewById(R.id.ve).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList doAnDangCo = new ArrayList<Item>();
                for (Integer item: UserInfo.getInstance().getUser().getItems()){
                    if(item <= 8 && item >= 6){
                        doAnDangCo.add(ShopFragmentDialog.LIST_ITEMS.get(item));
                    }
                }

                PickItemDialog pickDialog = PickItemDialog.newInstance(doAnDangCo, new PickItemDialog.ItemPickListener() {
                    @Override
                    public void onItemPicked(Item item) {
                        imgVe.setImageDrawable(getActivity().getDrawable(item.getIcon()));
                        for (Integer i: UserInfo.getInstance().getUser().getItems()){
                            if (i == item.getCode()){
                                UserInfo.getInstance().getUser().getItems().remove(i);
                                break;
                            }
                        }
                        for (Integer itemInBalo : UserInfo.getInstance().getUser().getItemsInBalo()){
                            if ( 6 <= itemInBalo && itemInBalo <= 8) {
                                UserInfo.getInstance().getUser().getItemsInBalo().remove(itemInBalo);
                                UserInfo.getInstance().getUser().getItems().add(itemInBalo);
                                break;
                            }
                        }
                        UserInfo.getInstance().getUser().getItemsInBalo().add(item.getCode());
                    }
                });
                pickDialog.setCancelable(true);
                pickDialog.show(getActivity().getSupportFragmentManager(), "pickDialog");
            }
        });
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (UserInfo.getInstance().getUser().getItemsInBalo().size() == 3){
            int item1 = 0;
            int item2 = 0;
            int item3 = 0;
            for (Integer i: UserInfo.getInstance().getUser().getItemsInBalo()){
                if ( 0 <= i && i <= 2) {
                    item1 = i;
                }
                if ( 3 <= i && i <= 5) {
                    item2 = i;
                }
                if ( 6 <= i && i <= 8) {
                    item3 = i;
                }
            }
            ApiClient.getRestInstance().startTrip(UserInfo.getInstance().getAccessToken(), item1, item2, item3)
                    .enqueue(new Callback<BaseResonse>() {
                        @Override
                        public void onResponse(Call<BaseResonse> call, Response<BaseResonse> response) {
                            Log.e("onResponse", "onResponse");
                            UserInfo.getInstance().getUser().getItemsInBalo().clear();
                        }

                        @Override
                        public void onFailure(Call<BaseResonse> call, Throwable t) {
                            Log.e("onFailure", "onFailure");
                        }
                    });
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.e("onCancel", "onCancel");
    }
}
