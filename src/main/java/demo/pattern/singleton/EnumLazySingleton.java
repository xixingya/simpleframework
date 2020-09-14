package demo.pattern.singleton;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/26 17:09
 */
public class EnumLazySingleton {

    private EnumLazySingleton(){

    }
    public EnumLazySingleton getInstance(){
        return ContainerHolder.HOLDER.singleton;
    }

    private enum ContainerHolder{
        HOLDER;
        private EnumLazySingleton singleton;
        private ContainerHolder(){
            singleton=new EnumLazySingleton();
        }
    }
}
