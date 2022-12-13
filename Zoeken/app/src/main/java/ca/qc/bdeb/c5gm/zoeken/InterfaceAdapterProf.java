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

public class InterfaceAdapterProf extends RecyclerView.Adapter<InterfaceAdapterProf.ViewHolder> {

    private List<ComptePOJO> listeEtudiants;
    private Context context;

    public InterfaceAdapterProf(List<ComptePOJO> listeEtudiants, Context context) {
        this.listeEtudiants = listeEtudiants;
        this.context = context;
    }

    @NonNull
    @Override
    public InterfaceAdapterProf.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item, parent, false);
        return new InterfaceAdapterProf.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InterfaceAdapterProf.ViewHolder holder, int position) {
        holder.tv_nom_etudiant.setText(String.valueOf(listeEtudiants.get(position).getNom()));
        holder.tv_nombre_de_stages.setText(String.valueOf(listeEtudiants.get(position).getEntreprises().size()));
    }

    @Override
    public int getItemCount() {
        return listeEtudiants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nom_etudiant;
        TextView tv_nombre_de_stages;
        LinearLayout layoutMain;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nom_etudiant = itemView.findViewById(R.id.tv_nom);
            tv_nombre_de_stages = itemView.findViewById(R.id.tv_nombre_stages);
            layoutMain = itemView.findViewById(R.id.layoutMain);

        }
    }

    public void initialiserListeRechercheEtudiants(List<ComptePOJO> listeEtudiantsTrouves) {
        this.listeEtudiants = listeEtudiantsTrouves;
        notifyDataSetChanged();

    }

}
