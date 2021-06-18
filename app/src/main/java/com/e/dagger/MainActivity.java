package com.e.dagger;

import android.annotation.SuppressLint;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.e.dagger.adapter.AlbumAdapter;
import com.e.dagger.adapter.PhotosAdapter;
import com.e.dagger.adapter.UserAdapter;
import com.e.dagger.broadcastReceiver.DetectConnectivityBroadcast;
import com.e.dagger.component.AppComponent;
import com.e.dagger.databinding.ActivityMainBinding;

import javax.inject.Inject;

import static com.e.dagger.common.AppUtils.slideFromLeft;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Management";
    @Inject
    Management management, management2;

    ActivityMainBinding binding;

    @Inject
    AppViewModel viewModel;

    @Inject
    UserAdapter adapter;
    @Inject
    AlbumAdapter albumAdapter;
    @Inject
    PhotosAdapter photosAdapter;

    @Inject
    DetectConnectivityBroadcast connectivityBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        initDependency();

        initBroadcast();


        binding.recUser.setAnimation(slideFromLeft(this));
     /*   viewModel.albumList().observe(this, albums -> albumAdapter.submitList(albums));
        viewModel.photos().observe(this, photos -> photosAdapter.submitList(photos));*/
        setUser();
    }

    private void initBroadcast() {
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(connectivityBroadcast, intentFilter);
    }

    private void setUser() {
        binding.recUser.setAdapter(adapter);
        viewModel.userList().observe(this, users -> adapter.submitList(users));
    }

    private void initDependency() {
        AppComponent appComponent = ((AppContext) getApplication()).getAppComponent();
        appComponent.inject(this);
        management.managementReport();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_file, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.albums:
                binding.recUser.setAdapter(albumAdapter);
                return true;
            case R.id.photos:
                binding.recUser.setAdapter(photosAdapter);
                return true;
            case R.id.comments:
                return true;
            case R.id.users:
                binding.recUser.setAdapter(adapter);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(connectivityBroadcast);
    }
}