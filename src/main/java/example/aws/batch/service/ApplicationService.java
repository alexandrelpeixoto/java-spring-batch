package example.aws.batch.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;

import example.aws.batch.params.ApplicationParams;

@Service
public class ApplicationService {


	@Autowired
	private ApplicationArguments appArgs;

	public ApplicationService() {
	}

	@PostConstruct
	public void init() throws Exception {
		System.out.println("AutomationService init ");
		execute();
	}

	/**
	 * Executa a aplicação de Reclassificação de servicøs de faturas
	 * 
	 * PARAMETROS
		id_user_updated dt_updated "[1,2,3]"
		4 04/10/2022 \[812\,813\]

	 * @throws Exception
	 */
	public void execute() throws Exception {

		
		System.out.println("App execute ");
		ApplicationParams params = null;
		
		try {

			params = ApplicationParams.buidParams(this.appArgs);
			
		} catch (Exception e) {
			throw e;
		}
	}

}