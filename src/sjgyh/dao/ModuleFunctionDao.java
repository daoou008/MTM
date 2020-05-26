package sjgyh.dao;

import sjgyh.domain.ModFunction;

import java.util.List;

/**
 *  模块功能信息DAO
 */
@SuppressWarnings("all")
public interface ModuleFunctionDao {
    public List<ModFunction> findAll();
}
