package org.manas.springrewardapplication.DTO;

import lombok.Data;

import java.util.List;

@Data
public class OutPut {
    private String name;
    private String price;
    private String rating;
    private String bankOffer;
    private String partnerOffer;
    private String availability;
    private String cashback;
    private String images;
    private String linkToAllReviews;
    private List<String> aboutItem;
}

