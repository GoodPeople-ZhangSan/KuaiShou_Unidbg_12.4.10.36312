package xl.kuaishou.selection;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import xl.kuaishou.Encryption;
import xl.kuaishou.KuaiShou_Main;
import xl.kuaishou.iPhone;
import xl.kuaishou.search.getSearchBody;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class getSelectionUrl {
    public static String SIG = "";
    public static String SIG3 = "";
    public static long TOTIME = 0;
    private static final String FANS_SALT = "382700b563f4";
    public static String recoReportContext ="";

    static {
        TOTIME = System.currentTimeMillis();
        set_recoReportContext();

        // 进入该方法后就计算sig的值
        setSig();
    }

    private static Map<String, String> getSelectionUrlAll(int i) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("earphoneMode", "0");
        linkedHashMap.put("mod", "Xiaomi()");
        linkedHashMap.put("appver", iPhone.KUAISHOU_VERSION);
        linkedHashMap.put("isp", "");
        linkedHashMap.put("language", "zh-cn");
        linkedHashMap.put("ud", "0");
        linkedHashMap.put("did_tag", "0");
        linkedHashMap.put("egid", KuaiShou_Main.ANDRIOD_EGID);
        linkedHashMap.put("thermal", "10000");
        linkedHashMap.put("net", "WIFI");
        // 1571?
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
        linkedHashMap.put("keyconfig_state", "1");
        linkedHashMap.put("cdid_tag", "2");
        linkedHashMap.put("cold", "ture");
        linkedHashMap.put("sys", "ANDROID_11");
        linkedHashMap.put("max_memory", "256");
        linkedHashMap.put("cold_launch_time_ms", String.valueOf(TOTIME));
        linkedHashMap.put("oc", "ALI_CPD%2C666");
        linkedHashMap.put("sh", "1920");
        linkedHashMap.put("deviceBit", "0");
        linkedHashMap.put("browseType", "4");
        linkedHashMap.put("ddpi", "420");
        linkedHashMap.put("socName", "Qualcomm Snapdragon 660");
        linkedHashMap.put("is_background", "1");
        linkedHashMap.put("c", "ALI_CPD,666");
        linkedHashMap.put("sw", "1080");
        linkedHashMap.put("ftt", "");
        linkedHashMap.put("abi", "arm32");
        linkedHashMap.put("userRecoBit", "0");
        linkedHashMap.put("device_abi", "arm64");
        linkedHashMap.put("totalMemory", "5725");
        linkedHashMap.put("grant_browse_type", "INITIALIZATION");
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
            return linkedHashMap;

        } else {
            System.out.println("合并");
            Map<String, String> body = getSelectionBody.getBody();
            Map<String, String> SelectionUrl_set_sig = new HashMap<String, String>();
            SelectionUrl_set_sig.putAll(linkedHashMap);
            SelectionUrl_set_sig.putAll(body);
            System.out.println("返回内容：" + SelectionUrl_set_sig);
            return SelectionUrl_set_sig;
        }

    }


    private static void set_recoReportContext() {
        JSONObject json_adClientInfo = new JSONObject();
        String[] a = new String[]{};
        json_adClientInfo.put("deviceStatBattery", 100);
        json_adClientInfo.put("deviceStatMemory", 3620);
        json_adClientInfo.put("deviceStatDiskFree", 46995);
        json_adClientInfo.put("updateMark", "1723106191.599095309");
        json_adClientInfo.put("bootMark", "54f90df0-b4ce-4560-a906-520c5392ca68");
        json_adClientInfo.put("androidApiLevel", "30");
        json_adClientInfo.put("supportGyroscope", false);
        json_adClientInfo.put("gestureType", 0);
        json_adClientInfo.put("clientVolume", 16);

//        json_adClientInfo.put("rateInfos", a);
//        json_adClientInfo.put("adPostback", a);


        JSONObject json_launchReferrerInfo = new JSONObject();
        json_launchReferrerInfo.put("packageName", "com.android.launcher3");
        json_launchReferrerInfo.put("launchTime", TOTIME);

        JSONObject json_recoReportContext = new JSONObject();
        json_recoReportContext.put("isGpsAuthorized", false);
        json_recoReportContext.put("isFeedLocationAuthorized", 1);
        json_recoReportContext.put("refresh_id", "de78bc98-8135-40b3-b360-3f5749e8a3fd");
        json_recoReportContext.put("parallelApiEnable", false);
        json_recoReportContext.put("apiIndex", "1");
        json_recoReportContext.put("smallWindowPlay", "FALSE");
        json_recoReportContext.put("useCacheCount", 0);

//        json_recoReportContext.put("warmStart", "1");
        json_recoReportContext.put("adClientInfo", json_adClientInfo);
//        json_recoReportContext.put("launchReferrerInfo", json_launchReferrerInfo);

        JSONObject json_eveFeatures = new JSONObject();
        json_recoReportContext.put("eveFeatures", json_eveFeatures);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{\"isGpsAuthorized\", false,\"isFeedLocationAuthorized\":1,\"refresh_id\":\"88fcd914-babe-4506-9029-1bb2f89829e1\",\"");
        stringBuffer.append("parallelApiEnable\":false,\"apiIndex\":1,\"smallWindowPlay\":\"FALSE\",\"useCacheCount\":0,\"");
        stringBuffer.append("adClientInfo\":{\"deviceStatBattery\":35,\"deviceStatMemory\":3829,\"deviceStatDiskFree\":48725,\"updateMark\":\"1723194686.9773523\",\"bootMark\":\"2fcab13d-2115-4a76-ab47-7540bf944b33\",\"androidApiLevel\":\"30\",\"supportGyroscope\":false,\"clientVolume\":16},");
        stringBuffer.append("\"launchReferrerInfo\":{\"packageName\":\"com.android.launcher3\",\"launchTime\":"+TOTIME+"},");
        stringBuffer.append("\"eveFeatures\":{}}");



        recoReportContext = stringBuffer.toString();
    }

    private static void setSig() {
        // 用于拼接字符串
        StringBuilder stringBuilder = new StringBuilder();
        try {
            // 1. 字典升序排序
            SortedMap<String, Object> sortedMap = new TreeMap<>(getSelectionUrlAll(1));
            // 2. 拼按URL键值对
            Set<String> keySet = sortedMap.keySet();
            for (String key : keySet) {
                String value = String.valueOf(sortedMap.get(key));
                stringBuilder.append(key + "=" + URLDecoder.decode(value, "UTF-8"));
            }
            String uriString = stringBuilder.toString();
            uriString = uriString + FANS_SALT;
            System.out.println("计算 sig 前的内容: \n" + uriString);
            // 3. MD5运算得到请求签名
            SIG = Encryption.md5_Encrypt(uriString).replace("\"", "");
            System.out.println("sig 计算后得到的值为:\n" + SIG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUrlRequst() {
        // 用于存储返回的数据
        StringBuilder sb = new StringBuilder();
        Map<String, String> urlAll = getSelectionUrlAll(0);
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
}
