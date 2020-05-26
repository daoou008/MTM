package sjgyh.service;

import sjgyh.domain.*;

import java.util.List;

/**
 * 模块库存业务接口
 */
public interface SearchService {
    /**
     * 查询所有模块库存
     * @return
     */
    public List<ModStore> findAllModStore();

    /**
     * 查询所有模块信息
     * @return
     */
    public List<Module> findAllModule();

    /**
     * 查询所有模块功能信息
     * @return
     */
    public List<ModFunction> findAllModFunc();

    /**
     * 查询所有客户信息
     * @return
     */
    public List<Customer> findAllCustomer();

    /**
     * 查询所有客户对应的模块库存信息
     * @return
     */
    public List<CusModFunction> findAllCusModFunc();

    /**
     * 根据当前页码和行数，返回PageBean对象
     * @param currentPage
     * @param row
     * @param cusName
     * @return
     */
    PageBean findPageBean(String currentPage, String row, String cusName);
}
