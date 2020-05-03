package com.zhitiekeji.equipmentmanagement.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.squareup.okhttp.Request;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.activity.AddEquipmentActivity;
import com.zhitiekeji.equipmentmanagement.activity.EquipmentDetailActivity;
import com.zhitiekeji.equipmentmanagement.activity.LoginActivity;
import com.zhitiekeji.equipmentmanagement.adapter.EquipmentAdapter;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_Equipment2Adapter;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_Equipment2Adapter1;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_Equipment3Adapter;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_EquipmentAdapter;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_UnitListAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseFragment;
import com.zhitiekeji.equipmentmanagement.model.AreaModel1;
import com.zhitiekeji.equipmentmanagement.model.AreaModel2;
import com.zhitiekeji.equipmentmanagement.model.AreaModel3;
import com.zhitiekeji.equipmentmanagement.model.EquipmentListModel;
import com.zhitiekeji.equipmentmanagement.model.MapDetailModel;
import com.zhitiekeji.equipmentmanagement.model.MapListModel1;
import com.zhitiekeji.equipmentmanagement.model.MapListModel2;
import com.zhitiekeji.equipmentmanagement.model.MapListModel3;
import com.zhitiekeji.equipmentmanagement.model.UnitModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.popupwindow.EquipmentPopupWindow;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.Constant;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.zhitiekeji.equipmentmanagement.view.FixedPopupWindow;
import com.zhitiekeji.equipmentmanagement.view.pullview.AbPullToRefreshView;
import com.zhitiekeji.equipmentmanagement.zxing.CaptureActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fafukeji01 on 2016/1/6.
 * 设备主页面
 */
public class EquipmentFragment extends BaseFragment {
    private final static int SCANNIN_GREQUEST_CODE = 1;
    /*标题栏*/
    private ImageView imageView1;
    /*搜索框*/
    private ImageView imageView2, imageView3;
    private EditText editText;
    /*分类选择栏*/
    LinearLayout linearLayout_fenlei;
    private RelativeLayout relativeLayout1, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout7;
    private TextView textView1, textView2, textView3, textView4, textView7;
    private View pop_view;
    String type = "";//类型（1.生产房屋 2.生产构筑物）
    String skill_type = "";//技术类型（安全级别：1.一级 2.二级 3.三级）
    //单位列表数据
    List<UnitModel> unitList = new ArrayList<UnitModel>();
    String company_id = "";//单位id

    //类型选择下标
    int i1 = 0;
    //单位选择下标
    int i3 = 0;
    //修缮选择下标
    int i4_1 = 0;
    int i4_2 = 0;
    //技术选择下标
    int i5 = 0;
    //区域列表数据-车间
    List<AreaModel1> areaList1 = new ArrayList<AreaModel1>();
    int i2_1 = 0;
    //区域列表数据-工区
    List<AreaModel2> areaList2 = new ArrayList<AreaModel2>();
    int i2_2 = 0;
    //区域列表数据-站区
    List<AreaModel3> areaList3 = new ArrayList<AreaModel3>();
    int i2_3 = 0;
    String workshop_id = "";//车间id
    String work_area_id = "";//工区id
    String station_id = "";//站区id

    String service_type = "";//修缮类型（1.请检修 2.综合维修 3.大修）
    String service_status = "";//修缮状态（2.已上报 3.下达 4.批复 5.实施 6.竣工）
    String title = "";//搜索框文本
    /*地图布局*/
    private RelativeLayout relativeLayout5;
    private ImageView imageView4, imageView5, imageView6;
    /*列表布局*/
    private RelativeLayout relativeLayout6;
    private ListView listView;
    List<EquipmentListModel> list = new ArrayList<EquipmentListModel>();
    EquipmentAdapter adapter;
    int page = 1;

    boolean ismap = true;

    BaiduMap mBaiduMap;
    MapView mMapView = null;
    private LocationClient mLocationClient = null;
    private BDLocationListener myListener = new MyLocationListener();
    int mapzoom = 7;
    int tempzomm = 7;
    String latitude = "", lontitude = "";
    /*覆盖物聚合*/
    MapStatus ms;
    List<MapListModel1> map_list1 = new ArrayList<MapListModel1>();
    List<MapListModel2> map_list2 = new ArrayList<MapListModel2>();
    List<MapListModel3> map_list3 = new ArrayList<MapListModel3>();

