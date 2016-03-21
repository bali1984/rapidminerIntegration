	package rapidminerIntegration;

	import com.rapidminer.repository.RepositoryException;
	import java.io.File;
    import java.lang.String;

	public class Main {
		public static void main(String[] args) throws RepositoryException {

			File fileProcess1Location = new File("C:\\test\\testProcess1.rmp");
			String fileTest1Location = "C:\\test\\test1.csv";
			String fileTrain1Location = "C:\\test\\train1.csv";

			File fileProcess2Location = new File("C:\\test\\testProcess2.rmp");
			String fileTest2Location = "C:\\test\\test2.csv";
			String fileTrain2Location = "C:\\test\\train2.csv";


			RapidminerProcess process1 = new RapidminerProcess(fileTest1Location,fileTrain1Location,fileProcess1Location);
			RapidminerProcess process2 = new RapidminerProcess(fileTest2Location,fileTrain2Location,fileProcess2Location);

			String resultat = process1.runModel();
			process1.compareModel(process2);

		}
	}