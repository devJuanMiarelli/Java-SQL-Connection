package p_04721062;

import org.camunda.bpm.client.ExternalTaskClient;

public class InscricaoWorker {
	private static final String CAMUNDA_SERVER_URL = "http://camunda.delivoro.com.br:8882/engine-rest";

	public static void main(String[] args) {
		ExternalTaskClient client = ExternalTaskClient.create().baseUrl(CAMUNDA_SERVER_URL)
				.asyncResponseTimeout(10000)
				.maxTasks(1).build();

		client.subscribe("armazena-insc-sistema")
			.handler((externalTask, externalTaskService) -> {

		
		String nome = (String) externalTask.getVariable("nome");
		String cpf = (String) externalTask.getVariable("cpf");
		String telefone = (String) externalTask.getVariable("telefone");
		String email = (String) externalTask.getVariable("email");
		String endereco = (String) externalTask.getVariable("endereco");
		String cidade = (String) externalTask.getVariable("cidade");
		String estado = (String) externalTask.getVariable("estado");
		String cep = (String) externalTask.getVariable("cep");
		System.out.println("Inscricoes do aluno '" + nome + "' '" + cpf
	            + "' com os dados: '" + telefone + "' '" + email + "' '" + endereco + "' '" + cidade + "' '" + estado 
	            + "' '" + cep);
		
		CandidatoTO inscricoes2 = new CandidatoTO();
		
		inscricoes2.setNome(nome);
		inscricoes2.setCpf(cpf);
		inscricoes2.setTelefone(telefone);
		inscricoes2.setEmail(email);
		inscricoes2.setEndereco(endereco);
		inscricoes2.setCidade(cidade);
		inscricoes2.setEstado(estado);
		inscricoes2.setCep(cep);
		
		CandidatoDAO inscricoesFeitas = new CandidatoDAO();
		try {
			inscricoesFeitas.insert(inscricoes2);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		externalTaskService.complete(externalTask);
		
		
		}).open();
	}
}
