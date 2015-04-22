package strip.tab.pager.com.tabfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.HashMap;
import java.util.Stack;


public class MainActivity extends FragmentActivity {

    public static HashMap<String, BaseFragment> fragmentMap = new HashMap<>();

    public static Stack<BaseFragment> tab1FragmentStack = new Stack<>();
    public static Stack<BaseFragment> tab2FragmentStack = new Stack<>();
    public static Stack<BaseFragment> tab3FragmentStack = new Stack<>();
    public static Stack<BaseFragment> tab4FragmentStack = new Stack<>();

    public ViewPagerAdapter pagerAdapter;
    public ViewPager viewPager;
    public PagerSlidingTabStrip tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.pager);

        PageFragment page = PageFragment.newInstance(null, null);
        MarketsFragment markets = MarketsFragment.newInstance(null, null);
        AccountFragment account = AccountFragment.newInstance(null, null);
        OtherFragment other = OtherFragment.newInstance(null, null);

        fragmentMap.put(page.getClass().getSimpleName(), page);
        fragmentMap.put(markets.getClass().getSimpleName(), markets);
        fragmentMap.put(account.getClass().getSimpleName(), account);
        fragmentMap.put(other.getClass().getSimpleName(), other);

        tab1FragmentStack.add(page);
        tab2FragmentStack.add(markets);
        tab3FragmentStack.add(account);
        tab4FragmentStack.add(other);

        // Set the ViewPagerAdapter into ViewPager
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(viewPager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        switch (viewPager.getCurrentItem()){
            case 0:
                if(tab1FragmentStack.size() > 1)
                    tab1FragmentStack.pop();
                else
                    super.onBackPressed();
                break;
            case 1:
                if(tab2FragmentStack.size() > 1)
                    tab2FragmentStack.pop();
                else
                    super.onBackPressed();
                break;
            case 2:
                if(tab3FragmentStack.size() > 1)
                    tab3FragmentStack.pop();
                else
                    super.onBackPressed();
                break;
            case 3:
                if(tab4FragmentStack.size() > 1)
                    tab4FragmentStack.pop();
                else
                    super.onBackPressed();
                break;
        }
    }
}
