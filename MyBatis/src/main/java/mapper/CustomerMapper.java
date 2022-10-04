package mapper;

import bean.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {
    List<Customer> selectAll();

    Customer selectByCustId(int id);

    //多条件查询
//    List<Customer> selectByCondition(@Param("cust_name") String cust_name, @Param("cust_state") String cust_state);
//    List<Customer> selectByCondition(Customer customer);
    List<Customer> selectByCondition(Map map);

    List<Customer> selectBySingleCondition(Customer customer);

    void add(Customer customer);

    @Insert("insert into customers (cust_name) values (#{custName});")
    void addByCustName(String custName);

    void update(Customer customer);

    void deleteByCustId(Customer customer);

    void deleteByCustNames(@Param("cust_names") String[] cust_names);

}
