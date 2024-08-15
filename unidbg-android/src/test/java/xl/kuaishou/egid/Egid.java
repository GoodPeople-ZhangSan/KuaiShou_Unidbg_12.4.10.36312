package xl.kuaishou.egid;

import com.google.protobuf.nano.MessageNano;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import xl.kuaishou.iPhone;

import java.util.zip.CRC32;


public class Egid {
    public static long toTime = 0;

    public static byte[] egidarg1() {
        // 设置一下当前时间
        toTime = System.currentTimeMillis();

        EgidNano egidNano = new EgidNano();
        // 需要修改如下
        egidNano.a5 = "54021062656";
        egidNano.a7 = iPhone.DID;
        egidNano.a16 = "android-build";
        egidNano.a19 = "sdm660";
        egidNano.a22 = iPhone.KUAISHOU_VERSION;
        egidNano.a23 = iPhone.Manufacturer;
        egidNano.a27 = iPhone.ANDROID_POP;
        egidNano.a28 = iPhone.Hardware_Name;
        egidNano.a29 = iPhone.Android_Dalvik;
        egidNano.a30 = iPhone.iPhone_Version;
        egidNano.a34 = iPhone.Width_Height;
        egidNano.a35 = iPhone.ANDROID_VERSION;
        egidNano.a36 = "7.4.2lite.566.0d19e68f";
        egidNano.a37 = iPhone.iPhone_Version;
        // 当前时间减去开机时间
        egidNano.a39 = String.valueOf(toTime - 1001000);
        egidNano.a40 = iPhone.Fingerprint;
        egidNano.a46 = "6003576832";
        egidNano.a47 = "unknown";
        egidNano.a52 = iPhone.Android_Type;
        egidNano.a58 = iPhone.Android_Type;
        egidNano.a59 = "1";
        egidNano.a61 = iPhone.Manufacturer;
        egidNano.a63 = "nobody";
        egidNano.a67 = "cn";
        egidNano.a84 = "509088901b3c2a9e";
        egidNano.a88 = "exsist";
        egidNano.a89 = "688326938";
        // 这个才是当前时间
        egidNano.a92 = String.valueOf(System.currentTimeMillis());
        egidNano.a93 = "{\"1\":\"0\",\"0\":1,\"2\":\"false\",\"4\":\"Qualcomm Technologies, Inc SDM660\",\"8\":\"9\",\"11\":\"KWE_N\",\"12\":\"KWE_N\",\"13\":\"30\",\"14\":\"0\",\"15\":\"false\",\"16\":\"KWE_N\",\"18\":false}";
        // APK安装时间
        egidNano.a96 = "{\"0\":\"" + iPhone.did_gt + "\";\"1\":\"1\"}";
        egidNano.a101 = "207082064";
        egidNano.a102 = "bc547ed9-2f94-4239-bcf8-849862f12a71";
        // 可能变化
        egidNano.a105 = "nnn|456766973::5535445171|nnn|841604195::0030422271|707333352::871675702";
        egidNano.a106 = "{\"1\":\"KWE_N\",\"2\":\"KWE_N\",\"3\":\"KWE_N\",\"4\":\"KWE_N\",\"5\":\"KWE_N\",\"6\":\"KWE_N\"}";
        egidNano.a110 = "-8368205524676799681";
        egidNano.a111 = "KWE_N";
        egidNano.a112 = "{\"KUAISHOU\":\"DFP63E46ACE7327107878DF3851D04CCDB3A947856A7E30111A3B6F76EB5E2C5\"}";
        egidNano.a113 = "{\"4\":{\"1\":\"KWE_N\",\"2\":\"KWE_N\",\"3\":\"KWE_N\",\"4\":\"KWE_N\",\"5\":\"KWE_N\",\"12\":\"KWE_N\",\"13\":\"KWE_N\"}}";
        egidNano.a119 = "KWE_N";

        // 最后设置 14
        String[] fields = {egidNano.a1, egidNano.a2, egidNano.a3, egidNano.a4, egidNano.a5, egidNano.a6, egidNano.a7, egidNano.a8, egidNano.a9, egidNano.a10, egidNano.a11, egidNano.a12, egidNano.a13, egidNano.a14, egidNano.a15, egidNano.a16, egidNano.a17, egidNano.a18, egidNano.a19, egidNano.a20, egidNano.a21, egidNano.a22, egidNano.a23, egidNano.a24, egidNano.a25, egidNano.a26, egidNano.a27, egidNano.a28, egidNano.a29, egidNano.a30, egidNano.a31, egidNano.a32, egidNano.a33, egidNano.a34, egidNano.a35, egidNano.a36, egidNano.a37, egidNano.a38, egidNano.a39, egidNano.a40, egidNano.a41, egidNano.a42, egidNano.a43, egidNano.a44, egidNano.a45, egidNano.a46, egidNano.a47, egidNano.a48, egidNano.a49, egidNano.a50, egidNano.a51, egidNano.a52, egidNano.a53, egidNano.a54, egidNano.a55, egidNano.a56, egidNano.a57, egidNano.a58, egidNano.a59, egidNano.a60, egidNano.a61, egidNano.a62, egidNano.a63, egidNano.a64, egidNano.a65, egidNano.a66, egidNano.a67, egidNano.a68, egidNano.a69, egidNano.a70, egidNano.a71, egidNano.a72, egidNano.a73, egidNano.a74, egidNano.a75, egidNano.a76, egidNano.a77, egidNano.a78, egidNano.a79, egidNano.a80, egidNano.a81, egidNano.a82, egidNano.a83, egidNano.a84, egidNano.a85, egidNano.a86, egidNano.a87, egidNano.a88, egidNano.a89, egidNano.a90, egidNano.a91, egidNano.a92, egidNano.a93, egidNano.a94, egidNano.a95, egidNano.a96, egidNano.a97, egidNano.a98, egidNano.a99, egidNano.a100, egidNano.a101, egidNano.a102, egidNano.a103, egidNano.a104, egidNano.a105, egidNano.a106, egidNano.a107, egidNano.a108, egidNano.a109, egidNano.a110, egidNano.a111, egidNano.a112, egidNano.a113, egidNano.a114, egidNano.a115, egidNano.a116, egidNano.a117, egidNano.a118, egidNano.a119};
        CRC32 crc32 = new CRC32();
        for (int i = 0; i < fields.length; i++) {
            crc32.update(fields[i].getBytes());
        }
        egidNano.a14 = "AND:"+crc32.getValue();

//        System.out.println("egid a14:"+egidNano.a14);
//        StringBuilder sb = new StringBuilder();
//        for (byte b : MessageNano.toByteArray(egidNano)) {
//            sb.append(String.format("%02x", b));
//        }
//        System.out.println(sb.toString());
//
//        System.out.println(new String(MessageNano.toByteArray(egidNano)));

        return MessageNano.toByteArray(egidNano);
    }

    public static RequestBody getEgidBody(String deviceInfo, String sign) {
        RequestBody body = new FormBody.Builder()
                .add("productName","KUAISHOU")
                .add("ts", String.valueOf(toTime))
                .add("deviceInfo",deviceInfo)
                .add("sign",sign)
                .add("sv","2")
                .add("rdid",iPhone.RDID)
                .add("didtag","-1")
                .build();

        return body;
    }
}
