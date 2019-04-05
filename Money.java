public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros += cents / 100;
            cents %= 100;
        }

        this.euros = euros;
        this.cents = cents;
    }
    
    public Money plus(Money added) {
        int euros = this.euros + added.euros();
        int cents = this.cents + added.cents();
        
        if(cents > 99) {
            euros += cents / 100;
            cents %= 100;
        }
        
        return new Money(euros, cents);    
    }
    
    public Money minus(Money subtracted) {
        int euros = this.euros - subtracted.euros;
        int cents = this.cents - subtracted.cents;
        
        if(cents < 0) {
            euros--;
            cents = cents + 100;
        }
        
        if(euros < 0) {
            euros = 0;
            cents = 0;
        }
        
        return new Money(euros, cents);
    }
    
    public boolean less(Money compared) {
        if(this.euros < compared.euros) {
            return true;
        } else if (this.euros == compared.euros && this.cents < compared.cents) {
            return true;
        }
        return false;           
    }

    public int euros() {
        return euros;
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

        return euros + "." + zero + cents + "e";
    }

}
