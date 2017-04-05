package jdkcontext.cu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhongym on 2017/3/6.
 */
public class BillUtils {
    private static final String DATE_PATTERN="yyMMddHHmmssSSS";
    private static int seed =1;
    public synchronized static  String genSerialCode() {
        if (seed < 1000000) {
            seed++;
        } else {
            seed = 1;
        }
        long l = System.currentTimeMillis()+seed;
        return new SimpleDateFormat(DATE_PATTERN).format(new Date(l));
    }

}
