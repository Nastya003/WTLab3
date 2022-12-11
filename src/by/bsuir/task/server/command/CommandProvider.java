package by.bsuir.task.server.command;

import by.bsuir.task.server.command.exception.CommandException;
import by.bsuir.task.server.command.impl.*;

public class CommandProvider {
    private static final CommandProvider INSTANCE = new CommandProvider();

    private CommandProvider() {
    }

    public static CommandProvider getInstance() {
        return INSTANCE;
    }

    public Command getCommand(String request) throws CommandException {
        if (request == null) throw new CommandException("No command");
        var arguments = request.split(" ");
        if (arguments.length < 1) throw new CommandException("No command");
        return switch (arguments[0]) {
            case "Auth" -> new AuthCommand();
            case "Disconnect" -> new DisconnectCommand();
            case "Edit" -> new EditCommand();
            case "View" -> new ViewCommand();
            case "Create" -> new CreateCommand();
            default -> throw new CommandException("No such command");
        };
    }
}
