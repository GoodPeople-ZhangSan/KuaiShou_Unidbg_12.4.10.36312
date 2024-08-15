package xl.kuaishou.search;

import okhttp3.FormBody;
import okhttp3.RequestBody;
import xl.kuaishou.Encryption;
import xl.kuaishou.iPhone;

import java.util.LinkedHashMap;
import java.util.Random;
import java.util.UUID;

public class getSearchBody {
    // 设置全局变量方便使用
    public static String queryId = "";
    public static String perf_session_id = "";
    public static String keyword = "";
    public static String extParams = "";

    // 这里传入的是搜索内容  queryId
    public getSearchBody(String str) {
        // 设置 keyword
        keyword = str;

        // 设置queryId
        str = str + "0" + System.currentTimeMillis() + new Random().nextInt(0x2710);
        queryId = Encryption.Base64_Encrypt(str.getBytes());

        // 设置 perf_session_id
        String str2 = "0" + System.currentTimeMillis() + new Random().nextInt(0x2710);
        perf_session_id = Encryption.Base64_Encrypt(str2.getBytes());

    }


    private static void extParams() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("kwaiSource", "search_entrance_bottom_featured");
        linkedHashMap.put("disableCorrection", "false");
        linkedHashMap.put("hasSelectedInterest", "false");
        linkedHashMap.put("referVideoId", "");
        linkedHashMap.put("referLog", "");
        linkedHashMap.put("isAd", "false");
        linkedHashMap.put("referAuthorId", "");
        linkedHashMap.put("referPlayDuration", "");
        linkedHashMap.put("isShieldBackend", "false");
        linkedHashMap.put("signalParams", "");
    }


    // 整个body内容
    public static RequestBody getSearchAllBody() {
        return new FormBody.Builder()
                .add("isRecoRequest", "false")
                .add("perf_session_id", perf_session_id)
                .add("fromPage", "1")
                .add("keyword", keyword)
                .add("queryId", queryId)
                .add("extParams", extParams)
                .add("cs", "false")
                .add("client_key", "3c2cd3f3")
                .add("videoModelCrowdTag", "1_99")
                .add("os", "android")
                .add("startSessionId", iPhone.startSessionId)
                .add("secondShard", "false")
                .add("uQaTag", "")
                .build();
    }

}