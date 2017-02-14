package com.orhanobut.logger;

public interface Printer {
    void clear();

    void d(String str, Object... objArr);

    void e(String str, Object... objArr);

    void e(Throwable th, String str, Object... objArr);

    Settings getSettings();

    void i(String str, Object... objArr);

    Settings init(String str);

    void json(String str);

    Printer t(String str, int i);

    void v(String str, Object... objArr);

    void w(String str, Object... objArr);

    void wtf(String str, Object... objArr);

    void xml(String str);
}
