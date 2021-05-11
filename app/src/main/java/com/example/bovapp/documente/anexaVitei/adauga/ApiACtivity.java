package com.example.bovapp.documente.anexaVitei.adauga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bovapp.R;
import com.example.bovapp.remoteData.Models.AnimalResponse;
import com.example.bovapp.remoteData.RequestModel.AnimalRequest;
import com.example.bovapp.remoteData.RequestModel.HeightR;
import com.example.bovapp.remoteData.RequestModel.WeightR;
import com.example.bovapp.remoteData.RetrofitClientInstance;
import com.example.bovapp.remoteData.iAnimalsAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiACtivity extends AppCompatActivity {
public ListView listviewApi;
TextView textviewApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_a_ctivity);
        textviewApi = findViewById(R.id.textView3);
        getAnimalInformation(getAnimalDataFromView());

    }
    private void getAnimalInformation(AnimalRequest animalRequest) {

        iAnimalsAPI service = RetrofitClientInstance.getRetrofitInstance().create(iAnimalsAPI.class);
        Call<AnimalResponse> call = service.postAnimals(animalRequest);
        call.enqueue(new Callback<AnimalResponse>() {
            @Override
            public void onResponse(Call<AnimalResponse> call, Response<AnimalResponse> response) {
                Toast.makeText(getApplicationContext(),
                        response.toString(),
                        Toast.LENGTH_LONG).show();
                textviewApi.setText(response.body().toString());

            }


            @Override
            public void onFailure(Call<AnimalResponse> call, Throwable t) {
                Toast.makeText(ApiACtivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private AnimalRequest getAnimalDataFromView() {
        WeightR weight = new WeightR("85.00", "kg");
        HeightR height = new HeightR("170.00", "cm");
        String sex = "m";
        String age = "24";
        String waist = "34.00";
        String hip = "40.00";

        return new AnimalRequest(weight, height, sex, age, waist, hip);
    }
}
