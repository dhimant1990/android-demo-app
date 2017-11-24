package com.test.xyz.demo.ui.weather;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.test.xyz.demo.ui.common.di.DaggerApplication;
import com.test.xyz.demo.ui.common.BaseFragment;
import com.test.xyz.demo.ui.weather.mvp.WeatherPresenter;
import com.test.xyz.demo.R;
import com.test.xyz.demo.ui.common.util.CommonUtils;
import com.test.xyz.demo.ui.weather.di.WeatherFragmentModule;
import com.test.xyz.demo.ui.weather.mvp.WeatherView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherFragment extends BaseFragment implements WeatherView, View.OnClickListener {
    private static String TAG = WeatherFragment.class.getName();

    @Inject
    WeatherPresenter presenter;

    @BindView(R.id.userNameText)
    EditText userNameText;

    @BindView(R.id.cityText)
    EditText cityText;

    @BindView(R.id.btnShowInfo)
    Button showInfoButton;

    @BindView(R.id.resultView)
    TextView resultView;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    protected void initializeFragment(Bundle savedInstanceState) {
        DaggerApplication.get(this.getContext())
                .getAppComponent()
                .plus(new WeatherFragmentModule(this))
                .inject(this);

        showInfoButton.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnShowInfo) {
            presenter.requestWeatherInformation();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "WeatherFragment is destroyed ...");
    }

    @Override
    public String getUserNameText() {
        return userNameText.getText().toString();
    }

    @Override
    public String getCityText() {
        return cityText.getText().toString();
    }

    @Override
    public void showUserNameError(final int messageId) {
        userNameText.setError(getString(messageId));
    }

    @Override
    public void showCityNameError(final int messageId) {
        cityText.setError(getString(messageId));
    }

    @Override
    public void showBusyIndicator() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideBusyIndicator() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showResult(final String result) {
        resultView.setText(result);
    }

    @Override
    public void showError(final String error) {
        CommonUtils.showDefaultAlert(WeatherFragment.this.getActivity(), error);
    }
}