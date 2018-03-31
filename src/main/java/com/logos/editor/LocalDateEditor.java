package com.logos.editor;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

/**
 * Created by Anzhelika on 12/11/2016.
 */
public class LocalDateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(LocalDate.parse(text));
    }


}
