package com.example.ex00.dependency.qualifier;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Data
@Qualifier("vips")
public class Vips implements Resturant {


    private int steak = Resturant.steak + 10000;

    @Override
    public boolean isSalad() {
        return false;
    }
}
