package id.sharetea.sharetea;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import id.sharetea.sharetea.persistence.User;


public class ProfileFragment extends Fragment {

TextView logout,name,email,phone;
    private DatabaseReference mDatabase;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myInflater = inflater.inflate(R.layout.fragment_profile, container, false);

        logout = (TextView) myInflater.findViewById(R.id.logout);
        name = (TextView) myInflater.findViewById(R.id.name);
        email = (TextView) myInflater.findViewById(R.id.username);
        phone = (TextView) myInflater.findViewById(R.id.phone);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            mDatabase = FirebaseDatabase.getInstance().getReference()
                    .child("users").child(user.getUid());
            ValueEventListener postListener = new ValueEventListener() {


                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    User user = dataSnapshot.getValue(User.class);
                    // [START_EXCLUDE]
                    name.setText(user.name);
                    email.setText(user.email);
                    phone.setText(user.phone);
                    // [END_EXCLUDE]
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    //Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // [START_EXCLUDE]
                    Toast.makeText(getActivity(), "Failed to load post.",
                            Toast.LENGTH_SHORT).show();
                    // [END_EXCLUDE]
                }
            };
            mDatabase.addListenerForSingleValueEvent(postListener);
        }
        return myInflater;
    }

    private void logout()
    {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getActivity(),
                LoginActivity.class);
        startActivity(intent);
        getActivity().finish();
    }


}
