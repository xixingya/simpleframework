package site.xixing.demo.reflect;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/18 10:18
 */
public class ReflectTarget {


    int a=0;
    public char b='a';
    private String s="str";

    @Override
    public String toString() {
        return "ReflectTarget{" +
                "a=" + a +
                ", b=" + b +
                ", s='" + s + '\'' +
                '}';
    }

    ReflectTarget(String str){
        System.out.println("受保护的构造函数:"+"String="+str);
    }

    public ReflectTarget(char name){
        System.out.println("公有的带参数构造方法\t name="+name);
    }

    public ReflectTarget(){
        System.out.println("无参的构造方法·");
    }

    public ReflectTarget(String str,int index){
        System.out.println("带两个参数的构造方法\t str="+str+"index="+index);
    }

    protected ReflectTarget(boolean flag){
        System.out.println("返回值为bool的受保护构造方法+flag="+flag);
    }

    private ReflectTarget(int index){
        System.out.println("私有的构造函数：index="+index);
    }

    public void sayHello(){
        System.out.println("Hello 我是public方法");
    }

    public static void main(String[] args) {


        ReflectTarget reflectTarget=new ReflectTarget();
        //1.第一种方法
        Class<? extends ReflectTarget> reflectTargetClass1 = reflectTarget.getClass();

        System.out.println("first :"+reflectTargetClass1.getName());


        //2.第二种方式
        Class reflectClass2=ReflectTarget.class;
        System.out.println("second :"+reflectClass2.getName());


        System.out.println(reflectTargetClass1==reflectClass2);

        //3.第三种方式
        try {
            Class reflectClass3=Class.forName("site.xixing.demo.reflect.ReflectTarget");

            System.out.println(reflectClass3.getName());
            System.out.println(reflectClass2==reflectClass3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
