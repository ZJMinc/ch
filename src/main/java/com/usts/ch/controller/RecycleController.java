package com.usts.ch.controller;

import com.usts.ch.pojo.Goods;
import com.usts.ch.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecycleController {
    @Autowired
    GoodsService goodsService;

    @CrossOrigin
    @GetMapping("/api/goods")
    public List<Goods> list() throws Exception{
        return goodsService.list();
    }

    @CrossOrigin
    @PostMapping("/api/goods")
    public Goods addOrupdate(@RequestBody Goods goods) throws Exception{
        goodsService.addOrUpdate(goods);
        return goods;
    }

    @CrossOrigin
    @PostMapping("/api/delete")
    public void delete(@RequestBody Goods goods) throws Exception{
        goodsService.deleteById(goods.getId());
    }

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/goods")
    public List<Goods> listByCategory(@PathVariable("cid") int cid) throws Exception{
        if (0 != cid){
            return goodsService.listByCategory(cid);
        }else {
            return list();
        }
    }

    @CrossOrigin
    @GetMapping("/api/search")
    public List<Goods> searchResult(@RequestParam("keywords") String keywords) {
        // 关键词为空时查询出所有商品
        if ("".equals(keywords)) {
            return goodsService.list();
        } else {
            return goodsService.Search(keywords);
        }
    }
}
