package xl.kuaishou.idmapping;

import com.google.protobuf.nano.MessageNano;
import xl.kuaishou.iPhone;

public class idMapping {

    public static long egidtime = System.currentTimeMillis();

    // 构造生成egid所需的参数
    public static byte[] egidarg1() {
        idMappingNano idMappingNano = new idMappingNano();
        idMappingNano.a = iPhone.DID;
        idMappingNano.b = "2";
        idMappingNano.c = iPhone.RDID;
        idMappingNano.d = "-1";
        idMappingNano.e = iPhone.RDID;
        idMappingNano.g = "fetch";
        idMappingNano.h = "KUAISHOW";
        idMappingNano.j = iPhone.KUAISHOU_VERSION;
        idMappingNano.k = "google";
        idMappingNano.l = iPhone.ANDROID;
        idMappingNano.m = "ANDROID_PHONE";
        idMappingNano.n = iPhone.SDK;
        idMappingNano.o = System.currentTimeMillis();
        return MessageNano.toByteArray(idMappingNano);
    }

    public static String getEgidBody(String deviceInfo, String sign) {
        // 使用StringBuilder来构建最终的字符串
        StringBuilder result = new StringBuilder();

        result.append("productName=" + "KUAISHOU" + "&");
        result.append("ts=" + System.currentTimeMillis() + "&");
        result.append("deviceInfo=" + deviceInfo + "&");
        result.append("sign=" + sign + "&");
        result.append("sv=" + "2" + "&");
        result.append("rdid=" + iPhone.RDID + "&");
        result.append("didtag=" + "-1");

        return result.toString();
    }
}
