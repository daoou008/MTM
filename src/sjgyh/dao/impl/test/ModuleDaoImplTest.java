package sjgyh.dao.impl.test;

import org.junit.jupiter.api.Test;
import sjgyh.dao.impl.ModuleDaoImpl;
import sjgyh.domain.Module;
import sjgyh.util.MD5;

import java.util.List;


class ModuleDaoImplTest {

    @Test
    void findAll() {
        ModuleDaoImpl dao = new ModuleDaoImpl();
        List<Module> modules = dao.findAll();
        if (modules!= null && modules.size() > 0) {
            for (int i = 0; i < modules.size(); i++) {
                System.out.println(modules.get(i));
            }
        }
    }

    @Test
    void checkMD5() {
        System.out.println(MD5.enCode("google123456"));
    }
}