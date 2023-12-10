package by.harlap.demo.exception;

import by.harlap.demo.dto.response.ErrorResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request) {
        final ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setMessages(List.of(ex.getMessage()));

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponseDTO);
    }

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    protected ResponseEntity<Object> handleException(MethodArgumentNotValidException ex, WebRequest request) {
        final Object[] exceptionArgs = ex.getDetailMessageArguments();

        if (exceptionArgs == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        final List<String> errors = Arrays.stream(exceptionArgs)
                .map(Object::toString)
                .filter(message -> !message.isBlank())
                .toList();

        final ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setMessages(errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDTO);
    }

    @ExceptionHandler(value = { EntityNotFoundException.class })
    protected ResponseEntity<Object> handleException(EntityNotFoundException ex, WebRequest request) {
        final ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setMessages(List.of(ex.getMessage()));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
    }

    @ExceptionHandler(value = { SubscriptionException.class })
    protected ResponseEntity<Object> handleException(SubscriptionException ex, WebRequest request) {
        final ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setMessages(List.of(ex.getMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDTO);
    }

}
