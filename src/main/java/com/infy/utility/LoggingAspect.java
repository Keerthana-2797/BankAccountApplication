package com.infy.utility;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.infy.exception.BankException;
import com.infy.model.AccountDTO;
import com.infy.model.TransactionDTO;

@Component
@Aspect
public class LoggingAspect {

	private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@AfterThrowing(pointcut = "execution(* com.infy.service.AccountServiceImpl.*(..))", throwing = "exception")
	public void logUserInvalidAdvice(JoinPoint joinPoint, BankException exception) {
		logger.info("From User Method:", joinPoint.getSignature());
		logger.info(exception.getMessage(), exception);
	}

	@AfterThrowing(pointcut = "execution(* com.infy.service.TransactionServiceImpl.*(..))", throwing = "exception")
	public void logUserNotAcceptedAdvice(JoinPoint joinPoint, BankException exception) {
		logger.info("From User Method:", joinPoint.getSignature());
		logger.info(exception.getMessage(), exception);
	}

	@AfterReturning(pointcut = "execution(* com.infy.service.AccountServiceImpl.*(..))", returning = "result")
	public void logUserAddUserAdvice(JoinPoint joinPoint, List<AccountDTO> result) {
		logger.info("From User Method:", joinPoint.getSignature());
		logger.info(result.toString());
	}

	@AfterReturning(pointcut = "execution(* com.infy.service.TransactionServiceImpl.*(..))", returning = "result")
	public void logUserLoginUserAdvice(JoinPoint joinPoint, List<TransactionDTO> result) {
		logger.info("From User Method:", joinPoint.getSignature());
		logger.info(result.toString());
	}
}
