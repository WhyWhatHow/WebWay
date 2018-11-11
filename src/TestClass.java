import java.lang.reflect.Method;

import org.junit.Test;

public class TestClass {

    private String MSG = "Original";

    private void privateMethod(String head , int tail){
        System.out.print(head + tail);
    }

    public String getMsg(){
        return MSG;
    }
    /**
     * 访问对象的私有方法
     * 为简洁代码，在方法上抛出总的异常，实际开发别这样
     */
    private static void getPrivateMethod() throws Exception{
        //1. 获取 Class 类实例
        TestClass testClass = new TestClass();
        Class mClass = testClass.getClass();

        //2. 获取私有方法
        //第一个参数为要获取的私有方法的名称
        //第二个为要获取方法的参数的类型，参数为 Class...，没有参数就是null
        //方法参数也可这么写 ：new Class[]{String.class , int.class}
        Method privateMethod =
                mClass.getDeclaredMethod("privateMethod", String.class, int.class);

        //3. 开始操作方法
        if (privateMethod != null) {
            //获取私有方法的访问权
            //只是获取访问权，并不是修改实际权限
            privateMethod.setAccessible(true);

            //使用 invoke 反射调用私有方法
            //privateMethod 是获取到的私有方法
            //testClass 要操作的对象
            //后面两个参数传实参
//            privateMethod.invoke(testClass, "Java Reflect ", 666);
            privateMethod.invoke(testClass, "java Reflect ");
        }
    }
    
}