package com.iview.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @Author szhua
 * @Description:ivew_demo==
 * @Date 2019/3/19
 **/
@Document(indexName = "testgoods",type = "goods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsInfo  implements Serializable {


    private Long id;
    private String name;
    private String description;

}
