package id.sharetea.sharetea;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ebanx.swipebtn.SwipeButton;


public class StampFragment extends Fragment {
TextView redeem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myInflater = inflater.inflate(R.layout.fragment_stamp, container, false);
        redeem = (TextView) myInflater.findViewById(R.id.redeem);
        redeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),SwipeActivity.class);
                startActivity(i);
            }
        });

        // Inflate the layout for this fragment
        return myInflater;
    }


}
