package com.lvmoney.frame.blockchain.webase.wallet.apiserver.controller;/**
 * 描述:
 * 包名:com.lvmoney.frame.blockchain.webase.wallet.apiserver.controller
 * 版本信息: 版本1.0
 * 日期:2021/6/26
 * Copyright XXXXXX科技有限公司
 */


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.gson.JsonArray;
import com.lvmoney.frame.base.core.api.ApiResult;
import com.lvmoney.frame.base.core.util.JsonUtil;
import com.lvmoney.frame.blockchain.webase.wallet.api.ao.BalanceAo;
import com.lvmoney.frame.blockchain.webase.wallet.api.ao.HandleWithSignAo;
import com.lvmoney.frame.blockchain.webase.wallet.api.ao.SendAo;
import com.lvmoney.frame.blockchain.webase.wallet.api.surface.IWallet;
import com.lvmoney.frame.blockchain.webase.wallet.apiserver.constant.WalletConstant;
import com.lvmoney.frame.blockchain.webase.wallet.apiserver.feign.ICoinClient;
import com.lvmoney.frame.blockchain.webase.wallet.apiserver.prop.WalletContractProp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2021/6/26 15:27
 */
@RestController
public class IWalletController implements IWallet {
    @Autowired
    ICoinClient iCoinClient;
    @Autowired
    WalletContractProp walletContractProp;

    @Override
    public ApiResult<Long> totalAmount() {
        HandleWithSignAo handleWithSignAo = initHandleWithSign(WalletConstant.CONTRACT_FUNC_COIN_TOTAL_AMOUNT);
        List result = iCoinClient.coin(handleWithSignAo);
        return ApiResult.success(result.get(0));
    }

    @Override
    public ApiResult<Long> balance(BalanceAo balanceAo) {
        return null;
    }

    @Override
    public void send(SendAo sendAo) {

    }

    /**
     * 共用的一个合约，对合约地址和内容进行通用初始化,指定合约的方法
     *
     * @param funcName:
     * @throws
     * @return: com.lvmoney.frame.blockchain.webase.front.api.ao.HandleWithSignAo
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/26 17:27
     */
    private HandleWithSignAo initHandleWithSign(String funcName) {
        HandleWithSignAo handleWithSignAo = new HandleWithSignAo();
        handleWithSignAo.setContractAddress(walletContractProp.getContractAddress());
        handleWithSignAo.setContractAbi(JSON.parseArray(walletContractProp.getContractAbi()));
        handleWithSignAo.setFuncName(funcName);
        handleWithSignAo.setGroupId(walletContractProp.getDefaultGroupId());
        handleWithSignAo.setSignUserId(walletContractProp.getDefaultSignUserId());
        handleWithSignAo.setUseCns(walletContractProp.isDefaultUseCns());
        handleWithSignAo.setFuncParam(new ArrayList());
        return handleWithSignAo;
    }
}
