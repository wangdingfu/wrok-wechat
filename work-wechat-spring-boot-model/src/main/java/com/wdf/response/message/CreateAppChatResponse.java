package com.wdf.response.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.response.AbstractBaseResponse;

/**
 * 描述
 *
 * @author ddshuai
 * date 2019-04-08 18:27
 **/
public class CreateAppChatResponse extends AbstractBaseResponse {
    @JsonProperty("chatid")
    private String chatId;

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }
}
