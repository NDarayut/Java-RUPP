class Exercise10 {
    public static void main(String[] args) {
       int i, divisor;  //Use i to be divided by divisor
       int sum;     //Use sum as total of divisor 

       //We can start checking from 2 to 10000
        for(i = 2; i <= 10000; i++){
            sum = 1;    //Since all number are divisible by 1, we automatically assign 1 to be added
            for(divisor = 2; divisor < i; divisor++){   //We can start dividing from 2 because any number can be divided by 1

                //We checked if the number is divisible by the divisor and is not equal to the divisor
                if(i % divisor == 0){  
                    sum = sum + divisor;    //If true, we add the divisor together and store it in variable sum
                }
            }
            
            //If the sum is equal to i, then we can assume that it is the perfect number
            if (sum == i){
                System.out.println("The perfect number is " + i);
            }

        }
    }
}
