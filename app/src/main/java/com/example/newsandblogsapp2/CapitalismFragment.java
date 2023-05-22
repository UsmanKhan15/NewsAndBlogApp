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
 * Use the {@link CapitalismFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CapitalismFragment extends Fragment {

    private RecyclerView capitalismRecView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CapitalismFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CapitalismFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CapitalismFragment newInstance(String param1, String param2) {
        CapitalismFragment fragment = new CapitalismFragment();
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
        View view = inflater.inflate(R.layout.fragment_capitalism, container, false);

        capitalismRecView = view.findViewById(R.id.capitalismRecView);

        ArrayList<NewsAndArticles> newsAndArticles = new ArrayList<>();

        newsAndArticles.add(new NewsAndArticles(1,"News","Paksitan is under hybrid regime","Dawn", "Null",
                "Null","Powerful military is ruling the country",
                "https://e-syndicate.net/wp-content/uploads/2019/08/General-Qamar-Javed-Bajwa-to-lead-Pakistan-Army-for-another-three-years-640x360.jpg"));
        newsAndArticles.add(new NewsAndArticles(2,"News", "Is Turkey the emerging power? Is Turkey the emerging power","TRT World",
                "","","Turkey is strengthing his economy, and paying lot of attention to military power",
                "http://www.smartearningmethods.com/wp-content/uploads/2016/08/what-is-net-worth-of-Tayyip-Erdogan.jpg"));
        newsAndArticles.add(new NewsAndArticles(3,"News","USA using illegal tactics against China","Chinese Ministry", "Null",
                "Null","Powerful military is ruling the country",
                "https://specials-images.forbesimg.com/imageserve/1202948800/960x0.jpg?fit=scale"));

        newsAndArticles.add(new NewsAndArticles(4,"News","Yemen economy is at the verge of collapse","UNDP", "Null",
                "Null","Powerful military is ruling the country",
                "https://i.middle-east-online.com/styles/home_special_coverage_1920xauto/s3/2020-06/yemen%20economy.jpg?lu__GD8m9YQA.b7h8hXSpOEiaSCLLpBj&itok=uvDmA9BD"));
        NewsRecViewAdapter adapter = new NewsRecViewAdapter(getContext());
        adapter.setNewsAndArticles(newsAndArticles);

        capitalismRecView.setAdapter(adapter);
        capitalismRecView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}