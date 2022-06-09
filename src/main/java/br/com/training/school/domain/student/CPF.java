package br.com.training.school.domain.student;

import java.util.InputMismatchException;

//VALUE OBJECT
public class CPF {
    private String cpf;

    public CPF(String cpf) {
        if (!isCPF(cpf)) {
            throw new IllegalArgumentException("This CPF is not valid!");
        }
        this.cpf = cpf;
    }



    private boolean isCPF(String cpf) {

        String cpfNumbers = removeSpecialCharacters(cpf);

        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (cpfNumbers.equals("00000000000") || cpfNumbers.equals("11111111111") || cpfNumbers.equals("22222222222") || cpfNumbers.equals("33333333333") || cpfNumbers.equals("44444444444") || cpfNumbers.equals("55555555555") || cpfNumbers.equals("66666666666") || cpfNumbers.equals("77777777777") || cpfNumbers.equals("88888888888") || cpfNumbers.equals("99999999999") || (cpfNumbers.length() != 11))
            return (false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (cpfNumbers.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpfNumbers.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == cpfNumbers.charAt(9)) && (dig11 == cpfNumbers.charAt(10)))
                return (true);
            else
                return (false);
        } catch (InputMismatchException erro) {
            return (false);
        }
    }


    private String removeSpecialCharacters(String doc) {
        if (doc == null) {
            throw new IllegalArgumentException("CPF is not valid!");
        }
        if (doc.contains(".")) {
            doc = doc.replace(".", "");
        }
        if (doc.contains("-")) {
            doc = doc.replace("-", "");
        }
        if (doc.contains("/")) {
            doc = doc.replace("/", "");
        }
        return doc;
    }

}


