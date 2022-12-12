package ca.qc.bdeb.c5gm.zoeken;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ca.qc.bdeb.c5gm.zoeken.POJO.ComptePOJO;

public class InterfaceAdapterProf extends RecyclerView.Adapter<InterfaceAdapterProf.ViewHolder> {

    private List<ComptePOJO> listeEtudiants;
    private Context context;

    public InterfaceAdapterProf(List<ComptePOJO> listeEtudiants , Context context) {
        this.listeEtudiants = listeEtudiants;
        this.context = context;
    }

    @NonNull
    @Override
    public InterfaceAdapterProf.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item, parent, false);
        return new InterfaceAdapterProf.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InterfaceAdapterProf.ViewHolder holder, int position) {

//        ComptePOJO comptePOJO = listeEtudiants.get(position);
        Toast.makeText(context, "Nom compte : " + listeEtudiants.get(position).getNom(), Toast.LENGTH_SHORT).show();

        holder.tv_nom_etudiant.setText(String.valueOf(listeEtudiants.get(position).getNom()));


    }

    @Override
    public int getItemCount() {
        return listeEtudiants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_nom_etudiant;
        LinearLayout layoutMain;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nom_etudiant = itemView.findViewById(R.id.tv_nom);
            layoutMain = itemView.findViewById(R.id.layoutMain);
        }
    }
}
