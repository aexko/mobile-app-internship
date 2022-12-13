package ca.qc.bdeb.c5gm.zoeken;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ca.qc.bdeb.c5gm.zoeken.POJO.ComptePOJO;

public class InterfaceAdapterProf extends RecyclerView.Adapter<InterfaceAdapterProf.ViewHolder> {

    private List<ComptePOJO> listeEtudiants;
    private final Context context;

    /**
     * Constructeur de InterfaceAdapterProf
     * @param listeEtudiants liste des etudiants
     * @param context context actuel
     */
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
        String nomComplet = listeEtudiants.get(position).getPrenom() + " " + listeEtudiants.get(position).getNom();
        holder.tv_nom_etudiant.setText(nomComplet);
        holder.tv_nombre_de_stages.setText(String.valueOf(listeEtudiants.get(position).getEntreprises().size()));
        if (listeEtudiants.get(position).getStageTrouve() != null) {
            holder.cv_stage_trouve.setChecked(listeEtudiants.get(position).getStageTrouve());
        }
    }

    @Override
    public int getItemCount() {
        return listeEtudiants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nom_etudiant;
        TextView tv_nombre_de_stages;
        LinearLayout layoutMain;
        CheckBox cv_stage_trouve;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nom_etudiant = itemView.findViewById(R.id.tv_nom);
            tv_nombre_de_stages = itemView.findViewById(R.id.tv_nombre_stages);
            layoutMain = itemView.findViewById(R.id.layoutMain);
            cv_stage_trouve = itemView.findViewById(R.id.cb_stage_trouve);
            cv_stage_trouve.setEnabled(false); // pour ne pas permettre de changement manuel
        }
    }

    /**
     * Change la liste des etudiants selon l'entree du prof
     * @param listeEtudiantsTrouves liste des etudiants trouves par la recherche
     */
    public void initialiserListeRechercheEtudiants(List<ComptePOJO> listeEtudiantsTrouves) {
        this.listeEtudiants = listeEtudiantsTrouves;
        notifyDataSetChanged();

    }

}
