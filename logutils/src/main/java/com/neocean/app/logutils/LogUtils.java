package com.neocean.app.logutils;

import android.util.Log;


/**
 * User weixn
 * Date 2019/6/6
 */
public class LogUtils {
    private static boolean IS_SHOW_LOG = true;

    private static final int V = 0x1;
    private static final int D = 0x2;
    private static final int I = 0x3;
    private static final int W = 0x4;
    private static final int E = 0x5;
    private static final int A = 0x6;

    /**
     * 建议写在 Application中全局把控
     * 是否显示log
     *
     * @param isShowLog
     */
    public static void init(boolean isShowLog) {
        IS_SHOW_LOG = isShowLog;
    }


    public static boolean isIsShowLog() {
        return IS_SHOW_LOG;
    }


    /**
     * Log.V
     * @param msg
     */
    public static void v(Object msg) {
        printLog(V, null, msg);
    }

    public static void v(String tag, String msg) {
        printLog(V, tag, msg);
    }

    public static void vl(Object msg) {
        printLogWithLine(V, null, msg);
    }

    public static void vl(String tag, String msg) {
        printLogWithLine(V, tag, msg);
    }


    /**
     * Log.D
     * @param msg
     */
    public static void d(Object msg) {
        printLog(D, null, msg);
    }

    public static void d(String tag, Object msg) {
        printLog(D, tag, msg);
    }

    public static void dl(Object msg) {
        printLogWithLine(D, null, msg);
    }

    public static void dl(String tag, String msg) {
        printLogWithLine(D, tag, msg);
    }


    /**
     * Log.I
     * @param msg
     */
    public static void i(Object msg) {
        printLog(I, null, msg);
    }

    public static void i(String tag, Object msg) {
        printLog(I, tag, msg);
    }


    public static void il(Object msg) {
        printLogWithLine(I, null, msg);
    }

    public static void il(String tag, String msg) {
        printLogWithLine(I, tag, msg);
    }


    /**
     * Log.W
     * @param msg
     */
    public static void w(  Object msg) {
        printLog(W, null, msg);
    }

    public static void w(String tag, Object msg) {
        printLog(W, tag, msg);
    }

    public static void wl(Object msg) {
        printLogWithLine(W, null, msg);
    }

    public static void wl(String tag, String msg) {
        printLogWithLine(W, tag, msg);
    }


    /**
     * Log.E
     * @param msg
     */
    public static void e(Object msg) {
        printLog(E, null, msg);
    }

    public static void e(String tag, Object msg) {
        printLog(E, tag, msg);
    }

    public static void el(Object msg) {
        printLogWithLine(E, null, msg);
    }

    public static void el(String tag, String msg) {
        printLogWithLine(E, tag, msg);
    }


    /**
     * Log.A
     * @param msg
     */
    public static void a(Object msg) {
        printLog(A, null, msg);
    }

    public static void a(String tag, Object msg) {
        printLog(A, tag, msg);
    }

    public static void al(Object msg) {
        printLogWithLine(A, null, msg);
    }

    public static void al(String tag, String msg) {
        printLogWithLine(A, tag, msg);
    }


