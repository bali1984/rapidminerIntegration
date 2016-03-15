	package rapidminerIntegration;
	
	import com.rapidminer.Process;
	import com.rapidminer.RapidMiner;
	import com.rapidminer.example.Attribute;
	import com.rapidminer.example.Example;
	import com.rapidminer.example.ExampleSet;
	import com.rapidminer.operator.IOContainer;
	import com.rapidminer.operator.OperatorException;
	import com.rapidminer.repository.RepositoryException;
	import com.rapidminer.tools.XMLException;
	import java.io.File;
	import java.io.IOException;
	import java.util.Iterator;
	
	public class ReadRapidminerProcess {
	  public static void main(String[] args) throws RepositoryException {
	    try {
	      RapidMiner.setExecutionMode(RapidMiner.ExecutionMode.COMMAND_LINE);
	      RapidMiner.init();
	      Process process = new Process(new File("C:\\Users\\alibe\\.RapidMiner\\repositories\\Local Repository\\processes\\testProcess2.rmp"));
	    
	      // execute the process and get the resulting objects
	      IOContainer ioResult = process.run();
	
	      // use the result(s) as needed, for example if your process just returns one ExampleSet, use this:
	      if (ioResult.getElementAt(0) instanceof ExampleSet) {
	      ExampleSet resultSet = (ExampleSet)ioResult.getElementAt(0);
	    
	      for (Example example : resultSet) {
	          Iterator<Attribute> allAtts = example.getAttributes().allAttributes();
	         
	          while(allAtts.hasNext()) {
	              Attribute a = allAtts.next();
	             
	                      if (a.isNumerical()) {
	                              double value = example.getValue(a);
	                              System.out.print(value+ " " );
	    
	                      } else {
	                              String value = example.getValueAsString(a);
	                              System.out.print(value+ " ");
	                      }
	               }
	          System.out.println("\n");
	    
	    }
	      }	
	
	    } catch (IOException | XMLException | OperatorException ex) {
	      ex.printStackTrace();
			//test
	    }
	 
	    
	  }
	}