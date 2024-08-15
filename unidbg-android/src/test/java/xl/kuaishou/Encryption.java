package xl.kuaishou;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;

// 加密算法类
public class Encryption {
    // md5运算
    public static String md5_Encrypt(String content) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(content.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("NoSuchAlgorithmException", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) {
                hex.append(0);
            }
            hex.append(Integer.toHexString(b & 0xff));
        }

        return hex.toString();
    }

    // Base64 编码 有填充
    public static String Base64_Encrypt(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    // Base64 编码  MIME 编码
    public static String Base64_MimeEncrypt(byte[] bytes) {
        return new String(Base64.getMimeEncoder().encode(bytes)).replace("\r\n", "\n") + "\n";
    }


    // gzip  传进来的参数是 Byte[]  返回的也是 Byte[]
    public static byte[] gZIP(byte[] bArr) {
        byte[] bArr2 = null;
        if (bArr != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                bArr2 = byteArrayOutputStream.toByteArray();
                gZIPOutputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bArr2;
    }

    // AES/CBC/PKCS5Padding 带IV的加密 , 输入输出都是 Byte[]
    public static byte[] AES(byte[] bArr) {
        byte[] key = "46a8qpMw6643TDiV".getBytes();
        String iv = "W3HaJGyGrfOVRb42";
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(iv.getBytes("utf-8")));
            return cipher.doFinal(bArr);
        } catch (Throwable unused) {
            return bArr;
        }
    }

}
