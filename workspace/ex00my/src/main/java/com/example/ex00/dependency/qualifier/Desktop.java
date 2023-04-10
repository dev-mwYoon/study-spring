package com.example.ex00.dependency.qualifier;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Data
@Qualifier("deskptop") @Primary // @Primary는 Qualifier의 default를 주는 것
public class Desktop implements Computer {
    @Override
    public int getScreenWidth() {
        return 0;
    }
}
