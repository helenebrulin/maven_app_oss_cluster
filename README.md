https://spring.io/guides/gs/maven/

Compile:
- mvn compile
- mvn package
- java -jar target/gs-maven-0.1.0.jar

Install:
- mvn install

Notes:
- I installed jdk and mvn with brew
- echo 'export PATH="/usr/local/opt/openjdk/bin:$PATH"' >> ~/.zshrc 
- source ~/.zshrc 

- Need to install slf4j and and commons-pool2 as dependencies as well# maven_app_oss_cluster


- Before you enable Redis OSS Cluster API for a database, make sure that:
  - The database uses the standard hashing policy.
  - The database proxy policy is all-master-shards.
  - The database proxy policy does not use node include or exclude.


You can monitor the shards with
- shard-cli ID monitor
- then check the size of each node with : redis-cli -h IP -p PORT DBSIZE


IMPORTANT:
- to run redis-cli in cluster-mode, use -c
- to tune cluster api to use external IPs and be able to use JedisCluster outside of the cluster:
```sh
tune db db:1 oss_cluster_api_preferred_ip_type external
```