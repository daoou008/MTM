package sjgyh.dao.impl.test;

import org.junit.jupiter.api.Test;
import sjgyh.dao.impl.ModStoreDaoImpl;
import sjgyh.domain.ModStore;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModStoreDaoImplTest {

    @Test
    void findAll() {
        ModStoreDaoImpl dao = new ModStoreDaoImpl();
        List<ModStore> modStores = dao.findAll();
        if (null != modStores && modStores.size() > 0) {
            for (int i = 0; i < modStores.size(); i++) {
                System.out.println(modStores.get(i));
            }
        }
    }
}