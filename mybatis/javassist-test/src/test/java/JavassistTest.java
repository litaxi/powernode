import com.powernode.bank.dao.impl.AccountDao;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Author wataxi
 * @Date 2023/9/23 17:46
 * @Version 1.0
 */
public class JavassistTest {

    @Test
    public void testGenerateImpl() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("com.powernode.bank.dao.impl.AccountDaoImpl");
        CtClass ctInterface = pool.makeInterface("com.powernode.bank.dao.impl.AccountDao");
        ctClass.addInterface(ctInterface);
        CtMethod ctMethod = CtMethod.make("public void delete(){System.out.println(\"hello delete !!!\");}", ctClass);
        ctClass.addMethod(ctMethod);
        Class<?> clazz = ctClass.toClass();
        AccountDao accountDao = (AccountDao) clazz.newInstance();
        accountDao.delete();

    }

    @Test
    public void testGenerateFirstClass() throws Exception {
        //获取类池，是用来生成class的
        ClassPool pool = ClassPool.getDefault();
        //制造类，告诉他类名
        CtClass ctClass = pool.makeClass("com.powernode.bank.dao.impl.AccountDaoImpl");
        //制造方法
        String methodCode = "public void insert(){System.out.println(123);}";
        CtMethod ctMethod = CtMethod.make(methodCode, ctClass);
        //将方法添加到类中
        ctClass.addMethod(ctMethod);
        //在内存中生成class
        ctClass.toClass();
        //类加载到JVM中，返回AccountDaoImpl类的字节码
        Class<?> clazz = Class.forName("com.powernode.bank.dao.impl.AccountDaoImpl");
        //创建对象
        Object obj = clazz.newInstance();
        Method insertMethod = clazz.getDeclaredMethod("insert");
        insertMethod.invoke(obj);

    }

}
