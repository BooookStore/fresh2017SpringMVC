package com.packt.webstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No product fond under this category")
public class NoProductsFondUnderCategoryException extends RuntimeException {

    private static final long serialVersionUID = 3929385782748582L;

}
