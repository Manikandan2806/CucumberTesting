package steps;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public abstract class TestListener implements ITestListener {

    public void onTestStart(ITestResult result) {
        // This method is invoked before each test method starts
        System.out.println("Test started: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        // This method is invoked when a test method succeeds
        System.out.println("Test succeeded: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        // This method is invoked when a test method fails
        System.out.println("Test failed: " + result.getName());
    }

    // Implement other methods as needed

    public void onFinish(ITestContext context) {
        // This method is invoked after all tests finish
        System.out.println("All tests finished");
    }
}


