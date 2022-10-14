package co.com.testlamdas.findcapbus;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

public class Handler implements RequestHandler <Map<String,String>, BUSPOJO> {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public BUSPOJO handleRequest(Map<String, String> groups, Context context) {

        LambdaLogger lambdaLogger = context.getLogger();
        CalculatorBusTravelsGroups calculatorBusTravelsGroups = new CalculatorBusTravelsGroups();
        BUSPOJO bus= new BUSPOJO();
        String response = "";
        response= calculatorBusTravelsGroups.calculateCapacityBus(groups);
        bus.setSizes(response);
        lambdaLogger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
        lambdaLogger.log("CONTEXT: " + gson.toJson(context));
        // process event
        lambdaLogger.log("EVENT: " + gson.toJson(groups));
        lambdaLogger.log("EVENT TYPE: " + groups.getClass());
        return bus;
    }
}
