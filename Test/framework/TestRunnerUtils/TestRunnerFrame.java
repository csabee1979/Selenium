package TestRunnerUtils;

public class TestRunnerFrame {
	private TestRunnerFrame(){
	}
	
	public static void runTest(TestRunner test){
		try{
			test.run();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
