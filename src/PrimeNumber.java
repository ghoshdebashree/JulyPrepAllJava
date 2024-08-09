public class PrimeNumber {
    public static void main(String[] args){
        int num = 30;
        boolean isPrime = true;
        for(int i = 2; i< Math.sqrt(num); i++){
            if(num % i == 0){
                isPrime =  false;
                break;

            }
        }
        if(isPrime){
            System.out.println("Yes a prime");
        }
        else{
            System.out.println("Not a Prime");
        }
    }

}
