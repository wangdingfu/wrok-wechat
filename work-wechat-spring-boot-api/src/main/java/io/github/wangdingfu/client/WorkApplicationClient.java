package io.github.wangdingfu.client;

import io.github.wangdingfu.client.config.WeChatConfiguration;
import io.github.wangdingfu.response.BaseResponse;
import io.github.wangdingfu.response.application.ApplicationButtonResponse;
import io.github.wangdingfu.response.application.WeChatApplicationResponse;
import io.github.wangdingfu.resquest.application.ApplicationButtonRequest;
import io.github.wangdingfu.resquest.application.ApplicationSettingReuqest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 企业微信应用
 *
 * @author ddshuai
 * date 2022-09-01 09:24
 **/
@FeignClient(name = "WorkApplicationClient", url = "${work-wechat.url:https://qyapi.weixin.qq.com}", path = "${work-wechat.public-path:cgi-bin}", configuration = WeChatConfiguration.class)
public interface WorkApplicationClient extends CommonClient {

    /**
     * 获取应用
     *
     * @param agentId 应用编号
     * @param app     应用名
     * @return WeChatApplicationResponse
     */
    @GetMapping(value = "agent/get", headers = HEAD)
    WeChatApplicationResponse getApplication(@RequestParam("agentid") String agentId, @RequestParam(HEAD_KEY) String app);

    /**
     * 设置应用
     *
     * @param reuqest 请求
     * @param app     应用名
     * @return BaseResponse
     */
    @PostMapping(value = "agent/set", headers = HEAD)
    BaseResponse applicationSetting(ApplicationSettingReuqest reuqest, @RequestParam(HEAD_KEY) String app);

    /**
     * 创建菜单
     *
     * @param request 请求体
     * @param agentid 应用编号
     * @param app     应用名
     * @return BaseResponse
     */
    @PostMapping(value = "menu/create", headers = HEAD)
    BaseResponse createApplicationButton(ApplicationButtonRequest request, @RequestParam("agentid") String agentid, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取菜单
     *
     * @param agentid 应用编号
     * @param app     应用名
     * @return ApplicationButtonResponse
     */
    @GetMapping(value = "menu/get", headers = HEAD)
    ApplicationButtonResponse getApplicationButtons(@RequestParam("agentid") String agentid, @RequestParam(HEAD_KEY) String app);

    /**
     * 删除菜单
     *
     * @param agentid 应用编号
     * @param app     应用名
     * @return BaseResponse
     */
    @GetMapping(value = "menu/delete", headers = HEAD)
    BaseResponse deleteApplicationButtons(@RequestParam("agentid") String agentid, @RequestParam(HEAD_KEY) String app);
}
