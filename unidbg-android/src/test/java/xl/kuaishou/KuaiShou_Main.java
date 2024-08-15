package xl.kuaishou;

import com.github.unidbg.AndroidEmulator;
import com.github.unidbg.Emulator;
import com.github.unidbg.file.FileResult;
import com.github.unidbg.file.IOResolver;
import com.github.unidbg.linux.android.AndroidEmulatorBuilder;
import com.github.unidbg.linux.android.AndroidResolver;
import com.github.unidbg.linux.android.dvm.*;
import com.github.unidbg.linux.android.dvm.api.AssetManager;
import com.github.unidbg.linux.android.dvm.array.ByteArray;
import com.github.unidbg.linux.android.dvm.jni.ProxyDvmObject;
import com.github.unidbg.memory.Memory;
import com.github.unidbg.virtualmodule.android.AndroidModule;
import okhttp3.RequestBody;
import xl.kuaishou.egid.Egid;
import xl.kuaishou.search.getSearchUrl;
import xl.kuaishou.selection.getSelectionUrl;


import java.io.File;
import java.net.URLEncoder;
import java.util.Arrays;

public class KuaiShou_Main extends AbstractJni implements IOResolver {
    // Unidbg所需参数
    public static AndroidEmulator emulator;
    public static VM vm;

    // 一些需要后续赋值的必要参数，需要向快手交互的
    private static DvmObject<?> APP_Context;
    private static String deviceInfo;
    private static String sign;
    public static String ANDRIOD_EGID = "DFP55414FB282ADE14337EF037C6B58C5BD4900A44D4B38D6CB4CA7EC32E543A";

    static {
        //创建Unidbg实例
        new KuaiShou_Main();

        // 第一次执行doCommandNative，初始化(必须)
        System.out.println("10412：第一次执行doCommandNative，初始化-->Start");
        // 构造第一次的参数
        Object[] objects1 = new Object[]{"", iPhone.ANDRIOD_UUID1, "", "", APP_Context, "", ""};
        System.out.println("第一次输出结果：" + doCommandNative(10412, objects1));
        System.out.println("10412：第一次执行doCommandNative，初始化-->End");
    }

    public static void main(String[] args) {

        // 如果egid==空，就需要生成egid
        if (ANDRIOD_EGID.equals("")) {
            // 生成egid所需参数：deviceInfo、sign
            setEgid_body_parameter();
        }

        // 设置 selection sig3 的内容
        set_sig3_url_parameter(0);
        // 获取发送 selection 请求的url参数，sig在其中计算
        String urlRequst1 = getSelectionUrl.getUrlRequst();
        System.out.println("selection URL：" + urlRequst1);
        // 发送 /rest/n/feed/selection 请求，获取返回值用于作为 Search 的body
        OkhttpExample.request_selection_suggestion(urlRequst1);


        // 设置 Search sig3 的内容
//        set_sig3_url_parameter(1);
        // 获取发送search请求的url参数，sig在其中计算
//        String urlRequst = getSearchUrl.getUrlRequst();
//        System.out.println(urlRequst);

        // 发送 search 请求
//        OkhttpExample.request_search_suggestion(urlRequst);


    }


    // 用于执行doCommandNative来获取 sig3 的值
    private static void set_sig3_url_parameter(int i) {
        String[] objArr1 = null;
        if (i == 0) {
            objArr1 = new String[]{"/rest/n/feed/selection" + getSelectionUrl.SIG};
        } else {
            objArr1 = new String[]{"/rest/n/search/new" + getSearchUrl.SIG};
        }
        System.out.println("获取sig3的参数：" + Arrays.toString(objArr1));
        // 构造第二次atlasEncrypt所需参数
        Object[] objects1 = new Object[]{objArr1, iPhone.ANDRIOD_UUID1, -1, false, APP_Context, null, false, ""};

        // 获得结果，后续需要用到,赋值到sig3
        if (i == 0) {
            getSelectionUrl.SIG3 = doCommandNative(10418, objects1).toString().replace("\"","");
            System.out.println("获取 Sig3 输出结果：" + getSelectionUrl.SIG3);
        } else {
            getSearchUrl.SIG3 = doCommandNative(10418, objects1).toString().replace("\"","");
            System.out.println("获取 Sig3 输出结果：" + getSearchUrl.SIG3);
        }
    }


