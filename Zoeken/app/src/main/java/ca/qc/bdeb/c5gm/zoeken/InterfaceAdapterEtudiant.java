package ca.qc.bdeb.c5gm.zoeken;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ca.qc.bdeb.c5gm.zoeken.POJO.Entreprise;

public class InterfaceAdapterEtudiant extends RecyclerView.Adapter<InterfaceAdapterEtudiant.ViewHolder> {

    private List<Entreprise> listeEntreprises;
    private final Context context;

    /**
     * Constructeur de InterfaceAdapterEtudiant
     * @param listeEntreprises liste d'entreprises
     * @param context context actuel
     */
    public InterfaceAdapterEtudiant(List<Entreprise> listeEntreprises, Context context) {
        this.listeEntreprises = listeEntreprises;
        this.context = context;
    }

    @NonNull
    @Override
    public InterfaceAdapterEtudiant.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item, parent, false);
        return new InterfaceAdapterEtudiant.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InterfaceAdapterEtudiant.ViewHolder holder, int position) {
        holder.tv_nom_compagnie.setText(String.valueOf(listeEntreprises.get(position).getNom()));
        holder.tv_nombre_stages.setVisibility(View.INVISIBLE); // SOURCE: https://stackoverflow.com/questions/38060002/how-to-show-hide-textview-in-android-xml-file-and-java-file
        holder.tv_stages_trouves.setVisibility(View.INVISIBLE); // casse la vue lorsqu'on met View.GONE, alors je mets View.INVISIBLE
        holder.cb_stage_trouve.setVisibility(View.INVISIBLE);

    }

    @Override
    public int getItemCount() {
        return listeEntreprises.size();
    }

    /**
     * ViewHolder
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nom_compagnie;
        LinearLayout layoutMain;
        TextView tv_nombre_stages;
        TextView tv_stages_trouves;
        CheckBox cb_stage_trouve;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nom_compagnie = itemView.findViewById(R.id.tv_nom);
            layoutMain = itemView.findViewById(R.id.layoutMain);
            tv_nombre_stages = itemView.findViewById(R.id.tv_nombre_stages);
            tv_stages_trouves = itemView.findViewById(R.id.tv_stages_appliques);
            cb_stage_trouve = itemView.findViewById(R.id.cb_stage_trouve);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != -1) { // -1: aucune position
                        Entreprise entreprise = listeEntreprises.get(position);
                        Intent intent = new Intent(context, ModifierEntreprise.class);
                        intent.putExtra("id_compagnie", entreprise.getId().toString());
                        intent.putExtra("nom_compagnie", entreprise.getNom());
                        intent.putExtra("nom_contact", entreprise.getContact());
                        intent.putExtra("email", entreprise.getEmail());
                        intent.putExtra("telephone", entreprise.getTelephone());
                        intent.putExtra("site_web", entreprise.getSiteWeb());
                        intent.putExtra("adresse", entreprise.getAdresse());
                        intent.putExtra("ville", entreprise.getVille());
                        intent.putExtra("province", entreprise.getProvince());
                        intent.putExtra("code_postal", entreprise.getCodePostal());
                        intent.putExtra("date_contact", entreprise.getDateContact());
                        context.startActivity(intent);
                    }
                }
            });

        }
    }

    /**
     * Change la liste des entreprises selon l'entree de l'etudiant
     * @param listeEntreprisesTrouvees liste des entreprises trouvees par la recherche
     */
    public void initialiserListeRechercheEntreprises(List<Entreprise> listeEntreprisesTrouvees) {
        this.listeEntreprises = listeEntreprisesTrouvees;
        notifyDataSetChanged();

    }
}
