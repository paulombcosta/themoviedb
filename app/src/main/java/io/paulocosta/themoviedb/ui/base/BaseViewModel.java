package io.paulocosta.themoviedb.ui.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import io.paulocosta.themoviedb.data.DataManager;
import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel<N> extends ViewModel {

    private N navigator;
    private final DataManager mDataManager;
    private final ObservableBoolean isLoading = new ObservableBoolean(false);

    private CompositeDisposable mCompositeDisposable;

    public BaseViewModel(DataManager dataManager) {
        this.mDataManager = dataManager;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    public void setNavigator(N navigator) {
        this.navigator = navigator;
    }

    public N getNavigator() {
        return navigator;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public ObservableBoolean getIsLoading() {
        return isLoading;
    }

    public void setIsLoading(boolean isLoading) {
        this.isLoading.set(isLoading);
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }
}
