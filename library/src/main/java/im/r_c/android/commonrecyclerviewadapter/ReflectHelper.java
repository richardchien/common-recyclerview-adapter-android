package im.r_c.android.commonrecyclerviewadapter;

import java.lang.reflect.Method;

/**
 * CommonAdapter
 * Created by richard on 16/1/8.
 */
public class ReflectHelper {
    public static void invokeMethodIfExists(String methodName, Object target, Class<?>[] paramTypes, Object... params) {
        Class<?> c = target.getClass();
        try {
            Method method = c.getMethod(methodName, paramTypes);
            method.invoke(target, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void invokeMethodIfExists(String methodName, Object target, Object[] params) {
        Class<?> c = target.getClass();
        Method[] methods = c.getMethods();
        Method matchedMethod = null;
        for (Method m : methods) {
            if (!m.getName().equals(methodName)) {
                continue;
            }

            Class<?>[] types = m.getParameterTypes();

            if (types.length != params.length) {
                continue;
            }

            boolean matched = true;
            final int len = params.length;
            for (int i = 0; i < len; i++) {
                if (!types[i].isInstance(params[i])) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                matchedMethod = m;
                break;
            }
        }
        if (matchedMethod != null) {
            try {
                matchedMethod.invoke(target, params);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
