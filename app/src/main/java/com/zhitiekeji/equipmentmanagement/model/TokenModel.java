package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by fafukeji01 on 2017/7/12.
 */

public class TokenModel implements Serializable {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TokenModel{" +
                "token='" + token + '\'' +
                '}';
    }
}
