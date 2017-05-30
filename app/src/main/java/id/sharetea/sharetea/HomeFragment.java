package id.sharetea.sharetea;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.storage.StorageReference;

import java.util.zip.Inflater;

public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myInflater = inflater.inflate(R.layout.fragment_home, container, false);
        ViewPager pager = (ViewPager) myInflater.findViewById(R.id.slider);
        AndroidImageAdapter adapterView = new AndroidImageAdapter(getActivity());
        pager.setAdapter(adapterView);
        // Inflate the layout for this fragment
        return myInflater;
    }




}
