package com.usts.ch.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "category")
@JsonIgnoreProperties({"handle","hibernateLazyInitializer"})

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
     String name;
     public int getId(){
         return id;
     }
     public void setId(int id){
         this.id = id;
     }

     public String getName(){
         return name;
     }
     public void setName(String name){
         this.name = name;
     }
}