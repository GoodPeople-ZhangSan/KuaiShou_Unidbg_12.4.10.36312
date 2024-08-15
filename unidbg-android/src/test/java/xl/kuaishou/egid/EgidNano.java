package xl.kuaishou.egid;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;

import java.io.IOException;


public class EgidNano extends MessageNano {

    public static volatile EgidNano egidNanoAll;
    public String a1 = "KWE_NC";
    public String a2 = "KWE_NPN";
    public String a3 = "com.smile.gifmaker";
    public String a4 = "KWE_NC";
    public String a5 = "";
    public String a6 = "0";
    public String a7 = "";
    public String a8 = "user";
    public String a9 = "KWE_NPN";
    public String a10 = "0";
    public String a11 = "0";
    public String a12 = "KWE_NPN";
    public String a13 = "KWE_NC";
    public String a14 = "AND";
    public String a15 = "KWE_NC";
    public String a16 = "";
    public String a17 = "KWE_N";
    public String a18 = "KWE_NPN";
    public String a19 = "oriole";
    public String a20 = "KWE_NC";
    public String a21 = "KWE_NC";
    public String a22 = "";
    public String a23 = "";
    public String a24 = "KWE_NC";
    public String a25 = "0";
    public String a26 = "armeabi-v7a,armeabi";
    public String a27 = "";
    public String a28 = "oriole";
    public String a29 = "";
    public String a30 = "";
    public String a31 = "KWE_NU";
    public String a32 = "KWE_NC";
    public String a33 = "KWE_NPN";
    public String a34 = "";
    public String a35 = "";
    public String a36 = "";
    public String a37 = "";
    public String a38 = "KWE_NC";
    public String a39 = "";
    public String a40 = "";
    public String a41 = "KWE_NPN";
    public String a42 = "KWE_NC";
    public String a43 = "KWE_NPN";
    public String a44 = "release-keys";
    public String a45 = "KWE_NC";
    public String a46 = "";
    public String a47 = "";
    public String a48 = "KWE_NC";
    public String a49 = "0";
    public String a50 = "KWE_NC";
    public String a51 = "KWE_NC";
    public String a52 = "oriole";
    public String a53 = "KWE_NC";
    public String a54 = "KWE_NPN";
    public String a55 = "KWE_NPN";
    public String a56 = "KWE_NC";
    public String a57 = "KWE_NU";
    public String a58 = "oriole";
    public String a59 = "0";
    public String a60 = "unknown";
    public String a61 = "";
    public String a62 = "KWE_NC";
    public String a63 = "android-build";
    public String a64 = "KWE_N";
    public String a65 = "KWE_NC";
    public String a66 = "KWE_NPN";
    public String a67 = "KWE_N";
    public String a68 = "KWE_NPN";
    public String a69 = "KWE_NC";
    public String a70 = "KWE_NC";
    public String a71 = "KWE_NPN";
    public String a72 = "KWE_NC";
    public String a73 = "KWE_NPN";
    public String a74 = "KWE_NPN";
    public String a75 = "KWE_NPN";
    public String a76 = "KWE_NC";
    public String a77 = "KWE_NPN";
    public String a78 = "KWE_NC";
    public String a79 = "KWE_NC";
    public String a80 = "KWE_NC";
    public String a81 = "KWE_NC";
    public String a82 = "KWE_NPN";
    public String a83 = "KWE_FIRST";
    public String a84 = "";
    public String a85 = "KWE_N";
    public String a86 = "KWE_N";
    public String a87 = "KWE_N";
    public String a88 = "noexsist";
    public String a89 = "";
    public String a90 = "KWE_NC";
    public String a91 = "KWE_NC";
    public String a92 = "";
    public String a93 = "";
    public String a94 = "KWE_N";
    public String a95 = "KWE_NS";
    public String a96 = "";
    public String a97 = "KWE_N";
    public String a98 = "KWE_N";
    public String a99 = "KWE_N";
    public String a100 = "KWE_N";
    public String a101 = "KWE_N";
    public String a102 = "";
    public String a103 = "KWE_NC";
    public String a104 = "KWE_NC";
    public String a105 = "";
    public String a106 = "";
    public String a107 = "2";
    public String a108 = "{}";
    public String a109 = "KWE_N";
    public String a110 = "";
    public String a111 = "";
    public String a112 = "";
    public String a113 = "KWE_N";
    public String a114 = "KWE_NPN";
    public String a115 = "KWE_NC";
    public String a116 = "KWE_NC";
    public String a117 = "KWE_NC";
    public String a118 = "KWE_NC";
    public String a119 = "";

