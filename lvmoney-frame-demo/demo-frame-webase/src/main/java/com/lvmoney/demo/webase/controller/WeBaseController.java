package com.lvmoney.demo.webase.controller;/**
 * 描述:
 * 包名:com.chdriver.demo.customer.function
 * 版本信息: 版本1.0
 * 日期:2020/3/5
 * Copyright XXXXXX科技有限公司
 */


import com.lvmoney.frame.base.core.api.ApiResult;
import com.lvmoney.frame.blockchain.common.util.BlockchainUtil;
import com.lvmoney.frame.blockchain.webase.trans.ao.QueryTransactionAo;
import com.lvmoney.frame.blockchain.webase.trans.constant.TransConstant;
import com.lvmoney.frame.blockchain.webase.trans.feign.ITrans;
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
    ITrans iTrans;

    @PostMapping(value = TransConstant.URI_TRANS_QUERY_TRANSACTION)
    public ApiResult<String> abiInfo(@RequestBody QueryTransactionAo queryTransactionAo) {
        return ApiResult.success(iTrans.transQueryTransaction(queryTransactionAo));
    }

    public static void main(String[] args) {
        String str="[{\"constant\":true,\"inputs\":[],\"name\":\"get\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"n\",\"type\":\"string\"}],\"name\":\"set\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";
        System.out.println(BlockchainUtil.quotationMarksReplace(str));
    }
}
