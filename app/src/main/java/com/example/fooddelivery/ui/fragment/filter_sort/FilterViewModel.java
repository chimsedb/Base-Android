package com.example.fooddelivery.ui.fragment.filter_sort;

import android.content.Context;
import android.widget.Toast;

import com.example.fooddelivery.R;
import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.data.model.api.request.FoodTypeRequest;
import com.example.fooddelivery.data.model.api.response.ListFoodTypeResponse;
import com.example.fooddelivery.data.model.api.response.RestaurantResponse;
import com.example.fooddelivery.ui.activity.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FilterViewModel extends BaseViewModel<FilterNavigator> {
    private final Context context;
    private FilterAdapter filterAdapter;

    public void setFilterAdapter(FilterAdapter filterAdapter) {
        this.filterAdapter = filterAdapter;
    }

    public FilterViewModel(Context context, DataManager dataManager) {
        super(dataManager);
        this.context = context;
    }

    public void getListFoodType() {
        getDataManager().getListFoodType()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<ListFoodTypeResponse>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<ListFoodTypeResponse> responses) {
                        filterAdapter.setItems(responses);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void apply() {
        postRequestFoodType(filterAdapter.getListRequest());
    }

    private void postRequestFoodType(List<FoodTypeModel> requests) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < requests.size(); i++) {
            builder.append(" or ")
                    .append("food_type_name = '")
                    .append(requests.get(i).getFood_type_name())
                    .append("'");
        }
        builder.delete(0, 4);
        String jsonCartCategory = builder.toString();

        getDataManager().postRequestFoodType(new FoodTypeRequest(jsonCartCategory))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<RestaurantResponse>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<RestaurantResponse> response) {
                        getNavigator().updateRestaurantFilter(response);
                        getNavigator().closeDialog();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        getNavigator().updateRestaurantFilter(new ArrayList<>());
                        getNavigator().closeDialog();
                        Toast.makeText(context,context.getString(R.string.txt_not_found),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
