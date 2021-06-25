package com.lvmoney.frame.blockchain.webase.wallet.api.surface;/**
 * 描述:
 * 包名:com.lvmoney.frame.blockchain.webase.wallet.api.surface
 * 版本信息: 版本1.0
 * 日期:2021/6/24
 * Copyright XXXXXX科技有限公司
 */


import com.lvmoney.frame.blockchain.webase.wallet.api.ao.BalanceAo;
import com.lvmoney.frame.blockchain.webase.wallet.api.ao.SendAo;
import com.lvmoney.frame.blockchain.webase.wallet.api.constant.WalletConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2021/6/24 19:50
 */
public interface IWallet {
    /**
     * 积分总数查询
     *
     * @throws
     * @return: java.lang.Long
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/24 20:32
     */
    Long totalAmount();

    /**
     * 查看账户余额
     *
     * @param balanceAo:
     * @throws
     * @return: java.lang.Long
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/24 20:54
     */
    Long balance(BalanceAo balanceAo);


    void send(SendAo sendAo);

}
