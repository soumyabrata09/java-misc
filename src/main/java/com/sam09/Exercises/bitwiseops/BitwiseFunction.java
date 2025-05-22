package com.sam09.Exercises.bitwiseops;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Soumyabrata09 This program implementing the concept about how we can dynamically invoke a funaction/method along with
 * their paramerts
 * @see <a href="https://www.delftstack.com/howto/java/how-to-pass-a-function-as-a-parameter-in-java/">how-to-pass-a-function-as-a-parameter-in-java</a>
 */
public class BitwiseFunction{
    private static final Logger getLogger() {
        return LoggerFactory.getLogger(BitwiseFunction.class);
    }

    /**
     * generates a binary representation of a given input
     * @param i takes an integer number
     * @return string binary representation
     */
    private String getBinary(int i) {
        return Integer.toBinaryString(i);
    }

    /**
     *
     * @param value1 takes int value
     * @param value2 takes int value
     */
    private void performAND(Integer value1, Integer value2) {
        getLogger().info("Binary representation of " + value1 + ": " + getBinary(value1)
                + "\n Binary representation of " + value2 + ": " + getBinary(value2)+ "\n");
        int result = value1 & value2;
        System.out.println("Result: " + result + " and its binary representation: " + getBinary(result));
    }

    /**
     *
     * @param value1 takes int value
     * @param value2 takes int value
     */
    private void performOR(Integer value1, Integer value2) {
        getLogger().info("Binary representation of " + value1 + ": " + getBinary(value1)
                + "\n Binary representation of " + value2 + ": " + getBinary(value2)+ "\n");
        int result = value1 | value2;
        System.out.println("Result: " + result + " and its binary representation: " + getBinary(result));
    }

    /**
     *
     * @param value1 takes int value
     * @param value2 takes int value
     */
    private void performXOR(Integer value1, Integer value2) {
        getLogger().info("Binary representation of " + value1 + ": " + getBinary(value1)
                + "\n Binary representation of " + value2 + ": " + getBinary(value2)+ "\n");
        int result = value1 ^ value2;
        System.out.println("Result: " + result + " and its binary representation: " + getBinary(result));
    }

    public void performBitwiseOperation(int[] values, String methodName)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class[] paramType = new Class[values.length];
        for (int i = 0; i < values.length; i++) {
            paramType[i] = Integer.class;
        }
        Method invokingMethod = getInvokingMethod(methodName,paramType[0],paramType[1]);
        invokeMethodDynamically(this,invokingMethod,values);
    }

    private void invokeMethodDynamically(Object instance, Method method, int[] values) throws InvocationTargetException, IllegalAccessException {
        /*Object[] params = new Object[values.length];
        for (int i = 0; i < values.length; i++) {
            params[i] = values[i];
        }*/
        int[] params = values.clone();
        method.invoke(instance,params[0],params[1]);
    }

    /**
     * To pass a method dynamically and then invoking them through a method
     * @param method
     *  Name of the method that you want to pass dynamically and invoke it eventually
     * @param param1ClassType
     *  It is the type of parameter(could be class/Object/any primitive type) which as parameter methodName takes
     * @throws NoSuchMethodException
     * @see NoSuchMethodException
     */
    public Method getInvokingMethod(String method, Class<? extends Object>... param1ClassType) throws NoSuchMethodException {

        /*return this.getClass().getDeclaredMethod(method,param1ClassType,param2ClassType);*/
        return this.getClass().getDeclaredMethod(method,param1ClassType);
    }
}
