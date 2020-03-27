package system.facade;

import system.business.Business;
import system.business.impl.BusinessImpl;
import system.dao.DAO;
import system.dao.impl.DAOImpl;
import system.presentation.Presentation;
import system.presentation.impl.PresentationImpl;

/**
 * 外观模式：定义代码生成器这一组接口的顶层接口
 */
public class Facade {

    public void generate(){
        Presentation presentation = new PresentationImpl();
        Business business = new BusinessImpl();
        DAO dao = new DAOImpl();
        presentation.generate();
        business.generate();
        dao.generate();
    }
}
