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
 * Use the {@link InternationalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InternationalFragment extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView contactsRecView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InternationalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InternationalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InternationalFragment newInstance(String param1, String param2) {
        InternationalFragment fragment = new InternationalFragment();
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
        View view = inflater.inflate(R.layout.fragment_international, container, false);

        contactsRecView = view.findViewById(R.id.contactsRecView);

        ArrayList<Books> contacts = new ArrayList<>();
        contacts.add(new Books("Usman Khan", "usmankhan479301617@gamil.com", "https://art-s.nflximg.net/5973f/cf832ad9935510d0fa8dd6970398061d6705973f.jpg"));
        contacts.add(new Books("Peaky Blinders", "peaky12blinders@gamil.com", "https://www.historic-uk.com/wp-content/uploads/2019/02/peaky-blinders-4-2800x1440.jpg"));
        contacts.add(new Books("Joker", "joker1231@gamil.com", "http://images.ctfassets.net/lm0nxqkzuy44/26IflfINZf1ZCx6sDYxpl/05babb962fc29046987ef8230291bfff/mastermind1FEATUREDIMAGE.jpg"));
        contacts.add(new Books("Joker", "joker1231@gamil.com", "http://images.ctfassets.net/lm0nxqkzuy44/26IflfINZf1ZCx6sDYxpl/05babb962fc29046987ef8230291bfff/mastermind1FEATUREDIMAGE.jpg"));

        BooksRecViewAdapter adapter = new BooksRecViewAdapter(getContext());
        adapter.setBooks(contacts);

        contactsRecView.setAdapter(adapter);
        contactsRecView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}