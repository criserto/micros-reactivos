package com.ej2;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class main {


    public static void main(String[] args) {

        List<Product> shoppingCart = List.of(
                new Product("Clothes", new BigDecimal("15.90"), Tax.NORMAL),
                new Product("Bread", new BigDecimal("1.5"), Tax.SUPERREDUCED),
                new Product("Meat", new BigDecimal("13.99"), Tax.REDUCED),
                new Product("Cheese", new BigDecimal("3.59"), Tax.SUPERREDUCED),
                new Product("Coke", new BigDecimal("1.89"), Tax.REDUCED),
                new Product("Whiskey", new BigDecimal("19.90"), Tax.NORMAL));


        String myListName = shoppingCart.stream()
                .filter(n -> n.name.startsWith("C"))
                .map(n -> n.name)
                .sorted((a, b) -> a.length() - b.length())
                .collect(Collectors.joining(","));

        //devuelve un String por orden de longitud separado con ","
        System.out.println(myListName);

        //RESULTADO 66.08
        //PRIMERA FORMA, TRANSFORMAR BIG DECIMAL EN DOUBLE

        //FORMATO DE SALIDA PARA AJUSTARLO AL RESULTADO ESPERADO (EN REALIDAD ES 66.0796)
        DecimalFormat df = new DecimalFormat("###.##");
        Double costeTotal = shoppingCart.stream()
                .mapToDouble(a ->
                    a.price.doubleValue() + (a.tax.percert * a.price.doubleValue()/100)
                ).sum();

        System.out.println(df.format(costeTotal));


        //SEGUNDA FORMA, NO TRANSFORMAR NADA, TRABAJAR CON LO QUE NOS VENGA.
        //SI FALLARÁ O NO OBTUVIERA VALOR, SE RECIBIRÍA UN 0 (DE OTRA FORMA TENDRÍA QUE DECLARARLO COMO OPTINAL.

        //CONTEXTO PARA INDICAR CUANTOS NÚMEROS QUEREMOS OBTENER COMO RESULTADO, SI ES 4 SERÁN XX.XX EN ESTE CASO
        MathContext c = new MathContext(4);

        BigDecimal cost = shoppingCart.stream()
                .map(a -> a.price.add(BigDecimal.valueOf(a.tax.percert).multiply(a.price).divide(new BigDecimal(100))))
                .reduce((a, x) -> a.add(x).round(c))
                .orElse(new BigDecimal(0));

        System.out.println(cost);
    }
}
