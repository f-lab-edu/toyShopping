package com.iam.shopping.exhandler;

import com.iam.shopping.exception.FileExtensionException;
import com.iam.shopping.exception.LoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

@RestControllerAdvice
@Slf4j
public class ExController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestPartException.class)
    public ErrorResult fileNullExHandler(MissingServletRequestPartException e) {
        log.error("error", e);
        return ErrorResult.builder()
                .code("400")
                .message("파일을 선택해주세요.")
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NullPointerException.class)
    public ErrorResult itemNullExHandler(NullPointerException e) {
        log.error("error", e);
        return ErrorResult.builder()
                .code("400")
                .message("상품명, 가격, 카테고리는 필수 정보입니다.")
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(FileExtensionException.class)
    public ErrorResult fileExtensionExHandler(FileExtensionException e) {
        log.error("error", e);
        return ErrorResult.builder()
                .code("400")
                .message(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ErrorResult fileSizeExHandler(MaxUploadSizeExceededException e) {
        log.error("error", e);
        return ErrorResult.builder()
                .code("400")
                .message("파일 최대 크기는 1048576 bytes 입니다.")
                .build();
    }

    /**
     * @Validated 유효성 체크에 통과하지 못하면 ConstraintViolationException 예외 발생, @Valid는 MethodArgumentNotValidException 예외 발생
     * 예외가 발생하지 않아 LoginException으로 다 처리
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResult methodArgumentValidExHandler(MethodArgumentNotValidException e) {
        log.error("error", e);
        return ErrorResult.builder()
                .code("400")
                .message(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(LoginException.class)
    public ErrorResult loginExHandler(LoginException e) {
        log.error("error", e);
        return ErrorResult.builder()
                .code("400")
                .message(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ErrorResult exHandler(Exception e) {
        log.error("error", e);
        return ErrorResult.builder()
                .code("400")
                .message(e.getMessage())
                .build();
    }

}
