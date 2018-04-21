package com.vppank.cricketadventure.screen.home;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.app.CricketApplication;
import com.vppank.cricketadventure.helper.Utils;
import com.vppank.cricketadventure.screen.common.BaseFragment;
import com.vppank.cricketadventure.screen.login.LoginActivity;
import com.vppank.cricketadventure.screen.main.MainActivity;
import com.vppank.cricketadventure.screen.shopping.ShoppingActivity;
import com.vppank.cricketadventure.screen.splash.SplashActivity;
import com.vppank.cricketadventure.service.api.ApiClient;
import com.vppank.cricketadventure.service.api.model.TranQuantity;
import com.vppank.cricketadventure.service.api.model.TransationResponse;
import com.vppank.cricketadventure.service.api.model.User;
import com.vppank.cricketadventure.service.api.model.UserResponse;
import com.vppank.cricketadventure.storage.share.UserInfo;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.name)
    protected TextView userName;

    @BindView(R.id.actor)
    protected ImageView imageView;

    @BindView(R.id.birthday)
    protected TextView birthday;

    @BindView(R.id.description_service)
    protected View addService;


    @BindView(R.id.content1)
    protected ImageView hasCredit;

    @BindView(R.id.content2)
    protected ImageView hasBanking;


    @BindView(R.id.card_view_has_credit)
    protected View viewHasCredit;

    @BindView(R.id.card_view_banking)
    protected View viewHasBanking;

    @BindView(R.id.text_credit)
    protected TextView tvHasCredit;

    @BindView(R.id.text_banking)
    protected TextView tvHasBanking;


    @BindView(R.id.description)
    protected TextView description;


    @BindView(R.id.tv_credit)
    protected TextView tvCredit;

    @BindView(R.id.tv_debit)
    protected TextView tvDebit;

    @BindView(R.id.tv_deposit)
    protected TextView tvDeposit;


    @BindView(R.id.tv_withdrawal)
    protected TextView tvWithdrawl;


    @BindView(R.id.tv_telco)
    protected TextView tvTelco;

    @BindView(R.id.tv_utility)
    protected TextView tvUtility;


    @BindView(R.id.card_view_credit)
    protected View viewCredit;

    @BindView(R.id.card_view_debit)
    protected View viewDebit;

    @BindView(R.id.card_view_deposit)
    protected View viewDeposit;


    @BindView(R.id.card_view_withdrawal)
    protected View viewWithdrawl;


    @BindView(R.id.card_view_telco)
    protected View viewTelco;

    @BindView(R.id.card_view_utility)
    protected View viewUtility;

    User user;
    TranQuantity tranQuantity;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        user = CricketApplication.getPrefManager().getUser();
        tranQuantity = CricketApplication.getPrefManager().getTranQuantity();
    }

    @Override
    protected void loadData() {
        // TODO REQUEST API TO RELOAD

        userName.setText(user.getName());
        birthday.setText("Ngày sinh: 02/01/1994");
        description.setText(String.format("Thu thập: %d \uD83C\uDF40 \nKhám phá: %d km", user.getTotalWeed(), user.getTotalTravel()));


        tvHasCredit.setText(user.isHasCreditCard() ? getString(R.string.content_has_credit) : getString(R.string.content_hasnt_credit));
        tvHasBanking.setText(user.isHasInternetBanking() ? getString(R.string.content_has_banking) : getString(R.string.content_hasnt_banking));

        viewHasCredit.setBackgroundResource(user.isHasCreditCard() ? R.color.background_has_service : R.color.background_hasnt_service);
        viewHasBanking.setBackgroundResource(user.isHasInternetBanking() ? R.color.background_has_service : R.color.background_hasnt_service);

        tvHasBanking.setTextColor(user.isHasInternetBanking() ? R.color.primary_text : R.color.secondary_text);
        tvHasCredit.setTextColor(user.isHasCreditCard() ? R.color.primary_text : R.color.secondary_text);

        if (user.isHasInternetBanking()) {
            hasBanking.setImageResource(R.drawable.ic_glasses);
        }
        if (user.isHasCreditCard()) {
            hasCredit.setImageResource(R.drawable.ic_hat);
        }
        if (user.isHasCreditCard() && user.isHasInternetBanking()) {
            addService.setVisibility(View.GONE);
        }

//        viewDebit.setBackgroundResource(tranQuantity.getType0() != 0 ? R.color.background_has_service : R.color.background_hasnt_service);
//        viewCredit.setBackgroundResource(tranQuantity.getType1() != 0 ? R.color.background_has_service : R.color.background_hasnt_service);
//        viewDeposit.setBackgroundResource(tranQuantity.getType2() != 0 ? R.color.background_has_service : R.color.background_hasnt_service);
//        viewWithdrawl.setBackgroundResource(tranQuantity.getType3() != 0 ? R.color.background_has_service : R.color.background_hasnt_service);
//        viewTelco.setBackgroundResource(tranQuantity.getType4() != 0 ? R.color.background_has_service : R.color.background_hasnt_service);
//        viewUtility.setBackgroundResource(tranQuantity.getType5() != 0 ? R.color.background_has_service : R.color.background_hasnt_service);

        tvDebit.setText(String.format("Debit Card(%s)", tranQuantity.getType0()));
        tvCredit.setText(String.format("Credit Card (%s)", tranQuantity.getType1()));
        tvDeposit.setText(String.format("Gửi tiền (%s)", tranQuantity.getType2()));
        tvWithdrawl.setText(String.format("Rút tiền (%s)", tranQuantity.getType3()));
        tvTelco.setText(String.format("Ngoại khối (%s)", tranQuantity.getType4()));
        tvUtility.setText(String.format("Tiện ích (%s)", tranQuantity.getType5()));

    }

    public void registryService(final String message, boolean hasInternetBanking, boolean hasCreditCard) {
        showLoadingDialog();
        ApiClient.getRestInstance().registerService(hasInternetBanking, hasCreditCard).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                dissmissLoadingDialog();
                if (response.body().isSuccess()) {
                    Utils.newBuilderAlertDialog(getContext())
                            .setTitle("Đăng kí thành công")
                            .setMessage(message)
                            .setPositiveButton("Đóng", null)
                            .setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialogInterface) {
                                    refreshData();
                                }
                            })
                            .show();
                } else {
                    dissmissLoadingDialog();
                    showMessageError(response.body().getMessage());

                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                dissmissLoadingDialog();
                showMessageError("Lỗi kết nối server");
            }
        });
    }


    public void addTransation(final String message, final int type) {

        showLoadingDialog();

        ApiClient.getRestInstance().creatTransation(type).enqueue(new Callback<TransationResponse>() {
            @Override
            public void onResponse(Call<TransationResponse> call, final Response<TransationResponse> response) {
                dissmissLoadingDialog();
                if (response.body().isSuccess()) {
                    Utils.newBuilderAlertDialog(getContext())
                            .setTitle("Giao dịch thành công")
                            .setMessage(String.format(message + " %d", response.body().getTransation().getBalance()))
                            .setPositiveButton("Đóng", null)
                            .setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialogInterface) {
                                    refreshData();
                                }
                            })
                            .show();
                } else {
                    dissmissLoadingDialog();
                    showMessageError(response.body().getMessage());

                }
            }

            @Override
            public void onFailure(Call<TransationResponse> call, Throwable t) {
                dissmissLoadingDialog();
                showMessageError("Lỗi kết nối server");
            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();
        refreshData();
    }

    public void refreshData() {
        ApiClient.getRestInstance().getProfile()
                .enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        dissmissLoadingDialog();
                        if (response.body().isSuccess()) {
                            CricketApplication.getPrefManager().saveUser(response.body().getUser());
                            CricketApplication.getPrefManager().saveTranQuanlity(response.body().getTranQuantity());
                            UserInfo.getInstance().setUser(response.body().getUser());
                            UserInfo.getInstance().setAccessToken(response.body().getToken());
                            user = response.body().getUser();
                            tranQuantity = response.body().getTranQuantity();
                            loadData();
                        } else {
                            showMessageError(response.body().getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        dissmissLoadingDialog();
                        showMessageError("Lỗi kết nối server");
                    }
                });

    }

    @OnClick(R.id.card_view_has_credit)
    public void onHasCreditClicked() {
        if (!user.isHasCreditCard()) {
            registryService("Thẻ Credit Card đã được tạo", user.isHasInternetBanking(), true);
        } else {

        }
    }

    @OnClick(R.id.card_view_banking)
    public void onHasBankingClicked() {
        if (!user.isHasInternetBanking()) {
            registryService("Tài khoản internet banking đã được tạo", true, user.isHasCreditCard());
        } else {

        }
    }


    @OnClick(R.id.card_view_debit)
    public void onDebitClicked() {
        addTransation("Giao dịch thẻ Debit ", 0);
    }

    @OnClick(R.id.card_view_credit)
    public void onCreditClicked() {
        addTransation("Giao dịch thẻ Credit ", 1);

    }

    @OnClick(R.id.card_view_deposit)
    public void onDepositClicked() {
        addTransation("Gửi tiền", 2);

    }

    @OnClick(R.id.card_view_withdrawal)
    public void onWithdrawalClicked() {
        addTransation("Rút tiền ", 3);

    }

    @OnClick(R.id.card_view_telco)
    public void onTelcoClicked() {
        addTransation("Giao dịch ngoại khối ", 4);

    }

    @OnClick(R.id.card_view_utility)
    public void onUtilityClicked() {
        addTransation("Thanh toán tiện ích ", 5);

    }
}
