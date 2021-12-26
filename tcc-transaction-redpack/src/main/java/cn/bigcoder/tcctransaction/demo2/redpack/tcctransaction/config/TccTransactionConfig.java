package cn.bigcoder.tcctransaction.demo2.redpack.tcctransaction.config;

import org.mengyun.tcctransaction.repository.RedisTransactionRepository;
import org.mengyun.tcctransaction.repository.TransactionRepository;
import org.mengyun.tcctransaction.serializer.JacksonTransactionSerializer;
import org.mengyun.tcctransaction.serializer.KryoTransactionSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-04
 **/
@Configuration
public class TccTransactionConfig {
    //内存
    //@Bean("transactionRepository")
    //public TransactionRepository memoryStoreTransactionRepository(){
    //    MemoryStoreTransactionRepository repository = new MemoryStoreTransactionRepository();
    //    repository.setDomain("TCC:DUBBO:CAPITAL:");
    //    return repository;
    //}

    //redis
    @Bean("transactionRepository")
    public TransactionRepository memoryStoreTransactionRepository2(JedisPool jedisPool) {
        RedisTransactionRepository repository = new RedisTransactionRepository();
        repository.setDomain("TCC:DUBBO:REDPACK:");
        repository.setSerializer(new KryoTransactionSerializer());
        repository.setJedisPool(jedisPool);
        return repository;
    }

}
