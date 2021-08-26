import model.Funcionario;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exemplos {
    //EXEMPLO 1 Tratamento de exception
    @Test
    public void CT001() throws Exception {

        Exception exception = assertThrows(Exception.class, () -> {
            Funcionario funcionario = new Funcionario("Astolfo", 9999.99, "PROGRAMADOR");
        });

        String expectedMessage = "\n#3 O salário base deve ser R$ 990.00";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    //EXEMPLO 2
    @Test
    public void CT002() throws Exception {
        //Trocar IF por assertTrue

        Funcionario funcionario = new Funcionario("Astolfo", 998, "PROGRAMADOR");

        assertTrue(funcionario.getSalarioBase() == 998);

        assertTrue(funcionario.getCargo().equals("PROGRAMADOR"));

    }

    //EX 03
    //Apenas 1 assertTrue por teste (Assertion Roulette)
    @Test
    public void CT003() throws Exception {

        Funcionario funcionario = new Funcionario("Astolfo", 998, "PROGRAMADOR");

        assertTrue(funcionario.getSalarioBase() == 998);

    }

    @Test
    public void CT004() throws Exception {

        Funcionario funcionario = new Funcionario("Astolfo", 998, "PROGRAMADOR");

        assertTrue(funcionario.getCargo().equals("PROGRAMADOR"));

    }

    //EX 04
    @Test
    public void CT005() throws Exception {

        Funcionario funcionario = new Funcionario("Astolfo", 998, "PROGRAMADOR");

        assertTrue(funcionario.getCargo().equals("PROGRAMADOR"));

    }

    //EX 05
    @Test
    public void CT006() throws Exception {
        Funcionario funcionario = new Funcionario("Astolfo", 998, "PROGRAMADOR");

        Exception exception = assertThrows(Exception.class, () -> {
            funcionario.setSalarioBase(9999.99);
        });

        String expectedMessage = "\n#3 O salário base deve ser R$ 990.00";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    //EX 06
    private Funcionario funcionario;

    @Before
    public void setup() throws Exception {
        funcionario = new Funcionario("Astolfo", 998, "PROGRAMADOR");
    }

    @Test
    public void CT007() throws Exception {
        assertTrue(funcionario.getSalarioBase() == 998);
    }

    @After
    public void tearDown() throws Exception {
        funcionario = null;
    }

    //EX 07 NÃO FUNCIONOU
    //@Test(expected-Exception.class)
    //public void test() {

    //}
}
