package pl.maciejapanowicz.taskreminder;

import pl.maciejapanowicz.taskreminder.controllers.AuthController;

/**
 * This is a tasks management application. It consists login & register mechanism,
 * filters the tasks for logged-in users and allows them to manage their tasks.
 * @version 1.01
 * @author Maciej
 */

public class Starter {
    public static void main(String[] args) {
        new AuthController().start();
    }
}
