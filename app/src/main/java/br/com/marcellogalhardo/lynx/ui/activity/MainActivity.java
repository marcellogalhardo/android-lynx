package br.com.marcellogalhardo.lynx.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.marcellogalhardo.lynx.R;
import br.com.marcellogalhardo.lynx.models.Channel;
import br.com.marcellogalhardo.lynx.ui.activity.base.BaseActivity;
import br.com.marcellogalhardo.lynx.ui.adapters.ChannelListAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.recyclerview_channels)
    RecyclerView mRecyclerViewChannels;

    private List<Channel> mChannelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mChannelList = new ArrayList<>();
        initializeToolbar();
        initializeUi();
        configureRecyclerView();
    }

    private void initializeToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initializeUi() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Channel channel = new Channel();
                channel.setName("#Teste");
                mChannelList.add(channel);
                mRecyclerViewChannels.getAdapter().notifyDataSetChanged();
            }
        });
    }

    private void configureRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerViewChannels.setHasFixedSize(true);
        mRecyclerViewChannels.setLayoutManager(linearLayoutManager);
        mRecyclerViewChannels.setAdapter(new ChannelListAdapter(mChannelList));
     }

}
