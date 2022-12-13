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

// SOURCE: Documentation du cours

/**
 * Interface de l'API
 */
public interface MonApi {

    /**
     * Pour la deconnexion
     * @param token ConnectUtils.authToken
     * @return reponse du serveur
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("/auth/deconnexion")
    Call<ResponseBody> deconnecter(@Header("Authorization") String token);

    /**
     * Pour la connexion
     * @param loginData Entrees de l'utilisateur
     * @return reponse du serveur
     */
    @POST("/auth/connexion")
    Call<CompteResult> connecter(@Body LoginData loginData);

    /**
     * Pour l'inscription
     * @param loginData Entrees de l'utilisateur
     * @return reponse du serveur
     */
    @POST("/inscription")
    Call<ComptePOJO> creerCompte(@Body CreationCompteData loginData);

    /**
     * Pour recuperer les comptes des eleves
     * @param token ConnectUtils.authToken
     * @return reponse du serveur
     */
    @GET("/compte/getcomptesetudiantsactifs")
    Call<List<ComptePOJO>> getComptesEleves(@Header("Authorization") String token);

    /**
     * Pour recuperer les informations de l'etudiant connecte
     * @param token ConnectUtils.authToken
     * @return reponse du serveur
     */
    @GET("/compte/getetudiant")
    Call<ComptePOJO> getEtudiantConnecte(@Header("Authorization") String token);

    /**
     * Pour supprimer un stage (non utilise dans le TP)
     * @param token ConnectUtils.authToken
     * @param idStage id du stage
     * @return reponse du serveur
     */
    @DELETE("/stage/{idStage}")
    Call<ResponseBody> supprStage(@Header("Authorization") String token, @Path("idStage") String idStage);

    /**
     * Pour creer une entreprise
     * @param token ConnectUtils.authToken
     * @param entreprise Objet Entreprise
     * @return reponse du serveur
     */
    @POST("/entreprise")
    Call<Entreprise> creerEntreprise(@Header("Authorization") String token, @Body Entreprise entreprise);

    /**
     *
     * @param token ConnectUtils.authToken
     * @return reponse du serveur
     */
    @GET("/entreprise")
    Call<List<Entreprise>> lireEntreprises(@Header("Authorization") String token);

    /**
     *
     * @param token ConnectUtils.authToken
     * @param idEntreprise id de l'entreprise
     * @param entreprise Objet Entreprise
     * @return reponse du serveur
     */
    @PATCH("/entreprise/{idEntreprise}")
    Call<Entreprise> modifierEntreprise(@Header("Authorization") String token, @Path("idEntreprise") String idEntreprise, @Body Entreprise entreprise);

    /**
     *
     * @param token ConnectUtils.authToken
     * @param idEntreprise id de l'entreprise
     * @return reponse du serveur
     */
    @DELETE("/entreprise/{idEntreprise}")
    Call<Entreprise> supprEntreprise(@Header("Authorization") String token, @Path("idEntreprise") String idEntreprise);
    
}
