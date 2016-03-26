package redis;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {

	private static JedisPool jedisPool;
	private static Lock lock = new ReentrantLock();

	public static Jedis getResource() {
		if (jedisPool == null) {
			lock.lock();
			try {
				if (jedisPool == null) {
					JedisPoolConfig cfg = new JedisPoolConfig();
					cfg.setMaxIdle(5);
					cfg.setMaxTotal(10);
					cfg.setMaxWaitMillis(150000);
					jedisPool = new JedisPool(cfg, "127.0.0.1");
				}
			} finally {
				lock.unlock();
			}
		}
		return jedisPool.getResource();
	}

	public static void returnResource(Jedis jedis) {
		if (jedis != null) {
			jedisPool.returnResource(jedis);
		}
	}
}
