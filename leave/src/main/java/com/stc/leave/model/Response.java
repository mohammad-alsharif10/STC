package com.stc.leave.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Response<T extends BasicModel> {

    private Integer status;
    private String message;
    private List<T> multipleEntries;
    private T singleEntry;
}
