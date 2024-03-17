package bankaccountapplication;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.geometry.Pos;

public class BankAccountApplication extends Application {

    private ArrayList<Customer> customers = new ArrayList<>();
    private TextField usernameField;
    private PasswordField passwordField;
    private Label statusLabel;

    @Override
    public void start(Stage primaryStage) {
        Manager manager = new Manager();

        primaryStage.setTitle("Bank Application");
        GridPane grid = createGrid();

        Button manLoginButton = new Button("Login as Manager");
        manLoginButton.setOnAction(e -> managerLogin(primaryStage, manager));
        GridPane.setConstraints(manLoginButton, 1, 1);

        Button custLoginButton = new Button("Login as Customer");
        custLoginButton.setOnAction(e -> customerLogin(primaryStage, manager));
        GridPane.setConstraints(custLoginButton, 1, 2);

        grid.getChildren().addAll(custLoginButton, manLoginButton);

        Scene scene = new Scene(grid, 1920, 1080); // Adjusted size for desktop users
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20));
        grid.setVgap(20); // Increased vertical gap
        grid.setHgap(20); // Increased horizontal gap
        return grid;
    }

    private void managerLogin(Stage primaryStage, Manager manager) {
        primaryStage.setTitle("Manager Login");
        GridPane grid = createGrid();

        Label usernameLabel = new Label("Manager Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        usernameField = new TextField();
        GridPane.setConstraints(usernameField, 1, 0);

        Label passwordLabel = new Label("Manager Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        passwordField = new PasswordField();
        GridPane.setConstraints(passwordField, 1, 1);

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> handleManagerLogin(primaryStage, manager));
        GridPane.setConstraints(loginButton, 1, 2);

        statusLabel = new Label();
        GridPane.setConstraints(statusLabel, 1, 3);

        Button goBackButton = new Button("Go Back");
        goBackButton.setOnAction(e -> start(primaryStage));
        GridPane.setConstraints(goBackButton, 1, 4);

        grid.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton, statusLabel, goBackButton);

        Scene scene = new Scene(grid, 1920, 1080);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleManagerLogin(Stage primaryStage, Manager manager) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (!username.isEmpty() && !password.isEmpty()) {
            if (manager.login(username, password)) {
                statusLabel.setText("Login Successful!");
                managerPage(primaryStage, manager);
            } else {
                statusLabel.setText("Invalid credentials");
            }
        } else {
            statusLabel.setText("Please enter username and password");
        }
    }

    private void customerLogin(Stage primaryStage, Manager manager) {
        primaryStage.setTitle("Customer Login");
        GridPane grid = createGrid();

        Label usernameLabel = new Label("Customer Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        usernameField = new TextField();
        GridPane.setConstraints(usernameField, 1, 0);

        Label passwordLabel = new Label("Customer Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        passwordField = new PasswordField();
        GridPane.setConstraints(passwordField, 1, 1);

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> handleCustomerLogin(primaryStage, manager));
        GridPane.setConstraints(loginButton, 1, 2);

        statusLabel = new Label();
        GridPane.setConstraints(statusLabel, 1, 3);

        Button goBackButton = new Button("Go Back");
        goBackButton.setOnAction(e -> start(primaryStage));
        GridPane.setConstraints(goBackButton, 1, 4);

        grid.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton, statusLabel, goBackButton);

        Scene scene = new Scene(grid, 1920, 1080);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleCustomerLogin(Stage primaryStage, Manager manager) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (!username.isEmpty() && !password.isEmpty()) {
            Customer customer = null;
            for (Customer c : manager.customers) {
                if (c.login(username, password)) {
                    customer = c;
                    break;
                }
            }
            if (customer != null) {
                statusLabel.setText("Login Successful!");
                customerPage(primaryStage, customer, manager);
            } else {
                statusLabel.setText("Invalid credentials");
            }
        } else {
            statusLabel.setText("Please enter username and password");
        }
    }

    private void managerPage(Stage primaryStage, Manager manager) {
        primaryStage.setTitle("Manager Page");
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        statusLabel = new Label();
        statusLabel.setText("Welcome admin");
        vbox.getChildren().add(statusLabel);

        displayCustomers(manager, vbox);

        HBox addDeleteBox = new HBox(10);
        Button addButton = new Button("Add Customer");
        addButton.setOnAction(e -> addCustomer(primaryStage, manager));
        addDeleteBox.getChildren().addAll(addButton);
        vbox.getChildren().add(addDeleteBox);

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> start(primaryStage));
        vbox.getChildren().add(logoutButton);

        Scene scene = new Scene(vbox, 1920, 1080);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayCustomers(Manager manager, VBox vbox) {
        for (Customer customer : manager.customers) {
            HBox hbox = new HBox(10);
            Label nameLabel = new Label(customer.getUsername());
            Button deleteButton = new Button("Delete");
            deleteButton.setOnAction(e -> {
                manager.deleteCustomer(customer.getUsername());
                statusLabel.setText("Customer " + customer.getUsername() + " deleted");
                vbox.getChildren().remove(hbox); // Remove the HBox containing this customer's details
            });

            hbox.getChildren().addAll(nameLabel, deleteButton);
            vbox.getChildren().add(hbox);
        }
    }

    private void addCustomer(Stage primaryStage, Manager manager) {
        primaryStage.setTitle("Add Customer");
        GridPane grid = createGrid();

        Label usernameLabel = new Label("Customer Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        usernameField = new TextField();
        GridPane.setConstraints(usernameField, 1, 0);

        Label passwordLabel = new Label("Customer Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        passwordField = new PasswordField();
        GridPane.setConstraints(passwordField, 1, 1);

        Button add = new Button("Add");
        add.setOnAction(e -> {
            if (!usernameField.getText().isEmpty() && !passwordField.getText().isEmpty()) {
                try {
                    manager.addCustomer(usernameField.getText(), passwordField.getText());
                    manager.customers.get(manager.customers.size()-1).setLevel();
                    statusLabel.setText("Customer Added");
                    displayCustomers(manager, (VBox) primaryStage.getScene().getRoot());
                } catch (Exception ex) {
                    statusLabel.setText("Customer with username already exists");
                }
            } else {
                statusLabel.setText("Please enter username and password");
            }
        });
        GridPane.setConstraints(add, 1, 2);

        statusLabel = new Label();
        GridPane.setConstraints(statusLabel, 1, 3);

        Button goBackButton = new Button("Go Back");
        goBackButton.setOnAction(e -> managerPage(primaryStage, manager));
        GridPane.setConstraints(goBackButton, 1, 4);

        grid.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, add, statusLabel, goBackButton);

        Scene scene = new Scene(grid, 1920, 1080);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void customerPage(Stage primaryStage, Customer customer, Manager manager) {
        primaryStage.setTitle("Customer Page");
        GridPane grid = createGrid();

        Label welcomeLabel = new Label("Welcome " + customer.getUsername());
        GridPane.setConstraints(welcomeLabel, 0, 0, 2, 1);

        Label balanceLabel = new Label("Balance: $" + customer.getBankAcc().getBalance());
        GridPane.setConstraints(balanceLabel, 0, 1, 2, 1);

        Label levelLabel = new Label("Customer Level: " + customer.getLevel());
        GridPane.setConstraints(levelLabel, 0, 2, 2, 1);

        Label messageLabel = new Label();
        GridPane.setConstraints(messageLabel, 0, 8, 2, 1);

        TextField depositField = new TextField();
        depositField.setPromptText("Enter amount to deposit");
        GridPane.setConstraints(depositField, 0, 3);

        Button depositButton = new Button("Deposit");
        depositButton.setOnAction(e -> handleDeposit(customer, depositField, balanceLabel, levelLabel, messageLabel, manager));
        GridPane.setConstraints(depositButton, 1, 3);

        TextField withdrawField = new TextField();
        withdrawField.setPromptText("Enter amount to withdraw");
        GridPane.setConstraints(withdrawField, 0, 4);

        Button withdrawButton = new Button("Withdraw");
        withdrawButton.setOnAction(e -> handleWithdraw(customer, withdrawField, balanceLabel, levelLabel, messageLabel, manager));
        GridPane.setConstraints(withdrawButton, 1, 4);

        TextField purchaseField = new TextField();
        purchaseField.setPromptText("Enter amount for online purchase");
        GridPane.setConstraints(purchaseField, 0, 5);

        Button purchaseButton = new Button("Make Purchase");
        purchaseButton.setOnAction(e -> handlePurchase(customer, purchaseField, balanceLabel, levelLabel, messageLabel, manager));
        GridPane.setConstraints(purchaseButton, 1, 5);

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> start(primaryStage));
        GridPane.setConstraints(logoutButton, 1, 7);

        grid.getChildren().addAll(welcomeLabel, balanceLabel, levelLabel, depositField, depositButton,
                withdrawField, withdrawButton, purchaseField, purchaseButton, logoutButton, messageLabel);

        Scene scene = new Scene(grid, 1920, 1080);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleDeposit(Customer customer, TextField depositField, Label balanceLabel, Label levelLabel, Label messageLabel, Manager manager) {
        try {
            double amount = Double.parseDouble(depositField.getText());
            customer.getBankAcc().deposit(amount);
            customer.setLevel();
            balanceLabel.setText("Balance: $" + customer.getBankAcc().getBalance());
            levelLabel.setText("Customer Level: " + customer.getLevel());
            messageLabel.setText("Deposit Successful. Current Balance: $" + customer.getBankAcc().getBalance());
            manager.writeCustomerCredentials();
        } catch (NumberFormatException ex) {
            messageLabel.setText("Invalid input for deposit amount.");
        }
    }

    private void handleWithdraw(Customer customer, TextField withdrawField, Label balanceLabel, Label levelLabel, Label messageLabel, Manager manager) {
        try {
            double amount = Double.parseDouble(withdrawField.getText());
            if (customer.getBankAcc().getBalance() < amount) {
                messageLabel.setText("Insufficient funds. Withdrawal failed.");
            } else {
                customer.getBankAcc().withdraw(amount);
                balanceLabel.setText("Balance: $" + customer.getBankAcc().getBalance());
                customer.setLevel();
                levelLabel.setText("Customer Level: " + customer.getLevel());
                messageLabel.setText("Withdrawal Successful. Current Balance: $" + customer.getBankAcc().getBalance());
                manager.writeCustomerCredentials();
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("Invalid input for withdrawal amount.");
        }
    }

    private void handlePurchase(Customer customer, TextField purchaseField, Label balanceLabel, Label levelLabel, Label messageLabel, Manager manager) {
        try {
            double amount = Double.parseDouble(purchaseField.getText());
            double fee = customer.calcFee();
            if (customer.getBankAcc().getBalance()<(fee+amount)) {
                messageLabel.setText("Insufficient funds. Purchase failed.");
            } else if (amount < 50) {
                messageLabel.setText("Purchase amount must be at least $50");
            } else {
                customer.getBankAcc().withdraw(amount + fee);
                balanceLabel.setText("Balance: $" + customer.getBankAcc().getBalance());
                customer.setLevel();
                levelLabel.setText("Customer Level: " + customer.getLevel());
                messageLabel.setText("Purchase Successful. Current Balance: $" + customer.getBankAcc().getBalance());
                manager.writeCustomerCredentials();
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("Invalid input for purchase amount.");
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
