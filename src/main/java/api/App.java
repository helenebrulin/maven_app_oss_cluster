package api;

import java.util.HashSet;
import java.util.Set;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * An OSS Cluster API test
 *
 * @author david.maier@redislabs.com
 */
public class App {

    public static final String HOST = "34.76.182.145";
    public static final int PORT = 11833;
    public static final int NUM_KEYS = 100000;

    public static void main(String[] args) {

        //Bootstrap the client
        Set<HostAndPort> jedisClusterNodes = new HashSet<>();
        jedisClusterNodes.add(new HostAndPort(HOST, PORT));
        JedisCluster jc = new JedisCluster(jedisClusterNodes);

        for (int i = 0; i < NUM_KEYS; i++) {

            jc.set("hello:" + i, "Hello world! #" + i);
            jc.get("hello:" + i);
        }
    }
}