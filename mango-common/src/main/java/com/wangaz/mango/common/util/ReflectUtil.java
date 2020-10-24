package com.wangaz.mango.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectUtil {
	
	public Object execute(Object obj, String methodName,Object params) {
		 try {
	            Class<?> clazz = obj.getClass();
	            Method method = clazz.getMethod(methodName, params.getClass());
	            return method.invoke(clazz.newInstance(), params);
	        }catch (Exception e) {
		}
		 return null;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T execute(Object obj, String methodName) {
		try {
			Method method = obj.getClass().getMethod(methodName);
			return method == null ? null : (T) method.invoke(obj);
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T executePrivate(Object obj, String methodName) {
		try {
			Method methodPrivate = obj.getClass().getDeclaredMethod(methodName);
			methodPrivate.isAccessible();
			methodPrivate.setAccessible(true);// 调private方法
			return (T) methodPrivate.invoke(obj);
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public static <T> T execute(Class<?> clazz, Object obj, String methodName, T value) {
		try {
			if (value == null)
				return null;
			Method func = obj.getClass().getMethod(methodName, value.getClass());
			if (func != null) {
				return (T) func.invoke(obj, value);
			} else {
				return null;
			}
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T executeForPage(Object obj, String methodName, Object param) {
		try {
			if (param == null)
				return null;
			Method func = obj.getClass().getMethod(methodName, param.getClass());
			if (func != null) {
				return (T) func.invoke(obj, param);
			} else {
				return null;
			}
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	public static <T> T executeInt(Object obj, String methodName, int value) {
		try {
			Method func = obj.getClass().getMethod(methodName, int.class);
			return (T) func.invoke(obj, value);
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T executeDouble(Class<?> objclass, Object obj, String methodName, double value) {
		try {
			Method func = objclass.getMethod(methodName, double.class);
			return (T) func.invoke(obj, value);
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T executeFloat(Class<?> objclass, Object obj, String methodName, float value) {
		try {
			Method func = objclass.getMethod(methodName, float.class);
			return (T) func.invoke(obj, value);
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T executeLong(Class<?> objclass, Object obj, String methodName, long value) {
		try {
			Method func = objclass.getMethod(methodName, long.class);
			return (T) func.invoke(obj, value);
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}

}
