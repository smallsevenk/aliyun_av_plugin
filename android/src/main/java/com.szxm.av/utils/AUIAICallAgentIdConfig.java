package com.szxm.av.utils;

import com.aliyun.auikits.aiagent.ARTCAICallEngine.ARTCAICallAgentType;

public class AUIAICallAgentIdConfig {

    private static String VOICE_AGENT_ID = "f05abdde9e5648efb966c3cb46361c5a";
    private static String Avatar_AGENT_ID = "";
    private static String VISION_AGENT_ID = "47b870aa48cc49d1b43485042c6ddcf5";
    private static String ChatBot_AGENT_ID = "";
    private static String VIDEO_AGENT_ID = "";

    private static String VOICE_AGENT_EMOTION_ID = "";
    private static String Avatar_AGENT_EMOTION_ID = "";
    private static String VISION_AGENT_EMOTION_ID = "";
    private static String VIDEO_AGENT_EMOTION_ID = "";

    private static String Region = "cn-hangzhou";

    public static String getAIAgentId(ARTCAICallAgentType agentType, boolean openEmotion) {
        String agentId = "";
        switch (agentType) {
            case VoiceAgent:
                agentId = openEmotion ? VOICE_AGENT_EMOTION_ID : VOICE_AGENT_ID;
                break;
            case AvatarAgent:
                agentId = openEmotion ? Avatar_AGENT_EMOTION_ID : Avatar_AGENT_ID;
                break;
            case VisionAgent:
                agentId = openEmotion ? VISION_AGENT_EMOTION_ID : VISION_AGENT_ID;
                break;
            case VideoAgent:
                agentId = openEmotion ? VIDEO_AGENT_EMOTION_ID : VIDEO_AGENT_ID;
                break;
            case ChatBot:
                agentId =  ChatBot_AGENT_ID;
                break;
        }
        return agentId;
    }


    public static String getRegion() {
        return Region;
    }
}
