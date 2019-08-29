package com.atguigu.gmall.manage.manageController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.entity.PmsBaseSaleAttr;
import com.atguigu.gmall.entity.PmsProductInfo;
import com.atguigu.gmall.entity.PmsProductSaleAttr;
import com.atguigu.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class SpuController {
    @Reference
    SpuService spuService;

    //    spuList?catalog3Id=6
    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id) {
        List<PmsProductInfo> pmsProductInfos = spuService.spuList(catalog3Id);
        return pmsProductInfos;
    }

    //    baseSaleAttrList
    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = spuService.baseSaleAttrList();
        return pmsBaseSaleAttrs;
    }

    //    saveSpuInfo
    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo) {
        spuService.saveSpuInfo(pmsProductInfo);
        return "succeed";
    }

}
