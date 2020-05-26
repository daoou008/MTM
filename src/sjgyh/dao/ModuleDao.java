package sjgyh.dao;

import sjgyh.domain.Module;

import java.util.List;

/**
 * 模块信息DAO
 */
@SuppressWarnings("all")
public interface ModuleDao {
    public List<Module> findAll();
}