    private static void printLog(int type, String tagStr, Object objectMsg) {
        String msg;
        if (!IS_SHOW_LOG) {
            return;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        int index = 4;
        String className = stackTrace[index].getFileName();
        String methodName = stackTrace[index].getMethodName();
        int lineNumber = stackTrace[index].getLineNumber();

        String tag = (tagStr == null ? className : tagStr);
        methodName = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ (").append(className).append(":").append(lineNumber).append(")#").append(methodName).append(" ] ");

        if (objectMsg == null) {
            msg = "传入对象不能为空";
        } else {
            msg = objectMsg.toString();
        }
        stringBuilder.append(msg);


        String logStr = stringBuilder.toString();

        switch (type) {
            case V:
                Log.v(tag, logStr);
                break;
            case D:
                Log.d(tag, logStr);
                break;
            case I:
                Log.i(tag, logStr);
                break;
            case W:
                Log.w(tag, logStr);
                break;
            case E:
                Log.e(tag, logStr);
                break;
            case A:
                Log.wtf(tag, logStr);
                break;
        }

    }


    private static void printLogWithLine(int type, String tagStr, Object objectMsg) {
        String msg;
        if (!IS_SHOW_LOG) {
            return;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        int index = 4;
        String className = stackTrace[index].getFileName();
        String methodName = stackTrace[index].getMethodName();
        int lineNumber = stackTrace[index].getLineNumber();

        String tag = (tagStr == null ? className : tagStr);
        methodName = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ (").append(className).append(":").append(lineNumber).append(")#").append(methodName).append(" ] ");

        if (objectMsg == null) {
            msg = "传入对象不能为空";
        } else {
            msg = objectMsg.toString();
        }
        stringBuilder.append(msg);


        String logStr = stringBuilder.toString();

        printLine(type, tag, true);
        spiltLog(type, tag, logStr);
        printLine(type, tag, false);
    }


    /**
     * 分割显示
     *
     * @param type
     * @param tag
     * @param logStr
     */
    private static void spiltLog(int type, String tag, String logStr) {
        if (logStr.length() > 4000) {
            showSpiltLog(type, tag, logStr);

        } else {
            switch (type) {
                case V:
                    Log.v(tag, logStr);
                    break;
                case D:
                    Log.d(tag, logStr);
                    break;
                case I:
                    Log.i(tag, logStr);
                    break;
                case W:
                    Log.w(tag, logStr);
                    break;
                case E:
                    Log.e(tag, logStr);
                    break;
                case A:
                    Log.wtf(tag, logStr);
                    break;
            }
        }
    }


    /**
     * 分割处理
     *
     * @param type
     * @param tag
     * @param logStr
     */
    private static void showSpiltLog(int type, String tag, String logStr) {
        for (int i = 0; i < logStr.length(); i += 4000) {
            if (i + 4000 < logStr.length()) {
                switch (type) {
                    case V:
                        Log.v(tag, logStr.substring(i, i + 4000));
                        break;
                    case D:
                        Log.d(tag, logStr.substring(i, i + 4000));
                        break;
                    case I:
                        Log.i(tag, logStr.substring(i, i + 4000));
                        break;
                    case W:
                        Log.w(tag, logStr.substring(i, i + 4000));
                        break;
                    case E:
                        Log.e(tag, logStr.substring(i, i + 4000));
                        break;
                    case A:
                        Log.wtf(tag, logStr.substring(i, i + 4000));
                        break;
                }
            } else {
                switch (type) {
                    case V:
                        Log.v(tag, logStr.substring(i, logStr.length()));
                        break;
                    case D:
                        Log.d(tag, logStr.substring(i, logStr.length()));
                        break;
                    case I:
                        Log.i(tag, logStr.substring(i, logStr.length()));
                        break;
                    case W:
                        Log.w(tag, logStr.substring(i, logStr.length()));
                        break;
                    case E:
                        Log.e(tag, logStr.substring(i, logStr.length()));
                        break;
                    case A:
                        Log.wtf(tag, logStr.substring(i, logStr.length()));
                        break;
                }

            }
        }
    }


    final static String STARTLINE = "╔═══════════════════════════════════════════════════════════════════════════════════════";
    final static String ENDLINE = "╚═══════════════════════════════════════════════════════════════════════════════════════";

    /**
     * 控制是否打印“标签”
     *
     * @param type
     * @param isTop
     */
    private static void printLine(int type, String tag, boolean isTop) {
        if (isTop) {

            switch (type) {
                case V:
                    Log.v(tag, STARTLINE);
                    break;
                case D:
                    Log.d(tag, STARTLINE);
                    break;
                case I:
                    Log.i(tag, STARTLINE);
                    break;
                case W:
                    Log.w(tag, STARTLINE);
                    break;
                case E:
                    Log.e(tag, STARTLINE);
                    break;
                case A:
                    Log.wtf(tag, STARTLINE);
                    break;
            }

        } else {

            switch (type) {
                case V:
                    Log.v(tag, ENDLINE);
                    break;
                case D:
                    Log.d(tag, ENDLINE);
                    break;
                case I:
                    Log.i(tag, ENDLINE);
                    break;
                case W:
                    Log.w(tag, ENDLINE);
                    break;
                case E:
                    Log.e(tag, ENDLINE);
                    break;
                case A:
                    Log.wtf(tag, ENDLINE);
                    break;
            }
        }
    }
}
