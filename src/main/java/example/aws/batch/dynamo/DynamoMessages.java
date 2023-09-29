package example.aws.batch.dynamo;

import java.util.Date;

public class DynamoMessages {
	
	
	
	public static String getDataProperty () {
		return "\"date\":\""+new Date()+"\"";
	}
	public static String blackListMessage() {
		return "{\"type\":\"WARNING\" , \"message\":\"Colaborador está na lista de exclusão\", "+getDataProperty()+"}";
	}
	
	public static String notEmailMessage() {
		return "{\"type\":\"ERROR\" , \"message\":\"Colaborador não possui e-mail\" , "+getDataProperty()+"}";
	}
	
	public static String notReportDataMessage(String reportName) {
		return "{\"type\":\"WARNING\" , \"message\":\"Colaborador não possui dados no relatório "+reportName+" \" ,"+getDataProperty()+"}";
	}

	public static String beginSendMailMessage() {
		return "{\"type\":\"INFO\" , \"message\":\"Iniciando envio de e-mail\" , "+getDataProperty()+ "}";
	}
	
	public static String measurements(String uuid,Integer attachments, Double data,Integer emails  ) {
		return "{\"type\":\"INFO\" , \"uuid\":\""+uuid+"\" , \"emails\":"+emails+" , \"data\":"+data+" , \"attachments\":"+attachments+", "+getDataProperty()+"}";
	}
	
	public static String beginSendedMailSuccess() {
		return "{\"type\":\"INFO\" , \"status\":\"SUCCESS\", \"message\":\"Email enviado com sucesso\" , "+getDataProperty()+"}";
	}
	
	public static String beginSendedMailError(String message) {
		return "{\"type\":\"ERROR\", \"message\":\""+message+"\" ,"+getDataProperty()+ "}";
	}
	
}
