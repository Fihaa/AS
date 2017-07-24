package com.example.elashry.aseer.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.elashry.aseer.Activities.Anshta;
import com.example.elashry.aseer.R;
import com.squareup.picasso.Picasso;

import de.ailis.pherialize.MixedArray;
import de.ailis.pherialize.Pherialize;

/**
 * A simple {@link Fragment} subclass.
 */
public class CallsFragment extends Fragment {

ImageView img1,img2;
    public CallsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calls, container, false);


      /*  MixedArray a = Pherialize.unserialize("a:2:{i:0;s:36:\"914cc8df6869c78731fbf47f3ff95c68.jpg\";i:1;s:36:\"1650ebae7f1b701df152240e70a4d161.jpg\";}").toArray();
        Toast.makeText(getContext(),a.getString(0)+"\n"+a.getString(1), Toast.LENGTH_SHORT).show();

        img1= (ImageView)getView().findViewById(R.id.img1);
        img2= (ImageView) getView().findViewById(R.id.img2);

        Picasso.with(getContext()).load("http://wefakhail.org/fihaa/uploads/thumbs/" +a.getString(0)).into(img1);
        Picasso.with(getContext()).load("http://wefakhail.org/fihaa/uploads/thumbs/" +a.getString(1)).into(img2);*/
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MixedArray a = Pherialize.unserialize("a:2:{i:0;s:36:\"914cc8df6869c78731fbf47f3ff95c68.jpg\";i:1;s:36:\"1650ebae7f1b701df152240e70a4d161.jpg\";}").toArray();
        Toast.makeText(getContext(),a.getString(0)+"\n"+a.getString(1), Toast.LENGTH_SHORT).show();

        img1= (ImageView)getView().findViewById(R.id.img1);
        img2= (ImageView) getView().findViewById(R.id.img2);

        Picasso.with(getContext()).load("http://wefakhail.org/fihaa/uploads/thumbs/" +a.getString(0)).into(img1);
        Picasso.with(getContext()).load("http://wefakhail.org/fihaa/uploads/thumbs/" +a.getString(1)).into(img2);
    }
}
