package com.zhitiekeji.equipmentmanagement.base;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.activity.MainActivity;
import com.zhitiekeji.equipmentmanagement.utils.LocalUserInfo;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.zhitiekeji.equipmentmanagement.view.LoadingLayout;
import com.zhitiekeji.equipmentmanagement.view.TitleView;
import com.zhitiekeji.equipmentmanagement.view.pullview.AbPullToRefreshView;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by ling on 2015/7/31.
 * last:2015/7/31
 * description:
 */
public abstract class BaseFragment extends Fragment implements IBaseView_Response, View.OnClickListener {
    private ProgressDialog pd;
    protected View mParent;
    protected BaseActivity mActivity;
    protected TitleView titleView;
    protected AbPullToRefreshView pullview;
    protected LoadingLayout loadingLayout;
    protected LocalUserInfo localUserInfo;
    protected Map<String, String> params = new HashMap<>();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("BaseFragment", getClass().getSimpleName());
        mParent = getView();
        if (!(getActivity() instanceof MainActivity)) {//这里转换
            mActivity = (BaseActivity) getActivity();
        }
        titleView = (TitleView) getView().findViewById(R.id.title_view);
        localUserInfo = LocalUserInfo.getInstance(getActivity());
        initCommonView();
        initView(mParent);
        initData();
        updateView();
    }

    protected void initCommonView() {
        pullview = findViewByID_My(R.id.pullview);
        if (pullview != null) {
            // 设置pull进度条的样式
            pullview.getHeaderView().setHeaderProgressBarDrawable(
                    this.getResources().getDrawable(R.drawable.progress_circular));
            pullview.getFooterView().setFooterProgressBarDrawable(
                    this.getResources().getDrawable(R.drawable.progress_circular));
        }

        loadingLayout = findViewByID_My(R.id.loading_layout);
        if (loadingLayout != null) {
            loadingLayout.setOnRetryClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadingLayout.showLoading();
                    requestServer();
                }
            });
        }
    }

    protected <T extends View> T findViewByID_My(int id) {
        return (T) mParent.findViewById(id);
    }

    protected abstract void initView(View view);

    protected abstract void initData();

    protected abstract void updateView();

    protected void myToast(String content) {
        Toast.makeText(this.getActivity(), content, Toast.LENGTH_SHORT).show();
    }

    public void requestServer() {

    }

    @Override
    public void showProgress(boolean flag, String message) {
        MyLogger.i("showProgress");
        if (pd == null) {
            pd = new ProgressDialog(getActivity());
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pd.setCancelable(flag);
            pd.setCanceledOnTouchOutside(false);
            pd.setMessage(message);
            pd.show();
        } else {
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pd.setCancelable(flag);
            pd.setCanceledOnTouchOutside(false);
            pd.setMessage(message);
            pd.show();
        }
    }

    @Override
    public void hideProgress() {
        if (pd == null)
            return;

        if (pd.isShowing()) {
            pd.dismiss();
        }
    }

    @Override
    public void showToast(int resId) {
        showToast(getString(resId));
    }

    @Override
    public void showToast(String msg) {
//        if (!getActivity().isFinishing()) {
//            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
//        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(msg);
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    public String getStringbyid(int resId) {
        return getString(resId);
    }


    @Override
    public void showLoadingPage() {
        loadingLayout.showLoading();
    }

    @Override
    public void showErrorPage() {
        loadingLayout.showError();
    }

    @Override
    public void showEmptyPage() {
        loadingLayout.showEmpty();
    }

    @Override
    public void showContentPage() {
        loadingLayout.showContent();
    }

    @Override
    public void onClick(View v) {

    }

}
