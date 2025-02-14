package com.PizzaHut.controller;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// global exception handling -- applicable for exception arised in any controller
@RestControllerAdvice
//@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(MethodArgumentNotValidException.class) 
	public ResponseEntity<?> validationExceptionHandler(MethodArgumentNotValidException ex)	{		
		// local class
		class FieldErrorDto {
			private String fieldName;
			private String errorMessage;
			
			public FieldErrorDto(String fieldName, String errorMessage) {
				this.fieldName = fieldName;
				this.errorMessage = errorMessage;
			}

			@SuppressWarnings("unused")
			public String getFieldName() {
				return fieldName;
			}

			@SuppressWarnings("unused")
			public void setFieldName(String fieldName) {
				this.fieldName = fieldName;
			}

			@SuppressWarnings("unused")
			public String getErrorMessage() {
				return errorMessage;
			}

			@SuppressWarnings("unused")
			public void setErrorMessage(String errorMessage) {
				this.errorMessage = errorMessage;
			}
		}
		
		List<FieldError> errors = ex.getFieldErrors();
		Stream<FieldErrorDto> result = errors.stream().map(err -> new FieldErrorDto(err.getField(), err.getDefaultMessage()));
		return Response.error(result);
	}	
	
	// Spring Server side validation
		// 1. Use appropriate validation annotations on DTO/Entity (whichever is used to get data using @RequestBody)
		//		@NotBlank, @DateTimeFormat, @Email, @NotNull, @Max, @Min, @Pattern, ...
		// 2. Use @Valid to validate on @RequestBody object. Do NOT use BindingResult as next arg. It will throw MethodArgumentNotValidException
		// 3. Implement @ExceptionHandler for MethodArgumentNotValidException.

}
