package com.lvmoney.frame.blockchain.webase.trans.feign;/**
 * 描述:
 * 包名:com.lvmoney.frame.blockchain.webase.contract.feign
 * 版本信息: 版本1.0
 * 日期:2021/6/19
 * Copyright XXXXXX科技有限公司
 */


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lvmoney.frame.base.core.api.ApiResult;
import com.lvmoney.frame.blockchain.common.util.BlockchainUtil;
import com.lvmoney.frame.blockchain.webase.trans.ao.*;
import com.lvmoney.frame.blockchain.webase.trans.constant.TransConstant;
import com.lvmoney.frame.blockchain.webase.trans.vo.SignMessageHashVo;
import com.lvmoney.frame.blockchain.webase.trans.vo.SignedTransactionVo;
import com.lvmoney.frame.blockchain.webase.trans.vo.TransHandleVo;
import com.lvmoney.frame.dispatch.feign.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2021/6/19 10:05
 */
@FeignClient(name = "${webase.server.name}", url = "${webase.server.url}", configuration = {FeignConfig.class})
public interface ITrans {
    /**
     * 通过此接口对合约进行调用，前置根据调用的合约方法是否是“constant”方法区分返回信息，“constant”方法为查询，返回要查询的信息。非“constant”方法为发送数据上链，返回块hash、块高、交易hash等信息。
     * <p>
     * 当合约方法为非“constant”方法，要发送数据上链时，此接口需结合WeBASE-Sign使用。通过调用WeBASE-Sign服务的签名接口让相关用户对数据进行签名，拿回签名数据再发送上链。需要调用此接口时，工程配置文件application.yml中的配置”keyServer”需配置WeBASE-Sign服务的ip和端口，并保证WeBASE-Sign服务正常和存在相关用户。
     * <p>
     * 方法入参（funcParam）为JSON数组，多个参数以逗号分隔（参数为数组时同理），示例：
     *
     * @param handleWithSignAo:
     * @throws
     * @return: String 返回值有两种：String or HandleWithSignVo对应的json
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/19 11:59
     */
    @PostMapping(value = TransConstant.URI_TRANS_HANDLE_WITH_SIGN)
    String handleWithSign(HandleWithSignAo handleWithSignAo);


    /**
     * 此接口为WeBASE-Front使用本地私钥（页面中的测试用户）进行签名
     * <p>
     * 通过合约信息进行调用，前置根据调用的合约方法是否是“constant”方法区分返回信息，“constant”方法为查询，返回要查询的信息。非“constant”方法为发送数据上链，返回块hash、块高、交易hash等信息。
     *
     * @param transHandleAo:
     * @throws
     * @return: com.lvmoney.frame.blockchain.webase.trans.vo.TransHandleVo
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/19 20:09
     */
    @PostMapping(value = TransConstant.URI_TRANS_HANDLE)
    TransHandleVo transHandle(TransHandleAo transHandleAo);

    /**
     * 发送已签名的交易上链，返回交易收据
     *
     * @param signedTransactionAo:
     * @throws
     * @return: com.lvmoney.frame.blockchain.webase.trans.vo.SignedTransactionVo
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/19 20:18
     */
    @PostMapping(value = TransConstant.URI_TRANS_SIGNED_TRANSACTION)
    SignedTransactionVo transSignedTransaction(SignedTransactionAo signedTransactionAo);


    /**
     * 发送已编码的查询交易，返回合约的返回值
     *
     * @param queryTransactionAo:
     * @throws
     * @return: java.lang.String
     * @author: lvmoney /XXXXXX&#x79D1;&#x6280;&#x6709;&#x9650;&#x516C;&#x53F8;
     * @date: 2021/6/19 20:25
     */
    @PostMapping(value = TransConstant.URI_TRANS_QUERY_TRANSACTION)
    String transQueryTransaction(QueryTransactionAo queryTransactionAo);


    /**
     * 计算HASH和签名值
     *
     * @param signMessageHashAo:
     * @throws
     * @return: com.lvmoney.frame.blockchain.webase.trans.vo.SignMessageHashVo
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/19 20:33
     */
    @PostMapping(value = TransConstant.URI_TRANS_SIGN_MESSAGE_HASH)
    SignMessageHashVo transSignMessageHash(SignMessageHashAo signMessageHashAo);

}
