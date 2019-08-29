package com.atguigu.gmall.manage.manageController;


import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.entity.PmsBaseCatalog1;
import com.atguigu.gmall.entity.PmsBaseCatalog2;
import com.atguigu.gmall.entity.PmsBaseCatalog3;
import com.atguigu.gmall.entity.PmsProductInfo;
import com.atguigu.gmall.service.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class CatalogController {
    @Reference
    CatalogService pmsBaseCatalog1service;

    //no.1 目录
    @ResponseBody
    @RequestMapping("/getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1() {
        List<PmsBaseCatalog1> listPmsBaseCatalog1 = pmsBaseCatalog1service.getCatalog1();
        return listPmsBaseCatalog1;
    }

    //no.2 目录
    @ResponseBody
    @RequestMapping("/getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        List<PmsBaseCatalog2> listPmsBaseCatalog2 = pmsBaseCatalog1service.getCatalog2(catalog1Id);
        return listPmsBaseCatalog2;
    }

    //no.3 目录
    @ResponseBody
    @RequestMapping("/getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        List<PmsBaseCatalog3> listPmsBaseCatalog3 = pmsBaseCatalog1service.getCatalog3(catalog2Id);
        return listPmsBaseCatalog3;
    }

}
