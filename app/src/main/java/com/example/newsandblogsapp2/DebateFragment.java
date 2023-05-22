package com.example.newsandblogsapp2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DebateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DebateFragment extends Fragment {

    private RecyclerView debateRecView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DebateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DebateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DebateFragment newInstance(String param1, String param2) {
        DebateFragment fragment = new DebateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        View view = inflater.inflate(R.layout.fragment_debate, container, false);

        debateRecView = view.findViewById(R.id.debateRecView);

        ArrayList<Debate> debates = new ArrayList<>();


        debates.add(new Debate(1,"Debate","Climate crises are due to Capitalism","Usman Khan", "Null",
                "These endless crises are the crises of Capitalism, because in this system everything is for profit not for human welfare",
                "https://peppermintmag.com/wp-content/uploads/2020/07/peppermint-climate-crisis2.jpg"));

        debates.add(new Debate(2,"Debate", "Climate crises are the crises due to mismanagement","Asad Jatoi",
                "Asad Jatoi","Turkey is strengthing his economy, and paying lot of attention to military power",
                "https://www.atlanticcouncil.org/wp-content/uploads/2019/09/2019-climate-march-sign.jpg"));
        debates.add(new Debate(3,"Debate","Paksitan is under hybrid regime","Dawn", "Null",
                "Powerful military is ruling the country","https://e-syndicate.net/wp-content/uploads/2019/08/General-Qamar-Javed-Bajwa-to-lead-Pakistan-Army-for-another-three-years-640x360.jpg"));

        DebateRecViewAdapter adapter = new DebateRecViewAdapter(getContext());
        adapter.setDebates(debates);

        debateRecView.setAdapter(adapter);
        debateRecView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}