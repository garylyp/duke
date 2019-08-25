package main.java;

import java.io.IOException;
import java.util.HashMap;

public class CommandCentre {

    private HashMap<String, Command> commands;

    public CommandCentre() {
        commands = new HashMap<>();
    }

    public void register(String commandName, Command command) {
        commands.put(commandName, command);
    }

    public void execute(String commandName) throws IOException {
        try {
            Command command = commands.get(commandName);
            if (command == null) {
                throw new InvalidCommandException();
            }
            commands.get(commandName).execute();
        } catch (InvalidCommandException e) {
                System.out.print("     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
        }
    }
}
