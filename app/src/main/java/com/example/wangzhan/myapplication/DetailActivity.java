package com.example.wangzhan.myapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.List;

public class DetailActivity extends FragmentActivity {

   private ViewPager viewPager;
   private List<Gv_Item_DataStructure> dataStructures;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        this.viewPager=this.findViewById(R.id.viewPager);
         dataStructures=new Main3Activity().initData();

         MyPagerAdapter myPagerAdapter= new  MyPagerAdapter(getSupportFragmentManager(),dataStructures);
         viewPager.setAdapter(myPagerAdapter);
         Intent intent =getIntent();
         viewPager.setCurrentItem( intent.getIntExtra("position",0));
    }




    /**
     * 自定义ViewPager适配器
     */
    public class   MyPagerAdapter extends FragmentPagerAdapter{
       List<Gv_Item_DataStructure> mlist;

        public MyPagerAdapter(FragmentManager fm, List<Gv_Item_DataStructure> list) {
            super(fm);
            this.mlist=list;
        }


        @Override
        public Fragment getItem(int i) {

        DetailFragment detailFragment=new DetailFragment();
        Bundle bundle=new Bundle();
        bundle.putSerializable("data",mlist.get(i));
        detailFragment.setArguments(bundle);

            return detailFragment;
        }

        @Override
        public int getCount() {
            return mlist.size();
        }
    }
}
