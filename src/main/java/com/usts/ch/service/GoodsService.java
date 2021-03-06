package com.usts.ch.service;

import com.usts.ch.pojo.Category;
import org.springframework.data.domain.Sort;
import com.usts.ch.dao.GoodsDAO;
import com.usts.ch.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    GoodsDAO goodsDAO;
    @Autowired
    CategoryService categoryService;

    public List<Goods> list(){
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        return goodsDAO.findAll(sort);
    }

    public void addOrUpdate(Goods goods){
        goodsDAO.save(goods);
    }
    public void deleteById(int id){
        goodsDAO.deleteById(id);
    }
    public Goods getInfo(int id){
        goodsDAO.findById(id);
        return goodsDAO.findById(id);
    }

    public List<Goods> listBySid(int sid){
        goodsDAO.findAllBySid(sid);
        return goodsDAO.findAllBySid(sid);
    }

    public List<Goods> listByCategory(int id){
        Category category = categoryService.get(id);
        return goodsDAO.findAllByCategory(category);
    }

    public List<Goods> Search(String keywords) {
        return goodsDAO.findAllByTitleLike('%' + keywords + '%');
    }

}
