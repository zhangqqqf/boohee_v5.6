package com.xiaomi.xmpush.thrift;

import com.joooonho.BuildConfig;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum s$a {
    DEBUG((short) 1, BuildConfig.BUILD_TYPE),
    TARGET((short) 2, "target"),
    ID((short) 3, "id"),
    APP_ID((short) 4, "appId"),
    TOPIC((short) 5, "topic"),
    PACKAGE_NAME((short) 6, "packageName"),
    CATEGORY((short) 7, "category");

    private static final Map<String, s$a> h = null;
    private final short  i;
    private final String j;

    static {
        h = new HashMap();
        Iterator it = EnumSet.allOf(s$a.class).iterator();
        while (it.hasNext()) {
            s$a com_xiaomi_xmpush_thrift_s_a = (s$a) it.next();
            h.put(com_xiaomi_xmpush_thrift_s_a.a(), com_xiaomi_xmpush_thrift_s_a);
        }
    }

    private s$a(short s, String str) {
        this.i = s;
        this.j = str;
    }

    public String a() {
        return this.j;
    }
}
