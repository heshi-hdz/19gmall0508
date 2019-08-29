package com.atguigu.gmall.manage.PmsBaseCatalog1ServiceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.entity.PmsBaseAttrInfo;
import com.atguigu.gmall.entity.PmsBaseAttrValue;
import com.atguigu.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.atguigu.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.atguigu.gmall.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
        return pmsBaseAttrInfos;
    }

    @Override
    public void attrService(PmsBaseAttrInfo pmsBaseAttrInfo) {
        pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);
        String attr_id = pmsBaseAttrInfo.getId();
        List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
        //知识点需要理解2019-08-28
        for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
            pmsBaseAttrValue.setAttrId(attr_id);
            pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
        }


    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        return pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
    }

    @Override
    public void updatPmsBaseAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        //取得属性id
        String attr_id = pmsBaseAttrInfo.getId();
        //删除修改前的属性值表
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attr_id);
        pmsBaseAttrValueMapper.delete(pmsBaseAttrValue);
        //添加修改后的值 因为是级联，先找属性 再找值
        List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
        for (PmsBaseAttrValue baseAttrValue : attrValueList) {
         baseAttrValue.setAttrId(attr_id);
         pmsBaseAttrValueMapper.insertSelective(baseAttrValue);
        }

    }
}
