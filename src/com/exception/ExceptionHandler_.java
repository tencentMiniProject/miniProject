package com.exception;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.util.JsonUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class ExceptionHandler_ {
	/*@ExceptionHandler(RuntimeException.class)
	public String getMyException(
			HttpServletRequest request,
			RedirectAttributes redirectAttributes,
			RuntimeException e) {
		redirectAttributes.addFlashAttribute("exception", e.getMessage());
		return "redirect:" + request.getHeader("referer");
	}*/

	@ResponseBody
	@ExceptionHandler(Exception.class)
	public String HandleException(
			HttpServletRequest request,
			HttpServletResponse response,
			Exception e) {
		e.printStackTrace();
		return "服务器出现异常："+e.getMessage();
	}

	@ResponseBody
	@ExceptionHandler(PostException.class)
	public String HandlePostException(HttpServletRequest request,HttpServletResponse response,PostException e) {
		return JsonUtils.writeStatus(0,e.getMessage());
	}
}
