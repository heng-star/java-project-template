package com.lvmoney.demo.webase.controller;/**
 * 描述:
 * 包名:com.chdriver.demo.customer.function
 * 版本信息: 版本1.0
 * 日期:2020/3/5
 * Copyright XXXXXX科技有限公司
 */


import com.chdriver.frame.blockchain.webase.front.api.ao.PrivateKeyAo;
import com.chdriver.frame.blockchain.webase.front.api.constant.FrontConstant;
import com.chdriver.frame.blockchain.webase.front.api.vo.PrivateKeyVo;
import com.chdriver.frame.blockchain.webase.front.api.vo.Web3TransactionVo;
import com.lvmoney.demo.webase.feign.IFrontClient;
import com.lvmoney.frame.base.core.api.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2020/3/5 15:25
 */
@RestController
public class WeBaseController {
    @Autowired
    IFrontClient iFrontClient;


    @PostMapping(value = FrontConstant.URL_FRONT_WEB3_TRANSACTION)
    public ApiResult abiInfo(@PathVariable("groupId") int groupId, @PathVariable("transHash") String transHash) {
        Web3TransactionVo re = iFrontClient.web3Transaction(groupId, transHash);
        return ApiResult.success(re);
    }

    @GetMapping(value = FrontConstant.URL_FRONT_PRIVATE_KEY)
    public ApiResult privateKey(PrivateKeyAo privateKeyAo) {
        RestTemplate restTemplate = new RestTemplate();
//        Object str = restTemplate.getForObject("http://192.168.0.34:5002/WeBASE-Front/privateKey?type=2&userName=xiangdaoquan3&appId=chdriver&signUserId=xiangdaoquan3&returnPrivateKey=true", String.class);
        Object re = iFrontClient.privateKey(privateKeyAo.getAppId(),privateKeyAo.getSignUserId(),privateKeyAo.getType(),privateKeyAo.getUserName(),privateKeyAo.getReturnPrivateKey());
        return ApiResult.success(re);
    }
}
