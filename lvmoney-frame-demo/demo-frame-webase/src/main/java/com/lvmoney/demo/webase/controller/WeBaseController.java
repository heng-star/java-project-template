package com.lvmoney.demo.webase.controller;/**
 * 描述:
 * 包名:com.chdriver.demo.customer.function
 * 版本信息: 版本1.0
 * 日期:2020/3/5
 * Copyright XXXXXX科技有限公司
 */


import com.lvmoney.frame.base.core.api.ApiResult;
import com.lvmoney.frame.blockchain.webase.contract.ao.AbiInfoAo;
import com.lvmoney.frame.blockchain.webase.contract.constant.ContractConstant;
import com.lvmoney.frame.blockchain.webase.contract.feign.IAbiInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2020/3/5 15:25
 */
@RestController
public class WeBaseController {
    @Autowired
    IAbiInfo iAbiInfo;

    @PostMapping(value = ContractConstant.URI_ABI_INFO)
    public ApiResult<String> abiInfo(@RequestBody AbiInfoAo abiInfoAo) {
        iAbiInfo.abiInfo(abiInfoAo);
        return ApiResult.success("success");
    }
}
