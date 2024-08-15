package xl.kuaishou.search;

import xl.kuaishou.Encryption;
import xl.kuaishou.KuaiShou_Main;
import xl.kuaishou.iPhone;

import java.net.URLDecoder;
import java.util.*;

public class getSearchUrl {
    public static String SIG = "";
    public static String SIG3 = "";
    public static String TOTIME = "";
    private static final String FANS_SALT = "382700b563f4";

    static {
        TOTIME = String.valueOf(System.currentTimeMillis());

        // 进入该方法后就计算sig的值
        setSig();
    }

    public static String getUrlRequst() {
        // 用于存储返回的数据
        StringBuilder sb = new StringBuilder();
        Map<String, String> urlAll = getUrlAll(0);
        for (Map.Entry<String, String> entry : urlAll.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        // 移除最后一个多余的"&"
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        // 返回输出
        return sb.toString();
    }


    private static Map<String, String> getUrlAll(int i) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("earphoneMode", "1");
        linkedHashMap.put("mod", iPhone.ANDROID);
        linkedHashMap.put("appver", iPhone.KUAISHOU_VERSION);
        linkedHashMap.put("isp", "CUCC");
        linkedHashMap.put("language", "zh-cn");
        linkedHashMap.put("ud", "0");
        linkedHashMap.put("did_tag", "0");
        linkedHashMap.put("egid", KuaiShou_Main.ANDRIOD_EGID);
        linkedHashMap.put("thermal", "10000");
        linkedHashMap.put("net", "WIFI");
        linkedHashMap.put("kcv", "1571");
        linkedHashMap.put("app", "0");
        linkedHashMap.put("kpf", "ANDROID_PHONE");
        linkedHashMap.put("bottom_navigation", "false");
        linkedHashMap.put("ver", iPhone.KUAISHOU_VERSION_MAX);
        linkedHashMap.put("android_os", "0");
        linkedHashMap.put("oDid", iPhone.ODID);
        linkedHashMap.put("boardPlatform", "sdm660");
        linkedHashMap.put("kpn", "KUAISHOU");
        linkedHashMap.put("newOc", "ALI_CPD,666");
        linkedHashMap.put("androidApiLevel", iPhone.SDK);
        linkedHashMap.put("slh", "0");
        linkedHashMap.put("country_code", "cn");
        linkedHashMap.put("nbh", "0");
        linkedHashMap.put("hotfix_ver", "");
        linkedHashMap.put("did_gt", iPhone.did_gt);
        linkedHashMap.put("keyconfig_state", "2");
        linkedHashMap.put("cdid_tag", "2");
        linkedHashMap.put("sys", "ANDROID_11");
        linkedHashMap.put("max_memory", "256");
        linkedHashMap.put("cold_launch_time_ms", TOTIME);
        linkedHashMap.put("oc", "ALI_CPD%2C666");
        linkedHashMap.put("sh", "1920");
        linkedHashMap.put("deviceBit", "0");
        linkedHashMap.put("browseType", "4");
        linkedHashMap.put("ddpi", "420");
        linkedHashMap.put("socName", "Qualcomm Snapdragon 660");
        linkedHashMap.put("is_background", "0");
        linkedHashMap.put("c", "ALI_CPD,666");
        linkedHashMap.put("sw", "1080");
        linkedHashMap.put("ftt", "");
        linkedHashMap.put("abi", "arm32");
        linkedHashMap.put("userRecoBit", "0");
        linkedHashMap.put("device_abi", "arm64");
        linkedHashMap.put("totalMemory", "5725");
        linkedHashMap.put("grant_browse_type", "AUTHORIZED");
        linkedHashMap.put("iuid", "");
        linkedHashMap.put("rdid", iPhone.RDID);
        linkedHashMap.put("sbh", "63");
        linkedHashMap.put("darkMode", "false");
        linkedHashMap.put("did", iPhone.DID);


        // 如果 i 为 0 ，则是URL所有参数，
        // 其他，则为计算sig，需去除：__NS_xfalcon sig __NS_sig3
        // 并加上body中的参数
        if (i == 0) {
            linkedHashMap.put("sig", SIG);
            linkedHashMap.put("__NS_sig3", SIG3);
            linkedHashMap.put("__NS_xfalcon", "");
        } else {
            linkedHashMap.put("perf_session_id", getSearchBody.perf_session_id);
            linkedHashMap.put("extParams", getSearchBody.extParams);
            linkedHashMap.put("isRecoRequest", "false");
            linkedHashMap.put("frompage", "5");
            linkedHashMap.put("secondShard", "false");
            linkedHashMap.put("keyword", getSearchBody.keyword);
            linkedHashMap.put("videoModelCrowdTag", "1_99");
            linkedHashMap.put("os", "android");
            linkedHashMap.put("client_key", "3c2cd3f3");
            linkedHashMap.put("uQaTag", "");
            linkedHashMap.put("startSessionId", iPhone.startSessionId);
            linkedHashMap.put("cs", "false");
            linkedHashMap.put("queryId", getSearchBody.queryId);
        }

        return linkedHashMap;
    }

    private static void setSig() {
        // 用于拼接字符串
        StringBuilder stringBuilder = new StringBuilder();
        try {
            // 1. 字典升序排序
            SortedMap<String, String> sortedMap = new TreeMap<>(getUrlAll(1));
            // 2. 拼按URL键值对
            Set<String> keySet = sortedMap.keySet();
            for (String key : keySet) {
                String value = sortedMap.get(key);
                stringBuilder.append(key + "=" + URLDecoder.decode(value, "UTF-8"));
            }
            String uriString = stringBuilder.toString();
            uriString = uriString + FANS_SALT;
            System.out.println("计算 sig 前的内容: \n" + uriString);
            // 3. MD5运算得到请求签名
            SIG = Encryption.md5_Encrypt(uriString);
            System.out.println("sig 计算后得到的值为:\n" + SIG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
