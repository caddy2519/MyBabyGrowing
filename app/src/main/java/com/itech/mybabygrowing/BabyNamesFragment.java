package com.itech.mybabygrowing;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.itech.DataBasesHandlers.DataBaseSQLiteHandler;
import com.itech.adapter.RecyclerViewBabyNameAdapter;
import com.itech.models.BabyName;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BabyNamesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BabyNamesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BabyNamesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView listView;
    private RecyclerViewBabyNameAdapter recyclerViewBabyNameAdapter;
    private ArrayList<BabyName> babyNamesBoys;
    private ArrayList<BabyName> babyNamesGirls;
    private Activity activity;
    DataBaseSQLiteHandler dbh ;


    public boolean isBoysList() {
        return boysList;
    }

    public void setBoysList(boolean boysList) {
        this.boysList = boysList;
    }

    private boolean boysList = true;
//    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BabyNamesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BabyNamesFragment newInstance(String param1, String param2) {
        BabyNamesFragment fragment = new BabyNamesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public BabyNamesFragment() {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_baby_names, container, false);

        listView = (ListView) view.findViewById(R.id.list_baby_names);

        babyNamesBoys = new ArrayList<BabyName>();

        babyNamesGirls = new ArrayList<BabyName>();

        init_data_bebenames();


        /*babyNamesBoys.add(new BabyName("Iheb", false));
        babyNamesBoys.add(new BabyName("Anis", false));
        babyNamesBoys.add(new BabyName("Said", false));
        babyNamesBoys.add(new BabyName("Abderahman", false));
        babyNamesBoys.add(new BabyName("Amine", false));
        babyNamesBoys.add(new BabyName("Imad", false));
        babyNamesBoys.add(new BabyName("Ishak", false));
        babyNamesBoys.add(new BabyName("Younes", false));

        babyNamesGirls.add(new BabyName("Hiba", false));
        babyNamesGirls.add(new BabyName("Lina", false));
        babyNamesGirls.add(new BabyName("Nawal", false));
        babyNamesGirls.add(new BabyName("Khadija", false));*/


        recyclerViewBabyNameAdapter = new RecyclerViewBabyNameAdapter(getActivity(), babyNamesBoys,babyNamesGirls);
        listView.setAdapter(recyclerViewBabyNameAdapter);
       // listView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        this.activity=activity ;
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        //     mListener = null;
    }

    public void showBoysList( FloatingActionButton floatingActionButton) {

        boysList = true;
        recyclerViewBabyNameAdapter.changeList(true);
        floatingActionButton.setIconDrawable(getResources().getDrawable(R.drawable.male));

    }

    public void showGirlsList(FloatingActionButton floatingActionButton) {
        boysList = false;
        recyclerViewBabyNameAdapter.changeList(false);
        floatingActionButton.setIconDrawable(getResources().getDrawable(R.drawable.female));


    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    public  void init_data_bebenames(){
         dbh=new DataBaseSQLiteHandler(this.getActivity()) ;
        babyNamesBoys=dbh.getBabyNamesByGenre("boy") ;
        babyNamesGirls=dbh.getBabyNamesByGenre("girl") ;

    }

    @Override
    public void onDestroy() {




        super.onDestroy();
    }
}