    Handler handler = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getContext().getApplicationContext());
        mLocationClient = new LocationClient(getContext().getApplicationContext());//声明LocationClient类
        mLocationClient.registerLocationListener(myListener);//注册监听函数
        initLocation();
        mLocationClient.start();


        View view = inflater.inflate(R.layout.fragment_equipment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void initView(View view) {
        /*标题栏*/
        imageView1 = findViewByID_My(R.id.imageView1);
        imageView1.setOnClickListener(this);
        findViewByID_My(R.id.title_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type = "";//类型（1.生产房屋 2.生产构筑物）
                skill_type = "";//技术类型（安全级别：1.一级 2.二级 3.三级）
                company_id = "";//单位id
                workshop_id = "";//车间id
                work_area_id = "";//工区id
                station_id = "";//站区id
                service_type = "";//修缮类型（1.请检修 2.综合维修 3.大修）
                service_status = "";//修缮状态（2.已上报 3.下达 4.批复 5.实施 6.竣工）
                editText.setText("");
                title = "";//搜索框文本
                requestServer();
            }
        });
        /*搜索框*/
        imageView2 = findViewByID_My(R.id.imageView2);
        imageView3 = findViewByID_My(R.id.imageView3);
        editText = findViewByID_My(R.id.editText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    title = v.getText().toString().trim();
                    if (!title.equals("")) {
                        requestServer();
                    } else {
                        showToast("请输入搜索内容");
                    }
                }
                return false;
            }
        });
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        /*分类选择栏*/
        linearLayout_fenlei = findViewByID_My(R.id.linearLayout_fenlei);
        relativeLayout1 = findViewByID_My(R.id.relativeLayout1);
        relativeLayout2 = findViewByID_My(R.id.relativeLayout2);
        relativeLayout3 = findViewByID_My(R.id.relativeLayout3);
        relativeLayout4 = findViewByID_My(R.id.relativeLayout4);
        relativeLayout7 = findViewByID_My(R.id.relativeLayout7);
        relativeLayout1.setOnClickListener(this);
        relativeLayout2.setOnClickListener(this);
        relativeLayout3.setOnClickListener(this);
        relativeLayout4.setOnClickListener(this);
        relativeLayout7.setOnClickListener(this);
        textView1 = findViewByID_My(R.id.textView1);
        textView2 = findViewByID_My(R.id.textView2);
        textView3 = findViewByID_My(R.id.textView3);
        textView4 = findViewByID_My(R.id.textView4);
        textView7 = findViewByID_My(R.id.textView7);
        pop_view = findViewByID_My(R.id.pop_view);
        /*地图布局*/
        relativeLayout5 = findViewByID_My(R.id.relativeLayout5);
        imageView4 = findViewByID_My(R.id.imageView4);
        imageView5 = findViewByID_My(R.id.imageView5);
        imageView6 = findViewByID_My(R.id.imageView6);
        imageView4.setOnClickListener(this);
        imageView5.setOnClickListener(this);
        imageView6.setOnClickListener(this);
        /*列表布局*/
        relativeLayout6 = findViewByID_My(R.id.relativeLayout6);
        listView = findViewByID_My(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("number", list.get(i).getNumber());
                CommonUtil.gotoActivityWithData(getActivity(), EquipmentDetailActivity.class, bundle, false);
            }
        });

        pullview.setOnHeaderRefreshListener(new AbPullToRefreshView.OnHeaderRefreshListener() {
            @Override
            public void onHeaderRefresh(AbPullToRefreshView view) {
                //刷新
                page = 1;
                String string = "?employee_id=" + localUserInfo.getUserId()
                        + "&role=" + localUserInfo.getUserJob()//角色
                        + "&belong_id=" + localUserInfo.getBelongid()//所属id
                        + "&type=" + type//类型（1.生产房屋 2.生产构筑物）
                        + "&company_id=" + company_id//单位id
                        + "&workshop_id=" + workshop_id//车间id
                        + "&work_area_id=" + work_area_id//工区id
                        + "&station_id=" + station_id//站区id
                        + "&service_type=" + service_type//修缮类型（1.请检修 2.综合维修 3.大修）
                        + "&service_status=" + service_status//修缮状态（2.已上报 3.下达 4.批复 5.实施 6.竣工）
                        + "&skill_type=" + skill_type//技术类型（安全级别：1.一级 2.二级 3.三级）
                        + "&title=" + title
                        + "&page=" + page//当前页号
                        + "&count=" + "10"//页面行数
                        + "&token=" + localUserInfo.getToken();
                RequestEquipmentList(string);
            }
        });
        pullview.setOnFooterLoadListener(new AbPullToRefreshView.OnFooterLoadListener() {
            @Override
            public void onFooterLoad(AbPullToRefreshView view) {
                page = page + 1;
                //加载更多
                String string = "?employee_id=" + localUserInfo.getUserId()
                        + "&role=" + localUserInfo.getUserJob()//角色
                        + "&belong_id=" + localUserInfo.getBelongid()//所属id
                        + "&type=" + type//类型（1.生产房屋 2.生产构筑物）
                        + "&company_id=" + company_id//单位id
                        + "&workshop_id=" + workshop_id//车间id
                        + "&work_area_id=" + work_area_id//工区id
                        + "&station_id=" + station_id//站区id
                        + "&service_type=" + service_type//修缮类型（1.请检修 2.综合维修 3.大修）
                        + "&service_status=" + service_status//修缮状态（2.已上报 3.下达 4.批复 5.实施 6.竣工）
                        + "&skill_type=" + skill_type//技术类型（安全级别：1.一级 2.二级 3.三级）
                        + "&title=" + title
                        + "&page=" + page//当前页号
                        + "&count=" + "10"//页面行数
                        + "&token=" + localUserInfo.getToken();
                RequestEquipmentListMore(string);
            }
        });

        /*百度地图*/
        /**
         * level: 距离(米)
         22: 2;
         21: 5;
         20: 10;
         19: 20;
         18: 50;
         17: 100;
         16: 200;
         15: 500;
         14: 1000;
         13: 2000;
         12: 5000;
         11: 10000;
         10: 20000;
         9: 25000;
         8: 50000;
         7: 100000;
         6: 200000;
         5: 500000;
         4: 1000000;
         3: 2000000;
         */
        //获取地图控件引用
        mMapView = findViewByID_My(R.id.bmapView);
        // 不显示缩放比例尺
        mMapView.showZoomControls(false);
        // 不显示百度地图Logo
        mMapView.removeViewAt(1);
        //百度地图
        mBaiduMap = mMapView.getMap();

       MyLogger.i(">>>中心点经纬度>>>>>"+mBaiduMap.getMapStatus().target.latitude +">>>>>>>"+mBaiduMap.getMapStatus().target.longitude);

        if (Integer.valueOf(localUserInfo.getUserJob()) >= 4) {
            mBaiduMap.setMaxAndMinZoomLevel(22, 7);//限制缩放最大或最小等级
            // 改变地图状态
            MapStatus mMapStatus = new MapStatus.Builder().zoom(7).build();//最大21-5米，最小3-2000公里。
            changeMap(7,mBaiduMap.getMapStatus().target.latitude,mBaiduMap.getMapStatus().target.longitude);
            MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
            mBaiduMap.setMapStatus(mMapStatusUpdate);
        } else if (Integer.valueOf(localUserInfo.getUserJob()) == 3) {
            mBaiduMap.setMaxAndMinZoomLevel(22, 9);//限制缩放最大或最小等级
            // 改变地图状态
            MapStatus mMapStatus = new MapStatus.Builder().zoom(9).build();//最大21-5米，最小3-2000公里。
            changeMap(9,mBaiduMap.getMapStatus().target.latitude,mBaiduMap.getMapStatus().target.longitude);
            MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
            mBaiduMap.setMapStatus(mMapStatusUpdate);
        } else {
            mBaiduMap.setMaxAndMinZoomLevel(22, 13);//限制缩放最大或最小等级
            // 改变地图状态
            MapStatus mMapStatus = new MapStatus.Builder().zoom(13).build();//最大21-5米，最小3-2000公里。
            changeMap(13,mBaiduMap.getMapStatus().target.latitude,mBaiduMap.getMapStatus().target.longitude);
            MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
            mBaiduMap.setMapStatus(mMapStatusUpdate);
        }


        //设置地图状态改变监听器
        mBaiduMap.setOnMapStatusChangeListener(new BaiduMap.OnMapStatusChangeListener() {
            @Override
            public void onMapStatusChangeStart(MapStatus arg0) {
            }

            @Override
            public void onMapStatusChangeStart(MapStatus mapStatus, int i) {

            }

            @Override
            public void onMapStatusChangeFinish(MapStatus arg0) {
                LatLng mCenterLatLng = arg0.target;
                //获取中心点经纬度
                double lat = mCenterLatLng.latitude;
                double log = mCenterLatLng.longitude;
                MyLogger.i(">>>中心点经纬度>>>>>"+lat +">>>>>>>"+log);

                //当地图状态改变后，获取放大级别
                MyLogger.i(">>>>>>>>地图放大的级别：" + (int) arg0.zoom + ">>>>临时级别：" + tempzomm);
                mapzoom = (int) arg0.zoom;
                if (mapzoom >= 13 && mapzoom <= 22){
                    //设备层级
                    map_list1.clear();
                    map_list2.clear();
                    changeMap(mapzoom,lat,log);
                }else {
                    //其他层级
                    if (mapzoom != tempzomm) {
                        tempzomm = mapzoom;
                        if (tempzomm >= 3 && tempzomm < 9 && map_list1.size() == 0) {
                            //车间层级
                            map_list2.clear();
                            map_list3.clear();
                            changeMap(mapzoom,lat,log);
                        } else if (tempzomm >= 9 && tempzomm < 13 && map_list2.size() == 0) {
                            //工区层级
                            map_list1.clear();
                            map_list3.clear();
                            changeMap(mapzoom,lat,log);
                        } /*else if (tempzomm >= 13 && tempzomm <= 22 ) {
                            //map_list3.size() == 0
                            //设备层级
                            map_list1.clear();
                            map_list2.clear();
                            changeMap(mapzoom,lat,log);
                        }*/
                    }
                }


            }

            @Override
            public void onMapStatusChange(MapStatus arg0) {
                //当地图状态改变的时候，获取放大级别
            }
        });
        // 设置maker点击时的响应
        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                MyLogger.i(">>>>>>>>>>" + marker.getPosition().longitude + ">>>>>" + marker.getPosition().latitude);
                if (mapzoom >= 13 && mapzoom <= 22) {
                    showProgress(true, "正在获取数据，请稍后...");
                    String string = "?longitude=" + marker.getPosition().longitude + ""
                            + "&latitude=" + marker.getPosition().latitude + ""
                            + "&token=" + localUserInfo.getToken();
                    RequestMapDetail(string);//设备地图-获取某个设备
                }
                return false;
            }
        });
        /*LatLng point = new LatLng(29.60855, 106.55102);
        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.reported2_1);
        OverlayOptions overlayOptions = new MarkerOptions().position(point).icon(bitmapDescriptor);
        mBaiduMap.addOverlay(overlayOptions);*/

       /* //覆盖物聚合
        ms = new MapStatus.Builder().target(new LatLng(29.914935, 106.403119)).zoom(8).build();
        mBaiduMap.setOnMapLoadedCallback(this);
        mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(ms));
        // 定义点聚合管理类ClusterManager
        mClusterManager = new ClusterManager<MyItem>(getActivity(), mBaiduMap);
        // 添加Marker点
        addMarkers();
        // 设置地图监听，当地图状态发生改变时，进行点聚合运算
        mBaiduMap.setOnMapStatusChangeListener(mClusterManager);
        // 设置maker点击时的响应
        mBaiduMap.setOnMarkerClickListener(mClusterManager);
        mClusterManager.setOnClusterClickListener(new ClusterManager.OnClusterClickListener<MyItem>() {
            @Override
            public boolean onClusterClick(Cluster<MyItem> cluster) {
                Toast.makeText(getActivity(), "有" + cluster.getSize() + "个点", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        mClusterManager.setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener<MyItem>() {
            @Override
            public boolean onClusterItemClick(MyItem item) {
                Toast.makeText(getActivity(),
                        "点击单个Item", Toast.LENGTH_SHORT).show();
                EquipmentPopupWindow popupwindow = new EquipmentPopupWindow(getActivity());
                popupwindow.showAtLocation(getActivity().findViewById(R.id.pop_view), Gravity.CENTER, 0, 0);
                return false;
            }
        });*/
    }

    //修改地图覆盖物
    private void changeMap(int zoom,double lat,double log) {
        showProgress(true, "正在获取数据，请稍后...");
        //获取地图数据
        String string = "?map_grade=" + zoom //地图等级
                + "&role=" + localUserInfo.getUserJob()//角色
                + "&belong_id=" + localUserInfo.getBelongid()//所属id
                + "&latitude=" + lat
                + "&longitude=" + log
                + "&level=" + zoom
                + "&token=" + localUserInfo.getToken();
        RequestMap(string, zoom);//设备地图
    }

    @Override
    protected void initData() {
        String string3 = "?token=" + localUserInfo.getToken();
        RequestAreaList1(string3);//区域列表
        RequestUnitList(string3);//单位列表
    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();


        requestServer();//获取数据
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
        // 退出时销毁定位
        mLocationClient.stop();

    }

    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
        //开启定位
        mBaiduMap.setMyLocationEnabled(true);
        if (!mLocationClient.isStarted()) {//如果定位client没有开启，开启定位
            mLocationClient.start();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        //关闭定位
        mBaiduMap.setMyLocationEnabled(false);
        if (mLocationClient.isStarted()) {
            mLocationClient.stop();
        }
    }

    //设备地图
    private void RequestMap(String string, final int zoom) {
        OkHttpClientManager.getAsyn(URLs.EQUIPMENT_MAP + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                onHttpResult();
                if (info.equals("13")) {
                    localUserInfo.setUserId("");
                    myToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(getActivity(), LoginActivity.class, true);
                } else {
                    if (!info.equals("")) {
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {

                MyLogger.i(">>>>>>>>>设备地图" + response);
                mBaiduMap.clear();
                mBaiduMap.hideInfoWindow();
                // 地图标注
                if (zoom >= 3 && zoom < 9) {
                    //三个车间
                    JSONObject jObj;
//                    map_list1 = new ArrayList<MapListModel1>();
                    try {
                        jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                        JSONArray jsonArray = jObj.getJSONArray("data");
                        map_list1 = JSON.parseArray(jsonArray.toString(), MapListModel1.class);
                        List<LatLng> list1 = new ArrayList<LatLng>();
                        List<String> name1 = new ArrayList<String>();
                        for (int i = 0; i < map_list1.size(); i++) {
                            if (!map_list1.get(i).getLatitude().equals("") && !map_list1.get(i).getLongitude().equals("")) {
                                list1.add(new LatLng(Double.valueOf(map_list1.get(i).getLatitude()),
                                        Double.valueOf(map_list1.get(i).getLongitude())));
                                name1.add(map_list1.get(i).getTitle() + "\n" + map_list1.get(i).getFacility_count());

                            }
                        }
                        for (int i = 0; i < list1.size(); i++) {
                            View view = View.inflate(getActivity(), R.layout.map_marke1, null);
                            TextView textView = (TextView) view.findViewById(R.id.textView);
                            textView.setText(name1.get(i));
                            BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(getViewBitmap(view));
                            OverlayOptions overlayOptions = new MarkerOptions().position(list1.get(i)).icon(bitmapDescriptor);
                            mBaiduMap.addOverlay(overlayOptions);
                        }
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                } else if (zoom >= 9 && zoom < 13) {
                    //17个工区
                    JSONObject jObj;
//                    map_list2 = new ArrayList<MapListModel2>();
                    try {
                        jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                        JSONArray jsonArray = jObj.getJSONArray("data");
                        map_list2 = JSON.parseArray(jsonArray.toString(), MapListModel2.class);
                        List<LatLng> list2 = new ArrayList<LatLng>();
                        List<String> name2 = new ArrayList<String>();
                        for (int i = 0; i < map_list2.size(); i++) {
                            if (!map_list2.get(i).getLatitude().equals("") && !map_list2.get(i).getLongitude().equals("")) {
                                list2.add(new LatLng(Double.valueOf(map_list2.get(i).getLatitude()),
                                        Double.valueOf(map_list2.get(i).getLongitude())));
                                name2.add(map_list2.get(i).getTitle() + "\n" + map_list2.get(i).getFacility_count());

                            }
                        }
                        for (int i = 0; i < list2.size(); i++) {
                            View view = View.inflate(getActivity(), R.layout.map_marke1, null);
                            TextView textView = (TextView) view.findViewById(R.id.textView);
                            textView.setText(name2.get(i));
                            BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(getViewBitmap(view));
                            OverlayOptions overlayOptions = new MarkerOptions().position(list2.get(i)).icon(bitmapDescriptor);
                            mBaiduMap.addOverlay(overlayOptions);
                        }
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else if (zoom >= 13 && zoom <= 22) {
                    //上万个标注点
                    JSONObject jObj;
//                    map_list3 = new ArrayList<MapListModel3>();
                    try {
                        jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                        JSONArray jsonArray = jObj.getJSONArray("data");
                        map_list3 = JSON.parseArray(jsonArray.toString(), MapListModel3.class);
                        /*final List<LatLng> list3 = new ArrayList<LatLng>();
                        final List<String> name3 = new ArrayList<String>();
                        final List<String> Is_urgent = new ArrayList<String>();
                        final List<String> Skill_type = new ArrayList<String>();*/
                        MyLogger.i(">>>>设备个数>>"+map_list3.size());
                        //耗时操作 批量在地图上描点
                        new Thread(new Runnable() {
                            public void run() {
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {

                                        for (int i = 0; i < map_list3.size(); i++) {
                                            if (!map_list3.get(i).getLatitude().equals("") && !map_list3.get(i).getLongitude().equals("")) {
                                                /*list3.add(new LatLng(Double.valueOf(map_list3.get(i).getLatitude()),
                                                        Double.valueOf(map_list3.get(i).getLongitude())));
                                                name3.add(map_list3.get(i).getTitle() + "\n" + map_list3.get(i).getNumber());
                                                Is_urgent.add(map_list3.get(i).getIs_urgent());
                                                Skill_type.add(map_list3.get(i).getSkill_type());*/
                                                View view = View.inflate(getActivity(), R.layout.map_marke2, null);
                                                TextView textView = (TextView) view.findViewById(R.id.textView);
                                                ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
                                                textView.setText(map_list3.get(i).getTitle() + "\n" + map_list3.get(i).getNumber());
                                                //根据设备技术等级显示不同圆点的颜色
                                                if (map_list3.get(i).getIs_urgent().equals("1")) {//是否为紧急病害
                                                    imageView.setImageResource(R.drawable.yuanxing_hongse1);//红色
                                                } else {
                                                    if (map_list3.get(i).getSkill_type().equals("1")) {
                                                        imageView.setImageResource(R.drawable.yuanxing_lvse1);//绿色
                                                    } else if (map_list3.get(i).getSkill_type().equals("2")) {
                                                        imageView.setImageResource(R.drawable.yuanxing_huangse);//黄色
                                                    } else if (map_list3.get(i).getSkill_type().equals("3")) {
                                                        imageView.setImageResource(R.drawable.yuanxing_hongse);//红色
                                                    }
                                                }

                                                BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(getViewBitmap(view));
                                                OverlayOptions overlayOptions = new MarkerOptions().position(new LatLng(Double.valueOf(map_list3.get(i).getLatitude()),
                                                        Double.valueOf(map_list3.get(i).getLongitude()))).icon(bitmapDescriptor);
                                                mBaiduMap.addOverlay(overlayOptions);
                                            }
                                        }

                                        /*for (int i = 0; i < map_list3.size(); i++) {
                                            if (!map_list3.get(i).getLatitude().equals("") && !map_list3.get(i).getLongitude().equals("")) {
                                                list3.add(new LatLng(Double.valueOf(map_list3.get(i).getLatitude()),
                                                        Double.valueOf(map_list3.get(i).getLongitude())));
                                                name3.add(map_list3.get(i).getTitle() + "\n" + map_list3.get(i).getNumber());
                                                Is_urgent.add(map_list3.get(i).getIs_urgent());
                                                Skill_type.add(map_list3.get(i).getSkill_type());
                                            }
                                        }

                                        for (int i = 0; i < list3.size(); i++) {
                                            View view = View.inflate(getActivity(), R.layout.map_marke2, null);
                                            TextView textView = (TextView) view.findViewById(R.id.textView);
                                            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
                                            textView.setText(name3.get(i));
                                            //根据设备技术等级显示不同圆点的颜色
                                            if (Is_urgent.get(i).equals("1")) {//是否为紧急病害
                                                imageView.setImageResource(R.drawable.yuanxing_hongse1);//红色
                                            } else {
                                                if (Skill_type.get(i).equals("1")) {
                                                    imageView.setImageResource(R.drawable.yuanxing_lvse1);//绿色
                                                } else if (Skill_type.get(i).equals("2")) {
                                                    imageView.setImageResource(R.drawable.yuanxing_huangse);//黄色
                                                } else if (Skill_type.get(i).equals("3")) {
                                                    imageView.setImageResource(R.drawable.yuanxing_hongse);//红色
                                                }
                                            }

                                            BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(getViewBitmap(view));
                                            OverlayOptions overlayOptions = new MarkerOptions().position(list3.get(i)).icon(bitmapDescriptor);
                                            mBaiduMap.addOverlay(overlayOptions);
                                        }*/


                                    }
                                });
                            }
                        }).start();


                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                hideProgress();
                onHttpResult();

            }
        });

    }

    //设备地图
    private void RequestMapDetail(String string) {
        OkHttpClientManager.getAsyn(URLs.EQUIPMENT_MAP_Detail + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                onHttpResult();
                if (info.equals("13")) {
                    localUserInfo.setUserId("");
                    myToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(getActivity(), LoginActivity.class, true);
                } else {
                    if (!info.equals("")) {
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                onHttpResult();
                MyLogger.i(">>>>>>>>>设备地图_详细" + response);


                JSONObject jObj;
                List<MapDetailModel> poplist = new ArrayList<MapDetailModel>();
                try {
                    jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    poplist = JSON.parseArray(jsonArray.toString(), MapDetailModel.class);
                    if (poplist.size() > 0) {
                        EquipmentPopupWindow popupwindow = new EquipmentPopupWindow(getActivity(), poplist);
                        popupwindow.showAtLocation(getActivity().findViewById(R.id.pop_view), Gravity.CENTER, 0, 0);
                    } else {
                        showToast("获取设备失败，请稍候再试");
                    }

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    //设备列表
    private void RequestEquipmentList(String string) {
        OkHttpClientManager.getAsyn(URLs.EQUIPMENT_LIST + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                onHttpResult();
                if (info.equals("13")) {
                    localUserInfo.setUserId("");
                    myToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(getActivity(), LoginActivity.class, true);
                } else {
                    if (!info.equals("")) {
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                showContentPage();
                onHttpResult();
                MyLogger.i(">>>>>>>>>设备列表" + response);
                JSONObject jObj;
                list = new ArrayList<EquipmentListModel>();
                try {
                    jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list = JSON.parseArray(jsonArray.toString(), EquipmentListModel.class);
                    if (list.size() == 0) {
                        showEmptyPage();//空数据
                    } else {
                        if (!title.equals("") && ismap) {
                            ShowMapPosition(list.get(0).getLatitude(), list.get(0).getLongitude());
                        } else {
                            adapter = new EquipmentAdapter(getActivity(), list);
                            listView.setAdapter(adapter);
                        }
                    }

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    private void RequestEquipmentListMore(String string) {
        OkHttpClientManager.getAsyn(URLs.EQUIPMENT_LIST + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                onHttpResult();
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                onHttpResult();
                MyLogger.i(">>>>>>>>>设备列表更多" + response);
                JSONObject jObj;
                List<EquipmentListModel> list1 = new ArrayList<EquipmentListModel>();
                try {
                    jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list1 = JSON.parseArray(jsonArray.toString(), EquipmentListModel.class);
                    if (list1.size() == 0) {
                        myToast("没有更多了");
                    } else {
                        list.addAll(list1);
                        adapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    //区域列表1-车间
    private void RequestAreaList1(String string) {
        OkHttpClientManager.getAsyn(URLs.AREA_LIST1 + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                onHttpResult();
                if (!info.equals("")) {
//                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                onHttpResult();
                MyLogger.i(">>>>>>>>>区域列表1-车间" + response);
                JSONObject jObj;
                areaList1 = new ArrayList<AreaModel1>();
                try {
                    jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    areaList1 = JSON.parseArray(jsonArray.toString(), AreaModel1.class);

                    /*if (areaList1.size() > 0) {
                        //获取第一个车间所属工区
                        String string = "?token=" + localUserInfo.getToken()
                                + "&workshop_id=" + areaList1.get(0).getId();
                        RequestAreaList2(string);//区域列表
                    }*/

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    //区域列表2-工区
    private void RequestAreaList2(String string) {
        OkHttpClientManager.getAsyn(URLs.AREA_LIST2 + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                onHttpResult();
                if (!info.equals("")) {
//                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                onHttpResult();
                MyLogger.i(">>>>>>>>>区域列表2-工区" + response);
                JSONObject jObj;
                areaList2 = new ArrayList<AreaModel2>();
                try {
                    jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    areaList2 = JSON.parseArray(jsonArray.toString(), AreaModel2.class);

                    list2.clear();
                    list2.add("全部");
                    for (int i = 0; i < areaList2.size(); i++) {
                        list2.add(areaList2.get(i).getTitle());
                    }
                    if (adapter2 != null) {
//                        adapter2 = new Pop_Equipment2Adapter(getActivity(),list2);
//                        pop_listView2.setAdapter(adapter2);
                        adapter2.notifyDataSetChanged();
                        adapter2.setSelectItem(0);
                    }
                    if (list2.size() == 1) {
                        String string = "?token=" + localUserInfo.getToken()
                                + "&work_area_id=" + "";
                        RequestAreaList3(string);//站区列表
                    } else {
                        if (areaList2.size() > 0) {
                            //获取第一个车间所属站区
                            String string = "?token=" + localUserInfo.getToken()
                                    + "&work_area_id=" + areaList2.get(0).getId();
                            RequestAreaList3(string);//站区列表
                        }
                    }

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    //区域列表3-站区
    private void RequestAreaList3(String string) {
        OkHttpClientManager.getAsyn(URLs.AREA_LIST3 + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                onHttpResult();
                if (!info.equals("")) {
//                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                onHttpResult();
                MyLogger.i(">>>>>>>>>区域列表3-站区" + response);
                JSONObject jObj;
                areaList3 = new ArrayList<AreaModel3>();
                try {
                    jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    areaList3 = JSON.parseArray(jsonArray.toString(), AreaModel3.class);

                    list3.clear();
                    list3.add("全部");
                    for (int i = 0; i < areaList3.size(); i++) {
                        list3.add(areaList3.get(i).getTitle());
                    }
                    if (adapter3 != null) {
                        adapter3.notifyDataSetChanged();
                        adapter3.setSelectItem(0);
                    }
                    /*if (areaList3.size() > 0) {
                        area_id = areaList3.get(0).getId();
                    }*/


                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    //单位列表
    private void RequestUnitList(String string) {
        OkHttpClientManager.getAsyn(URLs.UNIT_LIST + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                onHttpResult();
                if (!info.equals("")) {
//                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                showContentPage();
                onHttpResult();
                MyLogger.i(">>>>>>>>>单位列表" + response);
                JSONObject jObj;
                unitList = new ArrayList<UnitModel>();
                try {
                    jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    unitList = JSON.parseArray(jsonArray.toString(), UnitModel.class);

//                    company_id = unitList.get(0).getId();

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        Drawable drawable1 = getResources().getDrawable(R.mipmap.downimg2);//选中-蓝色
        Drawable drawable2 = getResources().getDrawable(R.mipmap.downimg3);//未选-灰色
        drawable1.setBounds(0, 0, drawable1.getMinimumWidth(), drawable1.getMinimumHeight());
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        switch (v.getId()) {
            /*标题栏*/
            case R.id.imageView1:
                //添加设备
                if (Integer.valueOf(localUserInfo.getUserJob()) <= 5) {
                    CommonUtil.gotoActivity(getActivity(), AddEquipmentActivity.class, false);
                } else {
                    showToast("无权限进行此操作");
                }
                break;
            /*搜索框*/
            case R.id.imageView2:
                //扫一扫
                startQrCode();
                /*ZXingLibrary.initDisplayOpinion(getActivity());
                Intent intent = new Intent(getContext(), CaptureActivity.class);
                startActivityForResult(intent, 10086);*/

                break;
            case R.id.imageView3:
                //切换列表
                ismap = !ismap;
                if (ismap) {
                    //显示地图
                    imageView3.setImageResource(R.mipmap.liebiao);
                    relativeLayout5.setVisibility(View.VISIBLE);
                    relativeLayout6.setVisibility(View.GONE);
                    linearLayout_fenlei.setVisibility(View.GONE);
                } else {
                    //显示列表
                    imageView3.setImageResource(R.mipmap.ditu);
                    relativeLayout5.setVisibility(View.GONE);
                    relativeLayout6.setVisibility(View.VISIBLE);
                    linearLayout_fenlei.setVisibility(View.VISIBLE);
                }
                break;
            /*分类选择栏*/
            case R.id.relativeLayout1:
                //类型
                CommonUtil.hideSoftKeyboard_fragment(v, getActivity());
                textView1.setTextColor(getResources().getColor(R.color.blue));
                textView2.setTextColor(getResources().getColor(R.color.black1));
                textView3.setTextColor(getResources().getColor(R.color.black1));
                textView4.setTextColor(getResources().getColor(R.color.black1));
                textView7.setTextColor(getResources().getColor(R.color.black1));
                textView1.setCompoundDrawables(null, null, drawable1, null);
                textView2.setCompoundDrawables(null, null, drawable2, null);
                textView3.setCompoundDrawables(null, null, drawable2, null);
                textView4.setCompoundDrawables(null, null, drawable2, null);
                textView7.setCompoundDrawables(null, null, drawable2, null);
                showPopupWindow1(pop_view);
                break;
            case R.id.relativeLayout2:
                //区域
                CommonUtil.hideSoftKeyboard_fragment(v, getActivity());
                textView1.setTextColor(getResources().getColor(R.color.black1));
                textView2.setTextColor(getResources().getColor(R.color.blue));
                textView3.setTextColor(getResources().getColor(R.color.black1));
                textView4.setTextColor(getResources().getColor(R.color.black1));
                textView7.setTextColor(getResources().getColor(R.color.black1));
                textView1.setCompoundDrawables(null, null, drawable2, null);
                textView2.setCompoundDrawables(null, null, drawable1, null);
                textView3.setCompoundDrawables(null, null, drawable2, null);
                textView4.setCompoundDrawables(null, null, drawable2, null);
                textView7.setCompoundDrawables(null, null, drawable2, null);
                showPopupWindow2(pop_view);
                break;
            case R.id.relativeLayout3:
                //单位
                CommonUtil.hideSoftKeyboard_fragment(v, getActivity());
                textView1.setTextColor(getResources().getColor(R.color.black1));
                textView2.setTextColor(getResources().getColor(R.color.black1));
                textView3.setTextColor(getResources().getColor(R.color.blue));
                textView4.setTextColor(getResources().getColor(R.color.black1));
                textView7.setTextColor(getResources().getColor(R.color.black1));
                textView1.setCompoundDrawables(null, null, drawable2, null);
                textView2.setCompoundDrawables(null, null, drawable2, null);
                textView3.setCompoundDrawables(null, null, drawable1, null);
                textView4.setCompoundDrawables(null, null, drawable2, null);
                textView7.setCompoundDrawables(null, null, drawable2, null);
                showPopupWindow3(pop_view);
                break;
            case R.id.relativeLayout4:
                //修缮
                CommonUtil.hideSoftKeyboard_fragment(v, getActivity());
                textView1.setTextColor(getResources().getColor(R.color.black1));
                textView2.setTextColor(getResources().getColor(R.color.black1));
                textView3.setTextColor(getResources().getColor(R.color.black1));
                textView4.setTextColor(getResources().getColor(R.color.blue));
                textView7.setTextColor(getResources().getColor(R.color.black1));
                textView1.setCompoundDrawables(null, null, drawable2, null);
                textView2.setCompoundDrawables(null, null, drawable2, null);
                textView3.setCompoundDrawables(null, null, drawable2, null);
                textView4.setCompoundDrawables(null, null, drawable1, null);
                textView7.setCompoundDrawables(null, null, drawable2, null);
                showPopupWindow4(pop_view);
                break;
            case R.id.relativeLayout7:
                //技术
                CommonUtil.hideSoftKeyboard_fragment(v, getActivity());
                textView1.setTextColor(getResources().getColor(R.color.black1));
                textView2.setTextColor(getResources().getColor(R.color.black1));
                textView3.setTextColor(getResources().getColor(R.color.black1));
                textView4.setTextColor(getResources().getColor(R.color.black1));
                textView7.setTextColor(getResources().getColor(R.color.blue));
                textView1.setCompoundDrawables(null, null, drawable2, null);
                textView2.setCompoundDrawables(null, null, drawable2, null);
                textView3.setCompoundDrawables(null, null, drawable2, null);
                textView4.setCompoundDrawables(null, null, drawable2, null);
                textView7.setCompoundDrawables(null, null, drawable1, null);
                showPopupWindow5(pop_view);
                break;
            /*地图布局*/
            case R.id.imageView4:
                //显示弹框
               /* EquipmentPopupWindow popupwindow = new EquipmentPopupWindow(getActivity());
                popupwindow.showAtLocation(getActivity().findViewById(R.id.pop_view), Gravity.CENTER, 0, 0);*/
                break;
            case R.id.imageView5:
                //显示弹框
                /*EquipmentPopupWindow popupwindow1 = new EquipmentPopupWindow(getActivity());
                popupwindow1.showAtLocation(getActivity().findViewById(R.id.pop_view), Gravity.CENTER, 0, 0);*/
                break;
            case R.id.imageView6:
                //定位到当前
                showProgress(true, "正在定位当前位置，请稍后...");
                ShowMapPosition(latitude, lontitude);
                break;
        }
    }

    //根据经纬度为中心点显示地图
    private void ShowMapPosition(String latitude, String lontitude) {
        if (!latitude.equals("") && !lontitude.equals("")) {
            mapzoom = 18;
            //设定中心点坐标
            LatLng cenpt = new LatLng(Double.valueOf(latitude), Double.valueOf(lontitude));
            //定义地图状态
            MapStatus mMapStatus = new MapStatus.Builder()
                    .target(cenpt)
                    .zoom(mapzoom)
                    .build();
            //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
            MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
            //改变地图状态
            mBaiduMap.setMapStatus(mMapStatusUpdate);
            changeMap(mapzoom,Double.valueOf(latitude), Double.valueOf(lontitude));
        }
    }

    // 开始扫码
    private void startQrCode() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // 申请权限
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, Constant.REQ_PERM_CAMERA);
            return;
        }
        // 二维码扫码
        Intent intent = new Intent(getActivity(), CaptureActivity.class);
        startActivityForResult(intent, Constant.REQ_QR_CODE);
    }

    @Override
    protected void updateView() {
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * 处理二维码扫描结果
         */
        /*if (requestCode == 10086) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
//                    Toast.makeText(getActivity(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("number", result);
                    CommonUtil.gotoActivityWithData(getActivity(), EquipmentDetailActivity.class, bundle1, false);
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }*/
        //扫描结果回调
        if (requestCode == Constant.REQ_QR_CODE) {
            if (data != null) {
                Bundle bundle = data.getExtras();
                String scanResult = bundle.getString(Constant.INTENT_EXTRA_KEY_QR_SCAN);
                if (scanResult != null && !scanResult.equals("")) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("number", scanResult);
                    CommonUtil.gotoActivityWithData(getActivity(), EquipmentDetailActivity.class, bundle1, false);
                }
            }


        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case Constant.REQ_PERM_CAMERA:
                // 摄像头权限申请
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 获得授权
                    startQrCode();
                } else {
                    // 被禁止授权
                    showToast("请至权限中心打开本应用的相机访问权限");
                }
                break;
        }
    }

    @Override
    public void requestServer() {
        super.requestServer();
        this.showLoadingPage();
        page = 1;
        String string = "?employee_id=" + localUserInfo.getUserId()
                + "&role=" + localUserInfo.getUserJob()//角色
                + "&belong_id=" + localUserInfo.getBelongid()//所属id
                + "&type=" + type//类型（1.生产房屋 2.生产构筑物）
                + "&company_id=" + company_id//单位id
                + "&workshop_id=" + workshop_id//车间id
                + "&work_area_id=" + work_area_id//工区id
                + "&station_id=" + station_id//站区id
                + "&service_type=" + service_type//修缮类型（1.请检修 2.综合维修 3.大修）
                + "&service_status=" + service_status//修缮状态（2.已上报 3.下达 4.批复 5.实施 6.竣工）
                + "&skill_type=" + skill_type//技术类型（安全级别：1.一级 2.二级 3.三级）
                + "&title=" + title
                + "&page=" + page//当前页号
                + "&count=" + "10"//页面行数
                + "&token=" + localUserInfo.getToken();
        RequestEquipmentList(string);//设备列表
    }

    public void onHttpResult() {
        pullview.onHeaderRefreshFinish();
        pullview.onFooterLoadFinish();
    }


    private void showPopupWindow1(View v) {
        // 一个自定义的布局，作为显示的内容
        final View contentView = LayoutInflater.from(getActivity()).inflate(
                R.layout.pop_equipment, null);
        final FixedPopupWindow popupWindow = new FixedPopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

        contentView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = contentView.findViewById(R.id.pop_listView).getTop();
                int height1 = contentView.findViewById(R.id.pop_listView).getBottom();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (y < height) {
                        popupWindow.dismiss();
                    }
                    if (y > height1) {
                        popupWindow.dismiss();
                    }
                }
                return true;
            }
        });
        // 设置按钮的点击事件
        ListView pop_listView = (ListView) contentView.findViewById(R.id.pop_listView);
        List<String> list = new ArrayList<String>();
        list.add("全部");
        list.add("生产房屋");
        list.add("生产构筑物");
        final Pop_EquipmentAdapter adapter = new Pop_EquipmentAdapter(getActivity(), list);
        adapter.setSelectItem(i1);
        pop_listView.setAdapter(adapter);
        pop_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i1 = i;
                adapter.setSelectItem(i);
                adapter.notifyDataSetChanged();
                if (i == 0) {
                    type = "";
                } else {
                    type = i + "";
                }
                requestServer();
                popupWindow.dismiss();
            }
        });

        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });
        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
//        popupWindow.setBackgroundDrawable(getResources().getDrawable(
//                R.drawable.yuanjiao_0_heisetouming));
        ColorDrawable dw = new ColorDrawable(this.getResources().getColor(R.color.transparentblack2));
        // 设置弹出窗体的背景
        popupWindow.setBackgroundDrawable(dw);
        // 设置好参数之后再show
        popupWindow.showAsDropDown(v);

    }

    Pop_Equipment2Adapter adapter2;
    ListView pop_listView2;
    List<String> list2 = new ArrayList<String>();
    Pop_Equipment3Adapter adapter3;
    ListView pop_listView3;
    List<String> list3 = new ArrayList<String>();

    private void showPopupWindow2(View v) {
        // 一个自定义的布局，作为显示的内容
        final View contentView = LayoutInflater.from(getActivity()).inflate(
                R.layout.pop_list3, null);
        final FixedPopupWindow popupWindow = new FixedPopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        contentView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = contentView.findViewById(R.id.linearLayout).getTop();
                int height1 = contentView.findViewById(R.id.linearLayout).getBottom();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        popupWindow.dismiss();
                    }
                    if (y > height1) {
                        popupWindow.dismiss();
                    }
                }
                return true;
            }
        });
        // 设置按钮的点击事件
        ListView pop_listView1 = (ListView) contentView.findViewById(R.id.pop_listView1);
        List<String> list1 = new ArrayList<String>();
        list1.add("全部");
        for (int i = 0; i < areaList1.size(); i++) {
            list1.add(areaList1.get(i).getTitle());
        }
        final Pop_EquipmentAdapter adapter = new Pop_EquipmentAdapter(getActivity(), list1);
        adapter.setSelectItem(i2_1);
        pop_listView1.setAdapter(adapter);
        pop_listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i2_1 = i;
                adapter.setSelectItem(i2_1);
                adapter.notifyDataSetChanged();
                i2_2 = 0;
                i2_3 = 0;
                work_area_id = "";//工区id
                station_id = "";//站区id
                if (i == 0) {
                    workshop_id = "";//车间id
                } else {
                    //获取该车间所属工区
                    workshop_id = areaList1.get(i - 1).getId();
                    ;//车间id
                }
                String string = "?token=" + localUserInfo.getToken()
                        + "&workshop_id=" + workshop_id;
                RequestAreaList2(string);//区域列表

                requestServer();

            }
        });

        pop_listView2 = (ListView) contentView.findViewById(R.id.pop_listView2);
        adapter2 = new Pop_Equipment2Adapter(getActivity(), list2);
        adapter2.setSelectItem(i2_2);
        pop_listView2.setAdapter(adapter2);
        pop_listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i2_2 = i;
                adapter2.setSelectItem(i2_2);
                adapter2.notifyDataSetChanged();
                i2_3 = 0;
                station_id = "";//站区id
                //获取该工区所属站区
                if (i == 0) {
                    work_area_id = "";//工区id
                } else {
                    work_area_id = areaList2.get(i - 1).getId();//工区id

                }
                String string = "?token=" + localUserInfo.getToken()
                        + "&work_area_id=" + work_area_id;
                RequestAreaList3(string);//站区列表
                requestServer();
            }
        });

        pop_listView3 = (ListView) contentView.findViewById(R.id.pop_listView3);
        adapter3 = new Pop_Equipment3Adapter(getActivity(), list3);
        adapter3.setSelectItem(i2_3);
        pop_listView3.setAdapter(adapter3);
        pop_listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i2_3 = i;
                adapter3.setSelectItem(i2_3);
                adapter3.notifyDataSetChanged();
                if (i == 0) {
                    station_id = "";//站区id
                } else {
                    station_id = areaList3.get(i - 1).getId();
                }
                requestServer();
                popupWindow.dismiss();
            }
        });

        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        ColorDrawable dw = new ColorDrawable(this.getResources().getColor(R.color.transparentblack3));
        // 设置弹出窗体的背景
        popupWindow.setBackgroundDrawable(dw);
        // 设置好参数之后再show
        popupWindow.showAsDropDown(v);
    }

    private void showPopupWindow3(View v) {
        // 一个自定义的布局，作为显示的内容
        final View contentView = LayoutInflater.from(getActivity()).inflate(
                R.layout.pop_list1, null);
        final FixedPopupWindow popupWindow = new FixedPopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

        contentView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = contentView.findViewById(R.id.pop_listView).getTop();
                int height1 = contentView.findViewById(R.id.pop_listView).getBottom();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        popupWindow.dismiss();
                    }
                    if (y > height1) {
                        popupWindow.dismiss();
                    }
                }
                return true;
            }
        });
        // 设置按钮的点击事件
        ListView pop_listView = (ListView) contentView.findViewById(R.id.pop_listView);
        List<String> list = new ArrayList<String>();
        list.add("全部");
        for (int i = 0; i < unitList.size(); i++) {
            list.add(unitList.get(i).getTitle());
        }
        final Pop_UnitListAdapter adapter = new Pop_UnitListAdapter(getActivity(), list);

        adapter.setSelectItem(i3);
        pop_listView.setAdapter(adapter);
        pop_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i3 = i;
                adapter.setSelectItem(i3);
                adapter.notifyDataSetChanged();
                if (i == 0) {
                    company_id = "";
                } else {
                    company_id = unitList.get(i - 1).getId();
                }

                requestServer();
                popupWindow.dismiss();
            }
        });

        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        ColorDrawable dw = new ColorDrawable(this.getResources().getColor(R.color.transparentblack3));
        // 设置弹出窗体的背景
        popupWindow.setBackgroundDrawable(dw);
        // 设置好参数之后再show
        popupWindow.showAsDropDown(v);
    }

    private void showPopupWindow4(View v) {
        // 一个自定义的布局，作为显示的内容
        final View contentView = LayoutInflater.from(getActivity()).inflate(
                R.layout.pop_list2, null);
        final FixedPopupWindow popupWindow = new FixedPopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        contentView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = contentView.findViewById(R.id.linearLayout).getTop();
                int height1 = contentView.findViewById(R.id.linearLayout).getBottom();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        popupWindow.dismiss();
                    }
                    if (y > height1) {
                        popupWindow.dismiss();
                    }
                }
                return true;
            }
        });
        // 设置按钮的点击事件
        ListView pop_listView1 = (ListView) contentView.findViewById(R.id.pop_listView1);
        List<String> list = new ArrayList<String>();
        list.add("全部");
        list.add("请检修");
        list.add("综合维修");
        list.add("大修");
        final Pop_EquipmentAdapter adapter = new Pop_EquipmentAdapter(getActivity(), list);
        adapter.setSelectItem(i4_1);
        pop_listView1.setAdapter(adapter);
        pop_listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i4_1 = i;
                adapter.setSelectItem(i4_1);
                adapter.notifyDataSetChanged();
                if (i == 0) {
                    service_type = "";
                } else {
                    service_type = i + "";
                }
                requestServer();
