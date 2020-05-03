package com.zhitiekeji.equipmentmanagement.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

import com.zhitiekeji.equipmentmanagement.model.UserInfo;


public class LocalUserInfo {
    /**
     * 保存Preference的name
     */
    public static final String PREFERENCE_NAME = "local_userinfo";
    public static final String USERPHOTO_FILENAME = "userphotoname";//头像图片文件名

    public static final String Time= "time";//时间戳
    public static final String Token = "token";//token
    public static final String UserType = "userType";//用户类型（1.员工 2.会员 3.      4.劳务）
    public static final String Version = "version";//版本号
    public static final String USERNAME = "userName";//用户名
    public static final String USERID = "userID";//用户id
    public static final String USERJOB = "userJob";//用户职位（角色（1.巡检工 2.工区长 3.车间主任 4.技术科 5.段长））
    public static final String BELONGID = "belong_id";//所属id（状态：[1.巡检工]此id为工区id [2.工区长]此id为车间id [3.车间主任 4.技术科 5.段长]此id为路段id）
    public static final String USERIMAGE= "userImage";//用户头像






    public static final String EMAIL = "email";//邮箱
    public static final String PHONENUMBER = "phoneNumber";//电话
    public static final String LEVEL = "level";//等级
    public static final String USERCAPTION = "userCaption";//用户简介
    public static final String ISREALNAMEVALIDATED = "isRealNameValidated";//用户是否实名验证
    public static final String USERREALNAME = "userRealName";//用户真实姓名
    private static SharedPreferences mSharedPreferences;
    private static LocalUserInfo localUserInfo;
    private static Editor editor;

    private LocalUserInfo(Context cxt) {
        mSharedPreferences = cxt.getSharedPreferences(PREFERENCE_NAME,
                Context.MODE_PRIVATE);
    }

    /**
     * 单例模式，获取instance实例
     *
     * @param cxt
     * @return
     */
    public static LocalUserInfo getInstance(Context cxt) {
        if (localUserInfo == null) {
            localUserInfo = new LocalUserInfo(cxt);
        }
        editor = mSharedPreferences.edit();
        return localUserInfo;
    }

    //设置时间戳
    public void setTime(String string) {
        editor.putString(Time, string);
        editor.commit();
    }
    //设置token
    public void setToken(String string) {
        editor.putString(Token, string);
        editor.commit();
    }
    //设置用户类型
    public void setUserType(String string) {
        editor.putString(UserType, string);
        editor.commit();
    }
    //设置版本号
    public void setVersion(String string) {
        editor.putString(Version, string);
        editor.commit();
    }
    //设置用户名
    public void setUserName(String string) {
        editor.putString(USERNAME, string);
        editor.commit();
    }
    //设置用户id
    public void setUserId(String string) {
        editor.putString(USERID, string);
        editor.commit();
    }
    //设置用户职位
    public void setUserJob(String string) {
        editor.putString(USERJOB, string);
        editor.commit();
    }
    //设置用户所属id
    public void setBelongid(String string) {
        editor.putString(BELONGID, string);
        editor.commit();
    }
    //设置用户头像
    public void setUserImage(String string) {
        editor.putString(USERIMAGE, string);
        editor.commit();
    }
    //设置本地存储的头像文件名
    public void setUserPhotoName(String photoName) {
        editor.putString(USERPHOTO_FILENAME, photoName);
        editor.commit();
    }
    //保存个人简介
    public void setUserCaption(String userCaption) {
        editor.putString(USERCAPTION, userCaption);
        editor.commit();
    }
    //保存手机号码
    public void setPhoneNumber(String phoneNumber) {
        editor.putString(PHONENUMBER, phoneNumber);
        editor.commit();
    }
    //保存邮箱
    public void setEmail(String email) {
        editor.putString(EMAIL, email);
        editor.commit();
    }

    //设置实名认证状态
    public void setIsVerified(String isVerified) {
        editor.putString(ISREALNAMEVALIDATED, isVerified);
        editor.commit();
    }

    public String getUserPhotoName() {
        return mSharedPreferences.getString(USERPHOTO_FILENAME, "");
    }

//	public void setUserInfo(String str_name, String str_value) {
//        editor.putString(str_name, str_value);
//        editor.commit();
//    }

    public void deleteUserInfo() {
        editor.clear();
        editor.commit();
    }

    public String getUserInfo(String str_name) {
        return mSharedPreferences.getString(str_name, "");
    }

    public boolean contains(String key) {
        return mSharedPreferences.contains(key);
    }

    /**
     * 保存键为key的值为vlaue
     *
     * @param key
     * @param vlaue
     */
    public void put(String key, int vlaue) {
        editor.putInt(key, vlaue);
        editor.commit();
    }

    /**
     * 保存键为key的值为vlaue
     *
     * @param key
     * @param vlaue
     */
    public void put(String key, String vlaue) {
        editor.putString(key, vlaue);
        editor.commit();
    }

    /**
     * 保存键为key的值为vlaue
     *
     * @param key
     * @param vlaue
     */
    public void put(String key, boolean vlaue) {
        editor.putBoolean(key, vlaue);
        editor.commit();
    }

    /**
     * 保存键为key的值为vlaue
     *
     * @param key
     * @param vlaue
     */
    public void put(String key, long vlaue) {
        editor.putLong(key, vlaue);
        editor.commit();
    }

