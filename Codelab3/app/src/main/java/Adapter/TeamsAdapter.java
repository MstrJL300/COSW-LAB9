package Adapter;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ba.codelab3.R;
import com.example.ba.codelab3.Team;

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by jose on 16/11/16.
 *
 */

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {

    //This list stores the teams.
    private final List<Team> teams;
    private Context context;

    public TeamsAdapter(List<Team> teams) {
        this.teams = teams;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.team_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Team team = teams.get(position);
        viewHolder.name.setText((team.getName()));
        viewHolder.shortName.setText((team.getShortName()));
        Picasso.with(context).load(String.valueOf(team.getImageUrl())).into(viewHolder.logo);
    }

    @Override
    public int getItemCount() {return teams.size();}

    /**
     * The class is created inside to hold eference to UI elements that represent a Team in
     * the model.
     */
    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView shortName;
        ImageView logo;

        ViewHolder(View view){
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            shortName = (TextView) view.findViewById(R.id.shortName);
            logo = (ImageView) view.findViewById(R.id.logo);
        }
    }
}