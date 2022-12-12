package ca.qc.bdeb.c5gm.zoeken;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ca.qc.bdeb.c5gm.zoeken.POJO.ComptePOJO;
import ca.qc.bdeb.c5gm.zoeken.POJO.Entreprise;

public class InterfaceAdapterEtudiant extends RecyclerView.Adapter<InterfaceAdapterEtudiant.ViewHolder> {

    private List<Entreprise> listeEntreprises;
    private Context context;

    public InterfaceAdapterEtudiant(List<Entreprise> listeEntreprises , Context context) {
        this.listeEntreprises = listeEntreprises;
        this.context = context;
    }

    @NonNull
    @Override
    public InterfaceAdapterEtudiant.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
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
        }
    }
}
