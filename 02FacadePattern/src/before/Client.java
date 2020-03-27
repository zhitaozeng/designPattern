package before;

import system.business.Business;
import system.business.impl.BusinessImpl;
import system.dao.DAO;
import system.dao.impl.DAOImpl;
import system.presentation.Presentation;
import system.presentation.impl.PresentationImpl;

/**
 * 使用外观模式之前的客户端
 * 需要调用代码生成器系统，生成相应的代码
 * 可以明显看出，客户端需要知道代码生成器的一组接口的实现类
 * 还需再知道怎么样组合他们，完成本次的功能
 * 任意一个模块发生变化，都会影响到客户端
 */
public class Client {
    public static void main(String[] args){
        Presentation presentation = new PresentationImpl();
        Business business = new BusinessImpl();
        DAO dao = new DAOImpl();
        presentation.generate();
        business.generate();
        dao.generate();
    }
}
