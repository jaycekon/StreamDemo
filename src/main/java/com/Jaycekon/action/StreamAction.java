package com.Jaycekon.action;


import com.Jaycekon.action.model.Trader;
import com.Jaycekon.action.model.Transaction;
import com.Jaycekon.action.util.TraderUtil;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamAction {

    private static List<Transaction> list = TraderUtil.getTransaction();

    /**
     * 找出2011年发生的所有交易，并按交易记录额排序
     */
    @Test
    public void actionOne() {
        List<Transaction> result = list.stream()
                .filter(transaction -> transaction.getYear() > 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        result.forEach(System.out::println);

    }


    /**
     * 交易员在哪些城市
     */
    @Test
    public void actionTwo() {

        System.out.println("Type 1:");
        //Type 1
        List<String> citys = list.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        citys.forEach(System.out::println);


        System.out.println("Type 2:");
        //Type 2
        Set<String> citySet = list.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());

        citySet.forEach(System.out::println);
    }


    /**
     * 找出在剑桥工作的交易员，根据姓名排序
     */
    @Test
    public void actionThree(){
        List<Trader> traders = list.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        traders.forEach(System.out::println);

    }
}
