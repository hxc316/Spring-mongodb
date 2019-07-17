import boot.spring.dao.OrderLogRepository;
import boot.spring.po.OrderLog;
import boot.spring.po.OrderLogDetail;
import boot.spring.service.OrderLogService;
import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OrderLogServiceTest extends BaseTest{

    @Autowired
    private OrderLogService orderLogService;
    @Autowired
    private OrderLogRepository orderLogRepository;

    @Test
    public void t(){
        orderLogService.add();
    }

    @Test
    public void addLog(){
        orderLogService.addLog("NO001",new OrderLogDetail(UUID.randomUUID().toString(),"CONFIRM",new Date()));
    }

    @Test
    public void find(){
        OrderLog orderLog = new OrderLog();
        orderLog.setStatus("CONFIRM");
        List<OrderLog> all = orderLogRepository.findAll(Example.of(orderLog));
        System.out.println(new Gson().toJson(all));
    }

}
