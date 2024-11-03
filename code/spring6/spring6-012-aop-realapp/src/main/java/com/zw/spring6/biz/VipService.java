package com.zw.spring6.biz;

import org.springframework.stereotype.Service;

@Service("vipService")
public class VipService {
    public void getVip(){
        System.out.println("获取VIP信息");
    }
    public void saveVip(){
        System.out.println("保存VIP");
    }
    public void deleteVip(){
        System.out.println("删除VIP");
    }
    public void modifyVip(){
        System.out.println("修改VIP");
    }
}
