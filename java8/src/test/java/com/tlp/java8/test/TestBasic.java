package com.tlp.java8.test;

import com.tlp.java8.entity.AgeAndSex;
import com.tlp.java8.entity.BmUser;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author：tlp
 * @crateDate：2019/9/16 19:36
 */
public class TestBasic {
    @Test
    public void testStringPool() {

        String str3 = new String("abc");

        String str1 = str3.intern();
        System.out.println(str1==str3);

        String str2 = new String("ab")+new String("cd");
        String str4 = str2.intern();
        System.out.println(str2 ==str4);

    }

    @Test
    public void testClon() throws Exception {
        //深拷贝  是否复制了子对象。/修改了克隆后的对象的属性值，影响到原对象-浅拷贝；不影响叫深拷贝。
        AgeAndSex ageAndSex = new AgeAndSex(18, "男");
        AgeAndSex ageAndSex1 = new AgeAndSex(23, "女");


        BmUser user1 = new BmUser(ageAndSex, "tlp");

        BmUser user3 =(BmUser) user1.clone();
        AgeAndSex ageAndSex2 = user1.getAgeAndSex();
        ageAndSex2.setAge(100);
        System.out.println(user1.toString());
        System.out.println(user3.toString());


        System.out.println("-----------------------");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(user1);

        oos.flush();

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        BmUser user2 = (BmUser) ois.readObject();
        user2.setName("tlpppppp");

        user2.setAgeAndSex(ageAndSex1);

        System.out.println(user1.toString());
        System.out.println(user2.toString());
    }

    @Test
    public void testFanxing()throws Exception {
        // 泛型的好处是在编译的时候检查类型安全，并且所有的强制转换都是自动和隐式的，提高代码的重用率。
        //参数化类型 就是将类型由原来的具体的类型参数化，类似于方法中的变量参数，此时类型也定义成参数形式
        //参数类型还可以是通配符类型
        Class<?> classType = Class.forName("java.lang.String");

        //泛型类，是在实例化类的时候指明泛型的具体类型；泛型方法，是在调用方法的时候指明泛型的具体类型
        MyArrays<String> myString = new MyArrays<>();
        myString.printContent("aaa");
        BmUser instant = myString.getInstant(BmUser.class);
        System.out.println(instant);

        MyArrays<List> myLsit = new MyArrays<>();
        myLsit.printContent(new ArrayList());


    }

    //这个表示类型参数 用来传递数据的类型
    class MyArrays<T>{
        public void printContent(T t){
            System.out.println(t.toString());
        }

        public <T> T  getInstant(Class<T> tClass) throws IllegalAccessException, InstantiationException {
            T t = tClass.newInstance();
            return t;
        }
    }
@Test
    public void test1() {
        Test1 test1 = new Test1();
        Test1 test11 = new Test1();
        System.out.println(test1.str==test11.str);
    }

    @Test
    public void test2() {
        try {
          //  Class.forName("com.tlp.java8.entity.Test1");
            //你好

            TestBasic.class.getClassLoader().loadClass("com.tlp.java8.entity.Test1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test3(){
        out:
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j < 10; j++) {
               if (j==2){
                   System.out.println(j);
                   break out;
               }
            }
            System.out.println(i);
        }
    }

    @Test
    public void test4(){
        System.out.println(Runtime.getRuntime().availableProcessors());
    }


}
