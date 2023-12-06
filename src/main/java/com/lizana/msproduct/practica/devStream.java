package com.lizana.msproduct.practica;

import io.reactivex.rxjava3.core.Maybe;

import java.util.stream.Stream;

public class devStream {

    public static void main(String[] args) {

        System.out.println("ITERATE=================");
        var infinite = Stream.iterate(1, x ->  x + 1);
        infinite
                .filter(x -> x%2==1)  //interfaz predicate
                .limit(5)
                .forEach(System.out::println);
        System.out.println("ITERATE SKY y LIMIT=================");
        var infinite2 = Stream.iterate(1, x ->  x + 1);
        infinite2
                .skip(5).limit(5).forEach(System.out::println);


        System.out.println("EMPTY inicio=======Stream.empty()");
        Stream<String> flujoVacio = Stream.empty();
        flujoVacio.forEach(System.out::println);  //TERMINAL consumer


        System.out.println("OF inicio ======Stream.of");
        Stream<String> flujo1 = Stream.of("daniel", "lizana");
        flujo1.peek(x->System.out.println("* "+x)) // es un consumer pero se comporta como spia sin modificar el flujo
            .forEach(System.out::println);


        System.out.println("DISTINc ======Stream.distinct()");
        Stream<String> flujo2 = Stream.of("daniel", "lizana","daniel");
        flujo2.peek(x->System.out.println("* "+x)) // es un consumer pero se comporta como spia sin modificar el flujo
                .distinct()
                .forEach(System.out::println);


        System.out.println("ORDENA inicio ======Stream.sorted()");
        Stream<String> flujo3 = Stream.of("daniel", "lizana","daniel");
        flujo3.peek(x->System.out.println("* "+x)) // es un consumer pero se comporta como spia sin modificar el flujo
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println("ORDENA inicio ======Stream.map()");
        Stream<String> flujo4 = Stream.of("1", "1","3");
        flujo4
                .map(x-> x+2) // es un consumer pero se comporta como spia sin modificar el flujo

                .forEach(System.out::println);





    }
}
