public class Player {
    private int bal; 
    private int pos; 

    public Player(){
        //each player starts with $1500
        bal = 1500;
        pos = 0; 
    }

    public int getBal(){
        return bal;
    }
    
    // will affect the balance, increasing or decreasing the amount of money available to the players based on their actions 
    public void addBal(int change){
        bal += x; 
    }

    public void subBal(int change){
        bal -= x;
    }

    // Will tell the user if they can pay the charged price 
    public boolean getCanPay(int price){
        if (bal >= price){
            return true;
        }
        return false;
    }

    public int getPos(){
        return pos; 
    }

    public void changePos(int dice){
        pos += dice;
        pos %= 40;
    }

    //status if game is lost 
    public boolean getLost(){
        if (bal <= 0){
            return true;
        }
        return false;
    }
}