//                popupWindow.dismiss();
            }
        });
        ListView pop_listView2 = (ListView) contentView.findViewById(R.id.pop_listView2);
        List<String> list2 = new ArrayList<String>();
        list2.add("全部");
        list2.add("上报");
        list2.add("下达");
        list2.add("批复");
        list2.add("实施");
        list2.add("竣工");
        final Pop_Equipment2Adapter1 adapter2 = new Pop_Equipment2Adapter1(getActivity(), list2);
        adapter2.setSelectItem(i4_2);
        pop_listView2.setAdapter(adapter2);
        pop_listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i4_2 = i;
                adapter2.setSelectItem(i4_2);
                adapter2.notifyDataSetChanged();
                if (i == 0) {
                    service_status = "";
                } else {
                    service_status = i + "";
                }
                requestServer();
                popupWindow.dismiss();
            }
        });


        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        ColorDrawable dw = new ColorDrawable(this.getResources().getColor(R.color.transparentblack3));
        // 设置弹出窗体的背景
        popupWindow.setBackgroundDrawable(dw);
        // 设置好参数之后再show
        popupWindow.showAsDropDown(v);
    }

    private void showPopupWindow5(View v) {
        // 一个自定义的布局，作为显示的内容
        final View contentView = LayoutInflater.from(getActivity()).inflate(
                R.layout.pop_equipment, null);
        final FixedPopupWindow popupWindow = new FixedPopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

        contentView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = contentView.findViewById(R.id.pop_listView).getTop();
                int height1 = contentView.findViewById(R.id.pop_listView).getBottom();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        popupWindow.dismiss();
                    }
                    if (y > height1) {
                        popupWindow.dismiss();
                    }
                }
                return true;
            }
        });
        // 设置按钮的点击事件
        ListView pop_listView = (ListView) contentView.findViewById(R.id.pop_listView);
        List<String> list = new ArrayList<String>();
        list.add("全部");
        list.add("一级");
        list.add("二级");
        list.add("三级");
        list.add("紧急");
        final Pop_EquipmentAdapter adapter = new Pop_EquipmentAdapter(getActivity(), list);
        adapter.setSelectItem(i5);
        pop_listView.setAdapter(adapter);
        pop_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i5 = i;
                adapter.setSelectItem(i5);
                adapter.notifyDataSetChanged();
                if (i == 0) {
                    skill_type = "";
                } else {
                    skill_type = i + "";
                }

                requestServer();
                popupWindow.dismiss();
            }
        });

        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        ColorDrawable dw = new ColorDrawable(this.getResources().getColor(R.color.transparentblack3));
        // 设置弹出窗体的背景
        popupWindow.setBackgroundDrawable(dw);
        // 设置好参数之后再show
        popupWindow.showAsDropDown(v);
