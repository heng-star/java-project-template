package com.lvmoney.frame.blockchain.webase.trans.constant;/**
 * 描述:
 * 包名:com.lvmoney.frame.blockchain.webase.contract.constant
 * 版本信息: 版本1.0
 * 日期:2021/6/19
 * Copyright XXXXXX科技有限公司
 */


/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2021/6/19 8:55
 */
public class TransConstant {
    /**
     * 交易处理接口（结合WeBASE-Sign）
     */
    public static final String URI_TRANS_HANDLE_WITH_SIGN = "trans/handleWithSign";

    /**
     * 交易处理接口（本地签名）
     */
    public static final String URI_TRANS_HANDLE = "trans/handle";

    /**
     * 发送已签名的交易上链，返回交易收据
     */
    public static final String URI_TRANS_SIGNED_TRANSACTION = "trans/signed-transaction";

    /**
     * 发送已编码的查询交易，返回合约的返回值
     */
    public static final String URI_TRANS_QUERY_TRANSACTION = "trans/query-transaction";

    /**
     * 计算HASH和签名值
     */
    public static final String URI_TRANS_SIGN_MESSAGE_HASH = "trans/signMessageHash";
}
