package cn.bigcoder.tcctransaction.demo2.tcctransaction.config;

import org.mengyun.tcctransaction.repository.RedisTransactionRepository;
import org.mengyun.tcctransaction.repository.TransactionRepository;
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
        repository.setDomain("TCC:DUBBO:INVENTORY:");
        repository.setRootDomain("TCC:DUBBO:ORDER");
        repository.setJedisPool(jedisPool);
        return repository;
    }

}
