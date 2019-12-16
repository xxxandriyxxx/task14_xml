package com.epam.controller;

import com.epam.model.BusinessLogic;
import com.epam.model.Model;

public class ControllerImpl implements Controller {

    private Model model;

    public ControllerImpl() {
        model = new BusinessLogic();
    }

    @Override
    public void parseByDOM() {
        model.parseByDOM();
    }

    @Override
    public void parseBySAX() {
        model.parseBySAX();
    }

    @Override
    public void parseByStAX() {
        model.parseByStAX();
    }

    @Override
    public void validateByDOM() {
        model.validateByDOM();
    }

    @Override
    public void validateBySAX() {
        model.validateBySAX();
    }

    @Override
    public void validateByStAX() {
        model.validateByStAX();
    }

    @Override
    public void transformToHtml() {
        model.transformToHtml();
    }

    @Override
    public void transformToHtmlSortedByPayroll() {
        model.transformToHtmlSortedByPayroll();
    }
}
