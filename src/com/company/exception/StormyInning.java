package com.company.exception;

/**
 * Created by qujunnan on 14-5-25.
 */
public class StormyInning extends Inning implements  Storm {
    public StormyInning() throws RainedOut,BaseballException {
    }

    public StormyInning(String s)throws Foul,BaseballException{

    }



    @Override
    public void atBat() throws PopFoul {

    }

    public void event(){}

    @Override
    public void rainHard() throws RainedOut {

    }

    public static void main(String[] args){
        try{
            StormyInning si = new StormyInning();
            si.atBat();
        }catch (PopFoul e){
            System.out.println("pop foul");
        }catch(RainedOut e){
            System.out.println("rained out");
        }catch (BaseballException e){
            System.out.println("Generic baseball exception");
        }
        try{
            Inning i= new StormyInning();
            i.atBat();
        }catch (Strike e){
            System.out.println("Strike");
        }catch (Foul e){
            System.out.println("foul");
        }catch (RainedOut e ){
            System.out.println("rained out");
        }catch (BaseballException e){
            System.out.println("Generic baseball exception");

        }


    }
}
