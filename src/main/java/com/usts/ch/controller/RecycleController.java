package com.usts.ch.controller;

import com.usts.ch.pojo.Goods;
import com.usts.ch.service.GoodsService;
import com.usts.ch.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    @CrossOrigin
    @PostMapping("/api/covers")
    public String coversUpload(MultipartFile file) throws Exception {
//        String folder = "/Campus_help/workspace/img";
        String folder = "/Users/zhaominchen/Desktop/CampusHelp/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(8) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
//            String imgURL = "https://kdcnxx.cn/api/file/" + f.getName();
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
