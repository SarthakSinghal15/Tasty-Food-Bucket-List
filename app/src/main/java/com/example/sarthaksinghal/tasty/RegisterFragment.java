package com.example.sarthaksinghal.tasty;


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
public class RegisterFragment extends Fragment {
    private EditText usernameField;
    private EditText passwordField;


    public RegisterFragment() {
        // Required empty public constructor
    }
    public static SQLiteHelper sqLiteHelper;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_register, container, false);

        Button button = (Button) view.findViewById(R.id.registerButton);
        usernameField = (EditText) view.findViewById(R.id.usernameField);
        passwordField = (EditText) view.findViewById(R.id.passwordField);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameField.getText().toString();
                String password = passwordField.getText().toString();
                sqLiteHelper = new SQLiteHelper(getActivity(),"UserDB.sqlite",null,1);
                sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS USERS(Id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, password VARCHAR)");
                sqLiteHelper.insertUserData(username,password);
                Toast.makeText(getActivity(),"User has successfully registered",Toast.LENGTH_LONG).show();
                usernameField.setText("");
                passwordField.setText("");
            }


    });
        return view;
    }


}
