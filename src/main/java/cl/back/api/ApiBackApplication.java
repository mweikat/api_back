package cl.back.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@SpringBootApplication
@EnableAutoConfiguration
public class ApiBackApplication {

	private static final Long MAX_AGE = 3600L;
	private static final int CORS_FILTER_ORDER = -102;

	public static void main(String[] args) {
		SpringApplication.run(ApiBackApplication.class, args);
	}

	@Bean
	 public WebMvcConfigurer corsConfigurer()
	{
		String[] allowDomains = new String[2];
		allowDomains[0] = "http://localhost:5173";
		allowDomains[1] = "http://localhost:4200";

		//System.out.println("CORS configuration....");
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins(allowDomains)
						.allowedHeaders("*")
						.allowedMethods("*")
						.allowCredentials(true)
						.maxAge(MAX_AGE);
						;


				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

	/*@Bean
	public static FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("http://localhost:5173");
		config.setAllowedHeaders(Arrays.asList(
				HttpHeaders.AUTHORIZATION,
				HttpHeaders.CONTENT_TYPE,
				HttpHeaders.ACCEPT));
		config.setAllowedMethods(Arrays.asList(
				HttpMethod.GET.name(),
				HttpMethod.POST.name(),
				HttpMethod.PUT.name(),
				HttpMethod.DELETE.name()));
		config.setMaxAge(MAX_AGE);
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));

		// should be set order to -100 because we need to CorsFilter before SpringSecurityFilter
		bean.setOrder(CORS_FILTER_ORDER);
		return bean;
	}*/
}
