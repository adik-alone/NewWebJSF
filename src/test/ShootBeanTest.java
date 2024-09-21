import com.example.newwebjsf.shootbean.ResultBean;
import com.example.newwebjsf.shootbean.Shot;
import jakarta.inject.Inject;
import org.junit.Test;
import static org.junit.Assert.*;


public class ShootBeanTest {

    @Test
    public void testCheckAreaZero() {
        ResultBean resultBean = new ResultBean();
        Shot bean = new Shot();
        bean.setX(0);
        bean.setY(0);
        bean.setR(0);
        assertTrue(resultBean.CheckArea(bean));
    }
    @Test
    public void testCheckAreaTrue() {
        ResultBean resultBean = new ResultBean();
        Shot bean = new Shot();
        bean.setX(0);
        bean.setY(0);
        bean.setR(1);
        assertTrue(resultBean.CheckArea(bean));
    }
    @Test
    public void testCheckAreaFalse() {
        ResultBean resultBean = new ResultBean();
        Shot bean = new Shot();
        bean.setX(13);
        bean.setY(15);
        bean.setR(1);
        assertFalse(resultBean.CheckArea(bean));
    }
    @Test
    public void testCheckAreaTrue_2() {
        ResultBean resultBean = new ResultBean();
        Shot bean = new Shot();
        bean.setX(3);
        bean.setY(4);
        bean.setR(5);
        assertTrue(resultBean.CheckArea(bean));
    }
}
