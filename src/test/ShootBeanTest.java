import com.example.newwebjsf.shootbean.ResultBean;
import com.example.newwebjsf.shootbean.Shot;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


//@DisplayName("Shoot bean test for check area")
public class ShootBeanTest {
//    @Inject
//    Shot bean;
//
//    @Inject
//    ResultBean resultBean;

    @Test
    public void zeroCheckAreaTest(){
        CheckAreaInShotBeanTest("true", 0.0f, 0.0f, 0.0f);
    }
    private void CheckAreaInShotBeanTest(String expectedResult, Float x, Float y, Float r){
        //setup
        Shot bean = new Shot();
        bean.setX(x);
        bean.setY(y);
        bean.setR(r);
        ResultBean resultBean = new ResultBean();
        //execute
        boolean result = resultBean.CheckArea(bean);
        //Assertion
        Assertions.assertEquals(expectedResult, Boolean.toString(result));
    }
}
