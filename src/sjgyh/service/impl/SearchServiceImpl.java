package sjgyh.service.impl;

import sjgyh.dao.*;
import sjgyh.dao.impl.*;
import sjgyh.domain.*;
import sjgyh.service.SearchService;

import java.util.List;

public class SearchServiceImpl implements SearchService {
    private ModStoreDao msDao = new ModStoreDaoImpl();
    private ModuleDao mDao = new ModuleDaoImpl();
    private ModuleFunctionDao mfDao = new ModFunctionDaoImpl();
    private CustomerDao cDao = new CustomerDaoImpl();
    private CusModFunctionDao cmfDao = new CusModFunctionDaoImpl();

    @Override
    public List<ModStore> findAllModStore() {
        //调用DAO完成查询
        return msDao.findAll();
    }

    @Override
    public List<Module> findAllModule() {
        //调用DAO完成查询
        return mDao.findAll();
    }

    @Override
    public List<ModFunction> findAllModFunc() {
        //调用DAO完成查询
        return mfDao.findAll();
    }

    @Override
    public List<Customer> findAllCustomer() {
        //调用DAO完成查询
        return cDao.findAll();
    }

    @Override
    public List<CusModFunction> findAllCusModFunc() {
        //调用DAO完成查询
        return cmfDao.findAll();
    }

    @Override
    public PageBean findPageBean(String _currentPage, String _row, String cusName) {
        PageBean<CusModFunction> pb = new PageBean<>();
        int currentPage;
        int row;
        //对字符串参数做转换
        if (null == _currentPage) {
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(_currentPage);
            if (currentPage < 1) {
                currentPage = 1;
            }
        }
        if (null == _row) {
            //设置默认行数为3
            row = 3;
        } else {
            row = Integer.parseInt(_row);
        }
        //设置总条目数
        int totalCount = cmfDao.findTotalCount(cusName);
        pb.setTotalCount(totalCount);
        //设置总页码
        int totalPage;
        if (totalCount / row == 0) {
            totalPage = 1;
        } else {
            totalPage = totalCount % row == 0 ? totalCount / row : (totalCount % row + 1);
        }
        //如果当前页码大于总页码，设置当前页码为总页码
        if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        pb.setCurrentPage(currentPage);
        pb.setRow(row);
        pb.setTotalPage(totalPage);
        //查询分页后的CusModFunction集合
        int start = (currentPage - 1) * row;
        List<CusModFunction> list = cmfDao.findCMFByPageRow(start, row, cusName);
        pb.setList(list);

        return pb;
    }
}
