package com.example.sarthaksinghal.tasty;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    private EditText lusernameField;
    private EditText lpasswordField;


    public LoginFragment() {
        // Required empty public constructor
    }
    public static SQLiteHelper sqLiteHelper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login, container, false);
        Button button = (Button) view.findViewById(R.id.loginButton);
        lusernameField = (EditText) view.findViewById(R.id.lusernameField);
        lpasswordField = (EditText) view.findViewById(R.id.lpasswordField);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = lusernameField.getText().toString();
                String password = lpasswordField.getText().toString();
                sqLiteHelper = new SQLiteHelper(getActivity(),"UserDB.sqlite",null,1);
                String uname = sqLiteHelper.searchUser(username,password);
                if(uname!=null)
                {
                    Toast.makeText(getActivity(),"User found",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getActivity(), FoodActivity.class);
                    intent.putExtra("Username",uname);
                    getActivity().startActivity(intent);
                }
                else{
                    Toast.makeText(getActivity(),"User not found",Toast.LENGTH_LONG).show();
                }
                lusernameField.setText("");
                lpasswordField.setText("");
            }
        });
        return view;
    }

}
