package com.tanguydev.ismb.Infrastructure.Config;

import com.tanguydev.ismb.Domain.Exception.BadRequestException;
import com.tanguydev.ismb.Domain.Exception.DuplicateResourceException;
import com.tanguydev.ismb.Domain.Exception.ResourceNotFoundException;
import com.tanguydev.ismb.Domain.Exception.UnauthorizedException;
import com.tanguydev.ismb.Domain.Response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private final Environment environment;

    public GlobalExceptionHandler(Environment environment) {
        this.environment = environment;
    }

    private boolean isDevProfileActive() {
        return environment != null && environment.acceptsProfiles(Profiles.of("dev", "development", "local"));
    }

    private void addDebugInfo(ErrorResponse errorResponse, Exception exception) {
        if (!isDevProfileActive() || exception == null) {
            return;
        }

        errorResponse.setDebugMessage(exception.getMessage());
        errorResponse.setException(exception.getClass().getName());

        StringWriter sw = new StringWriter();
        exception.printStackTrace(new PrintWriter(sw));
        errorResponse.setStackTrace(sw.toString());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
            ResourceNotFoundException ex,
            HttpServletRequest request) {
        logger.warn("Resource not found: {}", ex.getMessage());
        
        ErrorResponse error = new ErrorResponse(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                ex.getMessage(),
                request.getRequestURI()
        );

        addDebugInfo(error, ex);
        
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(
            BadRequestException ex,
            HttpServletRequest request) {
        logger.warn("Bad request: {}", ex.getMessage());
        
        ErrorResponse error = new ErrorResponse(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                ex.getMessage(),
                request.getRequestURI()
        );

        addDebugInfo(error, ex);
        
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateResourceException(
            DuplicateResourceException ex,
            HttpServletRequest request) {
        logger.warn("Duplicate resource: {}", ex.getMessage());
        
        ErrorResponse error = new ErrorResponse(
                Instant.now(),
                HttpStatus.CONFLICT.value(),
                "Conflict",
                ex.getMessage(),
                request.getRequestURI()
        );

        addDebugInfo(error, ex);
        
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorizedException(
            UnauthorizedException ex,
            HttpServletRequest request) {
        logger.warn("Unauthorized access: {}", ex.getMessage());
        
        ErrorResponse error = new ErrorResponse(
                Instant.now(),
                HttpStatus.UNAUTHORIZED.value(),
                "Unauthorized",
                ex.getMessage(),
                request.getRequestURI()
        );

        addDebugInfo(error, ex);
        
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDeniedException(
            AccessDeniedException ex,
            HttpServletRequest request) {
        logger.warn("Access denied: {}", ex.getMessage());
        
        ErrorResponse error = new ErrorResponse(
                Instant.now(),
                HttpStatus.FORBIDDEN.value(),
                "Forbidden",
                "Vous n'avez pas les permissions nécessaires pour accéder à cette ressource",
                request.getRequestURI()
        );

        addDebugInfo(error, ex);
        
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleBadCredentialsException(
            BadCredentialsException ex,
            HttpServletRequest request) {
        logger.warn("Bad credentials: {}", ex.getMessage());
        
        ErrorResponse error = new ErrorResponse(
                Instant.now(),
                HttpStatus.UNAUTHORIZED.value(),
                "Unauthorized",
                "Nom d'utilisateur ou mot de passe incorrect",
                request.getRequestURI()
        );

        addDebugInfo(error, ex);
        
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {
        logger.warn("Validation error: {}", ex.getMessage());
        
        Map<String, String> validationErrors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            validationErrors.put(fieldName, errorMessage);
        });
        
        ErrorResponse error = new ErrorResponse(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Validation Failed",
                "Les données fournies ne sont pas valides",
                request.getRequestURI(),
                validationErrors
        );

        addDebugInfo(error, ex);
        
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ErrorResponse> handleMaxUploadSizeExceededException(
            MaxUploadSizeExceededException ex,
            HttpServletRequest request) {
        logger.warn("File too large: {}", ex.getMessage());
        
        ErrorResponse error = new ErrorResponse(
                Instant.now(),
                HttpStatus.PAYLOAD_TOO_LARGE.value(),
                "Payload Too Large",
                "Le fichier est trop volumineux. Taille maximale autorisée: 10MB",
                request.getRequestURI()
        );

        addDebugInfo(error, ex);
        
        return new ResponseEntity<>(error, HttpStatus.PAYLOAD_TOO_LARGE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(
            Exception ex,
            HttpServletRequest request) {
        logger.error("Unexpected error occurred", ex);
        
        ErrorResponse error = new ErrorResponse(
                Instant.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                "Une erreur inattendue s'est produite. Veuillez réessayer plus tard.",
                request.getRequestURI()
        );

        addDebugInfo(error, ex);
        
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
