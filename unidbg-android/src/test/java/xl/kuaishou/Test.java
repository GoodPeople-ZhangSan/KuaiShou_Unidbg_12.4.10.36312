package xl.kuaishou;

import com.alibaba.fastjson.JSONObject;
import xl.kuaishou.search.get_unidbg_ct_context;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("isGpsAuthorized", false);
        map.put("isFeedLocationAuthorized", 1);
        map.put("refresh_id", "de78bc98-8135-40b3-b360-3f5749e8a3fd");
        map.put("parallelApiEnable", false);
        map.put("apiIndex", "1");
        map.put("smallWindowPlay", "FALSE");
        map.put("useCacheCount", 0);
        System.out.println(map.toString());
    }
}
