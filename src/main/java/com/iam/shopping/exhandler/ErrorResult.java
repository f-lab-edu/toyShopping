package com.iam.shopping.exhandler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResult {
    private String code;
    private String message;
}
