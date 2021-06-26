package com.lvmoney.frame.blockchain.webase.wallet.api.surface;/**
 * 描述:
 * 包名:com.lvmoney.frame.blockchain.webase.wallet.api.surface
 * 版本信息: 版本1.0
 * 日期:2021/6/24
 * Copyright XXXXXX科技有限公司
 */


import com.lvmoney.frame.base.core.api.ApiResult;
import com.lvmoney.frame.blockchain.webase.wallet.api.ao.BalanceAo;
import com.lvmoney.frame.blockchain.webase.wallet.api.ao.SendAo;
import com.lvmoney.frame.blockchain.webase.wallet.api.constant.WalletConstant;
import com.lvmoney.frame.prefix.constant.FramePrefixConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2021/6/24 19:50
 */
@RequestMapping(FramePrefixConstant.PLATFORM_BLOCKCHAIN_WEBASE_WALLET)
public interface IWallet {
    /**
     * 积分总数查询
     *
     * @throws
     * @return: com.lvmoney.frame.base.core.api.ApiResult<java.lang.Long>
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/26 18:16
     */
    @GetMapping("totalAmount")
    ApiResult<Long> totalAmount();

    /**
     * 查看账户余额
     *
     * @param balanceAo:
     * @throws
     * @return: com.lvmoney.frame.base.core.api.ApiResult<java.lang.Long>
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/26 18:16
     */
    @GetMapping("balance")
    ApiResult<Long> balance(BalanceAo balanceAo);

    /**
     * 用户id转账到指定公钥地址
     *
     * @param sendAo:
     * @throws
     * @return: void
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/26 15:16
     */
    @PostMapping("send")
    void send(SendAo sendAo);

}
