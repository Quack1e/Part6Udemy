package com.martin.training.recyclerviewchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CarAdapter.ItemClicked{

    //declare all variables
    Button ownerInfo, carInfo;
    ImageView make;
    TextView model, name, number;
    FragmentManager fragmentManager;
    Fragment ownerFrag, carFrag, listFrag, buttonFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ownerInfo = findViewById(R.id.BTNowner);
        carInfo = findViewById(R.id.BTNcar);
        make = findViewById(R.id.IVmake);
        model = findViewById(R.id.TVmodel);
        name = findViewById(R.id.TVname);
        number = findViewById(R.id.TVnumber);

        fragmentManager = getSupportFragmentManager();

        listFrag = fragmentManager.findFragmentById(R.id.listFrag);
        buttonFrag = fragmentManager.findFragmentById(R.id.buttonFrag);
        //carFrag is ownerFrag and ownerFrag is carFrag, but I literally cannot find where they are flipped so it just switched it here when initializing them
        carFrag = fragmentManager.findFragmentById(R.id.ownerFrag);
        ownerFrag = fragmentManager.findFragmentById(R.id.carFrag);

        fragmentManager.beginTransaction().show(buttonFrag).show(carFrag).show(listFrag).hide(ownerFrag).commit();

        onItemCLicked(0);

        //will hide or person info or car info based on the button shown
        ownerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().hide(carFrag).show(ownerFrag).commit();

            }
        });
        carInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().show(carFrag).hide(ownerFrag).commit();
            }
        });

    }

    @Override
    public void onItemCLicked(int index) {
        name.setText(ApplicationClass.cars.get(index).getName());
        number.setText(ApplicationClass.cars.get(index).getNumber());
        model.setText(ApplicationClass.cars.get(index).getModel());

        if(ApplicationClass.cars.get(index).getMake().equals("Volkswagen")){
            make.setImageResource(R.drawable.volkswagen);
        } else if(ApplicationClass.cars.get(index).getMake().equals("Mercedes")){
            make.setImageResource(R.drawable.mercedes);
        } else{
            make.setImageResource(R.drawable.nissan);
        }
    }
}