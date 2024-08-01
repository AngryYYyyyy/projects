package com.lxy.communitymanagementsystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/8/1 16:57
 * @Description：
 */
@ExtendWith(MockitoExtension.class)
public class Test01 {
    @Test
    public void test01() {
        System.out.println(UUID.randomUUID());
    }
}
