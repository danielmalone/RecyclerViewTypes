package com.finepointmobile.recyclerviewtypes.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.finepointmobile.recyclerviewtypes.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by danielmalone on 1/12/17.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private final int FIRST_VIEW = 0;
    private final int SECOND_VIEW = 1;

    private static final String TAG = "MainAdapter";

    private Context mContext;
    private ArrayList<String> mData;

    public MainAdapter(Context context, ArrayList<String> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getItemViewType(int position) {
        super.getItemViewType(position);
        if (position == FIRST_VIEW) {
            return FIRST_VIEW;
        }
        return SECOND_VIEW;
    }

    @Override
    public MainAdapter.MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (getItemViewType(viewType) == 0) {
            View view = inflater.inflate(R.layout.row_first, parent, false);
            return new FirstViewHolder(view);
        }

        View view = inflater.inflate(R.layout.row, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainAdapter.MainViewHolder holder, int position) {
        holder.mTitle.setText(mData.get(position));
        if (getItemViewType(position) == 0) {
            Picasso.with(mContext).load("https://placeholdit.imgix.net/~text?txtsize=33&txt=Daniel%20Malone%20" + position + "&w=350&h=150").into(holder.mImage);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    private class FirstViewHolder extends MainViewHolder {

        public TextView mTitle;
        public ImageView mImage;

        public FirstViewHolder(View view) {
            super(view);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mImage = (ImageView) itemView.findViewById(R.id.image);
        }
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        public TextView mTitle;
        public ImageView mImage;

        public MainViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mImage = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
