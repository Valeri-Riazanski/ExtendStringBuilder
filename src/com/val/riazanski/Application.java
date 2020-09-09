package com.val.riazanski;

public class Application {
    //fields
    public static CommandHistory history;
    private ExtendStringBuilder stringBuilder;
    //constructors
    public Application(ExtendStringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
        history = new CommandHistory();
    }
    //methods
    public String getText() {
        return this.stringBuilder.toString();
    }
    public void executeCommand(Command command) {
        history.push(command);
    }
    public void unDo() {
        Command command = history.pop();
        if (command != null) {
            command.unDo();
            System.out.println(ConsoleColors.CYAN + getText() + ConsoleColors.RESET);
        }

    }
    public static void main(String[] args) {
        ExtendStringBuilder stringBuilder = new ExtendStringBuilder(new StringBuilder("salkdfasldkfasldkfasldas;dlkfj/asdfkljas;dlfjkfj"));
        Application app = new Application(stringBuilder);
        System.out.println(app.getText());
        UnDeleteCommand command = new UnDeleteCommand(stringBuilder);
        stringBuilder.delete(command,3, 7);
        System.out.println(app.getText());
        app.unDo();
        UnAppend com = new UnAppend(stringBuilder);
        stringBuilder.append(com, "_фыдлваоыфвдла");
        System.out.println(app.getText());
        app.unDo();
        UnReverse commandReverse = new UnReverse(stringBuilder);
        stringBuilder.reverse(commandReverse);
        System.out.println(app.getText());
        app.unDo();
        UnInsert commandInsert = new UnInsert(stringBuilder);
        stringBuilder.insert(commandInsert, 2, "_ДШОдзщшЗЩШЗЩШ_");
        System.out.println(app.getText());
        app.unDo();
        UnReplace commandReplace = new UnReplace(stringBuilder);
        stringBuilder.replace(commandReplace, 5, 8, "_ЕКВЧКЕЧ_");
        System.out.println(app.getText());
        app.unDo();

    }
}
