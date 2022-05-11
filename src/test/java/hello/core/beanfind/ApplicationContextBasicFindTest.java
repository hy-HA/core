package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회 - 역할에 의존")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //Assertions > assertj로 선택 > 검증 후 옵션+엔터 > r demand처리
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        //Assertions > assertj로 선택 > 검증 후 옵션+엔터 > r demand처리
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회존 - 구현에 의존")
    void findBeanByName2() {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        //Assertions > assertj로 선택 > 검증 후 옵션+엔터 > r demand처리
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX() {
        //MemberService xxx = ac.getBean("xxx", MemberService.class);
        //예외처리 - Assertions > jUnit으로 선택 > 옵션 + 엔터 > demend처리 ㄹ
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxx", MemberService.class));
    }

}
