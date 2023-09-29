package example.aws.batch.dynamo;

import java.util.Date;

import org.joda.time.DateTime;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;

public class DynamoDBLog {
	
	private DynamoDB dynamoDB;
	public DynamoDBLog(DynamoDB dynamoDB) {
		this.dynamoDB = dynamoDB;
	}
	
	public final static String SCHEDULING_DETAIL_TABLE = "scheduling_execution_detail";
	public final static String SCHEDULING_RESUME_TABLE = "scheduling_resume";
	
	
	//Log(uuid, id_employee) - WARNING: colaborador está na lista de exclusão
	public void insertSchedulingDetail( String uuid , String employee , String json ) {
		Table table = dynamoDB.getTable(SCHEDULING_DETAIL_TABLE);

		try {
        	Date date = new Date();
            Item item = new Item().withPrimaryKey("pk", "UUID#"+uuid).withLong("sk",date.getTime())
                .withString("message", json).withString("employee", employee).withLong("ttl", (DateTime.now().plusMonths(1).getMillis() / 1000));
            table.putItem(item);
        }
        catch (Exception e) {
            System.err.println("Create items failed.");
            System.err.println(e.getMessage());
            System.out.println(e.getMessage());
            

        }
    }
	public void insertSchedulingResume( Long idClient, String json ) {
		Table table = dynamoDB.getTable(SCHEDULING_RESUME_TABLE);

		try {
        	Date date = new Date();
            Item item = new Item().withPrimaryKey("pk", "ID_CLIENT#"+idClient).withLong("sk",date.getTime())
                .withString("message", json);
            table.putItem(item);
        }
        catch (Exception e) {
            System.err.println("Create items failed.");
            System.err.println(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

}
