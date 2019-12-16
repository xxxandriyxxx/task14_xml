package com.epam.model;

public interface Model {

    void parseByDOM();

    void parseBySAX();

    void parseByStAX();

    void validateByDOM();

    void validateBySAX();

    void validateByStAX();

    void transformToHtml();

    void transformToHtmlSortedByPayroll();

}
