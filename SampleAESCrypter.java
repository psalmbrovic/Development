import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public class SampleAESCrypter {
    private IvParameterSpec ivspec;
    private SecretKeySpec keyspec;
    private Cipher cipher;
    public static void main(String args[]) throws UnsupportedEncodingException, Exception {
        System.out.println(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        SampleAESCrypter crypta = new SampleAESCrypter("4l9RuaBnP1cxUyga", "BNwMSWaiuWmmgMIa");
        String toenc = "{\n" + //
                "    \"sourceInstitutionCode\": \"999998\",\n" + //
                "    \"channelCode\": \"1\",\n" + //
                "    \"sessionId\": \"999001240705171444338881364022\"\n" + //
                "}";
        String enc = "";
        enc = crypta.encrypt(toenc);
        System.out.println(" ENCED : " + enc);
    }
    public SampleAESCrypter(String keyz, String ivStr) {
        ivspec = new IvParameterSpec(ivStr.getBytes());
        keyspec = new SecretKeySpec(keyz.getBytes(), "AES");
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }
    public SampleAESCrypter() {
    }
    public String encrypt(String text) throws Exception {
        System.out.println("text = " + text);
        if (text == null || text.length() == 0) {
            throw new Exception("Empty string");
        }
        byte[] encrypted = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            encrypted = cipher.doFinal(text.getBytes("UTF-8"));
        } catch (Exception e) {
            throw new Exception("[encrypt] " + e.getMessage());
        }
        return bytesToHex(encrypted);
    }
    public static String bytesToHex(byte[] data) {
        if (data == null) {
            return null;
        }
        int len = data.length;
        String str = "";
        for (int i = 0; i < len; i++) {
            if ((data[i] & 0xFF) < 16) {
                str = str + "0" + java.lang.Integer.toHexString(data[i] & 0xFF);
            } else {
                str = str + java.lang.Integer.toHexString(data[i] & 0xFF);
            }
        }
        return str;
    }
    public static byte[] hexToBytes(String str) {
        if (str == null) {
            return null;
        } else if (str.length() < 2) {
            return null;
        } else {
            int len = str.length() / 2;
            byte[] buffer = new byte[len];
            for (int i = 0; i < len; i++) {
                buffer[i] = (byte) Integer.parseInt(str.substring(i * 2, i * 2 + 2), 16);
            }
            return buffer;
        }
    }
}