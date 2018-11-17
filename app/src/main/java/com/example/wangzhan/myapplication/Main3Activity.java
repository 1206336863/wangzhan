package com.example.wangzhan.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main3Activity extends AppCompatActivity {

private GridView gridView;

private List<Gv_Item_DataStructure> dataLis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        dataLis=initData();

        gridView=this.findViewById(R.id.gridView3);

        MyAdapter myAdapter=new MyAdapter(this,R.id.gridView3,dataLis);
        gridView.setAdapter(myAdapter);

        //设置GridView的Item点击事件监听器
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Main3Activity.this,DetailActivity.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });
    }





    /**
     * 初始化Item中的数据
     * @return
     */
    public   List<Gv_Item_DataStructure>  initData(){

        List<Gv_Item_DataStructure> gv_item_dataStructureList=new ArrayList<>();


        Gv_Item_DataStructure gv_item_dataStructure1=new Gv_Item_DataStructure("套餐1","8.8折",R.drawable.img1);
        Gv_Item_DataStructure gv_item_dataStructure2=new Gv_Item_DataStructure("套餐2","7.5折",R.drawable.img2);
        Gv_Item_DataStructure gv_item_dataStructure3=new Gv_Item_DataStructure("套餐3","6.0折",R.drawable.img3);
        Gv_Item_DataStructure gv_item_dataStructure4=new Gv_Item_DataStructure("套餐4","8.8折",R.drawable.img4);
        Gv_Item_DataStructure gv_item_dataStructure5=new Gv_Item_DataStructure("套餐5","8.8折",R.drawable.img5);
        Gv_Item_DataStructure gv_item_dataStructure6=new Gv_Item_DataStructure("套餐6","8.8折",R.drawable.img6);
        Gv_Item_DataStructure gv_item_dataStructure7=new Gv_Item_DataStructure("套餐7","9.5折",R.drawable.img7);
        Gv_Item_DataStructure gv_item_dataStructure8=new Gv_Item_DataStructure("套餐8","6.8折",R.drawable.img8);




        gv_item_dataStructureList.add(gv_item_dataStructure1);
        gv_item_dataStructureList.add(gv_item_dataStructure2);
        gv_item_dataStructureList.add(gv_item_dataStructure3);
        gv_item_dataStructureList.add(gv_item_dataStructure4);
        gv_item_dataStructureList.add(gv_item_dataStructure5);
        gv_item_dataStructureList.add(gv_item_dataStructure6);
        gv_item_dataStructureList.add(gv_item_dataStructure7);
        gv_item_dataStructureList.add(gv_item_dataStructure8);

        return gv_item_dataStructureList;
    }



    /**
     * 自定义GridView适配器
     */
    public class MyAdapter extends BaseAdapter{
       List<Gv_Item_DataStructure> mlist;
       public MyAdapter(Context context,int resource, List<Gv_Item_DataStructure> dataStructures)
       {
          this.mlist=dataStructures;
       }

       @Override
       public int getCount() {
           return mlist.size();
       }

       @Override
       public Object getItem(int position) {
           return mlist.get(position);
       }

       @Override
       public long getItemId(int position) {
           return position;
       }

       @Override
       public View getView(int position, View convertView, ViewGroup parent) {
           View view=LayoutInflater.from(getApplicationContext()).inflate(R.layout.grid_item,parent,false);
            TextView tv1 =view.findViewById(R.id.tv1);
            TextView tv2=view.findViewById(R.id.tv2);
            ImageView imageView=view.findViewById(R.id.image_view);

           Gv_Item_DataStructure gv_item_dataStructure;
           gv_item_dataStructure=mlist.get(position);
           tv1.setText(gv_item_dataStructure.getTitle());
           tv2.setText(gv_item_dataStructure.getDiscount());
           imageView.setImageResource(gv_item_dataStructure.getImageId());

           return view;
       }
   }
}
