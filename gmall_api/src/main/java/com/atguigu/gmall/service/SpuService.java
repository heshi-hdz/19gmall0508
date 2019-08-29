package com.atguigu.gmall.service;

import com.atguigu.gmall.entity.PmsBaseSaleAttr;
import com.atguigu.gmall.entity.PmsProductInfo;

import java.util.List;

public interface SpuService {
    List<PmsProductInfo> spuList(String catalog3Id);

    List<PmsBaseSaleAttr> baseSaleAttrList();

    void saveSpuInfo(PmsProductInfo pmsProductInfo);
}
