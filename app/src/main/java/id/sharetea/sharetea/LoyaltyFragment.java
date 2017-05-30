package id.sharetea.sharetea;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class LoyaltyFragment extends Fragment {

LinearLayout pay;
    LinearLayout scan;
    LinearLayout reward;
    LinearLayout histoty;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myInflater = inflater.inflate(R.layout.fragment_loyalty, container, false);
        pay=(LinearLayout) myInflater.findViewById(R.id.pay);
        scan=(LinearLayout) myInflater.findViewById(R.id.scan);
        reward=(LinearLayout) myInflater.findViewById(R.id.reward);
        histoty=(LinearLayout) myInflater.findViewById(R.id.history);


        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),ScanActivity.class);
                startActivity(i);
            }
        });
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),ScanActivity.class);
                startActivity(i);
            }
        });
        reward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),RewardActivity.class);
                startActivity(i);
            }
        });
        return myInflater;
    }


}