//        if (Build.VERSION.SDK_INT == 24) {
//            // 适配 android 7.0
//            /*int[] location = new int[2];
//            v.getLocationOnScreen(location);
//            int x = location[0];
//            int y = location[1];
//            Log.e(getClass().getSimpleName(), "x : " + x + ", y : " + y);
//            popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, 0, y + v.getHeight());*/
//
//            int[] a = new int[2];
//            v.getLocationOnScreen(a);
//            popupWindow.showAtLocation(getActivity().getWindow().getDecorView(), Gravity.NO_GRAVITY, 0, v.getHeight()+a[1]);
//            popupWindow.update();
//
//        } else {
//            popupWindow.showAsDropDown(v);
//        }
    }

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0  0.0 完全不透明,1.0完全透明
        getActivity().getWindow().setAttributes(lp);
    }


    /**
     * ******************************百度地图定位************************************************
     */
    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setPriority(LocationClientOption.GpsFirst); //设置gps优先
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        option.setScanSpan(0);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(false);//可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true); //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤GPS仿真结果，默认需要

        mLocationClient.setLocOption(option);
    }

    public class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //获取定位结果
            StringBuffer sb = new StringBuffer(256);
//            sb.append("time : ");
//            sb.append(location.getTime());    //获取定位时间
//            sb.append("\nerror code : ");
//            sb.append(location.getLocType());    //获取类型类型
            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());    //获取纬度信息
            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());    //获取经度信息
