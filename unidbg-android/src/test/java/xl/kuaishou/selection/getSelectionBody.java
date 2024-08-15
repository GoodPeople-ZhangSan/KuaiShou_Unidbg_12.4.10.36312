package xl.kuaishou.selection;

import okhttp3.FormBody;
import okhttp3.RequestBody;

import java.util.LinkedHashMap;
import java.util.Map;

public class getSelectionBody {


    public static RequestBody getRequestBody() {
        String recoReportContext = getSelectionUrl.recoReportContext.toString();

        return new FormBody.Builder()
                .add("page", "1")
                .add("coldStart", "true")
                .add("count", "6")
                .add("pcursor", "0")
                .add("pv", "true")
                .add("seid", "03aad08d-5da0-48a6-b0aa-6684abbcad3c")
                .add("newUserRefreshTimes", "21")
                .add("newUserAction", "{\"click\":[],\"follow\":[],\"like\":[]}")
                .add("recoReportContext", recoReportContext)
                .add("source", "2")
                .add("edgeRecoBit", "2")
                .add("realShowPhotoIds", "5223612759473631320,5197717060847174408")
                .add("edgeRerankConfigVersion", "")
                .add("clientRealReportData", "")
                .add("teenageAge", "0")
                .add("isOpenAutoPlay", "false")
                .add("injectTask", "0")
                .add("videoModelCrowdTag", "1_99")
                .add("os", "android")
                .add("cs", "false")
                .add("client_key", "3c2cd3f3")
                .add("uQaTag", "").build();
    }

    public static Map<String, String> getBody() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("page", "1");
        linkedHashMap.put("coldStart", "true");
        linkedHashMap.put("count", "6");
        linkedHashMap.put("pcursor", "0");
        linkedHashMap.put("pv", "true");
        linkedHashMap.put("seid", "03aad08d-5da0-48a6-b0aa-6684abbcad3c");
        linkedHashMap.put("newUserRefreshTimes", "21");
        linkedHashMap.put("newUserAction", "{\"click\":[],\"follow\":[],\"like\":[]}");
        linkedHashMap.put("recoReportContext", getSelectionUrl.recoReportContext);
        linkedHashMap.put("source", "2");
        linkedHashMap.put("edgeRecoBit", "2");
        linkedHashMap.put("realShowPhotoIds", "5223612759473631320,5197717060847174408");
        linkedHashMap.put("edgeRerankConfigVersion", "");
        linkedHashMap.put("clientRealReportData", "");
        linkedHashMap.put("teenageAge", "0");
        linkedHashMap.put("isOpenAutoPlay", "false");
        linkedHashMap.put("injectTask", "0");
        linkedHashMap.put("videoModelCrowdTag", "1_99");
        linkedHashMap.put("os", "android");
        linkedHashMap.put("cs", "false");
        linkedHashMap.put("client_key", "3c2cd3f3");
        linkedHashMap.put("uQaTag", "");
        return linkedHashMap;
    }
}
