package boot.spring.service;

import boot.spring.dao.OrderLogRepository;
import boot.spring.po.OrderLog;
import boot.spring.po.OrderLogDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderLogService {
    @Autowired
    private OrderLogRepository orderLogRepository;

    public void add(){
        OrderLog orderLog = new OrderLog("NO002","CONFIRM",null);
        orderLogRepository.save(orderLog);
    }

    public void addLog(String orderNo,OrderLogDetail log){
        OrderLog one = orderLogRepository.findByOrderNo(orderNo);
        if(one.getLogDetails() == null){
            List<OrderLogDetail> list = new ArrayList<>(1);
            list.add(log);
            one.setLogDetails(list);
        }else {
            one.getLogDetails().add(log);
        }

        orderLogRepository.save(one);
    }

    public void find(){

    }
}
