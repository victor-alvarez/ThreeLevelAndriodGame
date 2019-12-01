package com.example.game;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater inflater;
    private ArrayList<Pair<Account, Integer>> itemsItems;



    public ScoreboardAdapter(Context context, ArrayList<Pair<Account, Integer>> itemsItems) {
        this.mContext = context;
        this.itemsItems = itemsItems;

    }

    @Override
    public int getCount() {
        return itemsItems.size();
    }

    @Override
    public Object getItem(int location) {
        return itemsItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View scoreView, ViewGroup parent) {
        ViewHolder holder;
        if (inflater == null) {
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (scoreView == null) {

            scoreView = inflater.inflate(R.layout.list_view, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) scoreView.findViewById(R.id.name);
            holder.score = (TextView) scoreView.findViewById(R.id.score);
            holder.icon = (ImageView) scoreView.findViewById(R.id.icon);
            holder.rank = scoreView.findViewById(R.id.rank);

            scoreView.setTag(holder);

        } else {
            holder = (ViewHolder) scoreView.getTag();
        }

        final Pair<Account, Integer> m = itemsItems.get(position);
        holder.name.setText(m.getFirst().getLogin());
        holder.score.setText(Integer.toString(m.getSecond()));
        holder.rank.setText(Integer.toString(position + 1));
        holder.icon.setImageResource(m.getFirst().getIcon());


        return scoreView;
    }

    static class ViewHolder {

        TextView rank;
        TextView name;
        ImageView icon;
        TextView score;

    }

}
