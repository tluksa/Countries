package mru.tluksa.com.countries;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;

public class Service {

    private static final String BASE_URL = "http://api.geonames.org/";

    interface GeoApi {
        @GET("/countryInfo?type=json&username=taluksa")
        Call<Countries> getCountries();
    }

    private static final Retrofit retrofit =  new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build();

    private static final GeoApi GEO_API = retrofit.create(GeoApi.class);

    public static GeoApi getApi(){
        return GEO_API;
    }

}


