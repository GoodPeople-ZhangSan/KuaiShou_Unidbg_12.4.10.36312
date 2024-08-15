package xl.kuaishou;

import xl.kuaishou.search.get_unidbg_ct_context;

import java.util.UUID;

public class iPhone {
    // 需要先设置一些必要参数！
    // 生产厂商
    public static final String Manufacturer = "Xiaomi";
    // 手机型号
    public static final String ANDROID = "Xiaomi(Mi Note 3)";
    // 手机型号 精简
    public static final String ANDROID_POP = "Mi Note 3";
    // Android版本
    public static final String ANDROID_VERSION = "11";
    // Android版本对应的SDK
    public static final String SDK = "30";
    // Android系统版本号
    public static final String iPhone_Version = "RQ3A.211001.001";
    // Android版本的发行型号或发行商
    public static final String Android_Type = "jason";
    // 手机Fingerprint标识
    public static final String Fingerprint = "Xiaomi/jason/jason:7.1.1/NMF26X/V9.6.2.0.NCHMIFD:user/release-keys";
    // 设备宽高之类信息
    public static final String Width_Height = "[2.625,1080,1920,2.625,403.411,403.041]";
    // 硬件名
    public static final String Hardware_Name = "qcom";
    // 手机的Android Dalvik
    public static final String Android_Dalvik = "Dalvik/2.1.0 (Linux; U; Android 11; Mi Note 3 Build/RQ3A.211001.001)";

    public final static String startSessionId = UUID.randomUUID().toString();

    public static final String DID = "ANDROID_d19e01c25441638c";
    public static final String RDID = "ANDROID_ecb29ab491f6a1e6";
    public static final String ODID = "ANDROID_1d138775d75dccf0";
    public static final String KUAISHOU_VERSION = "12.4.10.36312";
    public static final String KUAISHOU_VERSION_MAX = "12.4";

    // APK安装时间
    public static final String did_gt = "1723194686698";


    // unidbg时必须的UUID
    public static final String ANDRIOD_UUID1 = "d7b7d042-d4f2-4012-be60-d97ff2429c17";
    public static final String ANDRIOD_UUID2 = "7e46b28a-8c93-4940-8238-4c60e64e3c81";

    public static final String Header_ct_context = get_unidbg_ct_context.set_ct_context();

}
