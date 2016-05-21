package manage;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Leo
 * @date 2016年5月6日上午11:29:31
 * @description
 * @usage
 */

public class InstanceManager {
	/**
	 * key:接口或类的class<br>
	 * value:一个或多个对应的key的实例
	 */
	private static ConcurrentHashMap<Class<?>, Set<Object>> instancePool;
	/**
	 * 初始化
	 */
	static {
		instancePool = new ConcurrentHashMap<>();
		// InstanceManager.put(ITestService.class, new TestServiceImp());
	}

	public static <T> T get(Class<T> key, Class<?> instanceClass) {
		Set<Object> instanceSet = instancePool.get(key);
		if (instanceSet != null) {
			for (Object instance : instanceSet) {
				if (instance.getClass() == instanceClass) {
					return (T) instance;
				}
			}
		}
		return null;
	}

	public static void put(Class<?> key, Object instance) {
		Set<Object> instanceSet = instancePool.get(key);
		if (instanceSet == null) {
			instanceSet = new HashSet<>();
		}
		instanceSet.add(instance);
		instancePool.put(key, instanceSet);
	}
}
