package com.lvmoney.frame.blockchain.webase.trans.ao;/**
 * 描述:
 * 包名:com.lvmoney.frame.blockchain.webase.trans.ao
 * 版本信息: 版本1.0
 * 日期:2021/6/19
 * Copyright XXXXXX科技有限公司
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2021/6/19 20:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryTransactionAo implements Serializable {
    private static final long serialVersionUID = -7368114454150574844L;
    /**
     * 已编码字符串
     */
    private String encodeStr;
    /**
     * 合约地址
     */
    private String contractAddress;
    /**
     * 群组ID
     */
    private Integer groupId;
    /**
     * 合约名
     */
    private String funcName;
    /**
     * 合约abi
     */
    private String contractAbi;
    /**
     * 用户地址
     */
    private String userAddress;
}
