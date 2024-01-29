package ru.marinin.dataStream;

import java.util.ArrayList;
import java.util.List;

public class TestDataStream {

//        List.of("Qwwqw","ty5ty","6","A11");
//        List<Integer> list = new ArrayList<>(List.of(4, -2, 9, -4, 25, -7, -8));
//        DataStream.DataStream<Integer> ds = DataStream.DataStream.create(list);
//        ds = ds.filter(x -> x > 0)
//                .map(x -> Math.sqrt(x))
//                .map(x -> x.intValue());
//        int res=ds.reduce((x,y)->x+y,0);
//        System.out.println(res);
//        Object ArrayList;
//        List<Integer> resList = ds.collect(ArrayList::new, (xLst, x) -> xLst.add(x));
//        System.out.println(resList);

    static void test_1() {
        // 4.1
        List<String> list1 = new ArrayList<>(List.of("Hello", "world", "hello", "World"));
        DataStream<String> ds1 = DataStream.create(list1);
        int res1 = ds1.filter(x -> Character.isUpperCase(x.charAt(0)))
                .reduce((x,y) -> x+y, "").length();
        System.out.println(res1);
    }

    static void test_2() {
        //4.2
        List<Integer> list2 = new ArrayList<>(List.of(5,-1,0,3,9,0,-9,1,4));
        DataStream<Integer> ds2 = DataStream.create(list2);
        List<List<Integer>> res2 = ds2.filter(x -> x!=0)
                .collect(ArrayList::new, new Combiner());
        System.out.println(res2);
    }

    static void test_3() {
        //4.3
        List<String> list3 = new ArrayList<>(List.of("Hel2lo", "world", "hel1lo", "123", "World", "2", "-100", "123asd"));
        DataStream<String> ds3 = DataStream.create(list3);
        String res3 = ds3.filter(new FilterInteger())
                .reduce(new StringSum(), "0");
        System.out.println(res3);
    }

}

/*
1) статический метод инициализации
2) доделать метод collect
3) опционально: переделать текущую реализацию в ОО стиле
4) выполнить задачки c применением нашего DataStream.DataStream
4.1 есть список строк, отобрать те строки, которые начинаются с большой буквы, и посчитать общую длину оставшихся строк
4.2 есть список чисел, удалить нули, результат разложить по двум спискам: в одном отрицательные значения, в другом положительные
4.3 дан список строк, некоторые из них числа. Удалить все строки НЕ являющиеся числами, преобразовать строки в числа, и получить их сумму
 */