package com.shop.entity;

import com.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name="item")
public class Item {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    //상품코드

    @Column(nullable = false, length = 50)
    private String itemNm;  //상품명

    @Column(name = "price", nullable = false)
    private int price;  //상품 가격

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;  //상품 판매 상태 : 판매중, 품절

    @Column(nullable = false)
    private int stockNumber;    //상품 재고 수량

    @Column(nullable = false)
    private String itemDetail;  //상품 상세 설명

    private LocalDateTime regTime;  //등록시간

    private LocalDateTime updateTime;   //수정시간
}
