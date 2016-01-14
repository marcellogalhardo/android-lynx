package br.com.marcellogalhardo.lynx.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.marcellogalhardo.lynx.R;
import br.com.marcellogalhardo.lynx.models.Channel;
import butterknife.Bind;
import butterknife.ButterKnife;

public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListAdapter.ChannelViewHolder> {

    private List<Channel> channelList;

    public ChannelListAdapter(List<Channel> channelList) {
        this.channelList = channelList;
    }

    @Override
    public int getItemCount() {
        return channelList.size();
    }

    @Override
    public void onBindViewHolder(ChannelViewHolder contactViewHolder, int i) {
        Channel channel = channelList.get(i);
        contactViewHolder.vName.setText(channel.getName());
    }

    @Override
    public ChannelViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.listitem_channel, viewGroup, false);

        return new ChannelViewHolder(itemView);
    }

    public static class ChannelViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.textview_channel)
        TextView vName;

        public ChannelViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
