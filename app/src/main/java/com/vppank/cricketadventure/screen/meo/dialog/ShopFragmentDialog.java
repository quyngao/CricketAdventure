package com.vppank.cricketadventure.screen.meo.dialog;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.service.api.model.Item;
import com.vppank.cricketadventure.storage.share.UserInfo;

import java.util.ArrayList;


public class ShopFragmentDialog extends DialogFragment {

    OnBoughtItemListener listener;

    RecyclerView listItem;

    View btnShop;

    public static ArrayList<Item> LIST_ITEMS = new ArrayList<Item>() {{
        add(new Item(0, "Cá", 8, R.drawable.item_ca));
        add(new Item(1, "Bánh mì", 16, R.drawable.item_banhmi));
        add(new Item(2, "Xúc xích", 10, R.drawable.item_xucxich));
        add(new Item(3, "Đèn pin", 30, R.drawable.item_den));
        add(new Item(4, "Lều trại", 50, R.drawable.item_leu));
        add(new Item(5, "Củi đốt", 80, R.drawable.item_cui));
        add(new Item(6, "Vé xe khách", 3, R.drawable.bus_ticket));
        add(new Item(7, "Vé tàu hỏa", 5, R.drawable.train_ticket));
        add(new Item(8, "Vé máy bay", 10, R.drawable.fly_ticket));
    }};

    public static ShopFragmentDialog newInstance(OnBoughtItemListener listener) {
        ShopFragmentDialog fragment = new ShopFragmentDialog();
        fragment.listener = listener;
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
        View v =  inflater.inflate(R.layout.fragment_shop_fragment_dialog, container, false);
        setupView(v);
        return v;
    }

    private void setupView(View v){
        listItem = v.findViewById(R.id.list_item);
        listItem.setLayoutManager(new LinearLayoutManager(getActivity()));
        listItem.setAdapter(new ShopItemAdapter());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public interface OnBoughtItemListener {
        void onBoughtItem(int code);
    }

    class ShopItemAdapter extends RecyclerView.Adapter<ShopItemAdapter.ItemViewHolder> {

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater mLayoutInflater = LayoutInflater.from(getActivity());
            View v = mLayoutInflater.inflate(R.layout.item_shop_viewholder, parent, false);
            return new ItemViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, int position) {
            holder.icon.setImageDrawable(getResources().getDrawable(LIST_ITEMS.get(position).getIcon()));
            holder.txtPrice.setText(String.valueOf(LIST_ITEMS.get(position).getPrice()));
            holder.txtTitle.setText(LIST_ITEMS.get(position).getName());
        }

        @Override
        public int getItemCount() {
            return LIST_ITEMS.size();
        }

        class ItemViewHolder extends RecyclerView.ViewHolder {


            ImageView icon;

            TextView txtTitle;

            TextView txtPrice;

            Button btnBuy;

            public void onBuyClicked(View v) {
                listener.onBoughtItem(getAdapterPosition());
                this.btnBuy.setEnabled(false);
            }

            public ItemViewHolder(View itemView) {
                super(itemView);
                this.txtTitle = itemView.findViewById(R.id.txtName);
                this.txtPrice = itemView.findViewById(R.id.txtPrice);
                this.icon =  itemView.findViewById(R.id.icon);
                boolean hasItem = false;
                for (int i = 0; i < UserInfo.getInstance().getUser().getItems().size(); i++){
                    if (UserInfo.getInstance().getUser().getItems().get(i).equals(getAdapterPosition())){
                        hasItem = true;
                        break;
                    }
                }
                this.btnBuy = itemView.findViewById(R.id.btnBuy);
                if (hasItem) {
                    this.btnBuy.setEnabled(false);
                } else {
                    this.btnBuy.setEnabled(true);
                }

                this.btnBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onBuyClicked(view);
                    }
                });

            }
        }
    }

}