    @Override // com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        // 假设有一个数组或类似结构存储了所有的字符串，注意：这里需要您自己填充或动态获取这些值
        String[] fields = {this.a1, this.a2, this.a3, this.a4, this.a5, this.a6, this.a7, this.a8, this.a9, this.a10, this.a11, this.a12, this.a13, this.a14, this.a15, this.a16, this.a17, this.a18, this.a19, this.a20, this.a21, this.a22, this.a23, this.a24, this.a25, this.a26, this.a27, this.a28, this.a29, this.a30, this.a31, this.a32, this.a33, this.a34, this.a35, this.a36, this.a37, this.a38, this.a39, this.a40, this.a41, this.a42, this.a43, this.a44, this.a45, this.a46, this.a47, this.a48, this.a49, this.a50, this.a51, this.a52, this.a53, this.a54, this.a55, this.a56, this.a57, this.a58, this.a59, this.a60, this.a61, this.a62, this.a63, this.a64, this.a65, this.a66, this.a67, this.a68, this.a69, this.a70, this.a71, this.a72, this.a73, this.a74, this.a75, this.a76, this.a77, this.a78, this.a79, this.a80, this.a81, this.a82, this.a83, this.a84, this.a85, this.a86, this.a87, this.a88, this.a89, this.a90, this.a91, this.a92, this.a93, this.a94, this.a95, this.a96, this.a97, this.a98, this.a99, this.a100, this.a101, this.a102, this.a103, this.a104, this.a105, this.a106, this.a107, this.a108, this.a109, this.a110, this.a111, this.a112, this.a113, this.a114, this.a115, this.a116, this.a117, this.a118, this.a119};
        // 使用循环来遍历所有的字符串字段
        for (int i = 0; i < fields.length; i++) {
            if (!fields[i].equals("")) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(i + 1, fields[i]);
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {

        // 假设有一个数组或类似结构存储了所有的字符串，注意：这里需要您自己填充或动态获取这些值
        String[] fields = {this.a1, this.a2, this.a3, this.a4, this.a5, this.a6, this.a7, this.a8, this.a9, this.a10, this.a11, this.a12, this.a13, this.a14, this.a15, this.a16, this.a17, this.a18, this.a19, this.a20, this.a21, this.a22, this.a23, this.a24, this.a25, this.a26, this.a27, this.a28, this.a29, this.a30, this.a31, this.a32, this.a33, this.a34, this.a35, this.a36, this.a37, this.a38, this.a39, this.a40, this.a41, this.a42, this.a43, this.a44, this.a45, this.a46, this.a47, this.a48, this.a49, this.a50, this.a51, this.a52, this.a53, this.a54, this.a55, this.a56, this.a57, this.a58, this.a59, this.a60, this.a61, this.a62, this.a63, this.a64, this.a65, this.a66, this.a67, this.a68, this.a69, this.a70, this.a71, this.a72, this.a73, this.a74, this.a75, this.a76, this.a77, this.a78, this.a79, this.a80, this.a81, this.a82, this.a83, this.a84, this.a85, this.a86, this.a87, this.a88, this.a89, this.a90, this.a91, this.a92, this.a93, this.a94, this.a95, this.a96, this.a97, this.a98, this.a99, this.a100, this.a101, this.a102, this.a103, this.a104, this.a105, this.a106, this.a107, this.a108, this.a109, this.a110, this.a111, this.a112, this.a113, this.a114, this.a115, this.a116, this.a117, this.a118, this.a119};
        // 使用循环来遍历所有的字符串字段
        for (int i = 0; i < fields.length; i++) {
            if (!fields[i].equals("")) {
                codedOutputByteBufferNano.writeString(i + 1, fields[i]);
            }
        }

        super.writeTo(codedOutputByteBufferNano);
    }

    @Override
    public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int readTag = codedInputByteBufferNano.readTag();
        System.out.println("readTag=" + readTag);
        return null;
    }
}