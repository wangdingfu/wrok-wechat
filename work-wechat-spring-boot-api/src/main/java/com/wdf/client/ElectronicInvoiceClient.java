package com.wdf.client;

import com.wdf.client.config.WeChatConfiguration;
import com.wdf.response.BaseResponse;
import com.wdf.response.invoice.BatchInvoiceResponse;
import com.wdf.response.invoice.GetInvoiceResponse;
import com.wdf.resquest.invoice.BatchInvoiceRequest;
import com.wdf.resquest.invoice.BatchUpdateInvoiceRequest;
import com.wdf.resquest.invoice.GetInvoiceRequest;
import com.wdf.resquest.invoice.UpdateInvoiceRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 电子发票
 */
@FeignClient(name = "ElectronicInvoiceClient", url = "${qywx.url:https://qyapi.weixin.qq.com}", path = "${qywx.public-path:cgi-bin}", configuration = WeChatConfiguration.class)
public interface ElectronicInvoiceClient extends CommonClient {

    /**
     * 查询电子发票
     *
     * @param request 请求
     * @param app     应用
     * @return 收据详情
     */
    @PostMapping(value = "/card/invoice/reimburse/getinvoiceinfo", headers = HEAD)
    GetInvoiceResponse getInvoice(GetInvoiceRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 更新发票状态
     *
     * @param request 请求
     * @param app     应用
     * @return 操作结果
     */
    @PostMapping(value = "/card/invoice/reimburse/updateinvoicestatus", headers = HEAD)
    BaseResponse updateInvoice(UpdateInvoiceRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 批量更新发票状态
     *
     * @param request 请求
     * @param app     应用
     * @return 操作结果
     */
    @PostMapping(value = "/card/invoice/reimburse/updatestatusbatch", headers = HEAD)
    BaseResponse batchUpdateInvoice(BatchUpdateInvoiceRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 批量查询电子发票
     *
     * @param request 请求
     * @param app     应用
     * @return 电子发票结果
     */
    @PostMapping(value = "/card/invoice/reimburse/getinvoiceinfobatch", headers = HEAD)
    BatchInvoiceResponse getInvoices(BatchInvoiceRequest request, @RequestParam(HEAD_KEY) String app);
}
