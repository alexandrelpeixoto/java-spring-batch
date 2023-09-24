	package br.com.sumus.concept.invoice.process.params;

import org.springframework.boot.ApplicationArguments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApplicationParams {
	
	
	private Long idUserUpdated;
	private String [] invoicedIds;
	
	
	public static ApplicationParams buidParams(ApplicationArguments appArgs) {

		try {
			Long idUserUpdated = Long.parseLong(appArgs.getSourceArgs()[0]);
			String[] invoicedIds = appArgs.getSourceArgs()[1].replace("[", "").replace("]", "").split(",");
			return new ApplicationParams(idUserUpdated, invoicedIds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	

	public static ApplicationParams buidParamsLocal() {
		Long idUserUpdated = 1L;
		String ids[] = { "1", "2" };
		return new ApplicationParams(idUserUpdated, ids);
	}

	
}