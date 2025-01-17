package io.github.wangdingfu.service;

import io.github.wangdingfu.exception.ParamCheckException;
import io.github.wangdingfu.response.application.ApplicationButtonResponse;
import io.github.wangdingfu.response.application.WeChatApplicationResponse;
import io.github.wangdingfu.resquest.application.ApplicationButtonRequest;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 应用管理
 *
 * @author ddshuai
 * date 2019-04-06 21:53
 **/
@Service
public class ApplicationService extends AbstractBaseService {

    /**
     * 获取应用
     *
     * @param agentId         应用ID
     * @param applicationName 应用名称
     * @return WeChatApplicationResponse
     */
    public WeChatApplicationResponse getApplication(String agentId, String applicationName) {
        if (StringUtils.isNotEmpty(agentId)) {
            return applicationClient.getApplication(agentId, applicationName);
        }

        throw new ParamCheckException("agentId 不能为空，请检查！！！");
    }

    /**
     * 创建应用菜单
     *
     * @param request         请求
     * @param agentId         应用ID
     * @param applicationName 应用名称
     */
    public void createApplicationButton(ApplicationButtonRequest request, String agentId, String applicationName) {
        if (Objects.nonNull(request) && CollectionUtils.isNotEmpty(request.getButtonList())) {
            applicationClient.createApplicationButton(request, agentId, applicationName);
            if (logger.isInfoEnabled()) {
                logger.info("应用菜单创建成功:{},{}", agentId, applicationName);
            }
        }
    }

    /**
     * 获取菜单
     *
     * @param agentId         应用ID
     * @param applicationName 应用名称
     * @return ApplicationButtonResponse
     */
    public ApplicationButtonResponse getApplicationButtons(String agentId, String applicationName) {

        ApplicationButtonResponse response = null;
        if (StringUtils.isNotEmpty(agentId)) {
            response = applicationClient.getApplicationButtons(agentId, applicationName);
            if (logger.isInfoEnabled()) {
                logger.info("应用菜单获取成功:{},{}", agentId, applicationName);
            }
        }
        return response;
    }

    /**
     * 删除菜单
     *
     * @param agentId         应用ID
     * @param applicationName 应用名称
     */
    public void deleteApplicationButtons(String agentId, String applicationName) {
        if (StringUtils.isNotEmpty(agentId)) {
            applicationClient.deleteApplicationButtons(agentId, applicationName);
            if (logger.isInfoEnabled()) {
                logger.info("应用菜单删除成功:{},{}", agentId, applicationName);
            }
        } else {
            throw new ParamCheckException("agentId 不能为空，请检查！！！");
        }
    }
}
