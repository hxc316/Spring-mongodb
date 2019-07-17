package boot.spring.dao;

import boot.spring.po.OrderLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderLogRepository extends MongoRepository<OrderLog,String> {

    OrderLog findByOrderNo(String id);
}
