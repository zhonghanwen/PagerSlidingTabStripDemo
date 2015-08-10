package com.zhw.pagerslidingtabstripdemo;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends FragmentActivity {

	private ArrayList<String> fragments = new ArrayList<String>();
	private String[] TITLE = { "圈子项目", "待审核项目" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fragments.add(ProjectDynamicFragment.class.getName());
		fragments.add(ProjectDynamicFragment.class.getName());
		 // Initialize the ViewPager and set an adapter
		 ViewPager pager = (ViewPager) findViewById(R.id.pager);
		 pager.setAdapter(new FragmentsAdapter(MainActivity.this,this.getSupportFragmentManager(),fragments));

		 // Bind the tabs to the ViewPager
		 PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		 tabs.setViewPager(pager);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	class FragmentsAdapter extends FragmentPagerAdapter {
		private Context context = null;
		private ArrayList<Fragment> list = new ArrayList<Fragment>();

		public FragmentsAdapter(Context context, FragmentManager fm,
				ArrayList<String> fNames) {
			super(fm);
			this.context = context;
			init(fNames);
		}

		private void init(ArrayList<String> fNames) {
			int size = fNames.size();
			for (int i = 0; i < size; i++) {
				list.add(Fragment.instantiate(context, fNames.get(i)));
			}
		}

		@Override
		public Fragment getItem(int index) {
			return list.get(index);
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLE[position];
		}

	}

}
