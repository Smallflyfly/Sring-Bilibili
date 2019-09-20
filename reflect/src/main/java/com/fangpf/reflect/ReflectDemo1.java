package com.fangpf.reflect;

import com.fangpf.domain.Person;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-18 17:02
 */
public class ReflectDemo1 {

    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class.forName("全类名")
        Class cls1 = Class.forName("com.fangpf.domain.Person");
        System.out.println(cls1);
        //2.类名。class
        Class cls2 = Person.class;
        System.out.println(cls2);
        //3.对象。getClass()
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);

        System.out.println(cls1==cls2);
        System.out.println(cls2==cls3);
    }
}
