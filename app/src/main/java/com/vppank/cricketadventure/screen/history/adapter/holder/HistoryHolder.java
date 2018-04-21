package com.vppank.cricketadventure.screen.history.adapter.holder;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.user.adapter.listener.OnUserItemClickListener;
import com.vppank.cricketadventure.service.api.model.Transation;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.content)
    protected ImageView imageType;

    @BindView(R.id.title)
    protected TextView title;

    @BindView(R.id.description)
    protected TextView description;

    @BindView(R.id.time)
    protected TextView time;

    Transation transation;


    public HistoryHolder(View itemView) {
        super(itemView);
    }

    public HistoryHolder(@LayoutRes int layoutRes, LayoutInflater inflater, ViewGroup parent) {
        this(inflater.inflate(layoutRes, parent, false));
        ButterKnife.bind(this, itemView);
    }

    public void render(Transation transation) {
        this.transation = transation;

        title.setText(String.format("Giá trị giao dịch %d", transation.getBalance()));
        description.setText(String.format("+ %d %s", transation.getAddedGameBalance(), itemView.getContext().getString(R.string.grass)));
        time.setText(transation.getCreatedAtString());

        switch (transation.getType()) {
            case 0:
                imageType.setImageResource(R.drawable.ic_debit_card);
                break;
            case 1:
                imageType.setImageResource(R.drawable.ic_credit_card);

                break;
            case 2:
                imageType.setImageResource(R.drawable.ic_deposit);

                break;
            case 3:
                imageType.setImageResource(R.drawable.ic_withdrawal);

                break;
            case 4:
                imageType.setImageResource(R.drawable.ic_telco_topup);

                break;
            case 5:
                imageType.setImageResource(R.drawable.ic_utility_payment);
                break;
        }
    }
}
