package com.example.fooddelivery.ui.fragment.more;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.fooddelivery.BR;
import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentMoreBinding;
import com.example.fooddelivery.di.component.FragmentComponent;
import com.example.fooddelivery.ui.activity.base.BaseFragment;
import com.example.fooddelivery.ui.activity.main.MainActivity;

public class MoreFragment extends BaseFragment<FragmentMoreBinding, MoreViewModel> implements MoreNavigator {
    private FragmentMoreBinding binding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_more;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = getViewDataBinding();
        viewModel.setNavigator(this);
    }

    @Override
    public void manageAddressOpen() {
        ((MainActivity) getActivity()).navigateFragment(R.id.action_moreFragment_to_myLocationFragment2);
    }
}
