package ca.qc.bdeb.c5gm.zoeken.Authentification;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// SOURCE: Docs du cours

/**
 * Classe MonApiClient
 */
public class MonApiClient {
    private static Retrofit retrofit = null;
    private static OkHttpClient client = null;
    private static String adresse = "192.168.56.1"; // adresse IP de VirtualBox
    private static String server_url = "http://" + adresse + ":8888/";

    /**
     * Initialisation de Retrofit
     * @return retrofit
     */
    public static Retrofit getRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (client == null) {
            client = new OkHttpClient.Builder()
                    .readTimeout(5, TimeUnit.SECONDS)
                    .writeTimeout(5, TimeUnit.SECONDS)
                    .addInterceptor(interceptor).build();
        }
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(server_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }
}