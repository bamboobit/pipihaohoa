package com.pipihaohao.demo.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Auther: xfh
 * @Date: 2019/5/14
 * @Description:
 */
public class ExceptionUtil {
    /**
     * 获取异常的堆栈信息
     *
     * @param t
     * @return
     */
    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        try {
            t.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }
}
