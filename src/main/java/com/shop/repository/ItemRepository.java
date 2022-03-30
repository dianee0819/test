package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item> {
    List<Item> findByItemNm(String itemNm); //itemNm 으로 상품 조회하기

    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);  //itemNm 또는 itemDetail 로 상품조회하기

    List<Item> findByPriceLessThan(int price);  //price 값 보다 적은 가격의 상품들 조회

    List<Item> findByPriceLessThanOrderByPriceDesc(int price); //price 값 보다 적은 가격의 상품들 내림차순으로 조회

    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);    //@Param 어노테이션을 이용하여 변수를 JPQL에 전달
}
