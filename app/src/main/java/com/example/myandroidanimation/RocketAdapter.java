package com.example.myandroidanimation;

import android.content.Context;
import android.support.v7.widget.*;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class RocketAdapter extends RecyclerView.Adapter<RocketAdapter.RocketViewHolder> {

  private final List<RocketAnimationItem> mItems;
  private final Context mContext;

  public RocketAdapter(Context context, List<RocketAnimationItem> items) {
    super();
    mContext = context;
    mItems = items;
  }

  @Override
  public RocketViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(android.R.layout.simple_list_item_1, parent, false);
    return new RocketViewHolder(view);
  }

  @Override
  public void onBindViewHolder(RocketViewHolder holder, int position) {
    holder.mTitle.setText(mItems.get(position).getTitle());
  }

  @Override
  public int getItemCount() {
    return mItems == null ? 0 : mItems.size();
  }

  class RocketViewHolder extends RecyclerView.ViewHolder {
    public final TextView mTitle;

    public RocketViewHolder(View itemView) {
      super(itemView);
      mTitle = (TextView) itemView.findViewById(android.R.id.text1);
      mTitle.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          mContext.startActivity(mItems.get(getAdapterPosition()).getIntent());
        }
      });
    }
  }
}
