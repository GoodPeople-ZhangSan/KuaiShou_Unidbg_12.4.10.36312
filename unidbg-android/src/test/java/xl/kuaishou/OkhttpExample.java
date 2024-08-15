package xl.kuaishou;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import xl.kuaishou.search.getSearchBody;
import xl.kuaishou.search.getSearchHeader;
import xl.kuaishou.search.get_unidbg_ct_context;
import xl.kuaishou.selection.getSelectionBody;
import xl.kuaishou.selection.getSelectionHeader;

public class OkhttpExample {
    private static final OkHttpClient client = new OkHttpClient();

    public static void request_selection_suggestion(String url_parameter) {

        Request request = new Request.Builder()
                .url("https://apijsv6.gifshow.com/rest/n/feed/selection?" + url_parameter)
                .addHeader("Host", "apihb6.gifshow.com")
                .addHeader("User-Agent", "kwai-android aegon/3.47.2")
                .addHeader("Connection", "keep-alive")
                .addHeader("Accept-Language", "zh-cn")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("page-code", "SEARCH_SUGGESTION_PAGE")
                .addHeader("X-Client-Info", "model=" + iPhone.ANDROID_POP + ";os=Android;nqe-score=27;network=WIFI")
                .addHeader("X-REQUESTID", getSelectionHeader.getSelectionHeader_REQUESTID())
                .addHeader("Cookie", "region_ticket=RT_811077D92ED598C551B5595D8D0EA49E68B79ED0CA0124742B03DA3890947AE7539E82E83")
                .post(getSelectionBody.getRequestBody())
                .build();

        // 用于存储 返回值 body
        String resultBody = "";
        // 发送请求并获取响应
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful() && "gzip".equalsIgnoreCase(response.header("Content-Encoding"))) {
                // GZIP解压
                resultBody = un_gzip(response);
                // 输出解压后的响应体
                System.out.println("GZIP:" + resultBody);
            } else {
                resultBody = response.body().string();
                // 如果响应不是GZIP压缩的，直接读取响应体
                System.out.println("no GZIP:" + resultBody);
            }
            JSONObject jsonObject = JSONObject.parseObject(resultBody);
            System.out.println("获取后的Search返回值为：" + jsonObject);


        } catch (IOException e) {
            System.out.println("异常：" + e);
        }
        JSONObject jsonObject =  JSON.parseObject(resultBody);

    }

    public static void request_search_suggestion(String url_parameter) {
        Request request = new Request.Builder()
                .url("https://apihb6.gifshow.com/rest/n/search/new?" + url_parameter)
                .addHeader("Host", "apihb6.gifshow.com")
                .addHeader("User-Agent", "kwai-android aegon/3.47.2")
                .addHeader("Connection", "keep-alive")
                .addHeader("Accept-Language", "zh-cn")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("page-code", "SEARCH_SUGGESTION_PAGE")
                .addHeader("X-Client-Info", "model=" + iPhone.ANDROID_POP + ";os=Android;nqe-score=41;network=WIFI")
                .addHeader("X-REQUESTID", getSearchHeader.getSearchHeader_REQUESTID())
                .addHeader("Cookie", "region_ticket=RT_811077D92ED598C551B5595D8D0EA49E68B79ED0CA0124742B03DA3890947AE7539E82E83")
                .addHeader("ct-context", get_unidbg_ct_context.set_ct_context())
                .post(getSearchBody.getSearchAllBody())
                .build();

        // 用于存储 返回值 body
        String resultBody;
        // 发送请求并获取响应
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful() && "gzip".equalsIgnoreCase(response.header("Content-Encoding"))) {
                // GZIP解压
                resultBody = un_gzip(response);
                // 输出解压后的响应体
                System.out.println("GZIP:" + resultBody);
            } else {
                resultBody = response.body().string();
                // 如果响应不是GZIP压缩的，直接读取响应体
                System.out.println("no GZIP:" + resultBody);
            }
            JSONObject jsonObject = JSONObject.parseObject(resultBody);
            System.out.println("获取后的Search返回值为：" + jsonObject);


        } catch (IOException e) {
            System.out.println("异常：" + e);
        }
    }


    public static void request_egid(RequestBody body) {
        Request request = new Request.Builder()
                .url("https://gdfpsec.ksapisrv.com/rest/infra/gdfp/report/kuaishou/android")
                .addHeader("Host", "gdfpsec.ksapisrv.com")
                .addHeader("User-Agent", "okhttp/3.12.13")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Accept-Encoding", "gzip")
                .addHeader("Cookie", "did=" + iPhone.DID)
                .post(body)
                .build();

        // 用于存储 返回值 body
        String resultBody;
        // 发送请求并获取响应
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful() && "gzip".equalsIgnoreCase(response.header("Content-Encoding"))) {
                // Gizp 解压
                resultBody = un_gzip(response);
                // 输出解压后的响应体
                System.out.println("Egid GZIP解压后：:" + resultBody);
            } else {
                resultBody = response.body().string();
                // 如果响应不是GZIP压缩的，直接读取响应体
                System.out.println("no GZIP:" + resultBody);
            }
            JSONObject jsonObject = JSONObject.parseObject(resultBody);
            KuaiShou_Main.ANDRIOD_EGID = jsonObject.get("egid").toString();
            System.out.println("获取后的Egid为：" + KuaiShou_Main.ANDRIOD_EGID);


        } catch (IOException e) {
            System.out.println("异常：" + e);
        }
    }

    public static void request_idMapping(String body) {
        // 创建RequestBody,定义MediaType
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), body);

        Request request = new Request.Builder()
                .url("https://gdfpsec.gifshow.com/rest/infra/unifiedId/logReport/idMapping")
                .addHeader("Host", "gdfpsec.gifshow.com")
                .addHeader("User-Agent", "okhttp/3.12.13")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Accept-Encoding", "gzip")
                .addHeader("Cookie", "did=" + iPhone.DID)
                .post(requestBody)
                .build();

        String body_str = "";
        try {
            // 发送请求并获取响应
            Response response = client.newCall(request).execute();

            if (response.isSuccessful() && "gzip".equalsIgnoreCase(response.header("Content-Encoding"))) {
                // 如果是GZIP响应，解压
                body_str = un_gzip(response);
            } else {
                // 如果响应不是GZIP压缩的，直接读取响应体
                body_str = response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("返回内容为:" + body_str);


    }

    private static String un_gzip(Response response) {
        // 用于存储 返回值 body
        String result_un_Body = "";
        try {
            // 手动解压GZIP响应
            byte[] gzippedBody = response.body().bytes();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try (GZIPInputStream gzipInputStream = new GZIPInputStream(gzippedBody.length > 0 ? new java.io.ByteArrayInputStream(gzippedBody) : null)) {
                byte[] buffer = new byte[1024];
                int len;
                while ((len = gzipInputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, len);
                }
            }
            result_un_Body = byteArrayOutputStream.toString("UTF-8");
            // 输出解压后的响应体
            System.out.println("获取的Response Body 解压后:" + result_un_Body);

        } catch (IOException e) {
            System.out.println("异常：" + e);
        }
        return result_un_Body;
    }
}
