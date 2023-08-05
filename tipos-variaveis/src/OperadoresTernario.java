public class OperadoresTernario {
    public static void main (String[]args) {
        // classe operadores.java
        int  a, b;

        a = 5;
        b = 6;

        /*
            Exemplo d econdicional utilizando uma estrutura IF/ELSE
            if(a==b)
                resultado = "verdadeiro";
            else
                resultdado = "falso";
        */
        //MESMA CONDICIONAL, MAS DESSA VEZ, UTILIZANDO O OPERADOR CONDICIONAL TERNÁRIO
        String resultado = (a==b) ? "verdadeiro" : "false";
        System.out.println(resultado);
    }
}
