
import model.DBConnection;
import java.util.*;
public class TesteConexao {

	public static void main(String[] args) {
		
        try 
        {   
			DBConnection conexao = new DBConnection();
			System.out.println("Conex�o ok");
			
        }
		catch (Exception e)	
		{	
			System.out.println("Conex�o nok");
		}
		       
					
	}

}


