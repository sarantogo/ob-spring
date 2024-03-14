package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CalculatorService calculator = (CalculatorService) context.getBean("calculatorService");

       String text = calculator.helloWorld();
       System.out.println(text);

       //2. Cargar un bean dentro de otro bean:
        InvoiceManagement invoiceManager = (InvoiceManagement) context.getBean("invoiceManager");
        System.out.println(invoiceManager.calculator.helloWorld());

        /*3. Scope o alcance:
        los beans por defecto son singleton, se crea el objeto una sola vez y se reutiliza para toda la aplicacion
        podemos cambiarlo en el beans.xml a scope="prototype" si queremos que se cree un nuevo objeto cada vez que se usa*/
    }
}