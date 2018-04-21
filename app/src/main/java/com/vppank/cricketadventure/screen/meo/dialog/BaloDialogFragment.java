package com.vppank.cricketadventure.screen.meo.dialog;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.service.api.model.Item;
import com.vppank.cricketadventure.storage.share.UserInfo;

import java.util.ArrayList;

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

}
