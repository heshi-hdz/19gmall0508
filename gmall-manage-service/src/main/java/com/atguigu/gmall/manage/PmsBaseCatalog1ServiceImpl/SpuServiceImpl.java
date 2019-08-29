package com.atguigu.gmall.manage.PmsBaseCatalog1ServiceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.entity.PmsBaseSaleAttr;
import com.atguigu.gmall.entity.PmsProductInfo;
import com.atguigu.gmall.entity.PmsProductSaleAttr;
import com.atguigu.gmall.entity.PmsProductSaleAttrValue;
import com.atguigu.gmall.manage.mapper.PmsBaseSaleAttrsMapper;
import com.atguigu.gmall.manage.mapper.PmsProductInfoMapper;
import com.atguigu.gmall.manage.mapper.PmsProductSaleAttrMapper;
import com.atguigu.gmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.atguigu.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {
    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;
    @Autowired
    PmsBaseSaleAttrsMapper pmsBaseSaleAttrsMapper;
    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Autowired
    PmsProductSaleAttrValueMapper PmsProductSaleAttrValueMapper;


    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();

        pmsProductInfo.setId(catalog3Id);
        pmsProductInfoMapper.select(pmsProductInfo);
        List<PmsProductInfo> pmsProductInfos = pmsProductInfoMapper.select(pmsProductInfo);

        return pmsProductInfos;
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = pmsBaseSaleAttrsMapper.selectAll();
        return pmsBaseSaleAttrs;
    }

    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {
        pmsProductInfoMapper.insertSelective(pmsProductInfo);
        String spu_id = pmsProductInfo.getId();
        List<PmsProductSaleAttr> spuSaleAttrList = pmsProductInfo.getSpuSaleAttrList();
        for (PmsProductSaleAttr pmsProductSaleAttr : spuSaleAttrList) {
            pmsProductSaleAttr.setProductId(spu_id);
            pmsProductSaleAttrMapper.insertSelective(pmsProductSaleAttr);
            String saleAttrValueId = pmsProductSaleAttr.getId();
            List<PmsProductSaleAttrValue> spuSaleAttrValueList = pmsProductSaleAttr.getSpuSaleAttrValueList();
            for (PmsProductSaleAttrValue pmsProductSaleAttrValue : spuSaleAttrValueList) {
                pmsProductSaleAttrValue.setProductId(spu_id);
                PmsProductSaleAttrValueMapper.insertSelective(pmsProductSaleAttrValue);
            }
        }

    }


}