    /**
     * 保存键为key的值为vlaue
     *
     * @param key
     * @param vlaue
     */
    public void put(String key, float vlaue) {
        editor.putFloat(key, vlaue);
        editor.commit();
    }

    /**
     * key对应的整型值叠加1
     *
     * @param key
     */
    public void superposition(String key) {
        int vlaue = mSharedPreferences.getInt(key, 0);
        Editor editor = mSharedPreferences.edit();
        vlaue++;
        editor.putFloat(key, vlaue);
        editor.commit();
    }

    public int getInt(String key, int defult) {
        return mSharedPreferences.getInt(key, defult);
    }

    public int getInt(String key) {
        return mSharedPreferences.getInt(key, 0);
    }

    public boolean getBoolean(String key) {
        return mSharedPreferences.getBoolean(key, true);
    }

    public boolean getBoolean(String key, boolean isTrue) {
        return mSharedPreferences.getBoolean(key, isTrue);
    }

    public String getString(String key) {
        return mSharedPreferences.getString(key, null);
    }

    public String getString(String key, String defult) {
        return mSharedPreferences.getString(key, defult);
    }

    public long getLong(String key, long defult) {
        return mSharedPreferences.getLong(key, defult);
    }

    public long getLong(String key) {
        return mSharedPreferences.getLong(key, 0);
    }

    public void remove(String... keys) {
        Editor editor = mSharedPreferences.edit();
        for (String key : keys) {
            editor.remove(key);
        }
        editor.commit();
    }

	/**
	 * 保存用户信息
	 * @param
	 */
	public void putUser(UserInfo userInfo) {
        MyLogger.i(">>>>>>>>>>保存用户信息" + userInfo.toString());
        /*put(USERNAME, userInfo.getUserName());
		put(USERID, userInfo.getId());
        put(LEVEL,userInfo.getLevel()+"");
		put(EMAIL, userInfo.getEmail());
		put(PHONENUMBER, userInfo.getPhoneNumber());
        put(USERCAPTION,userInfo.getUserCaption()+"");
        put(ISREALNAMEVALIDATED,userInfo.getIsRealNameValidated()+"");
		put(USERREALNAME, userInfo.getUserRealName()+"");*/
//		put(Constant.INT_SHOPID, user.getShopId());//shopId
//		MyLogger.i("保存用户信息:"+Constant.INT_SHOPID);
//		put(Constant.PRE_LOGIN_USERNAME,
//				user.getPhoneNumber());
//		put(Constant.PRE_LOGIN_LASTTIME,
//				System.currentTimeMillis());
//		put(Constant.PRE_LOGIN_STATE, true);
//		put("payed", user.isPayed());

	}

	/**
	 * 获取当前用户信息
	 * @return
	 */
	public UserInfo getUser(){
        if (!TextUtils.isEmpty(getString(USERNAME))) {
//            UserInfo info = new UserInfo(getInt(Constant.PRE_USER_ID, Integer.MIN_VALUE),
//                    getInt(Constant.PRE_USER_LOGINTYPE, Integer.MIN_VALUE),
//                    getString(Constant.PRE_USER_NICKNAME),
//                    getString(Constant.PRE_USER_PHONENUMBER),
//                    getString(USERPHOTO_FILENAME), getString(Constant.INT_SHOPID), getBoolean("payed", false));
//            return info;
        }
        return null;
	}
    public String getTime(){
        String string=getString(Time);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        return "";
    }
    public String getToken(){
        String string=getString(Token);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        return "";
    }
    public String getUserType(){
        String string=getString(UserType);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        return "";
    }
    public String getVersion(){
        String string=getString(Version);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        return "";
    }
    public String getUserName(){
        String string=getString(USERNAME);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        return "";
    }
    public String getUserId(){
        String useid=getString(USERID);
        if (!TextUtils.isEmpty(useid)) {
            return useid;
        }
        return "";
    }
    public String getUserJob(){
        String string=getString(USERJOB);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        return "";
    }
    public String getBelongid(){
        String string=getString(BELONGID);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        return "";
    }
    public String getUserImage(){
        String string=getString(USERIMAGE);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        return "";
    }
    public String getUserRealName(){
        String userRealName=getString(USERREALNAME);
        if (!TextUtils.isEmpty(userRealName)) {
            return userRealName;
        }
        return "";
    }
    public String getPhonenumber(){
        String phoneNumber=getString(PHONENUMBER);
        if (!TextUtils.isEmpty(phoneNumber)) {
            return phoneNumber;
        }
        return "";
    }
    public String getEmail(){
        String email=getString(EMAIL);
        if (!TextUtils.isEmpty(email)) {
            return email;
        }
        return "";
    }
    public String getlevel(){
        String level=getString(LEVEL);
        if (!TextUtils.isEmpty(level)&&!"null".equals(level)) {
            return level;
        }
        return "0";
    }
    public String getuserCaption(){
        String userCaption=getString(USERCAPTION);
        if (!TextUtils.isEmpty(userCaption)&&!"null".equals(userCaption)) {
            return userCaption;
        }
        return "无";
    }
    public String getIsrealnamevalidated(){
        String isrealnamevalidated=getString(ISREALNAMEVALIDATED);
        if (!TextUtils.isEmpty(isrealnamevalidated)) {
            return isrealnamevalidated;
        }
        return "";
    }

    public boolean isLogin(){
        return !TextUtils.isEmpty(getString(USERID));
    }
}
