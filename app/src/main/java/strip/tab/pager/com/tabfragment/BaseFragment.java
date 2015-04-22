package strip.tab.pager.com.tabfragment;


import android.support.v4.app.Fragment;

import java.util.Stack;

public abstract class BaseFragment extends Fragment {

    public String getFragmentTag(){
        return getClass().getSimpleName();
    }

    public void pushFragment(Stack<BaseFragment> stack, BaseFragment fragment){
        if(MainActivity.fragmentMap.get(fragment.getFragmentTag()) == null)
            MainActivity.tab4FragmentStack.push(fragment);
        MainActivity.fragmentMap.put(fragment.getFragmentTag(), fragment);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((MainActivity) getActivity()).pagerAdapter = new ViewPagerAdapter(getFragmentManager());
                ((MainActivity) getActivity()).viewPager.setAdapter(((MainActivity) getActivity()).pagerAdapter);
                ((MainActivity) getActivity()).viewPager.setCurrentItem(3);
            }
        });
    }

}