//            sb.append("\nradius : ");
//            sb.append(location.getRadius());    //获取定位精准度
            if (location.getLocType() == BDLocation.TypeGpsLocation) {
                // GPS定位结果
//                sb.append("\nspeed : ");
//                sb.append(location.getSpeed());    // 单位：公里每小时
//                sb.append("\nsatellite : ");
//                sb.append(location.getSatelliteNumber());    //获取卫星数
//                sb.append("\nheight : ");
//                sb.append(location.getAltitude());    //获取海拔高度信息，单位米
//                sb.append("\ndirection : ");
//                sb.append(location.getDirection());    //获取方向信息，单位度
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());    //获取地址信息
                sb.append("\ndescribe : ");
                sb.append("gps定位成功");

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {
                // 网络定位结果
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());    //获取地址信息
                sb.append("\noperationers : ");
                sb.append(location.getOperators());    //获取运营商信息
                sb.append("\ndescribe : ");
                sb.append("网络定位成功");
            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {
                // 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");
            } else if (location.getLocType() == BDLocation.TypeServerError) {
                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");
            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
            }
//            sb.append("\nlocationdescribe : ");
//            sb.append(location.getLocationDescribe());    //位置语义化信息
//            List<Poi> list = location.getPoiList();    // POI数据
//            if (list != null) {
//                sb.append("\npoilist size = : ");
//                sb.append(list.size());
//                for (Poi p : list) {
//                    sb.append("\npoi= : ");
//                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
//                }
//            }
            MyLogger.i("BaiduLocationApiDem>>>>>>>>>>" + sb.toString());
            latitude = location.getLatitude() + "";
            lontitude = location.getLongitude() + "";
            // 开启定位图层
            mBaiduMap.setMyLocationEnabled(true);
            // 构造定位数据
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(100).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            // 设置定位数据
            mBaiduMap.setMyLocationData(locData);
            //获取经纬度
            LatLng ll = new LatLng(location.getLatitude(), location.getLongitude());
            MapStatusUpdate status = MapStatusUpdateFactory.newLatLng(ll);
//            mBaiduMap.setMapStatus(status);//直接到中间
            mBaiduMap.animateMapStatus(status);//动画的方式到中间
        }

    }


    /*将布局转换为bitmap*/
    private Bitmap getViewBitmap(View addViewContent) {

        addViewContent.setDrawingCacheEnabled(true);

        addViewContent.measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        addViewContent.layout(0, 0,
                addViewContent.getMeasuredWidth(),
                addViewContent.getMeasuredHeight());

        addViewContent.buildDrawingCache();
        Bitmap cacheBitmap = addViewContent.getDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(cacheBitmap);

        return bitmap;
    }
}