    private static void setEgid_body_parameter() {
        // 第二次执行doCommandNative，获取deviceInfo
        System.out.println("10400：第二次执行doCommandNative，获取deviceInfo-->Start");
        // 构造生成egid所需的参数1
        byte[] egidNano2 = Egid.egidarg1();

        // 构造第二次atlasEncrypt所需参数
        Object[] objects2 = new Object[]{egidNano2, iPhone.ANDRIOD_UUID1, 0, "", APP_Context, true, true, iPhone.ANDRIOD_UUID2};

        // 获得结果，后续需要用到
        ByteArray byteArray = (ByteArray) doCommandNative(10400, objects2);
        // 转为 byte[]，方便后续处理
        byte[] bytes = byteArray.getValue();
        System.out.println("第二次输出结果：" + Arrays.toString(bytes));
        System.out.println("10400：第二次执行doCommandNative，获取deviceInfo-->End");
        // 赋值deviceInfo
        deviceInfo = URLEncoder.encode(Encryption.Base64_MimeEncrypt(bytes));

        System.out.println("deviceInfo的值为：" + deviceInfo);

        // 第三次执行doCommandNative，获取sign
        System.out.println("10418：第三次执行doCommandNative，获取egid-->Start");
        // 构造第三次的参数，deviceInfo需要GetObjectArrayElement，需要转为 String[] 后传入参数
        String[] stringArray = new String[]{"KUAISHOU" + Egid.toTime + "2" + deviceInfo.trim()};
        System.out.println("deviceInfo转为StringArray：" + Arrays.toString(stringArray));
        Object[] objects3 = new Object[]{stringArray, iPhone.ANDRIOD_UUID1, -1, false, APP_Context, "", true, iPhone.ANDRIOD_UUID2};
        // 获得结果，后续需要用到
        sign = doCommandNative(10418, objects3).toString().replace("\"", "");
        System.out.println("第三次输出结果：" + sign);

        System.out.println("10418：第三次执行doCommandNative，获取egid-->End");

        // 发送第一次网络请求，获取快手返回的egid
        // 准备egid所需body内容
        RequestBody egidBody = Egid.getEgidBody(deviceInfo, sign);
        System.out.println("获取egid所需body：" + egidBody);
        // 发送请求，取得Egid
        OkhttpExample.request_egid(egidBody);
    }


    // 加载 doCommandNative 方法
    // doCommandNative(I[Ljava/lang/Object;)Ljava/lang/Object;, RX@0x40046435[libkwsgmain.so]0x46435)
    private static Object doCommandNative(int paramInt0, Object[] paramObjects1) {
        // 加载动态注册的doCommandNative，先把类找到，这里的原理很像反射
        DvmClass doCommandNative_dvmclass = vm.resolveClass("com.kuaishou.android.security.internal.dispatch.JNICLibrary");
        System.out.println("开始调用doCommandNative方法");
        Object resultobj = doCommandNative_dvmclass.callStaticJniMethodObject(emulator, "doCommandNative(I[Ljava/lang/Object;)Ljava/lang/Object;", paramInt0, ProxyDvmObject.createObject(vm, paramObjects1));
        System.out.println("结束调用doCommandNative方法");

        // 返回结果
        return resultobj;
    }


    private KuaiShou_Main() {
        System.out.println("创建Unidbg实例-->Start");
        // 创建模拟器实例,进程名建议依照实际进程名填写，可以规避针对进程名的校验
        emulator = AndroidEmulatorBuilder.for32Bit()
                .setProcessName("com.smile.gifmaker")
                .build();
        // 获取模拟器的内存操作接口
        final Memory memory = emulator.getMemory();
        // 设置多线程处理
//        emulator.getSyscallHandler().setEnableThreadDispatcher(True);

        // 设置系统类库解析
        memory.setLibraryResolver(new AndroidResolver(23));
        // 创建Android虚拟机,传入APK，Unidbg可以替我们做部分签名校验的工作
        vm = emulator.createDalvikVM(new File("unidbg-android\\src\\test\\resources\\kuaishou\\kuaishou_12.4.10.36312.apk"));

        // 注册libandroid.so虚拟模块
        new AndroidModule(emulator, vm).register(memory);

        // 加载目标 libkwsgmain.so
        DalvikModule dm_kwsgmain = vm.loadLibrary("kwsgmain", true);

        // 打印日志
        vm.setVerbose(true);
        // 设置JNI
        vm.setJni(this);

        // 调用JNI OnLoad
        dm_kwsgmain.callJNI_OnLoad(emulator);

        // 一些赋值
        DvmClass ContextWrapper = vm.resolveClass("android/content/ContextWrapper");
//        cNative = vm.resolveClass("com/kuaishou/android/security/internal/dispatch/JNICLibrary/JNICLibrary", ContextWrapper);
//        module = dm.getModule();
        APP_Context = vm.resolveClass("com/yxcorp/gifshow/App").newObject(null);
        System.out.println("Unidbg创建实例完成-->end");
    }

