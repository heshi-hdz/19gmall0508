package com.atguigu.gmall.service;

import com.atguigu.gmall.entity.PmsBaseAttrInfo;
import com.atguigu.gmall.entity.PmsBaseAttrValue;

import java.util.List;

public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    void attrService(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    void updatPmsBaseAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);
}
