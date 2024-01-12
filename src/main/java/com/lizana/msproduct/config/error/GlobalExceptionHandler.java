package com.lizana.msproduct.config.error;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.lizana.msproduct.model.dto.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.server.MissingRequestValueException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  private ObjectMapper mapper = new ObjectMapper();




  @Override
  protected Mono<ResponseEntity<Object>> handleWebExchangeBindException(WebExchangeBindException ex, HttpHeaders headers, HttpStatusCode status, ServerWebExchange exchange) {
    log.error("handleMethodArgumentNotValid " + ex.getMessage(), ex);

    Map<String, String> errors = new HashMap<>();

    ex.getBindingResult().getFieldErrors().forEach((error) -> {
      String field = error.getField();
      //field = field.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
      field = ((PropertyNamingStrategies.SnakeCaseStrategy)PropertyNamingStrategies.SNAKE_CASE).translate(field);
      String message = error.getDefaultMessage();
      errors.put(field, message);
    });

    var error = new ErrorResponseDto("Validation failed for argument", "" + HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), errors);
    return Mono.just(ResponseEntity.badRequest().body(error));
  }



}
