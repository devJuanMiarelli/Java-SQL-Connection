package p_04721062;

import org.junit.jupiter.api.Test;

class CandidatoDAOTest {

	@Test
	public void test() throws Exception{
        CandidatoTO inscricoes2 = new CandidatoTO();

        CandidatoDAO test = new CandidatoDAO();
        try {

        	inscricoes2.setNome("Teste Juan");
        	inscricoes2.setCpf("421.768.348-01");
        	inscricoes2.setTelefone("55 16 99628-0990");
        	inscricoes2.setEmail("teste@unira.edu.br");
        	inscricoes2.setEndereco("Uniara - Unid. 4");
        	inscricoes2.setCidade("Araraquara");
        	inscricoes2.setEstado("SP");
        	inscricoes2.setCep("XxXxx-xxx");

            test.insert(inscricoes2);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
