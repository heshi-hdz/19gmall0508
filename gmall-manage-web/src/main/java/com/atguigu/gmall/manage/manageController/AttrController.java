package com.atguigu.gmall.manage.manageController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.entity.PmsBaseAttrInfo;
import com.atguigu.gmall.entity.PmsBaseAttrValue;
import com.atguigu.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class AttrController {

    @Reference
    AttrService attrService;

    //insert 用户自己增加的属性值
    // saveAttrInfo
    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        String id = pmsBaseAttrInfo.getId();
        if (id==null){
            attrService.attrService(pmsBaseAttrInfo);

        }else {
            attrService.updatPmsBaseAttrInfo(pmsBaseAttrInfo);
        }
        return "succeed";
    }


    //    attrInfoList?catalog3Id=6查询数据
    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        //  attrService.attrInfoList(catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrs = attrService.attrInfoList(catalog3Id);
        return pmsBaseAttrs;
    }
//    getAttrValueList?attrId=48  8-29
    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList( String attrId){
        List<PmsBaseAttrValue> pmsBaseAttrValues= attrService.getAttrValueList(attrId);
        return  pmsBaseAttrValues;
    }
}
