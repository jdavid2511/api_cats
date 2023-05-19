package com.example.api_cats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView et1;
    private RecyclerView recyclerView;
    private BreedAdapter breedAdapter;

    private static final String API_KEY = "bda53789-d59e-46cd-9bc4-2936630fde39";
    private static final String API_BASE_URL = "https://api.thecatapi.com/v1/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1= findViewById(R.id.name);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CatApiService apiService = retrofit.create(CatApiService.class);
        Call<List<CatBreed>> call = apiService.getBreeds();
        call.enqueue(new Callback<List<CatBreed>>() {
            @Override
            public void onResponse(Call<List<CatBreed>> call, Response<List<CatBreed>> response) {
                if (response.isSuccessful()) {
                    List<CatBreed> breeds = response.body();
                    for (CatBreed breed : breeds) {
                        System.out.println(breed.getName());
                    }
                    //et1.setText(breeds.get(0).getName());
                    
                    breedAdapter.adicionarListaBreeds(breeds);
                }
            }

            @Override
            public void onFailure(Call<List<CatBreed>> call, Throwable t) {

            }
        });
    }
}