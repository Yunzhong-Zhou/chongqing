package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by fafukeji01 on 2017/1/17.
 */

public class HelpCenterModel implements Serializable {
    /**
     * id : 78b920b290ccfed55aafbc423050bc40
     * user_id : 94dd2a7cecb2580f30807a98c218be94
     * article_category_id : e84b5f037849407127f4d3a367b3c66a
     * title : 如何上传设备？
     * content_type : 1
     * keywords :
     * digest :
     * content : 中国铁路总公司
     * content_url :
     * cover :
     * source :
     * read :
     * sort :
     * created_at : 2017-10-16 15:30:55
     * updated_at : 2017-10-16 15:30:55
     * deleted_at :
     */

    private String id;
    private String user_id;
    private String article_category_id;
    private String title;
    private String content_type;
    private String keywords;
    private String digest;
    private String content;
    private String content_url;
    private String cover;
    private String source;
    private String read;
    private String sort;
    private String created_at;
    private String updated_at;
    private String deleted_at;
    private String detailURL;

    public String getDetailURL() {
        return detailURL;
    }

    public void setDetailURL(String detailURL) {
        this.detailURL = detailURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getArticle_category_id() {
        return article_category_id;
    }

    public void setArticle_category_id(String article_category_id) {
        this.article_category_id = article_category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent_url() {
        return content_url;
    }

    public void setContent_url(String content_url) {
        this.content_url = content_url;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }
}
