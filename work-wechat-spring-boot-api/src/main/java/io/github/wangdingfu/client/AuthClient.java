package io.github.wangdingfu.client;

import io.github.wangdingfu.client.config.WeChatConfiguration;
import io.github.wangdingfu.response.auth.AuthUserInfoResponse;
import io.github.wangdingfu.response.auth.UserSensitiveDetailResponse;
import io.github.wangdingfu.resquest.auth.UserSensitiveRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 身份认证
 */
@FeignClient(name = "AuthClient", url = "${work-wechat.url:https://qyapi.weixin.qq.com}", path = "${work-wechat.public-path:cgi-bin}", configuration = WeChatConfiguration.class)
public interface AuthClient extends CommonClient {

    /**
     * 获取访问用户身份
     *
     * @param code 授权码
     * @param app  应用
     * @return 用户身份信息
     */
    @GetMapping(value = "auth/getuserinfo", headers = HEAD)
    AuthUserInfoResponse getUserInfo(@RequestParam("code") String code, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取访问用户敏感信息
     *
     * @param request 请求信息
     * @param app     应用
     * @return 用户详情
     */
    @PostMapping(value = "auth/getuserdetail", headers = HEAD)
    UserSensitiveDetailResponse getUserDetail(UserSensitiveRequest request, @RequestParam(HEAD_KEY) String app);
}
