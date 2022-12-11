package ca.qc.bdeb.c5gm.zoeken;

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

import ca.qc.bdeb.c5gm.zoeken.POJO.Entreprise;

// SOURCE: https://www.youtube.com/playlist?list=PLSrm9z4zp4mGK0g_0_jxYGgg3os9tqRUQ

public class InterfaceAdapter extends RecyclerView.Adapter<InterfaceAdapter.ViewHolder> {

    private ArrayList<Entreprise> listeEntreprises;
    private Context context;

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
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.compagnie_item, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Constructeur de la classe InterfaceAdapter.
     */
//    public InterfaceAdapter(List<Compagnie> listeCompagnies) {
//        this.listeCompagnies = listeCompagnies;
//    }

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
        Entreprise entreprise = listeEntreprises.get(position);
        holder.tv_nom_compagnie.setText(entreprise.getNom());
        holder.layoutMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ModifierCompagnieActivity.class);
                intent.putExtra("entreprise", listeEntreprises);
                context.startActivity(intent);
            }
        });
    }




    /**
     * Retourne le nombre total d'items de l'adapteur
     *
     * @return Le nombre total d'items
     */
    @Override
    public int getItemCount() {
        return listeEntreprises.size();
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
