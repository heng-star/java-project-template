package com.lvmoney.frame.blockchain.webase.contract.ao;/**
 * 描述:
 * 包名:com.lvmoney.frame.blockchain.webase.contract.ao
 * 版本信息: 版本1.0
 * 日期:2021/6/19
 * Copyright XXXXXX科技有限公司
 */


import com.lvmoney.frame.blockchain.webase.contract.ao.item.AbiInfoAoItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2021/6/19 8:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbiInfoAo implements Serializable {
    private static final long serialVersionUID = -5682319942716922009L;
    /**
     * 所属群组
     */
    private Integer groupId;
    /**
     * 合约名称
     */
    private String contractName;
    /**
     * 合约地址
     */
    private String address;
    /**
     * 合约abi
     */
    private List<AbiInfoAoItem> abiInfo;
    /**
     * 合约bin
     */
    private String contractBin;


}
