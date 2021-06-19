package com.lvmoney.frame.blockchain.webase.contract.feign;/**
 * 描述:
 * 包名:com.lvmoney.frame.blockchain.webase.contract.feign
 * 版本信息: 版本1.0
 * 日期:2021/6/19
 * Copyright XXXXXX科技有限公司
 */


import com.lvmoney.frame.base.core.api.ApiResult;
import com.lvmoney.frame.blockchain.webase.contract.ao.AbiInfoAo;
import com.lvmoney.frame.blockchain.webase.contract.constant.ContractConstant;
import com.lvmoney.frame.dispatch.feign.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2021/6/19 10:05
 */
@FeignClient(name = "${webase.server.name}", url = "${webase.server.url}", configuration = {FeignConfig.class})
public interface IAbiInfo {
    /**
     * 根据abi内容判断合约是否已部署，未部署则生成对应abi文件
     *
     * @param abiInfoAo:
     * @throws
     * @return: com.lvmoney.frame.base.core.api.ApiResult<java.lang.Void>
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/19 11:45
     */
    @PostMapping(value = ContractConstant.URI_ABI_INFO)
    ApiResult<Void> abiInfo(AbiInfoAo abiInfoAo);

}
