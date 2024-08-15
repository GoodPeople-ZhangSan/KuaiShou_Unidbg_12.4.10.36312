package xl.kuaishou.selection;

import java.util.Random;

public class getSelectionHeader {

    // Selection 中 X-REQUESTID的值
    public static String getSelectionHeader_REQUESTID() {
        Random random = new Random();
        return String.valueOf(System.currentTimeMillis() + random.nextInt(100000));
    }
}
