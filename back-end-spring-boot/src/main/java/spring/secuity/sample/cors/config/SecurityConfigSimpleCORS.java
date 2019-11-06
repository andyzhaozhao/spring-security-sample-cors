package spring.secuity.sample.cors.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity(debug = true)
@Profile("simpleCORS")
public class SecurityConfigSimpleCORS extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().permitAll();
        http.cors();
        http.csrf().disable();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }
//
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("*"); // 1
//        corsConfiguration.addAllowedHeader("*"); // 2
//        // 允许所有方法包括"GET", "POST", "DELETE", "PUT"等等
//        corsConfiguration.addAllowedMethod("*");
//        corsConfiguration.setMaxAge(1800l);//30分钟
//        // 设为true则Cookie可以包含在CORS请求中一起发给服务器。
//        corsConfiguration.setAllowCredentials(true);
//        // CORS请求时。XMLHttpRequest对象的getResponseHeader()方法只能拿到6个基本字段：
//        // Cache-Control、Content-Language、Content-Type、Expires、Last-Modified、Pragma。
//        // 如果想拿到其他字段，
//        //允许clienHeaderWriterFiltert-site取得自定义得header值
//        corsConfiguration.addExposedHeader(HttpHeaders.AUTHORIZATION);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfiguration);
//        return source;
//    }
}
