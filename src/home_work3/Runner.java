package home_work3;


public class Runner {
    public static void main(String[] args){
        //Задача №4
        //1. Создать аннотацию GetMetaData, которая может быть над атрибутом, методом, классом
        //2. Создать класс UserMeta, с атрибутом String name, int count, методом GetSuperName(String prefix)
        //3. Создать обработчик аннотации GetMetaData, так чтобы:
        //3.1 При нахождении @GetMetaData над классом, то печатаем все атрибуты класса
        //3.2 При нахождении @GetMetaData над атрибутом, чтобы печаталось значение атрибута этого поля
        //3.3 При нахождении @GetMetaData над методом, печатаем сколько времени выполнялся метод.
        //4. Создаем класс Runner, запускаем
        // UserMetaData userMetaData=new UserMetaData("Jon",23);
        UserMetaData userMetaData=new UserMetaData("Jon",23);
    }
}
