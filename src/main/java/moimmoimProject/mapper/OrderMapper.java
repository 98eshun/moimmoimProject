package moimmoimProject.mapper;

import moimmoimProject.domain.ticketDomain.OrderDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderMapper {

    OrderDo findByUserIdNum(@Param("userIdNum") Long userIdNum);

    OrderDo findByMoimNum(@Param("moimNum") Long moimNum);

    //최대 주문 확인용
//    String getMaxOrderNum(Long moimNum);

    void insertOrder(OrderDo orderDo);

    OrderDo findByOrderNum(String orderNum);

    void deleteByOrderNum(String orderNum);

    int countByMoimNumAndOrderStatus(Long moimNum, String orderStatus);

    void updateOrderStatus(@Param("orderNum") String orderNum, @Param("orderStatus") String orderStatus);
}
