package strip.tab.pager.com.tabfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OtherFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OtherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OtherFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OtherFragment newInstance(String param1, String param2) {
        OtherFragment fragment = new OtherFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public OtherFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    String menu [] = new String[]{
            "Hisse İşlemleri",
            "Viop İşlemleri",
            "Hesaplarım",
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.other, container, false);

        ListView list = (ListView) v.findViewById(R.id.list);

        ArrayAdapter adapt = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, menu);
        list.setAdapter(adapt);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    if(MainActivity.fragmentMap.get(StockFragment.class.getSimpleName()) != null){
                        pushFragment(MainActivity.tab4FragmentStack, MainActivity.fragmentMap.get(StockFragment.class.getSimpleName()));
                    } else{
                        StockFragment stock = StockFragment.newInstance(null, null);
                        pushFragment(MainActivity.tab4FragmentStack, stock);
                    }
                } else if(position == 1){
                    if(MainActivity.fragmentMap.get(ViopFragment.class.getSimpleName()) != null){
                        pushFragment(MainActivity.tab4FragmentStack, MainActivity.fragmentMap.get(ViopFragment.class.getSimpleName()));
                    } else{
                        ViopFragment viop = ViopFragment.newInstance(null, null);
                        pushFragment(MainActivity.tab4FragmentStack, viop);
                    }
                } else{

                }
            }
        });

        return v;
    }


}
