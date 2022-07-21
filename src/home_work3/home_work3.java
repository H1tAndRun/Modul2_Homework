package home_work3;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

public class home_work3 {
    public static void main(String[] args)  {
        task1();
        task2();
        task3();



    }
    public static void task1(){
        HashSet<User>hashSet=new HashSet<>();
        //Задача №1
        //1. Создать класс User, с двумя атрибутами - int age, String name
        //2. Создать экземпляр класса HashSet<User>
        //3. Переопределить hashcode и equals у User так, чтобы при записи в HashSet, были только уникальные name юзера
        User user1=new User(22,"Egor");
        User user2=new User(25,"Egor");
        User user3=new User(22,"Roma");
        User user4=new User(28,"Roma");
        User user5=new User(30,"Bogdan");
        hashSet.add(user1);
        hashSet.add(user2);
        hashSet.add(user3);
        hashSet.add(user4);
        hashSet.add(user5);
        System.out.println(hashSet);
    }
    public static void task2(){
        //Задача №2
        //1. Создать класс UserBroken, с двумя атрибутами - int age, String name
        //2. Создать экземпляр класса HashSet<UserBroken>
        //3. Переопределить hashcode и equals так, чтобы при вставке любого юзера в HashSet,
        // в hashSet всегда оставался один юзер, который последний был вставлен
        HashSet<UserBroken>hashSet=new HashSet<>();
        UserBroken userBroken1=new UserBroken(22,"Jon");
        UserBroken userBroken2=new UserBroken(25,"David");
        UserBroken userBroken3=new UserBroken(30,"Pavel");
        hashSet.add(userBroken1);
        hashSet.add(userBroken2);
        hashSet.add(userBroken3);
        System.out.println(hashSet);
    }
    public static void task3(){
        //Задача №3
        //1. Создать класс CarBroken
        //2. Создать экземпляра класса HashMap<CarBroken, Integer>
        //3. Переопределить hashcode и equals так, чтобы при вставке любого CarBroken в HashMap,
        //всегда CarBroken попадал в один бакет.
        HashMap<CarBroken,Integer>hashMap=new HashMap<>();
        CarBroken carBroken1=new CarBroken();
        CarBroken carBroken2=new CarBroken();
        hashMap.put(carBroken1,23);
        hashMap.put(carBroken2,25);
        System.out.println(hashMap);
    }
}

