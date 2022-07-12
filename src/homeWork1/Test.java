package homeWork1;
//Создать свою реализацию List - (Number list). Она может работать только с Numbers (Generics)
//Особенности переопределения методов
//1. Метод add - который добавляет в начало массива
//2. Метод remove - удаляет все элементы массив
//3. Метод contains - возвращает true, только если таких элементов больше или равно 2
//
//Особенности новых методов
//1. Метод getDouble(int index), будет возвращать элемент типа Double по указанному индексу, или кидать ошибку
//2. Метод sumIntegers(), будет давать сумму всех чисел, если array - Integer, иначе кидать ошибку

//Опциально(По желанию)
//Закончить MyList класс - дописать оставшиешься методы, кроме итератор и toArray()

public class Test {
    public static void main(String[] args) {

        MyList<Double> list = new MyList<>(Double.class);
        list.add(20.0);
        list.add(20.0);
        list.add(3.0);
        list.add(15.0);
        System.out.println(list);
        list.remove(20.0);
        System.out.println(list);









    }
}
