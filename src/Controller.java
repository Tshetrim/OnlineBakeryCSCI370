import Factory.BakeryFactory;

/*
 * The controller class will manage the flow and of the application 
 * It will be the intermediary between view, models, and other backend related logic
 */
public class Controller {
    private View view;
    private ScriptReader sr; 
    private Security security;

    public Controller(View view) {
        this.view = view;
        this.sr = new ScriptReader();
        this.security = new Security();
        start();
    }

    public void start() {
        view.writeToScreen("Hello, welcome to the Online Bakery Store!\n");
        if(security.checkIfSignedUp())
            login();
        else 
            signUp();

        displayMenu();
    }

    public void signUp(){
        view.writeToScreen("Account not detected, please sign-up", 2);
        String name = view.getInput("Please enter your name:");
        String password = view.getInput("Please enter your password:");
        double funds = view.getInputNum("Please enter the money you are depositing:");
        security.saveUser(name, password, funds);
    }

    public void login(){
        String userAttempt = view.getInput("Please enter your username or type signup to make a new account");
        if(userAttempt.equals("signup")) {
            signUp();
            return;
        }

        if(security.userNameExists(userAttempt)){
            view.writeToScreen("Hello" + userAttempt);
            String passwordAttempt = view.getInput("Please enter your password " + userAttempt);
            if(security.authenticateUserPass(userAttempt, passwordAttempt)){
                view.writeToScreen("Welcome " + userAttempt);
            }
            else{
                //what to do if password in fails 
            }

        } else{
            //write login to try again if username fails 
        }
    }

    public void displayMenu(){

        final int ADD_ITEM = 1, REMOVE_ITEM = 2, VIEW_CART = 3, CHECKOUT = 4;

        int input = (int)view.getInputNum( "Select an option: \n" +
                "  1) Add Item\n" +
                "  2) Remove Item\n" +
                "  3) View Cart\n" +
                "  4) Checkout\n ");

        //if input is not between 1 and 4 ask again...
        if(input == ADD_ITEM){
            showItemMenu();
        } else if (input == REMOVE_ITEM) {
            showRemoveMenu();
        } else if (input == VIEW_CART) {
            showCartMenu();
        }else if (input == CHECKOUT) {
            showCheckoutMenu();
        } else {
            //if input is not between 1 and 4 ask again...
        }
    }
    public void showItemMenu(){
        view.writeToScreen("Select an option: \n"+
        "1) Cookie\n"+"2) Croissants\n"+"3) Donuts\n"+"4) Cake\n");
        int input = (int)view.getInputNum(null);
        final BakeryFactory BF = new BakeryFactory();

        //InputOptions array 0, 1, 2, 3, 4, 5,
        String[] inputOptions = new String[]{"Cookie","Croissants","Donuts","Cake","6inCake","9inCake"};
        if(input == 4){
            view.writeToScreen("1) 6in Cake\n"+"2) 9in Cake\n");
            input = (int)view.getInputNum("What size of the cake would you like? ");
            
            if(input == 1){
                view.writeToScreen( BF.getItem(inputOptions[4]) + " has been added to cart");
                //Mershad needs to upload add to cart funcs here I did most of the grunt work -Kenneth
            }
            if(input == 2){
                view.writeToScreen( BF.getItem(inputOptions[5]) + " has been added to cart");
                //Mershad needs to upload add to cart funcs here I did most of the grunt work -Kenneth
            }
        }

        else{
        view.writeToScreen( BF.getItem(inputOptions[input-1]) + " has been added to cart");
        //Mershad needs to upload add to cart funcs here I did most of the grunt work -Kenneth
        }
    }

    public void showRemoveMenu(){

        view.writeToScreen("to do: showRemoveMenu");
    }
    public void showCartMenu(){

        view.writeToScreen("to do: showCartMenu");
    }
    public void showCheckoutMenu(){
        view.writeToScreen("to do: showCheckoutMenu");

    }





}
