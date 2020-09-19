package com.usts.ch.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "goods")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})

public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name = "cid")
    private  Category category;

    String cover;
    String title;
    String seller;
    Date date;
    String abs;

    public Category getCategory(){
        return category;
    }
    public void setCategory(Category category){
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }

    public String getCover(){
        return cover;
    }
    public void setCover(String cover){
        this.cover = cover;
    }

    public String getAbs(){
        return abs;
    }
    public void setAbs(String abs){
        this.abs = abs;
    }

    public String getSeller(){
        return seller;
    }
    public void setSeller(String seller){
        this.seller = seller;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
}
