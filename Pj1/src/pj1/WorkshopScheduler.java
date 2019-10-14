package pj1;

import pj1.workshop.orders.*;
import pj1.workshop.policies.FirstComeFirstServed;
import pj1.workshop.policies.LastComeFirstServed;
import pj1.workshop.policies.Policy;
import pj1.workshop.policies.RoundRobin;

import java.rmi.UnexpectedException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class WorkshopScheduler {
    private static final int MAX_NUMBER_OF_ORDERS = 10;
    public static void main(String[] args) {

        args = new String[]{"-fcfs", "2-3", "3", "4", "5", "6"};
        //System.out.println(args);
        if(args.length != 6){

            System.out.println("Number of arguments must be 6. Exiting program.");
            return;
        }
        String errorMessage = validateArgs(args);
        if (!errorMessage.isEmpty()){
            System.out.println(errorMessage);
            return;
        }

        createOrders(Float.parseFloat( args[2]), Float.parseFloat(args[3]), Float.parseFloat(args[4]), Integer.parseInt( args[5]), args[0]);


    }

    public static void createOrders(double sedanTime, double coupeTime, double mircobusTime, int total, String policyChoice){
        SecureRandom secureRandom;
        int orderNumber = 1;
        Policy policy;
        if (policyChoice.equals("-fcfs")){
            policy = new FirstComeFirstServed();
        }else if (policyChoice.equals("-lcfs")){
            policy = new LastComeFirstServed();
        }else{
            policy =  new RoundRobin();
        }

        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
            int OrdersNumber = 1 +  secureRandom.nextInt(MAX_NUMBER_OF_ORDERS);
            int totalPiezas =  1 +  secureRandom.nextInt(3);
            int orderType = 0;

            for(int i = 0; i < OrdersNumber; i++){
                switch (orderType){
                    case 0:
                        CoupeOrder coupeOrder = new CoupeOrder(orderNumber, generatePlate(), total, coupeTime, totalPiezas);
                        policy.add(coupeOrder);
                        break;
                    case 1:
                        BusOrder microBusOrder = new BusOrder(orderNumber, generatePlate(), total, mircobusTime, totalPiezas);
                        policy.add(microBusOrder);
                        break;
                    case 2:
                        SedanOrder sedanOrder = new SedanOrder(orderNumber, generatePlate(), total, sedanTime, totalPiezas);
                        policy.add(sedanOrder);
                        break;
                }
                orderType = secureRandom.nextInt(3);
                orderNumber++;
            }


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        System.out.println("Politica seleccionada: First come First served.");

        PaintOrder order = policy.next();
        while (order !=null){
            order = policy.next();
        }

    }

    public static void fcfsPolicy(PaintOrder order){



    }

    public static String generatePlate(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        try {
            SecureRandom secureRandom;
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
            String plate = secureRandom.nextInt(9) + "" + secureRandom.nextInt(9) + "" + secureRandom.nextInt(9) + alphabet.charAt( secureRandom.nextInt(25)) + alphabet.charAt( secureRandom.nextInt(25)) +alphabet.charAt( secureRandom.nextInt(25));
            return plate;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";


    }


    public static String validateArgs(String[] args){
        String errorMessage = "";
        if ( !(args[0].equals("-fcfs")  || args[0].equals("-lcfs") || args[0].equals("-rr"))){
            errorMessage = errorMessage + "First argument must be -fcfs, -lcfs, -rr, but it was \"" + args[0] + "\"\n";
        }
        Object[] range =  args[1].split("-");
        //lenght must be 2, and then type of both must be float
        if (range.length != 2){
            errorMessage = errorMessage + "Range must be only 2 numbers\n";
        }else {
            boolean bothNumbersFloat = true;
            try{
                Float.parseFloat(range[0].toString());
                Float.parseFloat(range[1].toString());
            }catch(NumberFormatException e){
                //not float
                bothNumbersFloat = false;
            }
            if (!bothNumbersFloat){
                errorMessage = errorMessage + "time range must only be numers.\n";
            }
        }

        if (!isInteger(args[2])){
            errorMessage = errorMessage + "Attention time for sedan must be an integer number.\n";
        }

        if (!isInteger(args[3])){
            errorMessage = errorMessage + "Attention time for Microbus must be an integer number.\n";
        }
        if (!isInteger(args[4])){
            errorMessage = errorMessage + "Attention time for sedan Coupe be an integer number.\n";
        }

        if (!isInteger(args[5])){
            errorMessage = errorMessage + "Price for piece must be an integer number.\n";
        }


        return errorMessage;


    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

}
