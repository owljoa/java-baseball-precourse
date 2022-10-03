package baseball;

public class Application {
    public static void main(String[] args) {
        CommandExecutor commandExecutor = new CommandExecutor(new Game());
        commandExecutor.startReadInput();
    }
}
