package com.example.web_1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Web1Application {

	public static void main(String[] args) {
		SpringApplication.run(Web1Application.class, args);
	}

	@RestController
	public static class CalculatorController {

		@GetMapping("/calc/{operator}/{op1}/{op2}")
		public String calculate(@PathVariable String operator, @PathVariable double op1, @PathVariable double op2) {
			switch (operator) {
				case "sum":
					return op1 + " + " + op2 + " = " + (op1 + op2);
				case "subtract":
					return op1 + " - " + op2 + " = " + (op1 - op2);
				case "mult":
					return op1 + " * " + op2 + " = " + (op1 * op2);
				case "div":
					if (op2 == 0) return "Cannot divide by zero";
					return op1 + " / " + op2 + " = " + (op1 / op2);
				default:
					return "Invalid operator";
			}
		}
	}

}
