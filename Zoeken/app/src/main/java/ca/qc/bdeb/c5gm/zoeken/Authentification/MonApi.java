package ca.qc.bdeb.c5gm.zoeken.Authentification;

import java.util.List;

import ca.qc.bdeb.c5gm.zoeken.POJO.ComptePOJO;
import ca.qc.bdeb.c5gm.zoeken.POJO.CompteResult;
import ca.qc.bdeb.c5gm.zoeken.POJO.CreationCompteData;
import ca.qc.bdeb.c5gm.zoeken.POJO.Entreprise;
import ca.qc.bdeb.c5gm.zoeken.POJO.LoginData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

// SOURCE: Docs du cours

public interface MonApi {

    @Headers({
            "Content-Type:application/json"
    })
    @POST("/auth/deconnexion")
    Call<ResponseBody> deconnecter(@Header("Authorization") String token);

    @POST("/auth/connexion")
    Call<CompteResult> connecter(@Body LoginData loginData);

    @POST("/inscription")
    Call<ComptePOJO> creerCompte(@Body CreationCompteData loginData);

    @GET("/compte/getcomptesetudiantsactifs")
    Call<List<ComptePOJO>> getComptesEleves(@Header("Authorization") String token);

    @GET("/compte/getetudiant")
    Call<List<ComptePOJO>> getEtudiantConnecte(@Header("Authorization") String token);

    @DELETE("/stage/{idStage}")
    Call<ResponseBody> supprStage(@Header("Authorization") String token, @Path("idStage") String idStage);

    @POST("/entreprise")
    Call<Entreprise> creerEntreprise(@Header("Authorization") String token, @Body Entreprise entreprise);

    @GET("/entreprise")
    Call<List<Entreprise>> lireEntreprises(@Header("Authorization") String token);

    @PATCH("/entreprise/{idEntreprise}")
    Call<Entreprise> modifierEntreprise(@Header("Authorization") String token, @Path("idEntreprise") String idEntreprise, @Body Entreprise entreprise);

    @DELETE("/entreprise/{idEntreprise}")
    Call<Entreprise> supprEntreprise(@Header("Authorization") String token, @Path("idEntreprise") String idEntreprise);


}
