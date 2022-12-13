package ca.qc.bdeb.c5gm.zoeken;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ca.qc.bdeb.c5gm.zoeken.POJO.Entreprise;

public class InterfaceAdapterEtudiant extends RecyclerView.Adapter<InterfaceAdapterEtudiant.ViewHolder> {

    private List<Entreprise> listeEntreprises;
    private Context context;

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
    }

    @Override
    public int getItemCount() {
        return listeEntreprises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nom_compagnie;
        LinearLayout layoutMain;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nom_compagnie = itemView.findViewById(R.id.tv_nom);
            layoutMain = itemView.findViewById(R.id.layoutMain);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != -1) { // -1: aucune position
                        Entreprise entreprise = listeEntreprises.get(position);
                        Intent intent = new Intent(context, ModifierCompagnieActivity.class);
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
}
