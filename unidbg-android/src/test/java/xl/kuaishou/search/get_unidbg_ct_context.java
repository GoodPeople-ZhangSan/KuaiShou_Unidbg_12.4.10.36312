package xl.kuaishou.search;

import com.alibaba.fastjson.JSONObject;
import com.github.unidbg.AndroidEmulator;
import com.github.unidbg.Emulator;
import com.github.unidbg.Module;
import com.github.unidbg.arm.backend.DynarmicFactory;
import com.github.unidbg.arm.backend.HypervisorFactory;
import com.github.unidbg.file.FileResult;
import com.github.unidbg.file.IOResolver;
import com.github.unidbg.linux.android.AndroidEmulatorBuilder;
import com.github.unidbg.linux.android.AndroidResolver;
import com.github.unidbg.linux.android.dvm.*;
import com.github.unidbg.linux.android.dvm.jni.ProxyDvmObject;
import com.github.unidbg.memory.Memory;
import com.github.unidbg.virtualmodule.android.AndroidModule;
import xl.kuaishou.KuaiShou_Main;
import xl.kuaishou.iPhone;

import java.io.File;

public class get_unidbg_ct_context extends AbstractJni implements IOResolver {
    // Unidbg所需参数
    private static AndroidEmulator emulator = KuaiShou_Main.emulator;
    private static VM vm=KuaiShou_Main.vm;

    static {
        new get_unidbg_ct_context();
    }

    public get_unidbg_ct_context() {
        System.out.println("创建ct__context实例-->Start");
        // 获取模拟器的内存操作接口
        final Memory memory = emulator.getMemory();
        // 设置多线程处理
//        emulator.getSyscallHandler().setEnableThreadDispatcher(true);

        // 设置系统类库解析
        memory.setLibraryResolver(new AndroidResolver(23));

        // 注册libandroid.so虚拟模块
        new AndroidModule(emulator, vm).register(memory);

        // 加载目标 libkwsgmain.so
        DalvikModule dm = vm.loadLibrary("ktrace", true);

        // 打印日志
        vm.setVerbose(true);
        // 设置JNI
        vm.setJni(this);

        // 调用JNI OnLoad
//        dm.callJNI_OnLoad(emulator);
        System.out.println("Unidbg创建实例完成-->end");

    }


    public static String set_ct_context() {
        // 构造 construct 所需参数，获取返回值
//        DvmObject<?> construct_arg0 = vm.resolveClass("com/kwai/infra/ITraceHost").newObject(null);
        iPhone construct_arg0 = new iPhone();
        JSONObject construct_arg1 = new JSONObject();
        construct_arg1.put("enabled", true);
        construct_arg1.put("inWhiteList", true);
        construct_arg1.put("sampleRate", 1.0);
        construct_arg1.put("sampleOnError", 0.0);

        String construct_arg2 = "CLIENT_TRACE";
        String construct_arg3 = iPhone.DID;

        // 加载 construct，先把类找到，这里的原理很像反射
        DvmClass doCommandNative_dvmclass_construct_nativeCreateTrace = vm.resolveClass("com.kwai.infra.TraceManager");
        System.out.println("开始调用construct方法");

        long construct = doCommandNative_dvmclass_construct_nativeCreateTrace.callStaticJniMethodLong(emulator, "construct([Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)l", ProxyDvmObject.createObject(vm, construct_arg0), construct_arg1.toString(), construct_arg2, construct_arg3);
        System.out.println("construct为：" + construct);
        // 获得结果，作为 nativeCreateTrace 的第一个参数
        long nativeCreateTrace = doCommandNative_dvmclass_construct_nativeCreateTrace.callStaticJniMethodLong(emulator, "nativeCreateTrace(l;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)l", construct, "ATTRIBUTION", "");
        System.out.println("nativeCreateTrace为：" + nativeCreateTrace);
//        nativeCreateTrace =3491940464L;
        // 获得结果，作为 getTraceContext 的第一个参数
        DvmClass doCommandNative_dvmclass_getTraceContext = vm.resolveClass("com.kwai.infra.Segment");
        Object getTraceContext = doCommandNative_dvmclass_getTraceContext.callStaticJniMethodObject(emulator, "getTraceContext(l;)Ljava.lang.String;", nativeCreateTrace);
        System.out.println("getTraceContext为：" + getTraceContext);
        return getTraceContext.toString();
    }



    // 补：重载resolve，文件访问
    @Override
    public FileResult resolve(Emulator emulator, String pathname, int oflags) {
        System.out.println("补环境：重载resolve-->" + pathname);
        return null;
    }
}

