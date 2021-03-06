package com.usts.ch.controller;

import com.usts.ch.pojo.Goods;
import com.usts.ch.pojo.User;
import com.usts.ch.result.Result;
import com.usts.ch.result.ResultUtil;
import com.usts.ch.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class RecycleController {
    @Autowired
    GoodsService goodsService;

    @CrossOrigin
    @GetMapping("/api/goods/list")
    public List<Goods> list() throws Exception{
        return goodsService.list();
    }

    @CrossOrigin
    @GetMapping("/api/goods/list/{sid}")
    public List<Goods> listBySid(@PathVariable("sid") int sid) throws Exception{
        return goodsService.listBySid(sid);
    }

    @CrossOrigin
    @GetMapping("/api/goods/{id}")
    public Result getGood(@PathVariable("id") Integer id){
        Goods goods = goodsService.getInfo(id);
        if (goods != null){
            return ResultUtil.success(goods);
        }else{
            return ResultUtil.error(400,"未知错误");
        }
    }

    @CrossOrigin
    @PostMapping("/api/goods")
    public Goods add(@RequestBody Goods goods) throws Exception{
        Date date = new Date();
        long time = date.getTime();//当前时间的毫秒数
        goods.setDate(time);
        goodsService.addOrUpdate(goods);
        return goods;
    }

    @CrossOrigin
    @DeleteMapping("/api/goods/{id}")
    public void delete(@PathVariable("id") int id) throws Exception{
        goodsService.deleteById(id);
    }

    @CrossOrigin
    @PostMapping("/api/goods/{id}")
    public Goods update(@RequestBody Goods goods) throws Exception{
        goodsService.addOrUpdate(goods);
        System.out.print(goods);
        return goods;
    }

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/goods")
    public List<Goods> listBycategory(@PathVariable("cid") int cid) throws Exception{
        if (0 != cid){
            return goodsService.listByCategory(cid);
        }else {
            return goodsService.list();
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
