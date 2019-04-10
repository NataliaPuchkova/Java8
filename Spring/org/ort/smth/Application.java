package org.ort.smth;

@EnableOAuth2Sso
@EnableZuulProxy
@SpringBootApplication
		(scanBasePackages = "org.ort.smt.*")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}    
