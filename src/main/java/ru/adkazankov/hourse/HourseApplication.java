package ru.adkazankov.hourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import ru.adkazankov.hourse.controller.HourseCountServlet;

@SpringBootApplication
public class HourseApplication {

    @Bean
    public ServletRegistrationBean HourseCountServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(
                HourseCountServletBean(), "/servlet/count");
        bean.setLoadOnStartup(1);
        return bean;
    }

    @Bean
    public HourseCountServlet HourseCountServletBean() {
        return new HourseCountServlet();
    }

    public static void main(String[] args) {
        SpringApplication.run(HourseApplication.class, args);
    }

}
