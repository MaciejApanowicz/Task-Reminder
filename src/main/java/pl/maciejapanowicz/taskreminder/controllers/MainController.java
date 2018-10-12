package pl.maciejapanowicz.taskreminder.controllers;

import pl.maciejapanowicz.taskreminder.views.MainView;

public class MainController {
    private MainView mainView;

    public MainController(){
        mainView = new MainView();
    }

    public void start(){
        mainView.welcome();
    }
}
