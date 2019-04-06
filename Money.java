public class Money {

    private final int dollars;
    private final int cents;

    public Money(int dollars, int cents) {

        if (cents > 99) {
            dollars += cents / 100;
            cents %= 100;
        }

        this.dollars = dollars;
        this.cents = cents;
    }
    
    public Money plus(Money added) {
        int dollars = this.dollars + added.dollars();
        int cents = this.cents + added.cents();
        
        if(cents > 99) {
            dollars += cents / 100;
            cents %= 100;
        }
        
        return new Money(euros, cents);    
    }
    
    public Money minus(Money subtracted) {
        int dollars = this.dollars - subtracted.dollars;
        int cents = this.cents - subtracted.cents;
        
        if(cents < 0) {
            dollars--;
            cents = cents + 100;
        }
        
        if(dollars < 0) {
            dollars = 0;
            cents = 0;
        }
        
        return new Money(dollars, cents);
    }
    
    public boolean less(Money compared) {
        if(this.dollars < compared.dollars) {
            return true;
        } else if (this.dollars == compared.dollars && this.cents < compared.cents) {
            return true;
        }
        return false;           
    }

    public int dollars() {
        return dollars;
    }

    public int cents() {
        return cents;
    }

    @Override
    public String toString() {
        String zero = "";
        if (cents < 10) {
            zero = "0";
        }

        return dollars + "." + zero + cents + "e";
    }

}
