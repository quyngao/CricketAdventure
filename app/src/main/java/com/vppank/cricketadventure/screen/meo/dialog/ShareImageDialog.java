package com.vppank.cricketadventure.screen.meo.dialog;


import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.ShareApi;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.helper.Utils;
import com.vppank.cricketadventure.service.api.model.Mail;

public class ShareImageDialog extends DialogFragment {

    Mail mail;

    public ShareImageDialog() {
        // Required empty public constructor
    }

    public static ShareImageDialog newInstance(Mail mail) {
        ShareImageDialog fragment = new ShareImageDialog();
        fragment.mail = mail;
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
        View v = inflater.inflate(R.layout.fragment_share_image_dialog, container, false);
        ImageView img = v.findViewById(R.id.image);
        ImageView btnShare = v.findViewById(R.id.btnShare);
        Picasso.get().load(this.mail.getImage()).into(img);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.get().load(mail.getImage())
                        .into(new Target() {
                            @Override
                            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                                SharePhoto photo = new SharePhoto.Builder()
                                        .setBitmap(bitmap)
                                        .build();
                                SharePhotoContent content = new SharePhotoContent.Builder()
                                        .addPhoto(photo)
                                        .build();
                                ShareDialog shareDialog = new ShareDialog(getActivity());
                                shareDialog.show(content, ShareDialog.Mode.AUTOMATIC);
                            }

                            @Override
                            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

                            }

                            @Override
                            public void onPrepareLoad(Drawable placeHolderDrawable) {

                            }
                        });

            }
        });
        return v;
    }

}
