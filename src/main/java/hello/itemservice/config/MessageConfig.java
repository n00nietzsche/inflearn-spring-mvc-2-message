package hello.itemservice.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

public class MessageConfig {
    // 스프링 부트에서는 자동으로 빈이 등록되어 있음
//    @Bean
//    public MessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasenames("messages", "errors");
//        messageSource.setDefaultEncoding("utf-8");
//        return messageSource;
//    }
}
