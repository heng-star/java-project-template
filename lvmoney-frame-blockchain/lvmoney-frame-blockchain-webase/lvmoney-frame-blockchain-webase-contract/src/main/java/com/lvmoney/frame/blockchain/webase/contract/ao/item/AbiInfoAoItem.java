package com.lvmoney.frame.blockchain.webase.contract.ao.item;/**
 * 描述:
 * 包名:com.lvmoney.frame.blockchain.webase.contract.ao.item
 * 版本信息: 版本1.0
 * 日期:2021/6/19
 * Copyright XXXXXX科技有限公司
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @describe：通过webase 合约列表拷贝json即可
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2021/6/19 9:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbiInfoAoItem implements Serializable {
    private Boolean constant;
    private String name;
    private Boolean payable;
    private String type;
    private List<Input> inputs;
    private List<Output> outputs;
}
