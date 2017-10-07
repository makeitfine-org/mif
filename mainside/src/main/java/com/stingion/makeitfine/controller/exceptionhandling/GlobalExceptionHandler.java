/*
 * Created in scope of "Make it fine" project
 */
package com.stingion.makeitfine.controller.exceptionhandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = {Error.class, Exception.class, RuntimeException.class})
    public ModelAndView handleIOException(HttpServletRequest request, Exception e) {
        logger.error(e.getMessage(), e);

        ModelAndView mav = new ModelAndView("error/generic_error");
        mav.addObject("datetime", new Date());
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());

        return mav;
    }
}