    // 补： callObjectMethodV，本地非静态方法(有返回Object)调用
    @Override
    public DvmObject<?> callObjectMethodV(BaseVM vm, DvmObject<?> dvmObject, String signature, VaList vaList) {
        System.out.println("补环境：重载callObjectMethodV-->" + signature);
        switch (signature) {
            case "com/yxcorp/gifshow/App->getPackageCodePath()Ljava/lang/String;": {
                return new StringObject(vm, "/data/app/com.smile.gifmaker-q14Fo0PSb77vTIOM1-iEqQ==/base.apk");
            }
            case "com/yxcorp/gifshow/App->getPackageName()Ljava/lang/String;": {
                return new StringObject(vm, "com.smile.gifmaker");
            }
            case "com/yxcorp/gifshow/App->getAssets()Landroid/content/res/AssetManager;": {
//                return new Long(vm, "3817726272");
                return new AssetManager(vm, signature);
            }
            case "com/yxcorp/gifshow/App->getPackageManager()Landroid/content/pm/PackageManager;": {
                DvmClass clazz = vm.resolveClass("android/content/pm/PackageManager");
                return clazz.newObject(signature);
            }
        }
        return super.callObjectMethodV(vm, dvmObject, signature, vaList);
    }

    // 补： callStaticObjectMethodV，本地静态方法(有返回Object)调用
    @Override
    public DvmObject<?> callStaticObjectMethodV(BaseVM vm, DvmClass dvmClass, String signature, VaList vaList) {
        System.out.println("补环境：重载callStaticObjectMethodV-->" + signature);
        switch (signature) {
            case "com/kuaishou/android/security/internal/common/ExceptionProxy->getProcessName(Landroid/content/Context;)Ljava/lang/String;": {
                return new StringObject(vm, "com.smile.gifmaker");
            }
        }
        return super.callStaticObjectMethodV(vm, dvmClass, signature, vaList);
    }

    // 补： callStaticObjectMethodV，本地静态方法(无返回)调用
    @Override
    public void callStaticVoidMethodV(BaseVM vm, DvmClass dvmClass, String signature, VaList vaList) {
        System.out.println("补环境：重载callStaticVoidMethodV-->" + signature);
        switch (signature) {
            case "com/kuaishou/android/security/internal/common/ExceptionProxy->nativeReport(ILjava/lang/String;)V": {
                return;
            }
        }
        super.callStaticVoidMethodV(vm, dvmClass, signature, vaList);
    }

    // 补： callStaticObjectMethodV，本地方法(有返回Int)调用
    @Override
    public int callIntMethodV(BaseVM vm, DvmObject<?> dvmObject, String signature, VaList vaList) {
        System.out.println("补环境：重载callIntMethodV-->" + signature + "=" + dvmObject.getValue());
        switch (signature) {
            case "java/lang/Integer->intValue()I": {
                if ((Integer) dvmObject.getValue() == 0) {
                    return 0;
                }
                if ((Integer) dvmObject.getValue() == -1) {
                    return -1;
                }
            }
        }
        return super.callIntMethodV(vm, dvmObject, signature, vaList);
    }

    // 补： callStaticObjectMethodV，本地方法(有返回Bool)调用
    @Override
    public boolean callBooleanMethodV(BaseVM vm, DvmObject<?> dvmObject, String signature, VaList vaList) {
        System.out.println("补环境：重载callBooleanMethodV-->" + signature + "=" + dvmObject.getValue());
        switch (signature) {
            case "java/lang/Boolean->booleanValue()Z": {
                if ((Boolean) dvmObject.getValue()) {
                    return true;
                }
                if (!((Boolean) dvmObject.getValue())) {
                    return false;
                }
            }
        }
        return super.callBooleanMethodV(vm, dvmObject, signature, vaList);
    }

    // 补：重载resolve，文件访问
    @Override
    public FileResult resolve(Emulator emulator, String pathname, int oflags) {
        System.out.println("补环境：重载resolve-->" + pathname);
        return null;
    }
}