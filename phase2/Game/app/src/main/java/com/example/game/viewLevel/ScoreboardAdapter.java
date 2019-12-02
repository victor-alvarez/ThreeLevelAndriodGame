package com.example.game.viewLevel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.game.R;
import com.example.game.models.Account;
import com.example.game.models.Pair;

import java.util.ArrayList;

/**
 * Scoreboard adapter to create scoreboard view
 */
public class ScoreboardAdapter extends BaseAdapter {

    final private Context mContext;
    private LayoutInflater inflater;
    final private ArrayList<Pair<Account, Integer>> accountIntegerPair;


    /**
     * Constructor for ScoreboardAdapter
     * @param context Context in which to create the scoreboard
     * @param accountIntegerPair Account and score in Pair format
     */
    ScoreboardAdapter(Context context, ArrayList<Pair<Account, Integer>> accountIntegerPair) {
        this.mContext = context;
        this.accountIntegerPair = accountIntegerPair;

    }

    /**
     * @return amount of accounts in the scoreboard
     */
    @Override
    public int getCount() {
        return accountIntegerPair.size();
    }

    /**
     * @param location index of desired Object
     * @return Object at index location
     */
    @Override
    public Object getItem(int location) {
        return accountIntegerPair.get(location);
    }

    /**
     * @param position index
     * @return the position
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Creates the scoreboard, line by line
     * @param position index
     * @param scoreView view of the scoreboard
     * @param parent view in which to create scoreboard
     * @return view of scoreboard
     */
    @Override
    public View getView(int position, View scoreView, ViewGroup parent) {
        ViewHolder holder;
        if (inflater == null) {
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (scoreView == null) {

            scoreView = inflater.inflate(R.layout.list_view, parent, false);
            holder = new ViewHolder();
            holder.name = scoreView.findViewById(R.id.name);
            holder.score = scoreView.findViewById(R.id.score);
            holder.icon = scoreView.findViewById(R.id.icon);
            holder.rank = scoreView.findViewById(R.id.rank);

            scoreView.setTag(holder);

        } else {
            holder = (ViewHolder) scoreView.getTag();
        }

        final Pair<Account, Integer> m = accountIntegerPair.get(position);
        holder.name.setText(m.getFirst().getLogin());
        holder.score.setText(Integer.toString(m.getSecond()));
        holder.rank.setText(Integer.toString(position + 1));
        holder.icon.setImageResource(m.getFirst().getIcon());


        return scoreView;
    }

    /**
     * Objects held within the view
     */
    static class ViewHolder {

        TextView rank;
        TextView name;
        ImageView icon;
        TextView score;

    }

}
