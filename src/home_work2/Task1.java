package home_work2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    //Дан лист
    // List<Integer> integers = List.of(1,2,3,4,5,5,8,8,9);
// Random random = new Random(1);
//Задача №1
//Создать класс пользователей, каждый из которых будет иметь порядковый номер, и список с числами
//С помощью stream api:
// 1. Оставить только числа больше 4 из integers
// 2. Убрать дубликаты чисел
// 3. Создать пользователей на каждый элемент стрима, где каждый элемент стрима
// является порядковым номером пользователя.
// 4. У каждого пользователя заполнить список чисел: количество чисел в списке
// определяется порядковым номером пользователя. Например: для пользователя с порядковым номером 5
// генерируется пять случайных чисел используя переменную random ( в диапазоне до 10 ).
// 5. Создать единый стрим со всеми числами из списков пользователей.
// 6. Умножить числа на 10
// 7. Посчитать сумму всех чисел с помощью reduce
// 8. Вывести на экран
// 9. В случае если integers пустой, то должно выводиться на экран "0"
// Внимание! Все операции должны выполняться одной цепочкой integers.stream().map() ...
// никаких переменных не должно появиться
// Ожидаемый результат вывода на экран:
// 1120 - из примера, 0 - при пустом листе
    public static void main(String[] args) {
        task1();
        task2();
        System.out.println();
        task3();

    }

    public static void task1(){
        Random random = new Random(1);
        List<Integer> integers = List.of(1,2,3,4,5,5,8,8,9);
        System.out.println(integers.stream().filter(x->x>4).distinct().map(Users::new).
                peek(x-> x.setListNumber(Stream.generate(()->new AtomicInteger().incrementAndGet())
                        .limit(x.getSerialNumber()).map(num->random.nextInt(10))
                        .collect(Collectors.toList())))
                        .flatMap(e->e.getListNumber().stream().map(el->el*10)).reduce((sum,el)->sum+el).orElse(0));


    }

    public static void task2(){
        List<List<Integer>> lists = List.of(List.of(1, 2), List.of(3, 4,5), List.of());
        //Задача №2
        // 1. Отсортировать список lists так, чтобы сначала были самые большие списки по размеру
        // 2. Вывести на экран все элементы
        // Ожидаемый результат: 3,4,5,1,2
        lists.stream().sorted((x,y)->y.size()-x.size()).flatMap(x->x.stream()).forEach(e->System.out.print(e+","));
    }
    public static void task3(){
        //Задача №3
        // 1. Узнать, есть ли в lists хотя бы один список, который содержит сумму всех элементов вложенного листа
        // равную 12
        List<List<Integer>> lists = List.of(List.of(1, 2), List.of(3, 4, 5), List.of());
        System.out.println(lists.stream().anyMatch(x->x.stream().reduce((sum,num)->sum+num).orElse(0)==12));



    }
}


