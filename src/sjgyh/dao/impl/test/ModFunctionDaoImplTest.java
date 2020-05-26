package sjgyh.dao.impl.test;

import org.junit.jupiter.api.Test;
import sjgyh.dao.impl.ModFunctionDaoImpl;
import sjgyh.domain.ModFunction;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModFunctionDaoImplTest {

    @Test
    void findAll() {
        ModFunctionDaoImpl dao = new ModFunctionDaoImpl();
        List<ModFunction> modFunctions = dao.findAll();
        if (modFunctions != null && modFunctions.size() > 0) {
            for (int i = 0; i < modFunctions.size(); i++) {
                System.out.println(modFunctions.get(i));
            }
        }
    }
}