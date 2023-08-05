import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        double Saldo = 237.48;       

        System.out.println("Por favor, digite o número da agência !");
        String Agencia = scan.nextLine(); 

        System.out.println("Por favor, digite o seu nome !");
        String Nome = scan.nextLine(); 

        System.out.println("Por favor, digite o número da conta !");
        int Numero = scan.nextInt(); 

        System.out.println("Olá "+Nome+", obrigado por criar uma conta em nosso banco, sua agência é "+Agencia+ ", conta "+Numero+" e seu saldo "+Saldo+" já está disponível para saque.");
    }
}
