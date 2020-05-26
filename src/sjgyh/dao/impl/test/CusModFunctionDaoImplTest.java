package sjgyh.dao.impl.test;

import org.junit.jupiter.api.Test;
import sjgyh.dao.impl.CusModFunctionDaoImpl;
import sjgyh.domain.CusModFunction;

import java.util.List;

class CusModFunctionDaoImplTest {

    @Test
    void findAll() {
        CusModFunctionDaoImpl dao = new CusModFunctionDaoImpl();
        List<CusModFunction> cusModFunctions = dao.findAll();
        if (cusModFunctions!= null && cusModFunctions.size() > 0) {
            for (int i = 0; i < cusModFunctions.size(); i++) {
                System.out.println(cusModFunctions.get(i));
            }
        }
    }

    @Test
    void findCMFByPageRow() {
        CusModFunctionDaoImpl dao = new CusModFunctionDaoImpl();
        String cusName = null;
        List<CusModFunction> cusModFunctions = dao.findCMFByPageRow(0,3, cusName);
        System.out.println(cusModFunctions);
        List<CusModFunction> cusModFunctions2 = dao.findCMFByPageRow(3,3, cusName);
        System.out.println(cusModFunctions2);
    }
}