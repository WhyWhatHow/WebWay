package Util;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/*
 * 通过配置文件的方式获取主机号，与端口号的方式，应该效果会更好，如果以后会存在修改ip的行为，以为着要重新编码，才可以执行
 * 所以从适用性范围讲，配置文件获取用户ip地址与端口号更为合适，从运行速率来讲，直接写的快一点（static，只执行一次）
 * jedis jar包的好处是方法名与 redis command 类似，所以可以不考虑，
 * redis 的应用范围： 高并发系统，秒杀，抢购 
 * date ： 2018.11.09
 */
public class JedisUtils {

	private final static JedisPool POOL;
	static {
		 JedisPoolConfig config = new JedisPoolConfig();
		 config.setMaxTotal(50); // set max link num
		 config.setMaxIdle(10); // set free link num
		 POOL = new JedisPool(config, "192.168.80.128",6379);
		 
	}
	public static Jedis getJedis() {
		return POOL.getResource();
	}
	@Test
	public void run () {
		Jedis jedis = getJedis();
		jedis.set("gender", "male");
		System.out.println(jedis.get("gender"));
		
	}

}
