package sjgyh.dao;

import sjgyh.domain.ModStore;

import java.util.List;

/**
 * 模块库存DAO
 */
@SuppressWarnings("all")
public interface ModStoreDao {
    public List<ModStore> findAll();
}
