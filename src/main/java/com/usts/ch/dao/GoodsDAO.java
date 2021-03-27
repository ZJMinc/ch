package com.usts.ch.dao;

import com.usts.ch.pojo.Category;
import com.usts.ch.pojo.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsDAO extends JpaRepository<Goods,Integer> {
    List<Goods> findAllByCategory(Category category);
    List<Goods> findAllBySid(int sid);
    List<Goods> findAllByTitleLike(String keyword);
    Goods findById(int id);
}
