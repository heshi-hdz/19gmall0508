package com.atguigu.gmall.manage.PmsBaseCatalog1ServiceImpl;


import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.entity.PmsBaseCatalog1;
import com.atguigu.gmall.entity.PmsBaseCatalog2;
import com.atguigu.gmall.entity.PmsBaseCatalog3;
import com.atguigu.gmall.entity.PmsProductInfo;
import com.atguigu.gmall.manage.mapper.PmsBaseCatalog1Mapper;
import com.atguigu.gmall.manage.mapper.PmsBaseCatalog2Mapper;
import com.atguigu.gmall.manage.mapper.PmsBaseCatalog3Mapper;
import com.atguigu.gmall.manage.mapper.PmsProductImageMapper;
import com.atguigu.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PmsBaseCatalog1ServiceImpl implements CatalogService {

    @Autowired
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;
    @Autowired
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;
    @Autowired
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;
    @Autowired
    PmsProductImageMapper pmsProductImageMapper;
    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        List<PmsBaseCatalog1> listPmsBaseCatalog1 = pmsBaseCatalog1Mapper.selectAll();
        return listPmsBaseCatalog1;
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);
        List<PmsBaseCatalog2> PmsBaseCatalog2list = pmsBaseCatalog2Mapper.select(pmsBaseCatalog2);
        return PmsBaseCatalog2list;
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        List<PmsBaseCatalog3> PmsBaseCatalog3list = pmsBaseCatalog3Mapper.select(pmsBaseCatalog3);
        return PmsBaseCatalog3list;
    }



}
