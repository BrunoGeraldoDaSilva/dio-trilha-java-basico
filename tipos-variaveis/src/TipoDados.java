public class TipoDados {
    public static void main(String[] args) {
        byte idade = 123;
        short ano = 2023;
        int cep = 94195400; // Se começar com zero, talvez tenha que ser outor tipo
        long cpf = 92516009046L; // Se começar com zero, talvez tenha que ser outro tipo
        float pi = 3.14F;
        double salario = 1275.33;
        System.out.println("Idade: "+idade+" Ano: "+ano+" Cep: "+cep+" cpf "+cpf+ " Pi: " +pi+" Salario: "+salario);
    }
}
