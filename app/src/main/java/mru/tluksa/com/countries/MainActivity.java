package mru.tluksa.com.countries;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countries_list);
        fetchCountries();
    }

    private void fetchCountries() {
        Service.getApi().getCountries().enqueue(new Callback<Countries>() {
            @Override
            public void onResponse(Response<Countries> response, Retrofit retrofit) {
                populateAdapter(response.body());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void populateAdapter(Countries countries) {
        CountriesAdapter adapter = new CountriesAdapter(countries);

        RecyclerView countriesList = (RecyclerView) findViewById(R.id.countries_list);
        countriesList.setHasFixedSize(true);
        countriesList.setLayoutManager(new LinearLayoutManager(this));
        countriesList.setAdapter(adapter);
    }
}

