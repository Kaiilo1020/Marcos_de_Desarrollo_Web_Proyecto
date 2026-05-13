package com.novafarma.app.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DateTimeParseException.class)
    public String handleDateParseError(RedirectAttributes redirectAttributes) {
        return "redirect:/registro?error=fecha-invalida";
    }

    @ExceptionHandler(Exception.class)
    public String handleGenericError(RedirectAttributes redirectAttributes) {
        return "redirect:/?error=general";
    }
}
