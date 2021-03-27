package com.usts.ch.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

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
    private Category category;

    String cover;
    String title;
    String seller;
    long date;
    String abs;
    Double price;
    int sid;

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", cover='" + getCover() + "'" +
                ", title='" + getTitle() + "'" +
                ", seller='" + getSeller() + "'" +
                ", sid='" + getSid() + "'" +
                ", date='" + getDate() + "'" +
                ", abs='" + getAbs() + "'" +
                ", price='" + getPrice() + "'" +
                "}";
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDate(){
        return date;
    }
    public void setDate(long date){
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

    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public Double getPrice(){
        return price;
    }
    public void setPrice(Double price){
        this.price = price;
    }
}
