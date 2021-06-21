package com.lvmoney.frame.blockchain.webase.trans.ao;/**
 * 描述:
 * 包名:com.lvmoney.frame.blockchain.webase.trans.ao
 * 版本信息: 版本1.0
 * 日期:2021/6/19
 * Copyright XXXXXX科技有限公司
 */


import com.lvmoney.frame.blockchain.webase.trans.ao.item.Abi;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2021/6/19 11:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HandleWithSignAo implements Serializable {
    private static final long serialVersionUID = -83119756018487888L;
    /**
     * 用户编号 WeBASE-Sign用户编号（查询方法可不传）
     */
    private String signUserId;
    /**
     * 合约名称
     */
    private String contractName;
    /**
     * 合约地址
     */
    private String contractAddress;
    /**
     * 方法名
     */
    private String funcName;

    /**
     * 合约编译后生成的abi文件内容 合约中单个函数的ABI，若不存在同名函数可以传入整个合约ABI，格式：JSONArray
     */
    private List<Abi> contractAbi;

    /**
     * 方法参数 JSON数组，多个参数以逗号分隔（参数为数组时同理），如：["str1",["arr1","arr2"]]
     */
    private List<String> funcParam;
    /**
     * 群组ID 默认为1
     */
    private Integer groupId;
    /**
     * 是否使用cns调用
     */
    private Boolean useCns;

    /**
     * cns名称 CNS名称，useCns为true时不能为空
     */
    private String cnsName;
    /**
     * cns版本 CNS版本，useCns为true时不能为空
     */
    private String version;

}
