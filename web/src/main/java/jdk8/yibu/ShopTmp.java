package jdk8.yibu;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-17 16:29
 * Description:
 */
public class ShopTmp {
    private Random random = new Random();

    private String name;

    public String getName() {
        return name;
    }

    public ShopTmp() {
    }

    public ShopTmp(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ShopTmp shopTmp = new ShopTmp();
        long start = System.nanoTime();
        Future<Double> futurePrice = shopTmp.getPriceAsync("my favorite product");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");

//        try {
//            double price = futurePrice.get();
//            System.out.printf("Price is %.2f%n", price);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(today.plusDays(15));

        List<ShopTmp> shopTmps = Arrays.asList(new ShopTmp("BestPrice"),
                new ShopTmp("LetsSaveBig"),
                new ShopTmp("MyFavoriteShop"),
                new ShopTmp("MyFavoriteShop1"),
                new ShopTmp("Shop2"),
                new ShopTmp("MyFavoriteShop3"),
                new ShopTmp("MyFavoriteShop4"),
                new ShopTmp("MyFavoriteShop5"),
                new ShopTmp("MyFavoriteShop6"),
                new ShopTmp("MyFavoriteShop7"),
                new ShopTmp("BuyItAll"));

        ShopTmp tmp = shopTmps.stream().filter(s -> s.getName().equalsIgnoreCase("MyFavoriteShop4")).findFirst().get();
        tmp.name = "change";
        System.out.println(getPriceAsync2(shopTmps));
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.YEAR, 875999999);
        cal.set(Calendar.MONTH, 11);
        cal.set(Calendar.DAY_OF_MONTH, 31);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(cal.getTime()));
        System.out.println(cal.getTime().getTime());
        System.out.println(Long.MAX_VALUE);
        String bytes = Long.toBinaryString(cal.getTime().getTime());
        System.out.println(bytes);
        System.out.println(bytes.length());



    }

    public static List<String> getPriceAsync2(List<ShopTmp> shopTmps) {
//        CompletableFuture.supplyAsync(() -> shop.getName() + " price is " +
//                shop.getPrice(product), executor);

        final Executor executor = Executors.newFixedThreadPool(Math.min(shopTmps.size(), 100),
                new ThreadFactory() {
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        return t;
                    }

                });
        List<CompletableFuture<String>> priceFutures =
                shopTmps.stream()
                        .map(shopTmp -> CompletableFuture.supplyAsync(() -> shopTmp.getName() + " price is ", executor)).collect(Collectors.toList());
        return priceFutures.stream()
                .map(CompletableFuture::join).collect(Collectors.toList());
    }

    public Future<Double> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
//        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//        new Thread(() -> {
//            try{
//                double price = calculatePrice(product);
//                futurePrice.complete(price);
//            }catch (Exception e){
//                futurePrice.completeExceptionally(e);
//            }
//
//        }).start();
//        return futurePrice;
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
