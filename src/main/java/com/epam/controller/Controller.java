package com.epam.controller;

public interface Controller {
    
    void parseByDOM();

    void parseBySAX();

    void parseByStAX();

    void validateByDOM();

    void validateBySAX();

    void validateByStAX();

    void transformToHtml();

    void transformToHtmlSortedByPayroll();

}
