package com.example.fooddelivery.ui.fragment.cart;

import android.text.TextUtils;
import android.util.Log;

import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.data.model.api.request.UserCartConfirmRequest;
import com.example.fooddelivery.data.model.api.response.CartCategoryFoodResponse;
import com.example.fooddelivery.data.model.api.response.UserCartConfirmResponse;
import com.example.fooddelivery.ui.activity.base.BaseViewModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CartViewModel extends BaseViewModel<CartNavigator> {
    public CartViewModel(DataManager dataManager) {
        super(dataManager);
    }

    private CartAdapter cartAdapter;

    public void setCartAdapter(CartAdapter cartAdapter) {
        this.cartAdapter = cartAdapter;
    }

    public void openOrderPlaceScreen() {
        sendUserCartConfirm();
    }

    public void getCartCategoryFood() {
        Map<Integer, Long> counted = getDataManager().getFoodCart().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<CartModel> cartModelList = new ArrayList<>();
        List<Integer> cartIDList = new ArrayList<>();
        cartIDList.addAll(counted.keySet());
        List<Long> cartCountList = new ArrayList<>();
        cartCountList.addAll(counted.values());
        for (int i = 0; i < cartIDList.size(); i++) {
            cartModelList.add(new CartModel(cartIDList.get(i), cartCountList.get(i)));
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < counted.keySet().size(); i++) {
            builder.append(" or ")
                    .append("id = ")
                    .append(counted.keySet().toArray()[i]);
        }
        builder.delete(0, 4);
        String jsonCartCategory = builder.toString();
        if (!TextUtils.isEmpty(jsonCartCategory)) {
            getDataManager().getCartCategoryFood(jsonCartCategory)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<List<CartCategoryFoodResponse>>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull List<CartCategoryFoodResponse> responses) {
                            cartAdapter.setListTotalItem(cartModelList);
                            cartAdapter.setItems(responses);
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }

    }

    private void sendUserCartConfirm() {
        List<UserCartConfirmRequest> request = new ArrayList<>();
        for (int i = 0; i < cartAdapter.getList().size(); i++) {
            request.add(new UserCartConfirmRequest(
                    cartAdapter.getList().get(i).getRes_id(),
                    cartAdapter.getList().get(i).getId(),
                    getDataManager().getUserInfo().getId(),
                    cartAdapter.getList().get(i).getFood_name(),
                    (int) cartAdapter.getCartModelList().get(i).getCount(),
                    Integer.parseInt(cartAdapter.getList().get(i).getPrice()),
                    cartAdapter.getList().get(i).getDiscount(),
                    Calendar.getInstance().getTimeInMillis()
            ));
        }
        getDataManager().sendUserCartConfirm(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserCartConfirmResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull UserCartConfirmResponse cartConfirmResponse) {
                        getNavigator().openPaymentScreen();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("123123", e.getMessage());
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
