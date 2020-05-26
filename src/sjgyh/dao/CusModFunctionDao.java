package sjgyh.dao;

import sjgyh.domain.CusModFunction;

import java.util.List;

/**
 * 客户信息DAO
 */
@SuppressWarnings("all")
public interface CusModFunctionDao {
    public List<CusModFunction> findAll();

    public int findTotalCount(String cusName);

    public List<CusModFunction> findCMFByPageRow(int currentPage, int row, String cusName);
}
