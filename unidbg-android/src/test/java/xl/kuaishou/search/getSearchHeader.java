package xl.kuaishou.search;

import java.util.LinkedHashMap;
import java.util.Random;

public class getSearchHeader {
    // Search 中 X-REQUESTID的值
    public static String getSearchHeader_REQUESTID() {
        Random random = new Random();
        return String.valueOf(System.currentTimeMillis() + random.nextInt(100000));
    }

    // Search 中 ct-context 的值
    public static String getSearchHeader_context() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("biz_name", "ATTRIBUTION");
        linkedHashMap.put("error_occurred", "false");
        linkedHashMap.put("sampled", "true");
        linkedHashMap.put("sampled_on_error", "true");
        linkedHashMap.put("segment_id", "需要分析");
        linkedHashMap.put("service_name", "CLIENT_TRACE");
        linkedHashMap.put("span_id", "1");
        linkedHashMap.put("trace_id", "需要分析");
        linkedHashMap.put("upstream_error_occurred", "false");

        return linkedHashMap.toString();
    }
}
