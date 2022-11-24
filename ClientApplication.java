package com.example.soap;

import java.net.MalformedURLException;
import java.net.URL;

import com.example.soap.bottomup.generated.GetEmployee;
import com.example.soap.bottomup.generated.GetEmployeeResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.soap.bottomup.generated.EmployeeServiceBottomUp;
import com.example.soap.bottomup.generated.EmployeeServiceBottomUpImplService;
import com.example.soap.topdown.generated.EmployeeServiceTopDown;
import com.example.soap.topdown.generated.EmployeeServiceTopDownImplService;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@SpringBootApplication
public class ClientApplication {

    // Need to run server first
    public static void main(String[] args) {
//        try {
//            URL url = new URL("http://localhost:9090/employeeservicetopdown?wsdl");
//
//            EmployeeServiceTopDownImplService employeeServiceTopDown_Service = new EmployeeServiceTopDownImplService();
//            EmployeeServiceTopDown employeeServiceTopDownProxy = employeeServiceTopDown_Service.getEmployeeServiceTopDownPort();
//            System.out.println("TOPDOWN------CountEmployees(): " + employeeServiceTopDownProxy.countEmployees());
//
//        } catch (MalformedURLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//        try {
//            URL url = new URL("http://localhost:9091/employeeservicebottomup?wsdl");
//            EmployeeServiceBottomUpImplService employeeServiceTopDown_Service = new EmployeeServiceBottomUpImplService();
//            EmployeeServiceBottomUp employeeServiceTopDownProxy = employeeServiceTopDown_Service.getEmployeeServiceBottomUpImplPort();
//            System.out.println("BOTTOMUP------getFirstName(): " + employeeServiceTopDownProxy.getEmployee(1).getFirstName());
//
//        } catch (MalformedURLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        SpringApplication.run(ClientApplication.class, args);

//        try {
//            Employee employee = new Employee();
//            GetEmployeeResponse response = employee.getEmployee(1);
//            System.out.println(response.getReturn().getFirstName());
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }
        @Bean
        CommandLineRunner lookup(Employee employee) {
            return args -> {
                int employeeNum = 1;

                if (args.length > 0) {
                    employeeNum = Integer.parseInt(args[0]);
                }
                GetEmployeeResponse response = employee.getEmployee(employeeNum);
                System.out.println(response);
            };
        }

}
