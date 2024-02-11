//How often does each type of these 20 amino acids: A, C, D, E, F, G, H, I, K, L, M, N, P, Q, R, S, T, V, W and Y occurs
public class Exercise5 {
    public static void main(String[] args) {
        
        //Declaring a string containing the sequence
        String protein = "GIVEQCCTSICSLYQLENYCNFVNQHLCGSHLVEALYLVCGERGFFYTPKTNQHERGFFYTP"+
                        "KSICSLYQLVCGEVEQCCTTSICSLYLCGSHRGFFYTLVECGEALYLHERGICSLYQLENYCN"+
                        "FVNQHLCGSHLVEALYLVCGERGFFYTPKTNQHERGFFYTPKSICSLYQLVCGEVEQCCTTSI"+
                        "CSLYLCGSQCCTTSICSLYLCGSHRGFFYTLVECGEALYLHERGICSLYQLENYCNFVNQHL";

        //Declare integers to keep count of the 20 amino acids
        int A = 0, C = 0, D = 0, E = 0, F = 0, G = 0, H = 0, I = 0, K = 0, L = 0, 
            M = 0, N = 0, P = 0, Q = 0, R = 0, S = 0, T = 0, V = 0, W = 0, Y = 0;

        //Get the length of the string so we can loop through it 
        int length = protein.length();
        System.out.println("Total length: " + length);
       
        //Loop through the string from index 0 to the end of the string which is at index 249
        for(int i = 0; i < length; i++){
            
            //Use switch statement to check if the character at that specific index match with any case
            switch(protein.charAt(i)){      //The charAt() method returns a data type char of that character and not a string data type
                case 'A':       //The interpreter compares the ASCII value of the returned character to the char 'A'
                    A++;
                    break;      //use to break out of the switch statement
                case 'C':
                    C++;
                    break;
                case 'D':
                    D++;
                    break;
                case 'E':
                    E++;
                    break;
                case 'F':
                    F++;
                    break;
                case 'G':
                    G++;
                    break;
                case 'H':
                    H++;
                    break;
                case 'I':
                    I++;
                    break;
                case 'K':
                    K++;
                    break;
                case 'L':
                    L++;
                    break;
                case 'M':
                    M++;
                    break;
                case 'N':
                    N++;
                    break;
                case 'P':
                    P++;
                    break;
                case 'Q':
                    Q++;
                    break;
                case 'R':
                    R++;
                    break;
                case 'S':
                    S++;
                    break;
                case 'T':
                    T++;
                    break;
                case 'V':
                    V++;
                    break;
                case 'W':
                    W++;
                    break;
                case 'Y':
                    Y++;
                    break;
                default:        //If there is no matching case, the default code will run
                    System.out.println("Missing value");
            }
         }

         //Printing the total of each amino acid
        System.out.println("Total of A: "+ A + "\nTotal of C: " + C + "\nTotal of D: " + D + "\nTotal of E: " + E);
        System.out.println("Total of F: "+ F + "\nTotal of G: " + G + "\nTotal of H: " + H + "\nTotal of I: " + I);
        System.out.println("Total of K: "+ K + "\nTotal of L: " + L + "\nTotal of M: " + M + "\nTotal of E: " + N);
        System.out.println("Total of P: "+ P + "\nTotal of Q: " + Q + "\nTotal of R: " + R + "\nTotal of S: " + S);
        System.out.println("Total of T: "+ T + "\nTotal of V: " + V + "\nTotal of W: " + W + "\nTotal of Y: " + Y);
        System.out.println("sum of all amino acid is "+ (A+C+D+E+F+G+H+I+K+L+M+N+P+Q+R+S+T+V+W+Y));
    }   
}
