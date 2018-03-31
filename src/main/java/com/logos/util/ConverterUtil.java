package com.logos.util;

import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anzhelika on 12/22/2016.
 */
public class ConverterUtil {

    public static <S, T> List<T> convertAll(List<S> sources, Converter<S, T> converter) {
        List<T> result = new ArrayList<>();

        for (S source: sources) {
            T target = converter.convert(source);

            result.add(target);
        }

        return result;
    }
}
