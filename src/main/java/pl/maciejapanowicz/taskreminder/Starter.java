package pl.maciejapanowicz.taskreminder;

import pl.maciejapanowicz.taskreminder.controllers.AuthController;

public class Starter {
    public static void main(String[] args) {
        new AuthController().start();
    }
}
