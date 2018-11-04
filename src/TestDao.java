import jdk.dynalink.beans.StaticClass;

public interface TestDao {

default void  save() {
	System.out.println("default 方法调用了 ");
}

	
}
