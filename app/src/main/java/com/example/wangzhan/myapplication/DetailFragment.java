package com.example.wangzhan.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    private ImageView detail_image;
    private TextView detail_tv1;
    private TextView detail_tv2;
    private  View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

         view = inflater.inflate(R.layout.detail_layout, container, false);

         initView(view);
         setView();
        return view;
    }



    private void initView(View view) {
        detail_image = (ImageView) view.findViewById(R.id.detail_image);
        detail_tv1 = (TextView) view.findViewById(R.id.detail_tv1);
        detail_tv2 = (TextView) view.findViewById(R.id.detail_tv2);
    }


    /**
     * 设置内容
     */
    private void  setView(){
      Bundle bundle=getArguments();
      Gv_Item_DataStructure dataStructure= (Gv_Item_DataStructure) bundle.getSerializable("data");

        detail_image.setImageResource(dataStructure.getImageId());
        detail_tv1.setText(dataStructure.getTitle());
        detail_tv2.setText(dataStructure.getDiscount());

    }
}
