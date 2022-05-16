package com.sks.XDEPRECATED.algo2020.algoexperts;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author : Sujit K Singh
 * Purpose :
 */
public class TestRandom {

    public static void main(String[] args) throws ScriptException {
        //Set<Long> s = new HashSet<>(Arrays.asList(1L, 34L));
        Set<Long> s = new HashSet<>();
        System.out.println("First element: " + s.iterator().next());
        String webUrl = "https://web.yammer.com/{0}/threads/eyJfdHlwZSI6IlRocmVhZCIsImlkIjoiNjk4NTQyMzkxODY5NDQwIn0";
        //String threadId = "eyJfdHlwZSI6IlRocmVhZCIsImlkIjoiNjk4NTQyMzkxODY5NDQwIn0";
        long threadId = 698542391869440l;
        String teamsAppId = "955070e9-99a6-4319-b8df-32adf59949aa";
        String teamsEntityId = "0";
        String activityType = "announcementCreated";
        String clientReqId = UUID.randomUUID().toString();
        System.out.println("clientReqId = " + clientReqId);

        String deeplink = prepareDeepLinkUrl(webUrl, activityType, clientReqId, teamsAppId, teamsEntityId);
        System.out.println("deeplink = " + deeplink);
    }

    private static String prepareDeepLinkUrl(String webUrl, String activityType, String clientReqId, String teamsAppId, String teamsEntityId) throws ScriptException {
        String[] urlSplitArray = webUrl.split("/");
        String base64EncodedThreadId = urlSplitArray[urlSplitArray.length - 1];
        webUrl = webUrl.replace("{0}", "teams").concat("&label=Thread ID");
        String entityType = "Thread";
        String subEntity = clientReqId + ":" + activityType + ":" + entityType + ":" + base64EncodedThreadId;

        return new StringBuilder()
                .append("https://teams.microsoft.com/l/entity/")
                .append(teamsAppId)
                .append("/" + teamsEntityId + "?")
                .append("webUrl=" + encodeURI(webUrl))
                .append("&context=" + encodeURI("{\"subEntityId\": \"" + subEntity + "\"}"))
                .toString();
    }

    private static String encodeURI(String param) throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
        return String.valueOf(scriptEngine.eval("encodeURI('" + param + "')"));
    }
}
