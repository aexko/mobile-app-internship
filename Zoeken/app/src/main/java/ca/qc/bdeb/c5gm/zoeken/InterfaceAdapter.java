package ca.qc.bdeb.c5gm.zoeken;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class InterfaceAdapter extends RecyclerView.Adapter<InterfaceAdapter.ViewHolder> {
    ArrayList id_compagnie, nom_compagnie, nom_contact, email, telephone, site_web, adresse, ville, code_postal, date_contact;
    Context context;
    Activity activity;

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
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
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.tv_nom_compagnie.setText(String.valueOf(nom_compagnie.get(holder.getAdapterPosition())));

        holder.layoutMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passerDonneesVersActiviteMaps(holder);
                passerDonneesVersActiviteModifier(holder);
            }
        });
    }

    private void passerDonneesVersActiviteMaps(ViewHolder holder) {
        Intent intent = new Intent(context, ModifierCompagnieActivity.class);
        intent.putExtra("id_compagnie", String.valueOf(id_compagnie.get(holder.getAdapterPosition())));
        intent.putExtra("nom_compagnie", String.valueOf(nom_compagnie.get(holder.getAdapterPosition())));
        intent.putExtra("nom_contact", String.valueOf(nom_contact.get(holder.getAdapterPosition())));
        intent.putExtra("email", String.valueOf(email.get(holder.getAdapterPosition())));
        intent.putExtra("telephone", String.valueOf(telephone.get(holder.getAdapterPosition())));
        intent.putExtra("site_web", String.valueOf(site_web.get(holder.getAdapterPosition())));
        intent.putExtra("adresse", String.valueOf(adresse.get(holder.getAdapterPosition())));
        intent.putExtra("ville", String.valueOf(ville.get(holder.getAdapterPosition())));
        intent.putExtra("code_postal", String.valueOf(code_postal.get(holder.getAdapterPosition())));
        intent.putExtra("date_contact", String.valueOf(date_contact.get(holder.getAdapterPosition())));
    }

    private void passerDonneesVersActiviteModifier(ViewHolder holder) {
        Intent intent = new Intent(context, ModifierCompagnieActivity.class);
        intent.putExtra("id_compagnie", String.valueOf(id_compagnie.get(holder.getAdapterPosition())));
        intent.putExtra("nom_compagnie", String.valueOf(nom_compagnie.get(holder.getAdapterPosition())));
        intent.putExtra("nom_contact", String.valueOf(nom_contact.get(holder.getAdapterPosition())));
        intent.putExtra("email", String.valueOf(email.get(holder.getAdapterPosition())));
        intent.putExtra("telephone", String.valueOf(telephone.get(holder.getAdapterPosition())));
        intent.putExtra("site_web", String.valueOf(site_web.get(holder.getAdapterPosition())));
        intent.putExtra("adresse", String.valueOf(adresse.get(holder.getAdapterPosition())));
        intent.putExtra("ville", String.valueOf(ville.get(holder.getAdapterPosition())));
        intent.putExtra("code_postal", String.valueOf(code_postal.get(holder.getAdapterPosition())));
        intent.putExtra("date_contact", String.valueOf(date_contact.get(holder.getAdapterPosition())));
        activity.startActivityForResult(intent, 1);

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

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nom_compagnie;
        LinearLayout layoutMain;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nom_compagnie = itemView.findViewById(R.id.tv_nom_compagnie);
            layoutMain = itemView.findViewById(R.id.layoutMain);

        }
    }

}
