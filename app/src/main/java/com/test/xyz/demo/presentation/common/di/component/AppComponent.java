package com.test.xyz.demo.presentation.common.di.component;

import com.test.xyz.demo.presentation.repodetails.di.RepoDetailsFragmentComponent;
import com.test.xyz.demo.presentation.repodetails.di.RepoDetailsFragmentModule;
import com.test.xyz.demo.presentation.repolist.di.RepoListFragmentComponent;
import com.test.xyz.demo.presentation.repolist.di.RepoListFragmentModule;
import com.test.xyz.demo.presentation.weather.di.WeatherFragmentComponent;
import com.test.xyz.demo.presentation.weather.di.WeatherFragmentModule;
import com.test.xyz.demo.presentation.common.di.module.AppModule;
import com.test.xyz.demo.presentation.common.di.module.CommonModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, CommonModule.class})
public interface AppComponent {
    WeatherFragmentComponent plus(WeatherFragmentModule module);
    RepoListFragmentComponent plus(RepoListFragmentModule module);
    RepoDetailsFragmentComponent plus(RepoDetailsFragmentModule module);
}
