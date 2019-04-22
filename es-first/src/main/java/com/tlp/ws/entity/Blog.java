package com.tlp.ws.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @className: Blog
 * @description:
 * @author: tianlingpeng
 * @create: 2019-04-15 15:12
 */
@Document(indexName = "index1",type="blog")
public class Blog {

    @Id
    private Long id;

    private String title;

    private String content;

    private Date postdate;

    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
