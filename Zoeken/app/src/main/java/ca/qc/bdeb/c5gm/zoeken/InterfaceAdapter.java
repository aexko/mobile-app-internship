package ca.qc.bdeb.c5gm.zoeken;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// SOURCE: https://www.youtube.com/playlist?list=PLSrm9z4zp4mGK0g_0_jxYGgg3os9tqRUQ

public class InterfaceAdapter extends RecyclerView.Adapter<InterfaceAdapter.ViewHolder> {

    public static int CODE_DEMANDE = 1;

    ArrayList id_compagnie;
    ArrayList nom_compagnie;
    ArrayList nom_contact;
    ArrayList email;
    ArrayList telephone;
    ArrayList site_web;
    ArrayList adresse;
    ArrayList ville;
    ArrayList code_postal;
    ArrayList date_contact;

    Context context;
    Activity activity;


    /**
     * Appelé lorsque RecyclerView a besoin d'un nouveau {@link ViewHolder} du type donné à
     * représenter un élément.
     *
     * @param parent   Le ViewGroup dans lequel la nouvelle vue sera ajoutée après avoir été liée à
     *                 une position d'adaptation.
     * @param viewType Le type de vue de la nouvelle vue.
     * @return Un nouveau ViewHolder qui contient une vue du type de vue donné.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(ViewHolder, int)
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Constructeur de la classe InterfaceAdapter.
     */
    public InterfaceAdapter(Context context, ArrayList id_compagnie, ArrayList nom_compagnie,
                            ArrayList nom_contact, ArrayList email, ArrayList telephone,
                            ArrayList site_web, ArrayList adresse, ArrayList ville,
                            ArrayList code_postal, ArrayList date_contact, Activity activity) {
        this.context = context;
        this.id_compagnie = id_compagnie;
        this.nom_compagnie = nom_compagnie;
        this.nom_contact = nom_contact;
        this.email = email;
        this.telephone = telephone;
        this.site_web = site_web;
        this.adresse = adresse;
        this.ville = ville;
        this.code_postal = code_postal;
        this.date_contact = date_contact;
        this.activity = activity;
    }

    /**
     * Appelé par RecyclerView pour afficher les données à la position spécifiée. Cette méthode devrait
     * mettre à jour le contenu du {@link ViewHolder#itemView} pour refléter l'élément au moment donné
     * position.
     *
     * @param holder   Le ViewHolder qui doit être mis à jour pour représenter le contenu du
     *                 élément à la position donnée dans l'ensemble de données.
     * @param position Position de l'élément dans l'ensemble de données de l'adaptateur.
     */
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.tv_nom_compagnie.setText(String.valueOf(nom_compagnie.get(holder.
                getAdapterPosition())));
        holder.layoutMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                passerDonneesVersActiviteMaps(holder);
                passerDonneesVersActiviteModifier(holder);
            }
        });
    }

    /**
     * Passage des données vers MapsActivity.
     *
     * @param holder Le ViewHolder qui doit être mis à jour pour représenter le contenu du
     *               élément à la position donnée dans l'ensemble de données.
     */
    private void passerDonneesVersActiviteMaps(ViewHolder holder) {
        // changer pour passer une compagnie ou une liste
        Intent intent = new Intent(context, MapsActivity.class);
        intent.putExtra("id_compagnie", String.valueOf(id_compagnie.get
                (holder.getAdapterPosition())));
//        intent.putExtra("nom_compagnie", String.valueOf(nom_compagnie.get
//                (holder.getAdapterPosition())));
//        intent.putExtra("nom_contact", String.valueOf(nom_contact.get
//                (holder.getAdapterPosition())));
//        intent.putExtra("email", String.valueOf(email.get
//                (holder.getAdapterPosition())));
//        intent.putExtra("telephone", String.valueOf(telephone.get
//                (holder.getAdapterPosition())));
//        intent.putExtra("site_web", String.valueOf(site_web.get
//                (holder.getAdapterPosition())));
//        intent.putExtra("adresse", String.valueOf(adresse.get
//                (holder.getAdapterPosition())));
//        intent.putExtra("ville", String.valueOf(ville.get
//                (holder.getAdapterPosition())));
//        intent.putExtra("code_postal", String.valueOf(code_postal.get
//                (holder.getAdapterPosition())));
//        intent.putExtra("date_contact", String.valueOf(date_contact.get
//                (holder.getAdapterPosition())));

    }

    /**
     * Passage des données vers ModifierCompagnieActivity.
     *
     * @param holder Le ViewHolder qui doit être mis à jour pour représenter le contenu du
     *               élément à la position donnée dans l'ensemble de données.
     */
    private void passerDonneesVersActiviteModifier(ViewHolder holder) {
        Intent intent = new Intent(context, ModifierCompagnieActivity.class);
        intent.putExtra("id_compagnie", String.valueOf(id_compagnie.get
                (holder.getAdapterPosition())));
        intent.putExtra("nom_compagnie", String.valueOf(nom_compagnie.get
                (holder.getAdapterPosition())));
        intent.putExtra("nom_contact", String.valueOf(nom_contact.get
                (holder.getAdapterPosition())));
        intent.putExtra("email", String.valueOf(email.get
                (holder.getAdapterPosition())));
        intent.putExtra("telephone", String.valueOf(telephone.get
                (holder.getAdapterPosition())));
        intent.putExtra("site_web", String.valueOf(site_web.get
                (holder.getAdapterPosition())));
        intent.putExtra("adresse", String.valueOf(adresse.get
                (holder.getAdapterPosition())));
        intent.putExtra("ville", String.valueOf(ville.get
                (holder.getAdapterPosition())));
        intent.putExtra("code_postal", String.valueOf(code_postal.get
                (holder.getAdapterPosition())));
        intent.putExtra("date_contact", String.valueOf(date_contact.get
                (holder.getAdapterPosition())));


        activity.startActivityForResult(intent, CODE_DEMANDE);
    }

    /**
     * Retourne le nombre total d'items de l'adapteur
     *
     * @return Le nombre total d'items
     */
    @Override
    public int getItemCount() {
        return id_compagnie.size();
    }

    /**
     * Liaison des composantes du ViewHolder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nom_compagnie;
        LinearLayout layoutMain;
        ImageView logo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nom_compagnie = itemView.findViewById(R.id.tv_nom_compagnie);
            layoutMain = itemView.findViewById(R.id.layoutMain);
            logo = itemView.findViewById(R.id.logo_compagnie);
        }
    }

}
