package hello.itemservice.message;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MessageSourceTest {
    @Autowired MessageSource messageSource;

    @Test
    public void helloMessage() {
        String hello = messageSource.getMessage("hello", null, Locale.KOREAN);
        System.out.println("hello = " + hello);
        assertThat(hello).isEqualTo("안녕");
    }

    @Test
    public void notFoundMessageCode() {
        assertThatThrownBy(() -> messageSource.getMessage("no_code", null, Locale.KOREAN))
                .isInstanceOf(NoSuchMessageException.class);
    }

    @Test
    public void notFoundMessageCodeButDefault() {
        String result = messageSource.getMessage("no_code", null, "기본 메시지", Locale.KOREAN);
        assertThat(result).isEqualTo("기본 메시지");
    }

    @Test
    public void argumentMessage() {
        String result = messageSource.getMessage("hello.name", new String[]{"스프링"} , Locale.KOREAN);
        System.out.println("result = " + result);
        assertThat(result).isEqualTo("안녕 스프링");
    }

    @Test
    public void localeMessage() {
        assertThat(messageSource.getMessage("hello", null, null)).isEqualTo("안녕");
        assertThat(messageSource.getMessage("hello", null, Locale.KOREAN)).isEqualTo("안녕");
        assertThat(messageSource.getMessage("hello", null, Locale.ENGLISH)).isEqualTo("hello");
    }


}
