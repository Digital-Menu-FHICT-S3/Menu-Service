package com.onlinemenu.menuservice.valueObjects;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Long categoryId;
    private String name;
    private String description;
    private String imageUrl;
}