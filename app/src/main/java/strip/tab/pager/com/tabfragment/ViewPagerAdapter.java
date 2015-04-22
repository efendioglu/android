package strip.tab.pager.com.tabfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Kemal on 22/04/15.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private String tabtitles[] = new String[] { "Sayfam", "Piyasalar", "Hesabım", "Diğer" };

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public float getPageWidth(int position) {
        return super.getPageWidth(position);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return MainActivity.tab1FragmentStack.peek();
            case 1:
                return MainActivity.tab2FragmentStack.peek();
            case 2:
                return MainActivity.tab3FragmentStack.peek();
            case 3:
                return MainActivity.tab4FragmentStack.peek();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabtitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }

}
