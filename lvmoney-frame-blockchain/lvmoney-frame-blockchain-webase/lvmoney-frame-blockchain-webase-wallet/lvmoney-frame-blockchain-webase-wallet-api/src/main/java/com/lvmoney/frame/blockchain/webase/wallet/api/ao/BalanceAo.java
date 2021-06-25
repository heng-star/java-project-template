package com.lvmoney.frame.blockchain.webase.wallet.api.ao;/**
 * 描述:
 * 包名:com.lvmoney.frame.blockchain.webase.wallet.api.ao
 * 版本信息: 版本1.0
 * 日期:2021/6/24
 * Copyright XXXXXX科技有限公司
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2021/6/24 20:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalanceAo extends Wallet {
    private static final long serialVersionUID = 861409299825609609L;
    /**
     * 用户公钥地址
     */
    private String owner;
}
