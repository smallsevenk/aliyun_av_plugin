package com.szxm.av.bean;


import com.aliyun.auikits.aiagent.ARTCAIChatEngine;

public class ChatBotChatMessage {

    private boolean isAIResponse;;
    private ARTCAIChatEngine.ARTCAIChatMessage message;

    public ChatBotChatMessage(ARTCAIChatEngine.ARTCAIChatMessage message) {
       this.message = message;
    }


    public ARTCAIChatEngine.ARTCAIChatMessage getMessage() {
        return message;
    }

    public void setMessage(ARTCAIChatEngine.ARTCAIChatMessage message) {
        this.message = message;
    }

    public boolean isAIResponse() {
        return isAIResponse;
    }

    public void setAIResponse(boolean isAIResponse) {
        this.isAIResponse = isAIResponse;
    }


}
