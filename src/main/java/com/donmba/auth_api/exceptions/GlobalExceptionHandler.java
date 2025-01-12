package com.donmba.auth_api.exceptions;

import com.donmba.auth_api.dto.ApiResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(InvalidCredentialsException.class)
  public ResponseEntity<ApiResponse<Object>> handleInvalidCredentials(
      InvalidCredentialsException ex) {
    logger.error("Invalid credentials error: {}", ex.getMessage());

    ApiResponse<Object> response =
        ApiResponse.<Object>builder()
            .message(ex.getMessage())
            .statusCode(HttpStatus.UNAUTHORIZED.value())
            .data(null)
            .build();
    return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(InvalidRedirectUriException.class)
  public ResponseEntity<ApiResponse<Object>> handleInvalidRedirectUri(
      InvalidRedirectUriException ex) {
    logger.error("Invalid redirect URI error: {}", ex.getMessage());

    ApiResponse<Object> response =
        ApiResponse.<Object>builder()
            .message(ex.getMessage())
            .statusCode(HttpStatus.BAD_REQUEST.value())
            .data(null)
            .build();
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiResponse<Object>> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
    logger.error("Validation error: {}", ex.getMessage());

    List<String> errorMessages =
        ex.getBindingResult().getAllErrors().stream()
            .map(error -> ((FieldError) error).getDefaultMessage())
            .collect(Collectors.toList());

    ApiResponse<Object> response =
        ApiResponse.<Object>builder()
            .message("Validation failed: " + String.join(", ", errorMessages))
            .statusCode(HttpStatus.BAD_REQUEST.value())
            .data(null)
            .build();

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResponse<Object>> handleGenericException(Exception ex) {
    logger.error("Internal Server Error: {}", ex.getMessage(), ex);

    ApiResponse<Object> response =
        ApiResponse.<Object>builder()
            .message("Internal Server Error")
            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .data(null)
            .build();

    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
